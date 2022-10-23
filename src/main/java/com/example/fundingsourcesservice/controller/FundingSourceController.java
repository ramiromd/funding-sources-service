package com.example.fundingsourcesservice.controller;

import com.example.fundingsourcesservice.data.SampleResponseDto;
import com.example.fundingsourcesservice.data.SourceListItemDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/sources")
public class FundingSourceController {

    @Operation(summary="Get a source by its id")
    @GetMapping(value = "/{id}", produces = "application/json")
    public SampleResponseDto getSource(@PathVariable int id) {
        return new SampleResponseDto("Get a detail for source: " + id);
    }

    @Operation(summary="List a source collection")
    @Parameter(in = ParameterIn.HEADER, name = "X-USER-ID", schema = @Schema(type="string"), required = true)
    @Parameter(in = ParameterIn.DEFAULT, name = "name", schema = @Schema(type="string"))
    @Parameter(in = ParameterIn.DEFAULT, name = "type", schema = @Schema(type="string"))
    @ApiResponses(
            value = @ApiResponse(
                    responseCode = "200",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = SourceListItemDto.class))
                            )
                    }
            )
    )
    @GetMapping(value = "/", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ArrayList<SourceListItemDto> getSources() {
        ArrayList<SourceListItemDto> collection = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            collection.add(new SourceListItemDto());
        }

        return collection;
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