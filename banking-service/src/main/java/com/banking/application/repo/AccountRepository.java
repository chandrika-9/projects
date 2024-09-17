package com.banking.application.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.application.model.Account;

public interface AccountRepository extends JpaRepository<Account,Integer> {

}
