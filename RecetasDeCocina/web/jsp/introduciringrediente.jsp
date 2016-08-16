
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
        <p>&nbsp;</p></td>
        <td width="78%" valign="top"><p>&nbsp;</p>

              <form method="post" action="<%= response.encodeRedirectURL(request.getContextPath()+"/IntroducirIngrediente")%>">
            <table width="575" height="576" border="0">
              <tr>
                <td width="216" height="56"> Introducir ingrediente: *</td>

                <td width="343"><input name="name" type="text" id="name" size="60"></td>
              </tr>
              <tr>
                <td width="216" height="56"> Precio: *</td>
                <td width="343"><input name="price" type="text" id="price" size="60"></td>
              </tr>
              <tr>
                <td width="216" height="56"> cantidad necesaria en gramos: *</td>
                <td width="343"><input name="cant" type="text" id="cant" size="60"></td>
              </tr>
              <tr>
                <td width="216" height="56"> Lugar de adquisicion: *</td>
                <td width="343"><input name="place" type="text" id="place" size="60"></td>
              </tr>
              <tr>
                <td height="216">Propiedades: *</td>
                <td width="343"><label for="howto"></label>
                  <textarea name="howto" id="howto" cols="60" rows="10"></textarea></td>
              </tr>
              <tr>
              <td width="500" height="156"> Campos obligatorios *</td>
              </tr>
              <tr>
                <td height="216" align="center"><input type="submit" name="seguir poniendo ingredientes" id="aceptar" value="Mas ingredientes y guardar"></td>
                <td width="343" align="center"><a href="<%= response.encodeRedirectURL(request.getContextPath()+ "/dentro.jsp")%>">Volver menu principal</a></td>
              </tr>
            </table>
          </form>
          <h1></h1>
<p>&nbsp;</p>
        <p>&nbsp;</p></td>
        <td width="2%">&nbsp;</td>
      </tr>
      <tr>
       <td bgcolor="#99CCFF" height="36" colspan="3" align="center">Copyright; All Rights Reserved</td>
      </tr>
    </table>
    <p>&nbsp;</p>
</body>
</html>

