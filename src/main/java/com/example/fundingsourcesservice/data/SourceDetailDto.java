package com.example.fundingsourcesservice.data;

import lombok.Data;

import java.time.LocalDateTime;

@Data
abstract public class SourceDetailDto {

    protected Long id;

    protected String userId;

    protected String type;

    protected String name;

    protected LocalDateTime createdAt;

    protected LocalDateTime deletedAt;

}
