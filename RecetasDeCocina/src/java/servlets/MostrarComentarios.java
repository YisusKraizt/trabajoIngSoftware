/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import BaseDatos.connectSQLITE;
import clases.Receta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MostrarComentarios extends HttpServlet {
   
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
            connectSQLITE conn=new  connectSQLITE();
            conn.connect();

            String id = request.getParameter("id");
            System.out.println("***ID: "+id);
            String query = "select r.idreceta, r.nombre, t.tipo, r.provincia, v.url, r.precio, r.comentario from receta r, tipoplato t, video v, ingrediente i, receta_has_ingrediente ri "
                    + "where idreceta="+id+" and r.idtipoplato=t.idtipoplato and v.idvideo=r.idvideo";
            ResultSet resul=conn.executeSelect(query);
            resul.next();
            String identificador = resul.getString("idreceta");
            String nom = resul.getString("nombre");
            String categ = resul.getString("tipo");
            String provincia = resul.getString("provincia");
            String precio= resul.getString("precio");
            String modeb = resul.getString("comentario");
            String url = resul.getString("url");
            Receta nueva =  new Receta(identificador,nom,categ,provincia,precio,modeb);
            nueva.setVideo(url);
            query= "select c.comentario from comentario c, receta r where r.idreceta=c.idreceta and r.idreceta="+id;
            System.out.println(query);
            resul=conn.executeSelect(query);
            List<String> list = new ArrayList<String>();
           
            while(resul.next()){
                System.out.println(resul.getString("comentario"));
                list.add(resul.getString("comentario"));
            }
            System.out.println("lista comentarios"+list);
            if(list.isEmpty()){
            session.setAttribute("receta", nom);
            session.setAttribute("id", id);
            resul.close();
            conn.close();
            response.sendRedirect(request.getContextPath()+"/jsp/errorcomentarios.jsp");
            }
            else{
            session.setAttribute("comentarios",list);
            session.setAttribute("rec", nueva);

            resul.close();
            conn.close();
            response.sendRedirect(request.getContextPath()+"/jsp/mostrarcomentarios.jsp");
            }
            


        } catch (Exception ex) {
            Logger.getLogger(RecetaAleatoriaBuena.class.getName()).log(Level.SEVERE, null, ex);
        }  finally {
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