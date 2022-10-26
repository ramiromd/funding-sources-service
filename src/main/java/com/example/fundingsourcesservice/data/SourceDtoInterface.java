package com.example.fundingsourcesservice.data;

import com.example.fundingsourcesservice.entity.TypeDiscriminator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type" // Discriminator: A nivel de JSON. Luego, no lo tiene en cuenta para convertir a objeto.
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CreditCardDto.class, name = TypeDiscriminator.CREDIT_CARD),
        @JsonSubTypes.Type(value = BankAccountDto.class, name = TypeDiscriminator.BANK_ACCOUNT)
})
public interface SourceDtoInterface {

    String getType();

    String getName();
}
