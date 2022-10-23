package com.example.fundingsourcesservice.data;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SourceListItemDto {

    private Long id;

    private String type;

    private String name;

    private LocalDateTime createdAt;
}
