package com.example.fundingsourcesservice.data;

import com.example.fundingsourcesservice.data.contract.SourceDetailDtoInterface;
import lombok.Data;

@Data
public class BankAccountDetailDto extends SourceDetailDto implements SourceDetailDtoInterface {

    private String bankName;

    private String owner;

    private String number;

}
