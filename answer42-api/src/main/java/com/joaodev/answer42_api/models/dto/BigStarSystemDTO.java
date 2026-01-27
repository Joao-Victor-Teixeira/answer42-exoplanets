package com.joaodev.answer42_api.models.dto;

import java.util.ArrayList;
import java.util.List;

public class BigStarSystemDTO {

    private String hostname;
    private Double st_rad;
    
    private List<ExoplanetMinDTO> planets = new ArrayList<>();

    public BigStarSystemDTO(){
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

    public List<ExoplanetMinDTO> getPlanets() {
        return planets;
    }
    
}
