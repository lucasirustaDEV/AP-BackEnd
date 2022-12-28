package com.ABML.ABML.dto;

import javax.validation.constraints.NotBlank;

public class DtoSkill {
    @NotBlank
    private String nombre;
    @NotBlank
    private int porcentaje;

    public DtoSkill() {
    }

    public DtoSkill(String nombre, int porcentaje) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    
    
}
