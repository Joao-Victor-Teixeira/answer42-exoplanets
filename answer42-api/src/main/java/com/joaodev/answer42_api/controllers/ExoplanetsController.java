package com.joaodev.answer42_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaodev.answer42_api.models.dto.ExoplanetsDTO;
import com.joaodev.answer42_api.services.ExoplanetsService;

@RestController
@RequestMapping(value = "/exoplanets")
public class ExoplanetsController {

    @Autowired
    private ExoplanetsService service;

    @GetMapping
    public Page<ExoplanetsDTO> findAll(Pageable pageable){
        return service.findAll(pageable);
    }
}
