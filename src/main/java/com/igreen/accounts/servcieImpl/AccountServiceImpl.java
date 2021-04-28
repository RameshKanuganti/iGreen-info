package com.igreen.accounts.servcieImpl;

import com.igreen.accounts.model.AccountTransactions;
import com.igreen.accounts.model.Accounts;
import com.igreen.accounts.repository.AccountTransactionRepository;
import com.igreen.accounts.repository.AccountsRepository;
import com.igreen.accounts.servcieI.AccountServiceI;
import com.igreen.accounts.util.AccountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountServiceI {

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private AccountTransactionRepository accountTransactionRepository;

    @Override
    public AccountResponse getAllAccounts(Long userId) {
        AccountResponse response = new AccountResponse();
        List<Accounts> accountsList = accountsRepository.findAll();
        if (!ObjectUtils.isEmpty(accountsList) && accountsList.size() > 0) {
            response.setMessage("Accounts returned successfully");
            response.setStatus(HttpStatus.OK.value());
            response.setPayload(accountsList);
            return response;
        } else {
            response.setMessage("No accounts found");
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return response;
        }
    }

    @Override
    public AccountResponse getAccountTransactions(Long accountNumber) {
        AccountResponse response = new AccountResponse();
        if (!StringUtils.isEmpty(accountNumber)) {
            List<AccountTransactions> accountTransactions = accountTransactionRepository.findAllByAccountNumber(accountNumber);
            if (ObjectUtils.isEmpty(accountTransactions)) {
                response.setStatus(HttpStatus.OK.value());
                response.setMessage("Account transactions retrieved successfully");
                response.setPayload(accountTransactions);
                return response;
            } else {
                response.setMessage("No transaction data for provided account");
                response.setStatus(HttpStatus.NO_CONTENT.value());
                return response;
            }
        } else {
            response.setMessage("Invalid accounNumber");
            response.setStatus(HttpStatus.BAD_REQUEST.value());
            return response;
        }
    }
}
