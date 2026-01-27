package com.joaodev.answer42_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaodev.answer42_api.models.dto.ExoplanetMinDTO;
import com.joaodev.answer42_api.models.dto.ExoplanetsDTO;
import com.joaodev.answer42_api.services.ExoplanetsService;

@RestController
@RequestMapping(value = "/exoplanets")
public class ExoplanetsController {

    @Autowired
    private ExoplanetsService service;

    @GetMapping
    public Page<ExoplanetMinDTO> findAll(Pageable pageable){
        return service.findAll(pageable);
    }

    @GetMapping(value = "/{id}")
    public ExoplanetsDTO findById(@PathVariable String id){
        return service.findByid(id);
    }

    @GetMapping(value = "/earthSimilar")
    public Page<ExoplanetsDTO> findEarthLike(Pageable pageable){
        return service.findEarthLike(pageable);
    }
}
