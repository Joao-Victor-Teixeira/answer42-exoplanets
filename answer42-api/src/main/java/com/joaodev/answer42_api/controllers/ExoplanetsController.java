package com.joaodev.answer42_api.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaodev.answer42_api.controllers.assembler.ExoplanetsMinModelAssembler;
import com.joaodev.answer42_api.controllers.assembler.ExoplanetsModelAssembler;
import com.joaodev.answer42_api.models.dto.BigStarSystemDTO;
import com.joaodev.answer42_api.models.dto.ExoplanetMinDTO;
import com.joaodev.answer42_api.models.dto.ExoplanetsDTO;
import com.joaodev.answer42_api.models.dto.StarSystemDTO;
import com.joaodev.answer42_api.models.entities.Exoplanets;
import com.joaodev.answer42_api.services.ExoplanetsService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/exoplanets",produces = "application/json")
@Tag(name = "Exoplanets", description = "Controlador REST que filtra exoplanetas da API da NASA")
public class ExoplanetsController {

    private final ExoplanetsService service;

    private final ExoplanetsModelAssembler assembler;

    private final ExoplanetsMinModelAssembler minAssembler;

    public ExoplanetsController(ExoplanetsService service, ExoplanetsModelAssembler assembler,
            ExoplanetsMinModelAssembler minAssembler) {
        this.service = service;
        this.assembler = assembler;
        this.minAssembler = minAssembler;
    }

    @Operation(
        summary = "Retorna todos os exoplanetas de forma paginada",
        description = "Retorna uma página no formato JSON com todos os exoplanetas, contendo informações básicas dos planetas ",
        responses = {
            @ApiResponse(
                description = "Sucesso",
                responseCode = "200",
                content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ExoplanetMinDTO.class)))    
            ),
            @ApiResponse(description = "Erro interno do servidor", responseCode = "500", content = @Content)
       })
    @GetMapping
    public ResponseEntity<PagedModel<ExoplanetMinDTO>> findAll(
            Pageable pageable,
            PagedResourcesAssembler<Exoplanets> pagedResourcesAssembler) {

        Page<Exoplanets> page = service.findAll(pageable);
        PagedModel<ExoplanetMinDTO> pagedModel = pagedResourcesAssembler.toModel(page, minAssembler);

        return ResponseEntity.ok(pagedModel);
    }

    @Operation(
        summary = "Retorna um exoplaneta por id",
        description = "Retorna um único exoplaneta com todos os atributos mais atributos da sua estrela hospedeira no formato JSON",
        responses = {
            @ApiResponse(
                description = "Sucesso",
                responseCode = "200",
                content = @Content(schema = @Schema(implementation = ExoplanetsDTO.class))
            ),
            @ApiResponse(description = "")
        })
    @GetMapping(value = "/{id}")
    public ResponseEntity<ExoplanetsDTO> findById(@PathVariable String id) {
        Exoplanets exoplanets = service.findByid(id);
        ExoplanetsDTO dto = assembler.toModel(exoplanets);
        return ResponseEntity.ok(dto);
    }

    @Operation(
        summary = "Retorna todos os exoplanetas similares à Terra",
        description = "Retorna uma página no formato JSON com todos os exoplanetas similares à Terra, contendo todas informações dos planetas "
                        + "e algumas informações da sua estrela hospedeira.",
        responses = {
            @ApiResponse(
                description = "Sucesso",
                responseCode = "200",
                content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ExoplanetsDTO.class)))    
            ),
            @ApiResponse(description = "Erro interno do servidor", responseCode = "500", content = @Content)
       })
    @GetMapping(value = "/earth-similar")
    public ResponseEntity<PagedModel<ExoplanetsDTO>> findEarthLike(
            Pageable pageable,
            PagedResourcesAssembler<Exoplanets> pagedResourcesAssembler) {

        Page<Exoplanets> page = service.findEarthLike(pageable);
        PagedModel<ExoplanetsDTO> pagedModel = pagedResourcesAssembler.toModel(page, assembler);
        return ResponseEntity.ok(pagedModel);
    }

    @Operation(
        summary = "Retorna as estrelas com mais planetas",
        description = "Retorna uma lista no formato JSON com as estrelas que abrigam mais planetas já encontradas," 
                    + "contendo os seus nomes e seus planetas ",
        responses = {
            @ApiResponse(
                description = "Sucesso",
                responseCode = "200",
                content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = StarSystemDTO.class)))    
            ),
            @ApiResponse(description = "Erro interno do servidor", responseCode = "500", content = @Content)
       })
    @GetMapping("/top-stars")
    public ResponseEntity<List<StarSystemDTO>> getTopStars() {
        List<StarSystemDTO> topStars = service.getTopStarSystems();
        return ResponseEntity.ok().body(topStars);
    }

    @Operation(
        summary = "Retorna os maiores sistemas planetários",
        description = "Retorna uma lista no formato JSON com os maiores sistemas planetários" 
                    + "contendo os seus e o número de planetas abrigados ",
        responses = {
            @ApiResponse(
                description = "Sucesso",
                responseCode = "200",
                content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = BigStarSystemDTO.class)))    
            ),
            @ApiResponse(description = "Erro interno do servidor", responseCode = "500", content = @Content)
       })
    @GetMapping("/big-stars")
    public ResponseEntity<List<BigStarSystemDTO>> getBigStars() {
        List<BigStarSystemDTO> bigStars = service.getBiggestStarsWithPlanets();
        return ResponseEntity.ok().body(bigStars);
    }

}
