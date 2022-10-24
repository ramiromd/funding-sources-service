package com.example.fundingsourcesservice.data;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankAccountDto extends SourceDto implements SourceDtoInterface {

    private String owner;

    private String bankName;

    private String number;

    public String getType() {
        return "bank_account";
    }

}
