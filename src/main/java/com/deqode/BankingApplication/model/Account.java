package com.deqode.BankingApplication.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Account {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String user_id;
	private String account_number;
	private BigDecimal balance;
	
	public Long getId() {
		return id;
	}
	public String getUser_id() {
		return user_id;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
