package com.example.demo.backend.Data;

import com.example.demo.backend.domain.Account;
import com.example.demo.backend.repo.AccountRepository;
import com.example.demo.backend.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
@Slf4j
public class AdminSeeder implements CommandLineRunner {

    private final AccountService accountService;
    private final AccountRepository accountRepository;
    @Value("${app.admin.username}")
    private String username;
    @Value("${app.admin.password}")
    private String password;
    @Value("${app.admin.email}")
    private String email;

// because requiredArgsConstructor is used in the class, the constructor is not needed
//    public AdminSeeder(PasswordEncoder passwordEncoder, AccountService accountService, AccountRepository accountRepository) {
//        this.passwordEncoder = passwordEncoder;
//        this.accountService = accountService;
//        this.accountRepository = accountRepository;
//    }

    @Override
    public void run(String... args) throws Exception {
        if(accountRepository.count() == 0) {
            Account account = new Account();
            account.setUsername(username);
            account.setPasswordHash(password);
            account.setEmail(email);
            account.setRoles(Set.of(Account.Role.ADMIN));
            accountService.register(account);
            log.info("Admin user created");
        }
        else {
            log.info("User already exists");
        }
    }
}
