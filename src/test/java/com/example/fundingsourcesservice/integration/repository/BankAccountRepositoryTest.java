package com.example.fundingsourcesservice.integration.repository;

import com.example.fundingsourcesservice.entity.BankAccount;
import com.example.fundingsourcesservice.repository.BankAccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class BankAccountRepositoryTest {

    @Autowired
    BankAccountRepository repository;

    @Test
    public void it_can_persist_a_bank_account()
    {
        BankAccount account = new BankAccount();
        account.setName("My first bank account");
        account.setUserId("bca0c600-a79b-43b0-8474-c5ba91d86d67");
        account.setOwner("Ramiro Martinez D'Elía");
        account.setBankName("Banco de La Plata");
        account.setNumber("SK3112000000198742637541");
        account.setCreatedAt(LocalDateTime.now());

        repository.save(account);

        assertEquals(1, repository.count());
        assertNotNull(account.getId());
    }
}
