package com.example.fundingsourcesservice.data;

import lombok.Data;

@Data
public class BankAccountDto extends SourceDto implements SourceDtoInterface {

    private String owner;

    private String bankName;

    private String number;
}
