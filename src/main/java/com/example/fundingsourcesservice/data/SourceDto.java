package com.example.fundingsourcesservice.data;

import com.example.fundingsourcesservice.entity.TypeDiscriminator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
abstract public class SourceDto {

    protected String userId;
    // Jackson omite la propiedad que se usa como discriminador.
    // Se delega la responsabilidad a la especialización.
    // protected String type;

    protected String name;

    // Jackson omite la propiedad que se usa como discriminador.
    // Se delega la responsabilidad a la especialización.
    abstract public String getType();
}
