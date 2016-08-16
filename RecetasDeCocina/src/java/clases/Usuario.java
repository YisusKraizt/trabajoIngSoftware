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
public class Usuario {
 private String id;
       private String login;
       private String password;
       

    public Usuario() {
        this.id="";
        this.login="";
        this.password="";
        
    }

    

    public void setUsuario(String id, String login, String password, String tipo, String servicios) {
        this.id = id;
        this.login = login;
        this.password = password;
        
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

   public void setId(String id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}