/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

/**
 *
 * @author Usuario
 */
@WebServlet(name="ImagenesBBDD", urlPatterns={"/ImagenesBBDD"})
public class ImagenesBBDD extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ImagenesBBDD</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ImagenesBBDD at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    // mostramos un mensaje de depuraciÃ³n del sistema
    public void depura(String param)
    {
        System.out.println("Mensaje depuraciÃ³n: " + param);
    }
    // guardamos desde el stream de base de datos a disco
    public void guardaImagenEnDisco(InputStream imagenBuffer)
    {
        try
        {
            File fichero = new File("c:\\paella.jpg");
            BufferedInputStream in = new BufferedInputStream(imagenBuffer);
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fichero));

            byte[] bytes = new byte[8096];
            int len = 0;

            depura("Copiamos el fichero");

            while ( (len = in.read( bytes )) > 0 )
            {
                out.write( bytes, 0, len );
            }

            out.flush();
            out.close();
            in.close();

            depura("TeminaciÃ³n del proceso con Ã©xito");
        }
        catch(Exception e)
        {
            depura("Error al escribir en disco " + e.getMessage());
        }
    }

    // recuperamos la conexion
    public Connection getConexion()
    {
        Connection con = null;

        try
        {
            Driver d = (Driver)Class.forName("com.mysql.jdbc.Driver").newInstance();

            depura("Recuperamos conexiÃ³n");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tutoriales","","");
        }
        catch(Exception e)
        {
            depura("Error al recuperar conexion " + e.toString());
            return null;
        }

        return con;
    }


    // leemos de la base de datos
    public InputStream recuperaImagenBBDD(Connection con)
    {
        try
        {
            String consultaGenerada = "select * from imagenesbbdd limit 1";

            depura("Ejecutamos Statment");
            java.sql.Statement stmt = con.createStatement();

            depura("Ejecutamos sentencia " + consultaGenerada);
            ResultSet results = stmt.executeQuery(consultaGenerada);

            results.next();

            Blob campo = results.getBlob("imagen");
            return campo.getBinaryStream();
        }
        catch(Exception e)
        {
            depura("Error al recuperar el Stream");
        }

        return null;
    }

    // escribimos la imagen en la base de datos
    void escribeImagenEnBBDD(Connection con)
    {
        try
        {
              File fichero = new File("c:\\paella.jpg");  // no es muy elegante pero esto es solo un ejemplo
              FileInputStream streamEntrada = new FileInputStream(fichero);
              PreparedStatement pstmt = con.prepareStatement("insert into imagenesbbdd (nombre,imagen) values (?,?)",Statement.RETURN_GENERATED_KEYS);
              pstmt.setString(1, "paella.jpg");
              pstmt.setBinaryStream(2, streamEntrada, (int)fichero.length());
              pstmt.executeUpdate();

              // recuperamos el indice del elemento generado
              ResultSet rs = pstmt.getGeneratedKeys();
              rs.next();

              depura("El id recuperado es: " + rs.getInt(1));

              rs.close();
              pstmt.close();
              streamEntrada.close();

        }
        catch(Exception e)
        {
            depura("Error al escribir el Stream " + e.getMessage());
        }
    }


}