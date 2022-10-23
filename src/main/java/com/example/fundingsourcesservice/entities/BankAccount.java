package com.example.fundingsourcesservice.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@DiscriminatorValue("bank_account")
public class BankAccount extends Source {

    @Column(length = 100)
    private String owner;

    @Column(length = 64)
    private String bankName;

    @Column(length = 32)
    private String number;
}
