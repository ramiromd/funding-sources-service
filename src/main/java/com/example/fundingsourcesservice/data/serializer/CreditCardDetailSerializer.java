package com.example.fundingsourcesservice.data.serializer;

import com.example.fundingsourcesservice.entity.CreditCard;
import com.example.fundingsourcesservice.entity.Source;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class CreditCardDetailSerializer extends StdSerializer<CreditCard> {

    public CreditCardDetailSerializer() {
        this(null);
    }

    public CreditCardDetailSerializer(Class<CreditCard> t) {
        super(t);
    }

    @Override
    public void serialize(CreditCard source, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", source.getId());
        jsonGenerator.writeStringField("type", source.getType());
        jsonGenerator.writeStringField("name", source.getName());
        jsonGenerator.writeStringField("userId", source.getUserId());
        jsonGenerator.writeStringField("sourceDetail.brand", source.getBrand().toString());
        jsonGenerator.writeStringField("sourceDetail.cardHolderName", source.getCardholderName());
        jsonGenerator.writeStringField("sourceDetail.expirationDate", source.getExpirationDate());
        jsonGenerator.writeNumberField("sourceDetail.lastFourDigits", source.getLastFourDigits());
        jsonGenerator.writeObjectField("createdAt", source.getCreatedAt());
        jsonGenerator.writeObjectField("deletedAt", source.getDeletedAt());
        jsonGenerator.writeEndObject();
    }
}
