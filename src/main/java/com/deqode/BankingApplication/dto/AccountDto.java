package com.deqode.BankingApplication.dto;

import java.math.BigDecimal;

public class AccountDto {

	private String accountNumber;
    private BigDecimal balance;
    
	public String getAccountNumber() {
		return accountNumber;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
