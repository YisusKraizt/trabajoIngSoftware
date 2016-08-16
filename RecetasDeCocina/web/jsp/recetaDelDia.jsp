
<%@page import="java.util.Random"%>
<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Documento sin tÃ­tulo</title>
    </head>

    <body>
        <form name="form2" method="post" action="<%= response.encodeRedirectURL(request.getContextPath() + "/jsp/mostrarReceta.jsp")%>">

            <table width="50%" border="0" cellspacing="0" cellpadding="1">
                <tr bgcolor="#990033" align="center">
                    <td width="40%"><b><font color="#FFFFFF"> LA RECETA DEL DIA:</font></b></td>
                    <%
             
                    String name = request.getParameter("nom");
                    %>
                    <td width="60%"><input type="text" value="<%=name%>" /></td>
                </tr>

            </table>
            <input type="submit" value="IR A LA RECETA" />
        </form>
        <p>&nbsp;</p>
    </body>
</html>