package com.example.fundingsourcesservice.data;

import com.example.fundingsourcesservice.entity.TypeDiscriminator;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BankAccountDto extends SourceDto implements SourceDtoInterface {

    private String owner;

    private String bankName;

    private String number;

    public String getType() {
        return TypeDiscriminator.BANK_ACCOUNT;
    }

}
