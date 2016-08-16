/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

/**
 *
 * @author INGENIERIA
 */
import BaseDatos.connectSQLITE;
import clases.Receta;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.StringTokenizer;
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
public class BuscarReceta extends HttpServlet {
   
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
            ArrayList<String> palabras=new ArrayList();
            HttpSession session = request.getSession(true);
            String criterio = request.getParameter("criterio");
            String valor = request.getParameter("busqueda");
            String sqlWhere = "";
            int indica=0;
            palabras=buscar(valor);

            for(int t=0;t<palabras.size()+1;t++){
            valor=(String)palabras.get(t);
                System.out.println("valor"+valor);

            if(criterio.equals("nombre")){

             /*   sqlWhere = " where'"+ valor + "'=r.nombre  and "
                        + "r.idtipoplato=t.idtipoplato and v.idvideo=r.idvideo "
                        + "and ri.idtemporada=r.idreceta and i.idingrediente=ri.idingrediente ;";*/
                sqlWhere = " where r.idtipoplato=t.idtipoplato and v.idvideo=r.idvideo and r.nombre  LIKE '%"+valor+"%';";
                
                System.out.println("nombre "+sqlWhere);
            }
            if(criterio.equals("ingrediente")){
                sqlWhere = " where i.idingrediente=ri.idingrediente and "
                        + "ri.idtemporada=r.idreceta and r.idtipoplato=t.idtipoplato and r.idvideo=v.idvideo and i.nombre LIKE '%"+valor+"%';";
               indica=1;
                System.out.println("ingrediente "+sqlWhere);
            }
            if(criterio.equals("plato")){
                sqlWhere = " where r.idtipoplato=t.idtipoplato and v.idvideo=r.idvideo and t.tipo LIKE '%"+valor+"%';";
            }

           /* GestorBDRecetas bd = new GestorBDRecetas();
            String sql = "select r.idreceta, r.nombre, t.Tipo"
                    + " from receta r, TipoPlato t"
                    + sqlWhere;
            bd.baseDeDatos.conectar();
            ResultSet rs = bd.baseDeDatos.ejecutar(sql);*/
            
     // DriverManager.getConnection("jdbc:sqlite:C:\\recetariocodigo\\RecetasDeCocina\\web\\other\\recetario.sqlite");
     
    connectSQLITE conn=new  connectSQLITE();
     conn.connect();
     ResultSet rs;
    if(indica==1){
      rs=conn.executeSelect("select r.idreceta, r.nombre, t.tipo, r.provincia, v.url, r.precio from receta r, tipoplato t, video v, ingrediente i, receta_has_ingrediente ri" + sqlWhere);
            }
     else{
      rs=conn.executeSelect("select r.idreceta, r.nombre, t.tipo, r.provincia, v.url, r.precio from receta r, tipoplato t, video v" + sqlWhere);
            }
      // ResultSet rs = stat.executeQuery("SELECT * FROM usuario WHERE usuario='" + nombre + "' AND password=" + pass);
      System.out.println("sql: "+rs.toString());
      ArrayList<Receta> listaRecetas = new ArrayList<Receta>();

            while(rs.next()){
                String id = rs.getString("idReceta");
                String nombre = rs.getString("nombre");
                String cat = rs.getString("Tipo");
                 String prov = rs.getString("provincia");
                 String precio = rs.getString("precio");
                 String video = rs.getString("url");
                Receta receta = new Receta(id,nombre,cat,prov,precio);
                receta.setVideo(video);

                listaRecetas.add(receta);
            }

             if (listaRecetas.isEmpty()){
                    session.setAttribute("criterio", criterio);
                    session.setAttribute("valor", valor);
                    rs.close();
                response.sendRedirect(request.getContextPath()+"/jsp/error.jsp");
                }
            session.setAttribute("consulta", listaRecetas);

            response.sendRedirect(request.getContextPath()+"/jsp/mostrarRecetaFiltro.jsp");
 rs.close();
            }//fin for

        } catch (Exception ex) {
           Logger.getLogger(BuscarReceta.class.getName()).log(Level.SEVERE, null, ex);
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

    private ArrayList buscar(String valor) {
        ArrayList palabras=new ArrayList();
        palabras.add(valor);
        System.out.println(palabras);
        StringTokenizer st = new StringTokenizer(valor);

            while (st.hasMoreTokens()) {
                String val=st.nextToken();
                palabras.add(val);
                System.out.println(val);
            }
        return palabras;
     }


   
}
