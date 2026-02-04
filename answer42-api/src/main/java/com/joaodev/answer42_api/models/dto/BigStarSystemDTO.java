package com.joaodev.answer42_api.models.dto;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO responsável por filtrar as maiores estrelas que abrigam planetas")
public class BigStarSystemDTO {

    @Schema(description = "Nome da estrela hospedeira", example = "HAT-P-59")
    private String hostname;

    @Schema(description = "Raio da estrela comparada ao Sol", example = "1.1038")
    private Double st_rad;

    @Schema(description = "Lista de planetas associados à estrela")
    private List<PlanetAggregationDTO> planets;

    public BigStarSystemDTO() {
    }

    public BigStarSystemDTO(String hostname, Double st_rad) {
        this.hostname = hostname;
        this.st_rad = st_rad;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Double getSt_rad() {
        return st_rad;
    }

    public void setSt_rad(Double st_rad) {
        this.st_rad = st_rad;
    }

    public List<PlanetAggregationDTO> getPlanets() {
        return planets;
    }

}
