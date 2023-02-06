package com.ABML.ABML.dto;

import javax.validation.constraints.NotBlank;

public class DtoEducacion {
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;
    private String desde;
    private String hasta;
    private String imglogo;

    public DtoEducacion() {
    }

    public DtoEducacion(String nombreE, String descripcionE, String desde, String hasta, String imglogo) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
        this.desde = desde;
        this.hasta = hasta;
        this.imglogo = imglogo;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

    public String getDesde() {
        return desde;
    }

    public void setDesde(String desde) {
        this.desde = desde;
    }

    public String getHasta() {
        return hasta;
    }

    public void setHasta(String hasta) {
        this.hasta = hasta;
    }

    public String getImglogo() {
        return imglogo;
    }

    public void setImglogo(String imglogo) {
        this.imglogo = imglogo;
    }


    
}
