package com.deqode.BankingApplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deqode.BankingApplication.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}