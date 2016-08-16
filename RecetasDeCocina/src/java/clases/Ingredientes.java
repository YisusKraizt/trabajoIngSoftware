/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author INGENIERIA
 */
public class Ingredientes {
private String nombre;
 private int cantidad;

    public Ingredientes(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        if (nombre.equals("") || cantidad==0) {
           throw new IllegalArgumentException("No se permiten ingredientes vacios");
        }
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}