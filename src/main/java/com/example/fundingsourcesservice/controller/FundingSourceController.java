package com.example.fundingsourcesservice.controller;

import com.example.fundingsourcesservice.data.*;
import com.example.fundingsourcesservice.data.contract.SourceDetailDtoInterface;
import com.example.fundingsourcesservice.data.helper.DataMapperFactory;
import com.example.fundingsourcesservice.data.serializer.SourceListItemSerializer;
import com.example.fundingsourcesservice.entity.BankAccount;
import com.example.fundingsourcesservice.entity.CreditCard;
import com.example.fundingsourcesservice.entity.Source;
import com.example.fundingsourcesservice.repository.SourceRepository;
import com.example.fundingsourcesservice.service.FundingSourceService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/sources")
public class FundingSourceController {

    @Autowired
    FundingSourceService service;

    @Autowired
    SourceRepository sources;

    @Operation(summary="Get a source by its id")
    @GetMapping(value = "/{id}", produces = "application/json")
    public SourceDetailDtoInterface getSource(@PathVariable Long id) throws Exception {

        Optional<Source> entity = this.sources.findById(id);
        if (entity.isEmpty()) {
            throw new Exception("Entity not found");
        }

        return DataMapperFactory.convertSourceEntityToDetailDto(entity.get());
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

        // TODO: Filter deleted items
        Iterable<Source> data = this.sources.findAll();
        ArrayList<SourceListItemDto> collection = new ArrayList<>();

        // TODO: Refactor Mapper build ...
        // See: https://stackoverflow.com/a/57667716
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        SimpleModule module = new SimpleModule();
        module.addSerializer(CreditCard.class, new SourceListItemSerializer());
        module.addSerializer(BankAccount.class, new SourceListItemSerializer());

        mapper.registerModule(module);


        for (Source item : data) {
            SourceListItemDto dto  = mapper.convertValue(item, SourceListItemDto.class);
            collection.add(dto);
        }

        return collection;
    }

    @PostMapping(value="/", produces = "application/json")
    @Parameter(in = ParameterIn.HEADER, name = "X-USER-ID", schema = @Schema(type="string"), required = true)
    @ApiResponses(
            value = @ApiResponse(
                    responseCode = "201",
                    content = {
                            @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = SourceCreatedDto.class))
                            )
                    }
            )
    )
    @ResponseStatus(HttpStatus.CREATED)
    public SourceCreatedDto createSource(
            @RequestBody SourceDtoInterface source,
            @RequestHeader("X-USER-ID") String userId
    ) throws Exception {
        SourceCreatedDto response = this.service.createSourceFor(source, userId);
        return response;
    }
    // Usando la clase abstracta, castea bien en tiempo de ejecución.
    // Pero, chilla a nivel estático cuando se invoca a un método del servicio.
    // public SourceCreatedDto createSource(@RequestBody SourceDto source, @RequestHeader("X-USER-ID") String userId) throws Exception {
    //    return this.service.createSourceFor(source, userId);
        // return new SourceCreatedDto(1L, source.getName(), source.getType(), LocalDateTime.now());
    //}



    @DeleteMapping(value="/{id}", produces = "application/json")
    public SampleResponseDto deleteSource(@PathVariable int id) {
        return new SampleResponseDto("Delete source: " + id);
    }
}
