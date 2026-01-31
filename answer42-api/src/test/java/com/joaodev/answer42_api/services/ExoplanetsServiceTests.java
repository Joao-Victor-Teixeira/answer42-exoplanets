package com.joaodev.answer42_api.services;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.joaodev.answer42_api.models.entities.Exoplanets;
import com.joaodev.answer42_api.repositories.ExoplanetsRepository;
import com.joaodev.answer42_api.tests.ExoplanetsFactory;

@ExtendWith(MockitoExtension.class)
public class ExoplanetsServiceTests {

    @InjectMocks
    private ExoplanetsService service;

    @Mock
    private ExoplanetsRepository repository;

    private Exoplanets exoplanets;
    private String existingId;
    private String nonExistingId; 

    @BeforeEach
    void setUp(){
        exoplanets = ExoplanetsFactory.createExoplanets();
        existingId = "697957798c73b0fceffff2dd";
        nonExistingId = "999";
    }

    @Test
    @DisplayName("Deve retornar uma página de exoplanetas")
    void findAllShouldReturnPagedExoplanets(){
        Page<Exoplanets> page = new PageImpl<>((List.of(exoplanets)));
        Pageable pageable = PageRequest.of(0, 10);

        Mockito.when(repository.findAll(pageable)).thenReturn(page);

        Page<Exoplanets> exoplanetsResult = service.findAll(pageable);

        Assertions.assertNotNull(exoplanetsResult);
        Assertions.assertEquals(1, exoplanetsResult.getTotalElements());

        Exoplanets exoplanet = exoplanetsResult.getContent().get(0);

        Assertions.assertEquals(exoplanets.getId(), exoplanet.getId());
        Assertions.assertEquals(exoplanets.getPl_name(), exoplanet.getPl_name());
        Assertions.assertEquals(exoplanets.getHostname(), exoplanet.getHostname());
        Assertions.assertEquals(exoplanets.getSt_rad(), exoplanet.getSt_rad());

        Mockito.verify(repository).findAll(pageable);
    }

    @Test
    @DisplayName("Deve retornar um único exopplaneta correspondente ao id passado na requisição")
    void findByIdShoudReturnExoplantWhenIdExists(){

        Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(exoplanets));

        Exoplanets exoplanetResult = service.findByid(existingId);

        Assertions.assertNotNull(exoplanetResult);
        Assertions.assertEquals(exoplanets.getId(), exoplanetResult.getId());
        Assertions.assertEquals(exoplanets.getPl_name(), exoplanetResult.getPl_name());
        Assertions.assertEquals(exoplanets.getHostname(), exoplanetResult.getHostname());
        Assertions.assertEquals(exoplanets.getSt_rad(), exoplanetResult.getSt_rad());

        Mockito.verify(repository).findById(existingId);
    }
}
