package com.joaodev.answer42_api.controllers.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.joaodev.answer42_api.controllers.ExoplanetsController;
import com.joaodev.answer42_api.models.dto.ExoplanetMinDTO;
import com.joaodev.answer42_api.models.entities.Exoplanets;

@Component
public class ExoplanetsMinModelAssembler implements RepresentationModelAssembler<Exoplanets, ExoplanetMinDTO> {

    @Override
    public ExoplanetMinDTO toModel(Exoplanets entity) {

        ExoplanetMinDTO minDto = new ExoplanetMinDTO(entity);

        minDto.add(linkTo(methodOn(ExoplanetsController.class).findById(entity.getId())).withSelfRel());

        minDto.add(linkTo(methodOn(ExoplanetsController.class).findAll(null, null)).withRel("all-exoplanets"));

        minDto.add(linkTo(methodOn(ExoplanetsController.class).findEarthLike(null, null))
                .withRel("exoplanets-similar-earth"));

        return minDto;

    }

}
