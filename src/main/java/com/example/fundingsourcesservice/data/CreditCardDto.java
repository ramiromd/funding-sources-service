package com.example.fundingsourcesservice.data;

import lombok.Data;

@Data
public class CreditCardDto {

    private String userId;

    private String name;

    private String number;

    private String cardholderName;

    private String expirationDate;
}
