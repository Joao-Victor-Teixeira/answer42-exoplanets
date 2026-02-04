package com.joaodev.answer42_api.models.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO que representa o agrupamento de exoplanetas por sistema estelar")
public class StarSystemDTO {

    @Schema(description = "Nome da estrela hospedeira (sistema)", example = "Kepler-90")
    private String hostname;

    @Schema(description = "Quantidade total de exoplanetas confirmados orbitando esta estrela", example = "8")
    private Long planetCount;

    public StarSystemDTO() {
    }

    public StarSystemDTO(String hostname, Long planetCount) {
        this.hostname = hostname;
        this.planetCount = planetCount;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Long getPlanetCount() {
        return planetCount;
    }

    public void setPlanetCount(Long planetCount) {
        this.planetCount = planetCount;
    }

}
