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
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connectSQLITE {

    public connectSQLITE() {
    }
    private Connection conn;
    private Statement stat;

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            this.conn = DriverManager.getConnection("jdbc:sqlite:C:\\recetariocodigo\\RecetasDeCocina\\web\\other\\recetario.sqlite");
            this.stat = this.conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(connectSQLITE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(connectSQLITE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void close(){
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(connectSQLITE.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void ConnectSql() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection conn =
                DriverManager.getConnection("jdbc:sqlite:C:\\recetariocodigo\\RecetasDeCocina\\web\\other\\recetario.sqlite");
        Statement stat = conn.createStatement();
        // stat.executeUpdate("drop table if exists people;");
        //stat.executeUpdate("create table people (name, occupation);");
        PreparedStatement prep = conn.prepareStatement(
                "insert into usuario values (?, ?, ?);");

        // prep.setInt(1, 1);
        prep.setString(2, "usuario");
        prep.setString(3, "luis");
        prep.addBatch();
//    //prep.setInt(1, 2);
//    prep.setString(2, "pepe");
//    prep.setString(2, "paco");
//    prep.addBatch();


        conn.setAutoCommit(false);
        prep.executeBatch();
        conn.setAutoCommit(true);

        ResultSet rs = stat.executeQuery("select * from usuario;");
        while (rs.next()) {
            System.out.println("id = " + rs.getInt("id"));
            System.out.println("usuario = " + rs.getString("login"));
            System.out.println("password = " + rs.getString("password"));
        }
        rs.close();
        conn.close();
    }

    public static int insertarUsuario(String login, String pass) throws ClassNotFoundException, SQLException {

        Class.forName("org.sqlite.JDBC");
        Connection conn =
                DriverManager.getConnection("jdbc:sqlite:C:\\recetariocodigo\\RecetasDeCocina\\web\\other\\recetario.sqlite");
        Statement stat = conn.createStatement();
        PreparedStatement prep = conn.prepareStatement(
                "insert into usuario values (?, ?, ?);");

        prep.setString(2, login);
        prep.setString(3, pass);
        prep.addBatch();

        conn.setAutoCommit(false);
        prep.executeBatch();
        conn.setAutoCommit(true);

        conn.close();
        return 1;

    }
    
     public static int insertarComentario(String id, String com) throws ClassNotFoundException, SQLException {

        Class.forName("org.sqlite.JDBC");
        Connection conn =
                DriverManager.getConnection("jdbc:sqlite:C:\\recetariocodigo\\RecetasDeCocina\\web\\other\\recetario.sqlite");
        Statement stat = conn.createStatement();
        PreparedStatement prep = conn.prepareStatement(
                "insert into comentario values (?, ?, ?);");

        prep.setString(2, id);
        prep.setString(3, com);
        prep.addBatch();

        conn.setAutoCommit(false);
        prep.executeBatch();
        conn.setAutoCommit(true);

        conn.close();
        return 1;

    }


    public ResultSet executeSelect( String query) throws SQLException {
        return stat.executeQuery(query);
    }
public int executeUpdate(String sql) throws SQLException {
        return stat.executeUpdate(sql);
    }

public void executeInsert(String query) throws SQLException{
        boolean i= stat.execute(query);
    }
}