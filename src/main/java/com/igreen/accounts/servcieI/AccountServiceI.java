package com.igreen.accounts.servcieI;

import com.igreen.accounts.exception.APIException;
import com.igreen.accounts.util.AccountResponse;

public interface AccountServiceI {

    AccountResponse getAllAccounts(Long userId) throws APIException;

    AccountResponse getAccountTransactions(Long accountNumber) throws APIException;
}
