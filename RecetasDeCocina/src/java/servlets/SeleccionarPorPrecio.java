/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import BaseDatos.GestorBDRecetas;
import BaseDatos.connectSQLITE;
import clases.Receta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
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
public class SeleccionarPorPrecio extends HttpServlet {

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
            HttpSession session = request.getSession(true);
            String precio = request.getParameter("precio");


            connectSQLITE bd = new connectSQLITE();
            bd.connect();


//            String query = "select r.idreceta, r.nombre, r.provincia, t.tipo,r.precio"
//                    + " from receta r, tipoplato t"
//                    + " where r.idtipoplato=t.idtipoplato and r.precio < '" + precio + "';";
            String query = "select r.idreceta, r.nombre, r.provincia, t.tipo,r.precio, v.url"
                    + " from receta r, tipoplato t, video v"
                    + " where r.idtipoplato=t.idtipoplato and v.idvideo=r.idvideo and r.precio <'" + precio + "';";

//            ResultSet rs = bd.baseDeDatos.ejecutar(query);
             ResultSet rs = bd.executeSelect(query);

            ArrayList<Receta> listaRecetas = new ArrayList<Receta>();

            while(rs.next()){
                String id = rs.getString("idReceta");
                String nombre = rs.getString("nombre");
                String cat = rs.getString("Tipo");
                  String prov = rs.getString("provincia");
                  String prec = rs.getString("precio");
                  String url =rs.getString("url");

                Receta receta = new Receta(id,nombre,cat,prov,prec);
                receta.setVideo(url);
                session.setAttribute("rec",receta);

                listaRecetas.add(receta);
            }

//            bd.baseDeDatos.cerrar();
             bd.close();

            session.setAttribute("consulta", listaRecetas);

            response.sendRedirect(request.getContextPath()+"/jsp/mostrarRecetaFiltro.jsp");
        } catch (Exception ex) {
            Logger.getLogger(SeleccionarPorCategoria.class.getName()).log(Level.SEVERE, null, ex);
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

}
