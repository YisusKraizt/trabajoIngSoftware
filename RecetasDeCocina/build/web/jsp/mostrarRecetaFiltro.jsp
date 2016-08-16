<%@page import="clases.Receta"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Recetas</title>
    <style type="text/css">
    #email {
	text-align: center;
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

               <p>Datos leidos: </p>

               <table width="575" height="202" border="0">
                 <%
         session = request.getSession(true);
         ArrayList<Receta> rs = new ArrayList<Receta>();
         rs = (ArrayList)session.getAttribute("consulta");
         session.removeAttribute("consulta");
         for(int i = 0; i < rs.size(); i++){
             Receta receta = rs.get(i);
             String id = receta.getId();
            String name = receta.getNombre();
            String category = receta.getCategoria();
            String prov= receta.getProvincia();
            String precio= receta.getPrecio();
            String video = receta.getVideo();




          %>
                 <tr>
                   <td height="5%"> Nombre de la Receta: </td>
                   <td><textarea name="name" cols="60" rows="1" readonly="readonly"  style="overflow:hidden"><%=name%></textarea></td>
                 </tr>
                 <tr>
                   <td height="20"> Categoria: </td>
                   <td><textarea name="name2" cols="60" rows="1" readonly="readonly"  style="overflow:hidden"><%=category%></textarea></td>
                 </tr>
                  <tr>
                   <td height="20"> Provincia: </td>
                   <td><textarea name="name3" cols="60" rows="1" readonly="readonly" style="overflow:hidden"><%=prov%></textarea></td>
                 </tr>
                 <tr>
                   <td height="20"> Precio: </td>
                   <td><textarea name="name3" cols="60" rows="1" readonly="readonly"style="overflow:hidden"><%=precio%></textarea></td>
                 </tr>
                 <tr>
                     <td height="20"> Video: </td>
                   <td><a href="<%=video%>"><%=video%></a></td>
                 </tr>
                 <tr>

                   <td height="32"></td>
                   <td height="10">

                 <form action=""
                 method="post"
                 name="formulario"
                 id="formulario">
                   <!--  <a href="<%= response.encodeRedirectURL(request.getContextPath()+"/jsp/enviarRecetaPorEmail.jsp?id="+id)%>">Email</a>-->
	               <input  align="right"
                    type="submit"
	         name="ver"
	         value="Ver Detalles"
			 onclick=this.form.action="<%= response.encodeRedirectURL(request.getContextPath()+ "/RecetaAleatoriaBuena?id="+id)%>">
	               <input  align="right"
                    type="submit"
	         name="editar"
	         value="Editar"
			 onclick=this.form.action="<%= response.encodeRedirectURL(request.getContextPath()+ "/EditarReceta?id="+id)%>">
      <input  align="right"
                    type="submit"
	         name="enviar"
	         value="Enviar Email"
			 onclick=this.form.action="<%= response.encodeRedirectURL(request.getContextPath()+"/jsp/enviarRecetaPorEmail.jsp?id="+id)%>">

	  <input align="center"
                 type="submit"
	         name="comentar"
	         value="Comentar"
                 onclick=this.form.action="<%= response.encodeRedirectURL(request.getContextPath()+"/jsp/comentarreceta.jsp?id="+id)%>">

          <input align="left"
                 type="submit"
	         name="comentar"
	         value="Mostrar Comentarios"
                 onclick=this.form.action="<%= response.encodeRedirectURL(request.getContextPath()+"/MostrarComentarios?id="+id)%>">
	  </form>
                       --------------------------------------------------------------------- </td>
                 </tr>
                 <%}%>
               </table>
               <h1></h1>
<p>&nbsp;</p></td>
             <td width="2%">&nbsp;</td>
          
           <tr>
             <td bgcolor="#99CCFF" height="36" colspan="3" align="center">Copyright; All Rights Reserved</td>
           </tr>
         </table>
         <p>&nbsp;</p>
</body>
</html>