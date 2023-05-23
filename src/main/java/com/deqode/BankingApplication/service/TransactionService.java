package com.deqode.BankingApplication.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.deqode.BankingApplication.dto.TransactionDto;
import com.deqode.BankingApplication.model.Account;
import com.deqode.BankingApplication.model.Transaction;
import com.deqode.BankingApplication.repository.AccountRepository;
import com.deqode.BankingApplication.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
    private AccountRepository accountRepository;

	public Transaction getTransaction(Long transactionId) {
		return transactionRepository.findById(transactionId)
				.orElseThrow(() -> new IllegalArgumentException("Transaction not found with ID: " + transactionId));
	}

	public Transaction createTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	public List<TransactionDto> getAccountTransactions(Long accountId)throws NotFoundException {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new NotFoundException());

        List<Transaction> transactions = transactionRepository.findBySenderAccountOrReceiverAccount(account, account);

        return convertToDtoList(transactions);
    }

    private TransactionDto convertToDto(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setTransactionType(transaction.getTransaction_type());
        transactionDto.setAccountId(transaction.getAccount_id());
        transactionDto.setAmount(transaction.getAmount());
        return transactionDto;
    }

    private List<TransactionDto> convertToDtoList(List<Transaction> transactions) {
        return transactions.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
