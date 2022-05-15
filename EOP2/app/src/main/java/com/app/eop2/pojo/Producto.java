package com.app.eop2.pojo;

public class Producto {
    private String Nombre;
    private String Pasillo;
    private String Mostrador;

    public Producto() {

    }

    public Producto(String Nombre, String Pasillo, String Mostrador) {
        this.Nombre = Nombre;
        this.Pasillo = Pasillo;
        this.Mostrador = Mostrador;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getPasillo() {
        return Pasillo;
    }

    public void setPasillo(String pasillo) {
        this.Pasillo = pasillo;
    }

    public String getMostrador() {
        return Mostrador;
    }

    public void setMostrador(String mostrador) {
        this.Mostrador = mostrador;
    }
}
