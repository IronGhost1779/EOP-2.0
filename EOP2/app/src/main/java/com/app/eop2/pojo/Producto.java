package com.app.eop2.pojo;

public class Producto {
    private String Nombre;
    private String Pasillo;
    private String Mostrador;

    public Producto() {

    }

    public Producto(String nombre, String pasillo, String mostrador) {
        Nombre = nombre;
        Pasillo = pasillo;
        Mostrador = mostrador;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPasillo() {
        return Pasillo;
    }

    public void setPasillo(String pasillo) {
        Pasillo = pasillo;
    }

    public String getMostrador() {
        return Mostrador;
    }

    public void setMostrador(String mostrador) {
        Mostrador = mostrador;
    }
}
