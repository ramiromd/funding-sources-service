package com.example.fundingsourcesservice.data;

import lombok.Data;

@Data
public class CreditCardDto implements SourceDtoInterface {

    private String userId;

    private String type;

    private String name;

    private String number;

    private String cardholderName;

    private String expirationDate;
}
