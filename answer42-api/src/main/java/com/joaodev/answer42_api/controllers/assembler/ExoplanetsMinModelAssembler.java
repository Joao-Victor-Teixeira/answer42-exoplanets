package com.joaodev.answer42_api.controllers.assembler;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.joaodev.answer42_api.models.dto.ExoplanetMinDTO;
import com.joaodev.answer42_api.models.entities.Exoplanets;

@Component
public class ExoplanetsMinModelAssembler implements RepresentationModelAssembler<Exoplanets, ExoplanetMinDTO> {

    @Override
    public ExoplanetMinDTO toModel(Exoplanets entity) {

        ExoplanetMinDTO mindto = new ExoplanetMinDTO(entity);

        return mindto;

    }

}
