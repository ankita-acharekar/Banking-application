package com.deqode.BankingApplication.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private Long account_id;
	private String transaction_type;
	private BigDecimal amount;
	private Timestamp transaction_date;
	public Long getId() {
		return id;
	}
	public Long getAccount_id() {
		return account_id;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public Timestamp getTransaction_date() {
		return transaction_date;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setAccount_id(Long account_id) {
		this.account_id = account_id;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public void setTransaction_date(Timestamp transaction_date) {
		this.transaction_date = transaction_date;
	}
}
