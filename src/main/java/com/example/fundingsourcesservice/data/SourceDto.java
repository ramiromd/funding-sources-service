package com.example.fundingsourcesservice.data;

import lombok.Data;

@Data
abstract public class SourceDto {

    private String userId;

    private String type;

    private String name;

}
