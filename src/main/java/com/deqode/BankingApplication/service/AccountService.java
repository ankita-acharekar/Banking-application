package com.deqode.BankingApplication.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.deqode.BankingApplication.dto.AccountDto;
import com.deqode.BankingApplication.model.Account;
import com.deqode.BankingApplication.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public Account getAccount(Long accountId) {
		return accountRepository.findById(accountId)
				.orElseThrow(() -> new IllegalArgumentException("Account not found with ID: " + accountId));
	}

	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}

	public Account updateAccount(Long accountId, Account updatedAccount) {
		Account existingAccount = getAccount(accountId);
		BeanUtils.copyProperties(updatedAccount, existingAccount, "id");
		return accountRepository.save(existingAccount);
	}
	
	public void deleteAccount(Long accountId) throws NotFoundException {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new NotFoundException());

        accountRepository.delete(account);
    }

    private AccountDto convertToDto(Account account) {
        AccountDto accountDto = new AccountDto();
        accountDto.setAccountNumber(account.getAccount_number());
        accountDto.setBalance(account.getBalance());
        return accountDto;
    }

    private Account convertToEntity(AccountDto accountDto) {
        Account account = new Account();
        account.setAccount_number(accountDto.getAccountNumber());
        account.setBalance(accountDto.getBalance());
        return account;
    }
}
