package com.example.fundingsourcesservice.repository;

import com.example.fundingsourcesservice.entities.CreditCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCard, Long> {
}
