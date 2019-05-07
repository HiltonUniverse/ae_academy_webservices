package be.ae.services;

import be.ae.rest.model.Account;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AccountService {

    public static List<Account> accounts;

    public AccountService() {
        accounts = new ArrayList<>();
    }

    public List<be.ae.rest.model.Account> getAccounts() {
        return accounts;
    }

    public Account get(String id) {
        int intId = Integer.valueOf(id);
        if ( intId < accounts.size() ) {
            return accounts.get(intId);
        }
        return null;
    }

    public String create(be.ae.rest.model.Account account) {
        String id = String.valueOf(accounts.size());
        if (StringUtils.isEmpty(account.getIban()) ) {
            account.setIban(generateIban());
        }
        if (account.getMoneyAmount() == null) {
            account.setMoneyAmount(new Random().nextFloat() * 1000);
        }
        if (StringUtils.isEmpty(account.getLabel())) {
            account.setLabel(generateLabel(account.getMoneyAmount()));
        }
        if (account.getCurrency() == null) {
            account.setCurrency(generateCurrency());
        }
        accounts.add(account);
        return id;
    }

    public void delete(String id) {
        int intId = Integer.valueOf(id);
        if ( intId < accounts.size() ) {
            accounts.remove(intId);
        }
    }

    private Account.Currency generateCurrency() {
        if (new Random().nextBoolean()) {
            return Account.Currency.EUR;
        }
        return Account.Currency.USD;
    }

    private String generateIban() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        sb.append("BE");
        String.format("%02d", random.nextInt(100));
        sb.append("-");
        String.format("%04d", random.nextInt(10000));
        sb.append("-");
        String.format("%04d", random.nextInt(10000));
        sb.append("-");
        String.format("%04d", random.nextInt(10000));
        return sb.toString();
    }

    private String generateLabel(Float moneyAmount) {
        if ( moneyAmount > 500f ) {
            return "Rich man";
        }
        return  "Poor man";
    }
}