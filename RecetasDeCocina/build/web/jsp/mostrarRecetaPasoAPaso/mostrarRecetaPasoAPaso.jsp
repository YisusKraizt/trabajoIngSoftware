<%-- 
    Document   : mostrarReceta
    Created on : 13-oct-2010, 23:00:51
    Author     : Carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% 
			String receta = (String)request.getParameter("receta");
			Integer numPasos = 0;
			Integer pasoActual = 1;
			%>
</head>
    <body>
<table width="575" height="365" border="0">
           <tr>
             <td width="216" height="56"> Nombre de la Receta: </td>
             <td width="343"><textarea name="name" cols="60" rows="1" id="name" style="overflow:hidden">
			 <%
			 		if(receta.equals("huevoFrito"))
						out.println("Huevo Frito");
					if(receta.equals("sopaSobre"))
						out.println("Sopa de Sobre");
					if(receta.equals("patatasFritas"))
						out.println("Patatas Fritas");
			%></textarea></td>
           </tr>
           	<%
				if(receta.equals("huevoFrito"))
					numPasos = 3;
				if(receta.equals("sopaSobre"))
					numPasos = 3;
				if(receta.equals("patatasFritas"))
					numPasos = 2;
						
				while(numPasos<=pasoActual){
			%>
           <tr>
             <td height="194">Paso <%=pasoActual%>:</td>
             <td><label for="howto"></label>
               <textarea name="howto" id="howto" cols="60" rows="10" style="overflow:hidden">
               <%
				if(receta.equals("huevoFrito")){
					if(pasoActual == 1)
						out.println("Se echa el aceite en la sartÃ©n y se espera a que se caliente el aceite");
					if(pasoActual == 2)
						out.println("Se echa el huevo sobre la sartÃ©n.");
					if(pasoActual == 3)
						out.println("Servir sobre el plato y consumir.");
				}
				
				if(receta.equals("sopaSobre")){
					if(pasoActual == 1)
						out.println("Se echa agua en una olla y se pone a calentar.");
					if(pasoActual == 2)
						out.println("Cuando el agua empieza a hervir, echar el sobre de la sopa.");
					if(pasoActual == 3)
						out.println("Servir sobre el plato y consumir.");
				}
				
				if(receta.equals("patatasFritas")){
					if(pasoActual == 1)
						out.println("Pelar y cortar las patatas. Mientras, poner a calentar el aceite de la freidora.");
					if(pasoActual == 2)
						out.println("Cuando el aceite estÃ© caliente, echar las patatas. \nEsperar 10 minutos, servir sobre el plato y consumir.");
				}
			   %>
               </textarea></td></tr>
             <%
			 	numPasos++;
			 }
			 %>
           <tr>
             <td height="107" colspan="2" align="center">&nbsp;</td>
           </tr>
         </table>
<h1>&nbsp;</h1>
    </body>
</html>