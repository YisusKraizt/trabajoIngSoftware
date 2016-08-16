/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

/**
 *
 * @author INGENIERIA
 */
public class GestorBDRecetas {
     public GestorBD baseDeDatos;

    public GestorBDRecetas() {
        baseDeDatos = new GestorBD("mydb","recetas","recetas");
    }

}
