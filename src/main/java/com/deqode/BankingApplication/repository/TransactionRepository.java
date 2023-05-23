package com.deqode.BankingApplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deqode.BankingApplication.model.Account;
import com.deqode.BankingApplication.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findBySenderAccountOrReceiverAccount(Account senderAccount, Account receiverAccount);

}