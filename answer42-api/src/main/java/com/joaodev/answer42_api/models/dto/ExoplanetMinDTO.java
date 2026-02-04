package com.joaodev.answer42_api.models.dto;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.joaodev.answer42_api.models.entities.Exoplanets;

import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true, value = {"links"})
@Schema(description = "DTO com os campos mínimos dos planetas")
public class ExoplanetMinDTO extends RepresentationModel<ExoplanetMinDTO> {

    @Schema(description = "Atributo indentificador de cada planeta", example = "697957798c73b0fceffff2de")
    private String id;

    @Schema(description = "Nome do planeta", example = "AU Mic b")
    private String pl_name;
    
    @Schema(description = "Nome da estrela hospedeira", example = "AU Mic")
    private String hostname;

    @Schema(description = "Ano da descoberta", example = "2020")
    private Integer disc_year;
    
    @Schema(description = "Observatório ou equipe de descoberta", example = "Transiting Exoplanet Survey Satellite (TESS)")
    private String disc_facility;

    public ExoplanetMinDTO() {
    }

    public ExoplanetMinDTO(String id, String pl_name, String hostname, Integer disc_year, String disc_facility) {
        this.id = id;
        this.pl_name = pl_name;
        this.hostname = hostname;
        this.disc_year = disc_year;
        this.disc_facility = disc_facility;
    }

    public ExoplanetMinDTO(Exoplanets entity) {
        id = entity.getId();
        pl_name = entity.getPl_name();
        hostname = entity.getHostname();
        disc_year = entity.getDisc_year();
        disc_facility = entity.getDisc_facility();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPl_name() {
        return pl_name;
    }

    public void setPl_name(String pl_name) {
        this.pl_name = pl_name;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getDisc_year() {
        return disc_year;
    }

    public void setDisc_year(Integer disc_year) {
        this.disc_year = disc_year;
    }

    public String getDisc_facility() {
        return disc_facility;
    }

    public void setDisc_facility(String disc_facility) {
        this.disc_facility = disc_facility;
    }
}
