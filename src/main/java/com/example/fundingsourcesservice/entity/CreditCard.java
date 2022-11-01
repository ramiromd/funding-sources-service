package com.example.fundingsourcesservice.entity;

import com.example.fundingsourcesservice.data.enums.CreditCardBrand;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@DiscriminatorValue(TypeDiscriminator.CREDIT_CARD)
public class CreditCard extends Source {

    @NotNull
    @Column(length = 100, nullable = false)
    private String cardholderName;

    @NotNull
    @Column(nullable = false)
    private int bin;

    @NotNull
    @Column(length = 32, nullable = false)
    private CreditCardBrand brand;

    @NotNull
    @Column(nullable = false)
    private int lastFourDigits;

    @Column(length = 8, nullable = false)
    private String expirationDate;

    public String getType() {
        return TypeDiscriminator.CREDIT_CARD;
    }
}
