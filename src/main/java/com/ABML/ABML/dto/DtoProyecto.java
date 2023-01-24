package com.ABML.ABML.dto;

import javax.validation.constraints.NotBlank;

public class DtoProyecto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;
    private String imgproyecto;
    private String linkproyecto;

    public DtoProyecto() {
    }

    public DtoProyecto(String nombre, String descripcion, String imgproyecto, String linkproyecto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imgproyecto = imgproyecto;
        this.linkproyecto = linkproyecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImgproyecto() {
        return imgproyecto;
    }

    public void setImgproyecto(String imgproyecto) {
        this.imgproyecto = imgproyecto;
    }

    public String getLinkproyecto() {
        return linkproyecto;
    }

    public void setLinkproyecto(String linkproyecto) {
        this.linkproyecto = linkproyecto;
    }
    
    
}
