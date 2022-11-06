package com.example.fundingsourcesservice.data.serializer;

import com.example.fundingsourcesservice.entity.CreditCard;
import com.example.fundingsourcesservice.entity.Source;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class SourceListItemSerializer extends StdSerializer<Source> {

    public SourceListItemSerializer() {
        this(null);
    }

    public SourceListItemSerializer(Class<Source> t) {
        super(t);
    }

    @Override
    public void serialize(Source source, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id", source.getId());
        jsonGenerator.writeStringField("type", source.getType());
        jsonGenerator.writeStringField("name", source.getName());
        jsonGenerator.writeStringField("userId", source.getUserId());
        jsonGenerator.writeObjectField("createdAt", source.getCreatedAt());
        jsonGenerator.writeObjectField("deletedAt", source.getDeletedAt());
        jsonGenerator.writeEndObject();
    }
}
