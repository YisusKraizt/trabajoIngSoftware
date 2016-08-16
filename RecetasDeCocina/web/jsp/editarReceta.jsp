<%@page import="clases.Ingredientes"%>
<%@page import="java.util.ArrayList"%>
<%@page import="clases.Receta"%>
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
             <td width="78%" valign="top"><p>&nbsp;</p>
                 <%
		 	Receta receta = (Receta)session.getAttribute("receta");
                        session.removeAttribute("receta");
                        System.out.println("**** ModoElab: " + receta.getModoelab());
          %>
               <form name="form1" method="post" action="<%= response.encodeRedirectURL(request.getContextPath()+"/EditarRecetaUpdate?id="+receta.getId())%>">
                 <table width="575" height="593" border="0">
                   <tr>
                     <td height="56"> Nombre de la Receta: </td>
                     <td><input name="nombre" type="text" id="nombre" style="overflow:hidden" value="<%=receta.getNombre()%>" size="60"></td>
                   </tr>
                   <tr>
                     <td height="56"> Categoria: </td>
                     <td><label for="categoria"></label>
                       <select name="categoria" id="categoria">
                         <option>selecciona una categorÃ­a</option>
                         <option value="1">primer plato</option>
                         <option value="2">segundo plato</option>
                         <option value="3">postre</option>
                         <option value="4">aperitivo</option>
                     </select></td>
                   </tr>
                   <tr>
                     <td height="56"> Provincia: </td>
                     <td><input name="provincia" type="text" id="provincia" style="overflow:hidden" value="<%=receta.getProvincia()%>" size="60"></td>
                   </tr>
                   <tr>
                     <td width="216" height="209">Ingredientes:</td>
                     <td width="343"><textarea name="ingredientes" id="ingredientes" cols="60" rows="10" style="overflow:hidden">
                             <%
                             ArrayList<Ingredientes> listaIngredientes = receta.getIngredientes();
                             out.println("");
                             for(int i = 0; i < listaIngredientes.size(); i++)
                                 out.println(listaIngredientes.get(i).getNombre());
                             %>
                         </textarea></td>
                   </tr>
                   <tr>
                     <td>Modo de elaboraciÃ³n: </td>
                     <td><label for="howto"></label>
                       <textarea name="elaboracion" id="elaboracion" cols="60" rows="10" style="overflow:hidden"><%= receta.getModoelab()%></textarea></td>
                   </tr>
                   <tr>
                     <td colspan="2" align="center"><input type="submit" name="submit" id="submit" value="Actualizar"></td>
                   </tr>
                 </table>
                   <p></p>
               </form>
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