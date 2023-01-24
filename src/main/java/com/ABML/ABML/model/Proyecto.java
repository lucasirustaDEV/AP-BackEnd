package com.ABML.ABML.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private String descripcion;
    private String imgproyecto;
    private String linkproyecto;

    public Proyecto() {
    }

    public Proyecto(String nombre, String descripcion, String imgproyecto, String linkproyecto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imgproyecto = imgproyecto;
        this.linkproyecto = linkproyecto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
