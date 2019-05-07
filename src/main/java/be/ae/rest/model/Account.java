
package be.ae.rest.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "label",
        "type",
        "owners",
        "iban",
        "moneyAmount",
        "currency"
})
public class Account {

    @JsonProperty("label")
    private String label;
    @JsonProperty("type")
    private Account.Type type;
    @JsonProperty("owners")
    private List<String> owners = new ArrayList<String>();
    @JsonProperty("iban")
    private String iban;
    @JsonProperty("moneyAmount")
    private Float moneyAmount;
    @JsonProperty("currency")
    private Account.Currency currency;

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    @JsonProperty("type")
    public Account.Type getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(Account.Type type) {
        this.type = type;
    }

    @JsonProperty("owners")
    public List<String> getOwners() {
        return owners;
    }

    @JsonProperty("owners")
    public void setOwners(List<String> owners) {
        this.owners = owners;
    }

    @JsonProperty("iban")
    public String getIban() {
        return iban;
    }

    @JsonProperty("iban")
    public void setIban(String iban) {
        this.iban = iban;
    }

    @JsonProperty("moneyAmount")
    public Float getMoneyAmount() {
        return moneyAmount;
    }

    @JsonProperty("moneyAmount")
    public void setMoneyAmount(Float moneyAmount) {
        this.moneyAmount = moneyAmount;
    }

    @JsonProperty("currency")
    public Account.Currency getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(Account.Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(label).append(type).append(owners).append(iban).append(moneyAmount).append(currency).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Account) == false) {
            return false;
        }
        Account rhs = ((Account) other);
        return new EqualsBuilder().append(label, rhs.label).append(type, rhs.type).append(owners, rhs.owners).append(iban, rhs.iban).append(moneyAmount, rhs.moneyAmount).append(currency, rhs.currency).isEquals();
    }

    public enum Currency {

        EUR("EUR"),
        USD("USD");
        private final String value;
        private final static Map<String, Account.Currency> CONSTANTS = new HashMap<String, Account.Currency>();

        static {
            for (Account.Currency c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Currency(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Account.Currency fromValue(String value) {
            Account.Currency constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum Type {

        CHECKINGS("checkings"),
        SAVINGS("savings");
        private final String value;
        private final static Map<String, Account.Type> CONSTANTS = new HashMap<String, Account.Type>();

        static {
            for (Account.Type c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Type(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Account.Type fromValue(String value) {
            Account.Type constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}