package com.deqode.BankingApplication.dto;

import java.math.BigDecimal;

public class TransactionDto {

	private Long accountId;
    private String transactionType;
    private BigDecimal amount;
    
	public Long getAccountId() {
		return accountId;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
}
