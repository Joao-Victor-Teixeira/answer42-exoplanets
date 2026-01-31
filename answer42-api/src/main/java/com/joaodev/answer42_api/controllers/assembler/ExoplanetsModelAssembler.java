package com.joaodev.answer42_api.controllers.assembler;

import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.joaodev.answer42_api.models.dto.ExoplanetsDTO;
import com.joaodev.answer42_api.models.entities.Exoplanets;

@Component
public class ExoplanetsModelAssembler implements RepresentationModelAssembler<Exoplanets, ExoplanetsDTO>  {

    @Override
    public ExoplanetsDTO toModel(Exoplanets entity) {
        
        ExoplanetsDTO dto = new ExoplanetsDTO(entity);

        return dto;
       
    }

}
