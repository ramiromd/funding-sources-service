package com.example.fundingsourcesservice.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@DiscriminatorValue(TypeDiscriminator.BANK_ACCOUNT)
public class BankAccount extends Source {

    @NotNull
    @Column(length = 100, nullable = false)
    private String owner;

    @NotNull
    @Column(length = 64, nullable = false)
    private String bankName;

    @NotNull
    @Column(length = 32, nullable = false)
    private String number;

    public String getType() {
        return TypeDiscriminator.BANK_ACCOUNT;
    }
}
