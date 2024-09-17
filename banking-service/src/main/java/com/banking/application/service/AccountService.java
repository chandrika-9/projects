package com.banking.application.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.application.model.Account;
import com.banking.application.repo.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepo;

	public Account createAccount(Account account) {
		account.setBalance(0.0);

		return accountRepo.save(account);
	}

	public Optional<Account> getAccountId(int id) {
		return accountRepo.findById(id);
	}

	public void deposite(int id, Double amount) {
		Account account = accountRepo.findById(id).orElseThrow();
		account.setBalance(account.getBalance() + amount);
		accountRepo.save(account);
	}

	public void withdrawAmount(int id, Double amount) {
		Account account = accountRepo.findById(id).orElseThrow();
		if (account.getBalance() >= amount) {
			account.setBalance(account.getBalance() - amount);
			accountRepo.save(account);
		} else {
			throw new RuntimeException("Insuffiscient funds");
		}
	}

}
