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

@RestController
@RequestMapping(value = "/exoplanets")
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

    @GetMapping
    public ResponseEntity<PagedModel<ExoplanetMinDTO>> findAll(
            Pageable pageable,
            PagedResourcesAssembler<Exoplanets> pagedResourcesAssembler) {

        Page<Exoplanets> page = service.findAll(pageable);
        PagedModel<ExoplanetMinDTO> pagedModel = pagedResourcesAssembler.toModel(page, minAssembler);

        return ResponseEntity.ok(pagedModel);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ExoplanetsDTO> findById(@PathVariable String id) {
        Exoplanets exoplanets = service.findByid(id);
        ExoplanetsDTO dto = assembler.toModel(exoplanets);
        return ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/earth-similar")
    public ResponseEntity<PagedModel<ExoplanetsDTO>> findEarthLike(
            Pageable pageable,
            PagedResourcesAssembler<Exoplanets> pagedResourcesAssembler) {

        Page<Exoplanets> page = service.findEarthLike(pageable);
        PagedModel<ExoplanetsDTO> pagedModel = pagedResourcesAssembler.toModel(page, assembler);
        return ResponseEntity.ok(pagedModel);
    }

    @GetMapping("/top-stars")
    public ResponseEntity<List<StarSystemDTO>> getTopStars() {
        List<StarSystemDTO> topStars = service.getTopStarSystems();
        return ResponseEntity.ok().body(topStars);
    }

    @GetMapping("/big-stars")
    public ResponseEntity<List<BigStarSystemDTO>> getBigStars() {
        List<BigStarSystemDTO> bigStars = service.getBiggestStarsWithPlanets();
        return ResponseEntity.ok().body(bigStars);
    }

}
