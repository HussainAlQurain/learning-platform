package com.example.demo.backend.service;

import com.example.demo.backend.domain.Account;
import com.example.demo.backend.exception.RegistrationException;
import com.example.demo.backend.repo.AccountRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;
    public AccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void register(Account account) {
        if(accountRepository.existsByEmail(account.getEmail())) {
            throw new RegistrationException("Email is already registered");
        }
        if(accountRepository.existsByUsername(account.getUsername())) {
            throw new RegistrationException("Username is already registered");
        }

        try{
            account.setPasswordHash(passwordEncoder.encode(account.getPasswordHash()));
            accountRepository.save(account);
        } catch (Exception e) {
            throw new RegistrationException("Email or username is already taken", e);
        }
    }
}
