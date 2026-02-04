package com.joaodev.answer42_api.models.dto;

import org.springframework.hateoas.RepresentationModel;

import com.joaodev.answer42_api.models.entities.Exoplanets;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO com todos os campos de dados dos planetas")
public class ExoplanetsDTO extends RepresentationModel<ExoplanetsDTO> {

    @Schema(description = "Atributo indentificador de cada planeta", example = "697957798c73b0fceffff2dd")
    private String id;

    @Schema(description = "Nome do planeta", example = "55Cnc e")
    private String pl_name;
    
    @Schema(description = "Nome da estrela hospedeira", example = "55Cnc")
    private String hostname;

    @Schema(description = "Ano da descoberta", example = "2004")
    private Integer disc_year;
    
    @Schema(description = "Observatório ou equipe de descoberta", example = "McDonald Observatory")
    private String disc_facility;
    
    @Schema(description = "Método usado para a descoberta do planeta", example = "Radial Velocity")
    private String discoverymethod;

    @Schema(description = "Raio do planeta em comparação com a Terra", example = "1.875")
    private Double pl_rade;
    
    @Schema(description = "Massa do planeta em comparação com a Terra", example = "7.99")
    private Double pl_masse;
    
    @Schema(description = "Temperatura de equilíbrio do planeta em Kelvin", example = "1158.0")
    private Double pl_eqt;

    @Schema(description = "Período orbital do planeta (tempo para uma volta na estrela) em dias", example = "0.73654")
    private Double pl_orbtper;

    @Schema(description = "Semieixo maior da órbita (distância média da estrela) em UA", example = "0.01544")
    private Double pl_orbsmax;

    @Schema(description = "Temperatura efetiva da estrela hospedeira em Kelvin", example = "5196.0")
    private Double st_teff;

    @Schema(description = "Raio da estrela hospedeira em comparação com o Sol", example = "0.94")
    private Double st_rad;

    @Schema(description = "Massa da estrela hospedeira em comparação com o Sol", example = "0.91")
    private Double st_mass;

    @Schema(description = "Luminosidade da estrela hospedeira (log10)", example = "-0.134")
    private Double st_lum;

    @Schema(description = "Indica se o registro é o conjunto de parâmetros padrão da NASA", example = "true")
    private Boolean default_flag;

    @Schema(description = "Indica se o planeta transita sua estrela hospedeira", example = "true")
    private Boolean tran_flag;

    @Schema(description = "Indica se a existência do planeta é controversa", example = "false")
    private Boolean pl_controv_flag;

    @Schema(description = "Referência bibliográfica da descoberta ou dos dados", example = "<a href=https://ui.adsabs.harvard.edu/abs/2011ApJ...740...49D/abstract>Dawson & Fabrycky 2011</a>")
    private String pl_refname;

    public ExoplanetsDTO(){
    }

    public ExoplanetsDTO(String id, String pl_name, String hostname, Integer disc_year, String disc_facility,
            String discoverymethod, Double pl_rade, Double pl_masse, Double pl_eqt, Double pl_orbtper,
            Double pl_orbsmax, Double st_teff, Double st_rad, Double st_mass, Double st_lum, Boolean default_flag,
            Boolean tran_flag, Boolean pl_controv_flag, String pl_refname) {
        this.id = id;
        this.pl_name = pl_name;
        this.hostname = hostname;
        this.disc_year = disc_year;
        this.disc_facility = disc_facility;
        this.discoverymethod = discoverymethod;
        this.pl_rade = pl_rade;
        this.pl_masse = pl_masse;
        this.pl_eqt = pl_eqt;
        this.pl_orbtper = pl_orbtper;
        this.pl_orbsmax = pl_orbsmax;
        this.st_teff = st_teff;
        this.st_rad = st_rad;
        this.st_mass = st_mass;
        this.st_lum = st_lum;
        this.default_flag = default_flag;
        this.tran_flag = tran_flag;
        this.pl_controv_flag = pl_controv_flag;
        this.pl_refname = pl_refname;
    }

