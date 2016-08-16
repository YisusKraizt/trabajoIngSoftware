<%@page import="clases.Receta"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

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
          <tr bgcolor="#CCFFFF">
            <td width="20%" height="444" valign="top"><p>&nbsp;</p>
              <p>OPCIONES</p>
              <p><a href="<%= response.encodeRedirectURL(request.getContextPath()+ "/dentro.jsp")%>" style="text-decoration: none; color:#000">Pantalla Principal</a></p>
              <p><a href="<%= response.encodeRedirectURL(request.getContextPath()+ "/jsp/introducirReceta.jsp")%>" style="text-decoration: none; color:#000">Introducir una Receta</a></p>
              <p><a href="<%= response.encodeRedirectURL(request.getContextPath()+ "/jsp/buscarReceta.jsp")%>" style="text-decoration: none; color: #000">Buscar una Receta</a></p>
              <p><a href="<%= response.encodeRedirectURL(request.getContextPath()+ "/jsp/mostrarPorCategoria.jsp")%>" style="text-decoration: none; color: #000">Mostrar las recetas por categoria</a></p>
              <p><a href="<%= response.encodeRedirectURL(request.getContextPath()+ "/jsp/recetaPorProvincia.jsp")%>" style="text-decoration: none; color: #000">Mostrar receta de una provincia</a></p>
              <p><a href="<%= response.encodeRedirectURL(request.getContextPath()+ "/jsp/recetaBajoCoste.jsp")%>" style="text-decoration: none; color: #000">Mostrar receta de bajo coste</a></p>
              <p>&nbsp;</p>
              <p><%
                ArrayList<Receta> ultimasVisitadas = (ArrayList<Receta>) session.getAttribute("ultimasRecetasVisitadas");
                if(ultimasVisitadas.size() > 0){
                    out.println("<p>Ãšltimas Recetas Visitadas:</p>");
                    out.println("<p>");
                    for(int i = 0; i < ultimasVisitadas.size(); i++){
                                    out.println(ultimasVisitadas.get(i).getNombre()+"<br />");
                    }	
                    out.println("</p>");
                 }
          %></p>
              <p>&nbsp;</p>
<p>&nbsp;</p></td>
            <td width="78%" valign="top"><p>&nbsp;</p>
              <form name="form1" method="post" action="<%= response.encodeRedirectURL(request.getContextPath()+"/BuscarReceta")%>">
                <p>
                  <label for="criterio"></label>
                  Buscar por
                  <select name="criterio" id="criterio">
                    <option value="nombre" selected>Nombre</option>
                    <option value="ingrediente" selected>Ingrediente</option>
                    <option value="plato">Plato</option>
                  </select>
                  <label for="busqueda"></label>
                  <input name="busqueda" type="text" id="busqueda" size="60">
                </p>
                <blockquote>
                  <p>&nbsp; </p>
                  <p>
                    <input type="submit" name="buscar" id="buscar" value="Buscar">
                  </p>
                </blockquote>
                <p>&nbsp;</p>
              </form>
              <h1></h1>
<p>&nbsp;</p>

            <td width="5%" align="center">
                <P>
                    QUE BUSCAR??
                </P>
                <div align="center"> <img src="../other/interrogante.jpg" alt="TamaÃ±o original" border="3"></div>
            <td width="2%">&nbsp;</td>
          </tr>
          <tr>
            <td bgcolor="#99CCFF" height="36" colspan="3" align="center">Copyright; All Rights Reserved</td>
          </tr>
        </table>
</body>
</html>