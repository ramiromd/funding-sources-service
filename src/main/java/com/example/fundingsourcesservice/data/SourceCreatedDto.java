package com.example.fundingsourcesservice.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class SourceCreatedDto {

   private Long id;

   private String name;

   private String type;

   private LocalDateTime createdAt;
}
