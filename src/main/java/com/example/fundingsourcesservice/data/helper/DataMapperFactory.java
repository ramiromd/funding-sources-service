package com.example.fundingsourcesservice.data.helper;

import com.example.fundingsourcesservice.data.BankAccountDetailDto;
import com.example.fundingsourcesservice.data.CreditCardDetailDto;
import com.example.fundingsourcesservice.data.contract.SourceDetailDtoInterface;
import com.example.fundingsourcesservice.entity.BankAccount;
import com.example.fundingsourcesservice.entity.CreditCard;
import com.example.fundingsourcesservice.entity.Source;
import com.example.fundingsourcesservice.entity.TypeDiscriminator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class DataMapperFactory {

    private static ObjectMapper getDefaultMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        // Avoid fail on unknown properties.
        // https://stackoverflow.com/a/57667716
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        return mapper;
    }

    public static SourceDetailDtoInterface convertSourceEntityToDetailDto(Source aSource) throws Exception {

        switch (aSource.getType()) {
            case TypeDiscriminator.CREDIT_CARD:
                // !!! Explicit cast type ...
                return getDefaultMapper().convertValue((CreditCard) aSource, CreditCardDetailDto.class);
            case TypeDiscriminator.BANK_ACCOUNT:
                // !!! Explicit cast type ...
                return getDefaultMapper().convertValue((BankAccount) aSource, BankAccountDetailDto.class);
            default:
                throw new Exception("Tipo de medio de financiación incorrecto.");
        }
    }
}
