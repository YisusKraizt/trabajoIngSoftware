<%-- 
    Document   : dentro
    Created on : 11/08/2016, 03:42:48 PM
    Author     : INGENIERIA
--%>
<%@page import="clases.Receta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="BaseDatos.connectSQLITE"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   
<%@page import="java.util.Random"%>
<%@page language="java" import="java.sql.*" errorPage="" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <table width="100%" height="571" border="1">
      <tr bgcolor="#99CCFF" align="center">
        <th height="83" colspan="3" scope="col"><p>WEB DE RECETAS DE COCINA</p></th>
      </tr>
      <tr  bgcolor="#CCFFFF">
        <td width="30%" height="444" valign="top"><p>&nbsp;</p>
          <p>OPCIONES</p>
          <p><a href="<%= response.encodeRedirectURL(request.getContextPath()+ "/dentro.jsp")%>" style="text-decoration: none; color:#000">Pantalla Principal</a></p>
          <p><a href="jsp/introducirReceta.jsp" style="text-decoration: none; color:#000">Introducir una Receta</a></p>
          <p><a href="jsp/buscarReceta.jsp" style="text-decoration: none; color: #000">Buscar una Receta</a></p>
          <p><a href="jsp/mostrarPorCategoria.jsp" style="text-decoration: none; color: #000">Mostrar las recetas por categoria</a></p>
          <p><a href="jsp/recetaPorProvincia.jsp" style="text-decoration: none; color: #000">Mostrar receta de una provincia</a></p>
          <p><a href="<%= response.encodeRedirectURL(request.getContextPath()+ "/jsp/recetaBajoCoste.jsp")%>" style="text-decoration: none; color: #000">Mostrar receta de bajo coste</a></p>
          <p>&nbsp;</p>
          <%
                ArrayList<Receta> ultimasVisitadas = (ArrayList<Receta>) session.getAttribute("ultimasRecetasVisitadas");
                if(ultimasVisitadas.size() > 0){
                    out.println("<p>Ãšltimas Recetas Visitadas:</p>");
                    out.println("<p>");
                    for(int i = 0; i < ultimasVisitadas.size(); i++){
                                    out.println(ultimasVisitadas.get(i).getNombre()+"<br />");
                    }	
                    out.println("</p>");
                 }
          %>
        <p>&nbsp;</p></td>
        <td width="78%" valign="top"><p>&nbsp;</p>
        <p>Receta del dÃ­a:</p>
        <%
           connectSQLITE conn=new  connectSQLITE();
           conn.connect();
            ResultSet contador=conn.executeSelect("select count(*) from receta;");
            Integer p = 0;
            contador.next();

                System.out.println(contador.getString(1));
                String aux = contador.getString(1);
                p = new Integer(aux);

             Random rd = new Random();
             Integer i = rd.nextInt(p)+1;

             ResultSet rec1 = conn.executeSelect("select nombre, idreceta from receta where idreceta="+i);
             rec1.next();

             String nombre = rec1.getString("nombre");
             String  id = rec1.getString("idreceta");

            contador.close();
            rec1.close();
            conn.close();
                    %>
        <form name="form2" method="post" action="<%= response.encodeRedirectURL(request.getContextPath() + "/RecetaAleatoriaBuena?id="+id)%>">
          <table width="65%" border="0" cellspacing="0" cellpadding="1">
            <tr bgcolor="#990033" align="center">
              <td width="40%"><b><font color="#FFFFFF"> LA RECETA DEL DIA:</font></b></td>
              
              <td width="60%"><input type="text" value="<%=nombre%>" /></td>
            </tr>
          </table>
          <input align="center" type="submit" value="IR A LA RECETA" />
        </form>
        <p></p>
        <p>&nbsp;</p>
        <p>&nbsp;</p>
        <p>&nbsp; </td>

        <td width="5%"><div align="center"> <img src="./other/arguinano.jpg" alt="TamaÃ±o original" height="444" border="3"></div>
       
        <td width="2%">&nbsp;</td>

      </tr>
      <tr>
        <td bgcolor="#99CCFF" height="36" colspan="3" align="center">Copyright; All Rights Reserved</td>
      </tr>
    </table>
    <p>&nbsp;</p>
    </body>
</html>