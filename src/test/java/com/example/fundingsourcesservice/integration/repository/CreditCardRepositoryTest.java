package com.example.fundingsourcesservice.integration.repository;

import com.example.fundingsourcesservice.entity.CreditCard;
import com.example.fundingsourcesservice.entity.enums.CreditCardBrand;
import com.example.fundingsourcesservice.repository.CreditCardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class CreditCardRepositoryTest {

    @Autowired
    CreditCardRepository repository;

    @Test
    public void it_can_persist_a_credit_card()
    {
        CreditCard card = new CreditCard();
        card.setName("My first credit card");
        card.setUserId("bca0c600-a79b-43b0-8474-c5ba91d86d67");
        card.setCardholderName("Ramiro Martinez D'Elía");
        card.setBin(420598);
        card.setBrand(CreditCardBrand.VISA);
        card.setExpirationDate("10/23");
        card.setLastFourDigits(1234);
        card.setCreatedAt(LocalDateTime.now()); // TODO: Por defecto.

        repository.save(card);

        assertEquals(1, repository.count());
        assertNotNull(card.getId());
    }
}
