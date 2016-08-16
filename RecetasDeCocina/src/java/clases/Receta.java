/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.*;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class Receta {

    private String id;
    private String nombre;
    private ArrayList ingredientes = new ArrayList();
    private String categoria;
    private String provincia;
    private String precio;
    private String video;
    private String modoelab;

    public Receta(String id, String nombre, String categoria, String provincia){
        if(nombre == "")
            throw new IllegalArgumentException();
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.provincia = provincia;
    }

    public Receta(String id, String nombre, String categoria, String provincia,String precio){
        if(nombre == "")
            throw new IllegalArgumentException();
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.provincia = provincia;
        this.precio = precio;
    }

     public Receta(String id, String nombre, String categoria, String provincia,String precio, String modlab){
        if(nombre == "")
            throw new IllegalArgumentException();
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.provincia = provincia;
        this.precio = precio;
        this.modoelab=modlab;
    }


    Receta(String string, String string0) {
        throw new UnsupportedOperationException("Not yet implemented");
    }


    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getModoelab() {
        return modoelab;
    }

    public void setModoelab(String modoelab) {
        this.modoelab = modoelab;
    }


    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public ArrayList getIngredientes() {
        return ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIngredientes(ArrayList ingredientes) {
        this.ingredientes = ingredientes;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void addAReceta(Ingredientes I){
    this.ingredientes.add(I);
    }

    public void verReceta(){
        System.out.println("La receta es :"+this.getNombre());

        for(int i=0;i<this.ingredientes.size();i++){
            System.out.println("Ingrediente "+i+"\n"+((Ingredientes)this.ingredientes.get(i)).getNombre());
            System.out.println("Cantidad \n"+((Ingredientes)this.ingredientes.get(i)).getCantidad());
        }
    }

}