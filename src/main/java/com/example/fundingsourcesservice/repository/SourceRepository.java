package com.example.fundingsourcesservice.repository;

import com.example.fundingsourcesservice.entity.Source;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SourceRepository extends CrudRepository<Source, Long> {
}
