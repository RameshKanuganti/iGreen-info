package com.igreen.accounts.controller;

import com.igreen.accounts.model.AccountTransactions;
import com.igreen.accounts.model.Accounts;
import com.igreen.accounts.servcieI.AccountServiceI;
import com.igreen.accounts.util.AccountResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountServiceI accountServiceI;

    @ApiOperation(value = "Retrieves all accounts")
    @GetMapping("/accounts/{userId}")
    public AccountResponse getAllAccounts(@ApiParam(value = "userId of customer", required = false)
                                   @PathVariable final Long userId) throws Exception {
        return accountServiceI.getAllAccounts(userId);
    }

    @ApiOperation(value = "Retrieval of account transactions")
    @GetMapping("/accounts/transactions/{accountNumber}")
    public AccountResponse getAccountTransactions(@ApiParam(value = "customer account number", required = true)
                                                      @PathVariable final Long accountNumber) throws Exception {
        return accountServiceI.getAccountTransactions(accountNumber);
    }

}
