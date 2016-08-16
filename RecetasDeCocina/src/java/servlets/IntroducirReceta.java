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
@WebServlet(name="IntroducirReceta", urlPatterns={"/IntroducirReceta"})
public class IntroducirReceta extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        int accedeingrediente = 0;
        try {
            HttpSession session=request.getSession(true);

            String name = request.getParameter("name");
            System.out.println("name"+name);
            String category = request.getParameter("category");
            String provincia = request.getParameter("prov");
            String precio = request.getParameter("price");
            String video = request.getParameter("film");
            String comentario = request.getParameter("howto");
            String dibujo = request.getParameter("picture");
            //System.out.println("cate");
            if(provincia ==""||category ==""|| precio=="" || video=="" ||
                    comentario== "" || dibujo== "" ){ accedeingrediente=1;}
            else{
            connectSQLITE conn=new  connectSQLITE();
            conn.connect();

            
//meto el video primero en video
            ResultSet rsss=conn.executeSelect("select count(*) from video;");
            rsss.next();
            String aux2 = rsss.getString(1);
            Integer p2 = new Integer(aux2);//p2 el numero maximo que va tener el video
            p2=p2+1;
            //System.out.println("id del video"+p2);
           // int insertarvideo = connectSQLITE.insertarvideo(p2,video,name);
            
            
            String titulo="video1";

            String sql="INSERT INTO video (idvideo,url,titulo) VALUES ('"+p2+"','"+video+"','"+titulo+"');";
            System.out.println("sentencia"+sql);
            //ResultSet re=conn.executeSelect(sql);
            conn.executeInsert(sql);
            //ResultSet re=conn.executeSelect("INSERT INTO video (idvideo,url,titulo) VALUES (7,'www.prueba.com','titulopru')");
            //System.out.println("sentencia1"+sql);
            
            //Generamos numero aleatorio id a la receta
            

            ResultSet rs=conn.executeSelect("select count(*) from receta;");
            rs.next();
            String aux = rs.getString(1);
            Integer p = new Integer(aux);//p el numero maximo
            p=p+1;
            //System.out.println("hola1");
 //buscar codcategoria a traves de category
           
            String sqlcategory="select t.idtipoplato from  tipoplato t where '"+ category+"'=t.tipo";
            rs=conn.executeSelect(sqlcategory);
            rs.next();
            System.out.println("sqlcategory " + sqlcategory);
            String aux1 = rs.getString(1);
            Integer p1 = new Integer(aux1);//p1 codtipodeplato
System.out.println("hola2");
//lugar de la foto
            ResultSet r4=conn.executeSelect("select count(*) from dibujo;");
            rsss.next();
            String aux4 = r4.getString(1);
            String foto="foto1";
            Integer p4 = new Integer(aux4);//p2 el numero maximo que va tener el video
            p4=p4+1;
            String sql2="INSERT INTO dibujo (idDibujo,nombre,imagen) VALUES ('"+p4+"','"+foto+"','"+dibujo+"');";
            System.out.println("sentencia"+sql2);
            //ResultSet ree=conn.executeSelect("INSERT INTO dibujo (idDibujo,nombre,imagen) VALUES ("+p4+","+foto+","+dibujo+");");
            //String sql2="INSERT INTO dibujo (idDibujo,nombre,imagen) VALUES ('"+p4+"','"+foto+"','"+dibujo+"');";
            conn.executeInsert(sql2);
            System.out.println("hola3");
         
int visitada=0;
            //crea receta total
        String sql3="INSERT INTO receta (idreceta,idtipoplato,idvideo,iddibujo,nombre,visitada,precio,provincia,comentario) "
        + "VALUES('"+p+"','"+p1+"','"+p2+"','"+p4+"','"+name+"','"+visitada+"','"+precio+"','"+provincia+"','"+comentario+"')";
        conn.executeInsert(sql3);
            session.setAttribute("receta", p);
            }//fin else

            if (accedeingrediente==0){
                response.sendRedirect(request.getContextPath() + "/jsp/introduciringrediente.jsp");
            }

            else{
                response.sendRedirect(request.getContextPath() + "/jsp/faltanparametros.jsp");
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
            try {
                processRequest(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(IntroducirReceta.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IntroducirReceta.class.getName()).log(Level.SEVERE, null, ex);
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
            try {
                processRequest(request, response);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(IntroducirReceta.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(IntroducirReceta.class.getName()).log(Level.SEVERE, null, ex);
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