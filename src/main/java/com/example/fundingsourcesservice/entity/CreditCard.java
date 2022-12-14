package com.example.fundingsourcesservice.entity;

import com.example.fundingsourcesservice.entity.enums.CreditCardBrand;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@DiscriminatorValue("credit_card")
public class CreditCard extends Source {

    @Column(length = 100)
    private String cardholderName;

    @Column
    private int bin;

    @Column(length = 32)
    private CreditCardBrand brand;

    @Column
    private int lastFourDigits;

    @Column(length = 5)
    private String expirationDate;
}
