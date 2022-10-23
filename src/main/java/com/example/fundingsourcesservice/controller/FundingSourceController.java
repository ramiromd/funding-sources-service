package com.example.fundingsourcesservice.controller;

import com.example.fundingsourcesservice.data.SampleResponseDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sources")
public class FundingSourceController {

    @GetMapping(value = "/{id}", produces = "application/json")
    public SampleResponseDto getSource(@PathVariable int id) {
        return new SampleResponseDto("Get a detail for source: " + id);
    }

    @GetMapping(value = "/", produces = "application/json")
    public SampleResponseDto getSources() {
        return new SampleResponseDto("Listing all sources ...");
    }

    @PostMapping(value="/", produces = "application/json")
    public SampleResponseDto createSource() {
        return new SampleResponseDto("Source created ...");
    }

    @DeleteMapping(value="/{id}", produces = "application/json")
    public SampleResponseDto deleteSource(@PathVariable int id) {
        return new SampleResponseDto("Delete source: " + id);
    }
}
