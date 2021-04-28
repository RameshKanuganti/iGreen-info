package com.igreen.accounts.repository;

import com.igreen.accounts.model.AccountTransactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransactions, Long> {

    @Query(value = "select * from account_transactions at where at.account_number = :accountNumber", nativeQuery = true)
    List<AccountTransactions> findAllByAccountNumber(@Param("accountNumber") Long accountNumber);

}