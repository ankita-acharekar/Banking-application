package com.deqode.BankingApplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deqode.BankingApplication.dto.TransactionDto;
import com.deqode.BankingApplication.model.Transaction;
import com.deqode.BankingApplication.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@GetMapping("/{transactionId}")
	public ResponseEntity<Transaction> getTransaction(@PathVariable Long transactionId) {
		Transaction transaction = transactionService.getTransaction(transactionId);
		return ResponseEntity.ok(transaction);
	}

	@PostMapping
	public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
		Transaction createdTransaction = transactionService.createTransaction(transaction);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdTransaction);
	}
	
	@GetMapping("/account/{accountId}")
    public ResponseEntity<List<TransactionDto>> getAccountTransactions(@PathVariable Long accountId) throws NotFoundException {
        List<TransactionDto> transactions = transactionService.getAccountTransactions(accountId);
        return ResponseEntity.ok(transactions);
    }
}
