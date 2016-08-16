<%-- 
    Document   : buscarRecetasinlogin
    Created on : 20-dic-2010, 0:51:58
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar Receta sin estar Inscrito</title>
    </head>
        <body>
        <table width="100%" height="571" border="1">
          <tr bgcolor="#99CCFF" align="center">
            <th height="83" colspan="3" scope="col"><p>WEB DE RECETAS DE COCINA</p></th>
          </tr>
          <tr bgcolor="#CCFFFF">
            <td width="78%" valign="top" align="center"><p>&nbsp;</p>
              <form  name="form1" method="post" action="<%= response.encodeRedirectURL(request.getContextPath()+"/BuscarRecetaSinLogin")%>">
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
            <p>&nbsp;</p></td>
            <td width="2%">&nbsp;</td>
          </tr>
          <tr>
           <td bgcolor="#99CCFF" height="36" colspan="3" align="center">Copyright; All Rights Reserved</td>
          </tr>
        </table>

</body>
</html>