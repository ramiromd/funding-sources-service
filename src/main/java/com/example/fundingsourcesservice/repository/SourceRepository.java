package com.example.fundingsourcesservice.repository;

import com.example.fundingsourcesservice.entities.Source;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends CrudRepository<Source, Long> {
}
