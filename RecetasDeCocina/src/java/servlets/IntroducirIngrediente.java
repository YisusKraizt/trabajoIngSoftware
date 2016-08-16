/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import BaseDatos.connectSQLITE;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author USUARIO
 */
@WebServlet(name="IntroducirIngrediente", urlPatterns={"/IntroducirIngrediente"})
public class IntroducirIngrediente extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int accedeingrediente = 0;
        try {
            HttpSession session=request.getSession(true);
            String name = request.getParameter("name");
            //System.out.println("name"+name);
            String precio = request.getParameter("price");
            String cantidad = request.getParameter("cant");
            String lugar = request.getParameter("place");
            String propiedades = request.getParameter("howto");
            if(precio ==""||cantidad ==""|| lugar=="" || propiedades=="" )
            { accedeingrediente=1;}
            else{
            connectSQLITE conn=new  connectSQLITE();
            conn.connect();

            ResultSet rs=conn.executeSelect("select count(*) from receta;");
            rs.next();
            String aux = rs.getString(1);
            Integer p = new Integer(aux);//p el numero maximo
            p=p+1;

            String sql="INSERT INTO ingrediente (idingrediente,nombre,propiedades,lugar,precio) VALUES ('"+p+"','"+name+"','"+propiedades+"','"+lugar+"','"+precio+"');";
            System.out.println("sentencia"+sql);
            //ResultSet re=conn.executeSelect(sql);
            conn.executeInsert(sql);

            Integer idreceta=(Integer)session.getAttribute("receta");
             String sql2="INSERT INTO receta_has_ingrediente (idingrediente,idtemporada) VALUES ('"+p+"','"+idreceta+"');";
            //System.out.println("sentencia"+sql);
             conn.executeInsert(sql2);
            }
            if (accedeingrediente==0){
                response.sendRedirect(request.getContextPath() + "/jsp/introduciringrediente.jsp");
            }

            else{
                response.sendRedirect(request.getContextPath() + "/jsp/faltaningred.jsp");
            }
            
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(IntroducirIngrediente.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(IntroducirIngrediente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}