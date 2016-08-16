
<%@page import="clases.Receta"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="../other/scriptComunidades.js"> </script>
        <title>JSP Page</title>
    </head>
    <body>
    <table width="100%" height="571" border="1">
        <tr bgcolor="#99CCFF" align="center">
        <th height="83" colspan="3" scope="col"><p>WEB DE RECETAS DE COCINA</p></th>
      </tr>
      <tr  bgcolor="#CCFFFF">
        <td width="35%" height="444" valign="top"><p>&nbsp;</p>
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
        <td width="78%" valign="top"><h1>Elija la Provincia :</h1>
          <form name="form1" method="post" action="<%= response.encodeRedirectURL(request.getContextPath()+ "/SeleccionarPorProvincia")%>">
            <p>
             <table border="0">      
    <tr>
      <td>
        <select id='countrySelect' name='country' onchange='populateState()'>
        </select>
        </td>
        <td>
        <select id='stateSelect' name='state'>
        </select>
        <script type="text/javascript">initCountry('US'); </script>
      </td>
    </tr>
  </table>
           
            <blockquote>
              <input type="submit" name="submit2" id="submit2" value="Enviar">
            </blockquote>

</form>


<p><div align="center">
</div><p>


       


        <p>&nbsp;</p></td>
        <td width="5%"><div align="center"> <img src="../other/Provincias.jpg" alt="TamaÃ±o original" border="3"></div>
</td>
      </tr>
      <tr>
        <td bgcolor="#99CCFF" height="36" colspan="3" align="center">Copyright; All Rights Reserved</td>
      </tr>
    </table>
    <h1>&nbsp;</h1>
</body>
</html>