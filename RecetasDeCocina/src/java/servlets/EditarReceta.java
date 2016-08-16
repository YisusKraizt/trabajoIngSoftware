/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import BaseDatos.connectSQLITE;
import clases.Ingredientes;
import clases.Receta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Carlos
 */
public class EditarReceta extends HttpServlet {
   
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

        try {
            HttpSession session = request.getSession(true);
            String id = request.getParameter("id");

            connectSQLITE bd = new connectSQLITE();
            bd.connect();

            String query = "select r.nombre, r.provincia, t.tipo, r.comentario, r.precio"
                    + " from receta r, tipoplato t"
                    + " where r.idreceta="+id+" and r.idtipoplato=t.idtipoplato;";
            String queryIngredientes = "select i.nombre"
                    + " from ingrediente i, receta_has_ingrediente ri"
                    + " where i.idingrediente=ri.idingrediente and ri.idtemporada=" + id;

            ResultSet rs = bd.executeSelect(query);
            rs.next();
            String nombre = rs.getString("nombre");
            String categoria = rs.getString("tipo");
            String provincia = rs.getString("provincia");
            String modoElab = rs.getString("comentario");
            String precio = rs.getString("precio");
            System.out.println("***** ModoElab: " + modoElab);
            Receta receta = new Receta(id, nombre, categoria, provincia, precio, modoElab);
            rs.close();

            ResultSet rsIngredientes = bd.executeSelect(queryIngredientes);
            ArrayList<Ingredientes> listaIngredientes = new ArrayList<Ingredientes>();
            String nombreIng;
            while(rsIngredientes.next()){
                nombreIng = rsIngredientes.getString("nombre");
                Ingredientes ingrediente = new Ingredientes(nombreIng,1);
                listaIngredientes.add(ingrediente);
            }
            rsIngredientes.close();

            receta.setIngredientes(listaIngredientes);
            session.setAttribute("receta", receta);
            bd.close();
//            String sql = "Update **tablaReceta**"
//                    + " Set name=" + name + ", category=" + category + ", ingredients=" + ingredients + ", howto=" + howto
//                    + " Where condiciones_de_selecciÃ³n";

            //Actualizar

            response.sendRedirect(request.getContextPath() + "/jsp/editarReceta.jsp");
        } catch (SQLException ex) {
            Logger.getLogger(EditarReceta.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EditarReceta.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EditarReceta.class.getName()).log(Level.SEVERE, null, ex);
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