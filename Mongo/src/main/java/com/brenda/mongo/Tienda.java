package com.brenda.mongo;

public class Tienda {

    int idRefresco;
    String nombre;
    double precio;
    String tamanio;
    int existencias;

    public Tienda() {
    }

    public Tienda(int idRefresco, String nombre, double precio, String tamanio, int existencias) {
        this.idRefresco = idRefresco;
        this.nombre = nombre;
        this.precio = precio;
        this.tamanio = tamanio;
        this.existencias = existencias;
    }

    public int getIdRefresco() {
        return idRefresco;
    }

    public void setIdRefresco(int idRefresco) {
        this.idRefresco = idRefresco;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
}
