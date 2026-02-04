package com.joaodev.answer42_api.models.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO que representa o nome de um planeta associado a uma estrela")
public class PlanetAggregationDTO {
    
    @Schema(description = "Nome do planeta", example = "HAT-P-59 b")
    private String pl_name;

    public PlanetAggregationDTO() {
    }

    public PlanetAggregationDTO(String pl_name) {
        this.pl_name = pl_name;
    }

    public String getPl_name() {
        return pl_name;
    }

    public void setPl_name(String pl_name) {
        this.pl_name = pl_name;
    }
}

