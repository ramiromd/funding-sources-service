package com.example.fundingsourcesservice.data;

import lombok.Data;

@Data
public class BankAccountDto implements SourceDtoInterface {

    private String userId;

    private String type;

    private String name;

    private String owner;

    private String bankName;

    private String number;
}
