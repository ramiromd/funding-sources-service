package com.example.fundingsourcesservice.repository;

import com.example.fundingsourcesservice.entities.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Long> {
}
