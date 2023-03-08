package com.ABML.ABML.dto;

import java.util.Date;
import javax.persistence.Temporal;
import javax.validation.constraints.NotBlank;


public class DtoPersona {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    private int edad;
    @NotBlank
    private String acerca;
    private String imgperfil;
   @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNac;
    private String mail;
    private String ocupacion;
    private String imgBanner;
    private String domicilio;

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, int edad, String acerca, String imgperfil, Date fechaNac, String mail, String ocupacion, String imgBanner, String domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.acerca = acerca;
        this.imgperfil = imgperfil;
        this.fechaNac = fechaNac;
        this.mail = mail;
        this.ocupacion = ocupacion;
        this.imgBanner = imgBanner;
        this.domicilio = domicilio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getAcerca() {
        return acerca;
    }

    public void setAcerca(String acerca) {
        this.acerca = acerca;
    }

    public String getImgperfil() {
        return imgperfil;
    }

    public void setImgperfil(String imgperfil) {
        this.imgperfil = imgperfil;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getImgBanner() {
        return imgBanner;
    }

    public void setImgBanner(String imgBanner) {
        this.imgBanner = imgBanner;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    

    
}
