/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

import java.sql.*;

public class GestorBD
{
    static private String basedatos;
    static private String usuario;
    static private String password;
    static private String url;
    static private Connection conn;
    static public Statement sentencia;



    public GestorBD (String bd, String user, String pasw){
        basedatos=bd;
        usuario=user;
        password=pasw;
        url="jdbc:mysql://localhost/"+basedatos;
        conn=null;
        sentencia=null;
    }

    public static void conectar ()throws Exception{
        conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn=DriverManager.getConnection(url, usuario, password);

            if (conn!=null){
               sentencia=conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
               }

            }
        catch (SQLException ex) {
              System.out.println("No se puede conectar a la base de datos ubicada en "+url+"\n");
        }
        catch (ClassNotFoundException ex){
              System.out.println(ex);
        }
    }

    public static void cerrar(){
        try {
            if (conn!=null) {
               sentencia.close();
               conn.close();
               }
            }
        catch (Exception ex){
              System.out.println(ex);
        }
    }

    public ResultSet ejecutar(String cadena) throws SQLException
    {
    return sentencia.executeQuery(cadena);
    }
}