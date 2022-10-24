package com.example.fundingsourcesservice.data;

import com.example.fundingsourcesservice.entity.TypeDiscriminator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCardDto extends SourceDto implements SourceDtoInterface {

    private String number;

    private String cardholderName;

    private String expirationDate;

    public String getType() {
        return TypeDiscriminator.CREDIT_CARD;
    }
}
