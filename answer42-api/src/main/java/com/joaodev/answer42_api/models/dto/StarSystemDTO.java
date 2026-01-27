package com.joaodev.answer42_api.models.dto;

public class StarSystemDTO {

    private String hostname;
    private Long planetCount;

    public StarSystemDTO(){
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
