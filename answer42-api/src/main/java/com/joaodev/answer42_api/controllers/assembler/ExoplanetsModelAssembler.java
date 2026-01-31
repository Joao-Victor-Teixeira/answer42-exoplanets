package com.joaodev.answer42_api.controllers.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.joaodev.answer42_api.controllers.ExoplanetsController;
import com.joaodev.answer42_api.models.dto.ExoplanetsDTO;
import com.joaodev.answer42_api.models.entities.Exoplanets;

@Component
public class ExoplanetsModelAssembler implements RepresentationModelAssembler<Exoplanets, ExoplanetsDTO> {

    @Override
    public ExoplanetsDTO toModel(Exoplanets entity) {

        ExoplanetsDTO dto = new ExoplanetsDTO(entity);

        dto.add(linkTo(methodOn(ExoplanetsController.class).findById(entity.getId())).withSelfRel());

        dto.add(linkTo(methodOn(ExoplanetsController.class).findAll(null, null)).withRel("all-exoplanets"));

        dto.add(linkTo(methodOn(ExoplanetsController.class).findEarthLike(null, null))
                .withRel("exoplanets-similar-earth"));

        return dto;

    }

}
