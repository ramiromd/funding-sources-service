package com.example.fundingsourcesservice.data;

import lombok.Data;

@Data
public class CreditCardDto extends SourceDto implements SourceDtoInterface {

    private String number;

    private String cardholderName;

    private String expirationDate;
}
