package com.banking.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.application.model.Account;
import com.banking.application.service.AccountService;

@RestController
@RequestMapping("/api/account")
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount (@RequestBody Account account) {
		return ResponseEntity.ok(accountService.createAccount(account));
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Account> getAcoount(@PathVariable int id){
		return ResponseEntity.ok(accountService.getAccountId(id).orElseGet(null));
	}
	
	@PostMapping("/{id}/deposite")
	public ResponseEntity<Void> deposite(@PathVariable int id,@RequestParam Double amount){
		accountService.deposite(id, amount);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/{id}/withdraw")
	public ResponseEntity<Void> withdraw(@PathVariable int id,@RequestParam Double amount){
		accountService.withdrawAmount(id, amount);
		return ResponseEntity.ok().build();
	}
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