    public ExoplanetsDTO(Exoplanets entity) {
        id = entity.getId();
        pl_name = entity.getPl_name();
        hostname = entity.getHostname();
        disc_year = entity.getDisc_year();
        disc_facility = entity.getDisc_facility();
        discoverymethod = entity.getDiscoverymethod();
        pl_rade = entity.getPl_rade();
        pl_masse = entity.getPl_masse();
        pl_eqt = entity.getPl_eqt();
        pl_orbtper = entity.getPl_orbtper();
        pl_orbsmax = entity.getPl_orbsmax();
        st_teff = entity.getSt_teff();
        st_rad = entity.getSt_rad();
        st_mass = entity.getSt_mass();
        st_lum = entity.getSt_lum();
        default_flag = entity.getDefault_flag();
        tran_flag = entity.getTran_flag();
        pl_controv_flag = entity.getPl_controv_flag();
        pl_refname = entity.getPl_refname();
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

    public String getDiscoverymethod() {
        return discoverymethod;
    }

    public void setDiscoverymethod(String discoverymethod) {
        this.discoverymethod = discoverymethod;
    }

    public Double getPl_rade() {
        return pl_rade;
    }

    public void setPl_rade(Double pl_rade) {
        this.pl_rade = pl_rade;
    }

    public Double getPl_masse() {
        return pl_masse;
    }

    public void setPl_masse(Double pl_masse) {
        this.pl_masse = pl_masse;
    }

    public Double getPl_eqt() {
        return pl_eqt;
    }

    public void setPl_eqt(Double pl_eqt) {
        this.pl_eqt = pl_eqt;
    }

    public Double getPl_orbtper() {
        return pl_orbtper;
    }

    public void setPl_orbtper(Double pl_orbtper) {
        this.pl_orbtper = pl_orbtper;
    }

    public Double getPl_orbsmax() {
        return pl_orbsmax;
    }

    public void setPl_orbsmax(Double pl_orbsmax) {
        this.pl_orbsmax = pl_orbsmax;
    }

    public Double getSt_teff() {
        return st_teff;
    }

    public void setSt_teff(Double st_teff) {
        this.st_teff = st_teff;
    }

    public Double getSt_rad() {
        return st_rad;
    }

    public void setSt_rad(Double st_rad) {
        this.st_rad = st_rad;
    }

    public Double getSt_mass() {
        return st_mass;
    }

    public void setSt_mass(Double st_mass) {
        this.st_mass = st_mass;
    }

    public Double getSt_lum() {
        return st_lum;
    }

    public void setSt_lum(Double st_lum) {
        this.st_lum = st_lum;
    }

    public Boolean getDefault_flag() {
        return default_flag;
    }

    public void setDefault_flag(Boolean default_flag) {
        this.default_flag = default_flag;
    }

    public Boolean getTran_flag() {
        return tran_flag;
    }

    public void setTran_flag(Boolean tran_flag) {
        this.tran_flag = tran_flag;
    }

    public Boolean getPl_controv_flag() {
        return pl_controv_flag;
    }

    public void setPl_controv_flag(Boolean pl_controv_flag) {
        this.pl_controv_flag = pl_controv_flag;
    }

    public String getPl_refname() {
        return pl_refname;
    }

    public void setPl_refname(String pl_refname) {
        this.pl_refname = pl_refname;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ExoplanetsDTO other = (ExoplanetsDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Exoplanets{" +
                "pl_name='" + pl_name + '\'' +
                ", hostname='" + hostname + '\'' +
                ", disc_year=" + disc_year +
                ", discoverymethod='" + discoverymethod + '\'' +
                ", pl_rade=" + pl_rade +
                ", pl_masse=" + pl_masse +
                ", pl_eqt=" + pl_eqt +
                ", tran_flag=" + tran_flag +
                '}';
    }
}