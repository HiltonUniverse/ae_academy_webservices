package be.ae.rest;

import be.ae.rest.model.Account;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * No description
 * (Generated with springmvc-raml-parser v.0.10.2)
 *
 */
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    /**
     * Get list of accounts
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Account>> getAccounts() {
        //TODO Get accounts
        return ResponseEntity.ok( new ArrayList<>());
    }

    /**
     * Create new accounts
     */
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAccount(@Valid @RequestBody Account account) {
        //TODO Create account
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(new Random().nextInt()).toUri();
        return ResponseEntity.created(location).build();
    }

    /**
     * Retrieve account details
     */
    @RequestMapping(value = "/{accountId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Account> getAccountById(@PathVariable String accountId) {
        //TODO Get account
        return ResponseEntity.ok(new Account());
    }

    /**
     * Delete account
     */
    @RequestMapping(value = "/{accountId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteAccountById(@PathVariable String accountId) {
        //TODO Delete account
        return ResponseEntity.noContent().build();
    }
}