package com.deqode.BankingApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deqode.BankingApplication.model.Account;
import com.deqode.BankingApplication.service.AccountService;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/{accountId}")
	public ResponseEntity<Account> getAccount(@PathVariable Long accountId) {
		Account account = accountService.getAccount(accountId);
		return ResponseEntity.ok(account);
	}

	@PostMapping
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		Account createdAccount = accountService.createAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdAccount);
	}

	@PutMapping("/{accountId}")
	public ResponseEntity<Account> updateAccount(@PathVariable Long accountId, @RequestBody Account account) {
		Account updatedAccount = accountService.updateAccount(accountId, account);
		return ResponseEntity.ok(updatedAccount);
	}
	
	@DeleteMapping("/{accountId}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long accountId) throws NotFoundException {
        accountService.deleteAccount(accountId);
        return ResponseEntity.noContent().build();
    }
}
