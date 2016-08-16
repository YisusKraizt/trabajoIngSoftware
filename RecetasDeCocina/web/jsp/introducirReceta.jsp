<%@page import="clases.Receta"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Introduce una Receta</title>
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
        <p>&nbsp;</p></td>
        <td width="78%" valign="top"><p>&nbsp;</p>
     
              <form method="post" action="<%= response.encodeRedirectURL(request.getContextPath()+"/IntroducirReceta")%>">
            <table width="575" height="576" border="0">
              <tr>
                <td width="216" height="56"> Nombre de la Receta: *</td>

                <td width="343"><input name="name" type="text" id="name" size="60"></td>
              </tr>
              <tr>
                <td width="216" height="56"> Precio: *</td>
                <td width="343"><input name="price" type="text" id="price" size="60"></td>
              </tr>
              <tr>
                <td width="216" height="56"> provincia: *</td>
                <td width="343"><input name="prov" type="text" id="prov" size="60"></td>
              </tr>
              <p>
                  <label for="category"></label>
                  Tipo plato *
                  <select name="category" id="category">
                    <option value="primero" selected>primero</option>
                    <option value="segundo">segundo</option>
                    <option value="postre" selected>postre</option>
                    <option value="aperitivo" selected>aperitivo</option>
                    </select>
                </p>
    
             <tr>
                <td width="216" height="56"> url del video: *</td>
                <td width="343"><input name="film" type="text" id="film" size="60"></td>
              </tr>
              <tr>
                <td width="216" height="56"> dibujo relacionado: *</td>
                <td width="343"><input name="picture" type="text" id="picture" size="60"></td>
              </tr>
              <tr>
                <td height="194">Modo de elaboraciÃ³n: *</td>
                <td><label for="howto"></label>
                  <textarea name="howto" id="howto" cols="60" rows="10"></textarea></td>
              </tr>
              <tr>
              <td width="500" height="156"> Campos obligatorios *</td>
              </tr>
              <tr>
                <td height="107" colspan="2" align="center"><input type="submit" name="aceptar" id="aceptar" value="Aceptar"></td>
              </tr>
            </table>
          </form>
          <h1></h1>
<p>&nbsp;</p>
       <td width="5%"><div align="center"> <img src="../other/introducir.jpg" alt="TamaÃ±o original" border="3" height="300"></div>
        <td width="2%">&nbsp;</td>
      </tr>
      <tr>
       <td bgcolor="#99CCFF" height="36" colspan="3" align="center">Copyright; All Rights Reserved</td>
      </tr>
    </table>
    <p>&nbsp;</p>
</body>
</html>