<%@page import="clases.Receta"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
<style type="text/css">
#email {	text-align: center;
}
</style>
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
             <td width="78%" valign="top">
             	<table width="575" height="593" border="0">
                 <%
                 Receta recetario = (Receta)session.getAttribute("rec");
                 %>
                 <tr>
                   <td height="56"> Nombre de la Receta: </td>
                   <td><textarea name="name2" cols="60" rows="1" readonly="readonly" id="name2" style="overflow:hidden"><%=recetario.getNombre()%></textarea></td>
                 </tr>
                 <tr>
                   <td height="56"> Categoria: </td>
                   <td><textarea name="name2" cols="60" rows="1" readonly="readonly" id="name2" style="overflow:hidden"><%=recetario.getCategoria()%></textarea></td>
                 </tr>
                 <tr>
                   <td height="56"> Provincia: </td>
                   <td><textarea name="name2" cols="60" rows="1" readonly="readonly" id="name2" style="overflow:hidden"><%=  recetario.getProvincia()%></textarea></td>
                 </tr>
                 <!--<tr>
                   <td width="216" height="209">Ingredientes:</td>
               		<td width="343"><textarea name="ingredients2" cols="60" rows="10" readonly="readonly" id="ingredients2" style="overflow:hidden"><%//=ingredients%></textarea></td>
                 </tr>-->
                 <!--<tr>
                   <td height="194">Modo de elaboraciÃ³n: </td>
                   <td><label for="howto2"></label>
              			<textarea name="howto2" cols="60" rows="10" readonly="readonly" id="howto2" style="overflow:hidden"><%//=howto%></textarea></td>
                 </tr>-->
                 <tr>
                   <td height="107" align="center" >
                       <a href="<%= response.encodeRedirectURL(request.getContextPath()+ "/EditarReceta?id="+recetario.getId())%>" style="text-decoration: none; color:#000">Editar</a>
                   </td>
                   <td height="107" align="center"><a href="<%= response.encodeRedirectURL(request.getContextPath()+ "/jsp/comentarreceta.jsp?id="+recetario.getId())%>" style="text-decoration:none; color:#000">
                     <input type="submit" name="comentar2" id="comentar2" value="Comentar Receta">
                   </a></td>
                 </tr>
               </table>
             </td>
             <td width="2%">&nbsp;</td>
           </tr>
           <tr>
             <td bgcolor="#99CCFF" height="36" colspan="3" align="center">Copyright; All Rights Reserved</td>
           </tr>
    </table>
    <h1>&nbsp;</h1>
</body>
</html>