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
             <p>&nbsp;</p></td>

                <%
            String id=request.getParameter("id");
            System.out.println("id: "+id);
            %>

             <td width="78%" valign="top"><p>&nbsp;</p>
               <p>Comentar la Receta:               </p>
               <table width="575" height="410" border="0">
         <tr><form name="form1" method="post" action="<%= response.encodeRedirectURL(request.getContextPath()+ "/ComentarReceta?id="+id)%>">

          <td height="345">Comentario: </td>
          <td><label for="comentario"></label>
          <textarea name="comentario" id="comentario" cols="60" rows="10" style="overflow:hidden"></textarea></td>
          <tr>
                <td height="89" colspan="2" align="center"><input type="submit" name="submit" value="Comentar Receta"></td>
          </tr>
          </form>
                 </tr>
                 <tr>
                 </tr>
               </table>
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