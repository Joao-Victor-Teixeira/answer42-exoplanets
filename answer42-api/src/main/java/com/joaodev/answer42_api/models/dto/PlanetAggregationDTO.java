package com.joaodev.answer42_api.models.dto;

public class PlanetAggregationDTO {
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

