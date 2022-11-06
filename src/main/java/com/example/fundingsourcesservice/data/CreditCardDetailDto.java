package com.example.fundingsourcesservice.data;

import com.example.fundingsourcesservice.data.contract.SourceDetailDtoInterface;
import lombok.Data;

@Data
public class CreditCardDetailDto extends SourceDetailDto implements SourceDetailDtoInterface {

    private String cardholderName;

    private int lastFourDigits;

    private String expirationDate;

    private String brand;
}
