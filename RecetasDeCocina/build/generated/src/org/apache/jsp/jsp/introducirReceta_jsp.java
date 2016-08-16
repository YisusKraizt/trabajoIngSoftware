package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import clases.Receta;
import java.util.ArrayList;

public final class introducirReceta_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Introduce una Receta</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("    <table width=\"100%\" height=\"571\" border=\"1\">\n");
      out.write("     <tr bgcolor=\"#99CCFF\" align=\"center\">\n");
      out.write("        <th height=\"83\" colspan=\"3\" scope=\"col\"><p>WEB DE RECETAS DE COCINA</p></th>\n");
      out.write("      </tr>\n");
      out.write("      <tr  bgcolor=\"#CCFFFF\">\n");
      out.write("        <td width=\"30%\" height=\"444\" valign=\"top\"><p>&nbsp;</p>\n");
      out.write("          <p>OPCIONES</p>\n");
      out.write("          <p><a href=\"");
      out.print( response.encodeRedirectURL(request.getContextPath()+ "/dentro.jsp"));
      out.write("\" style=\"text-decoration: none; color:#000\">Pantalla Principal</a></p>\n");
      out.write("          <p><a href=\"");
      out.print( response.encodeRedirectURL(request.getContextPath()+ "/jsp/introducirReceta.jsp"));
      out.write("\" style=\"text-decoration: none; color:#000\">Introducir una Receta</a></p>\n");
      out.write("          <p><a href=\"");
      out.print( response.encodeRedirectURL(request.getContextPath()+ "/jsp/buscarReceta.jsp"));
      out.write("\" style=\"text-decoration: none; color: #000\">Buscar una Receta</a></p>\n");
      out.write("          <p><a href=\"");
      out.print( response.encodeRedirectURL(request.getContextPath()+ "/jsp/mostrarPorCategoria.jsp"));
      out.write("\" style=\"text-decoration: none; color: #000\">Mostrar las recetas por categoria</a></p>\n");
      out.write("          <p><a href=\"");
      out.print( response.encodeRedirectURL(request.getContextPath()+ "/jsp/recetaPorProvincia.jsp"));
      out.write("\" style=\"text-decoration: none; color: #000\">Mostrar receta de una provincia</a></p>\n");
      out.write("        <p><a href=\"");
      out.print( response.encodeRedirectURL(request.getContextPath()+ "/jsp/recetaBajoCoste.jsp"));
      out.write("\" style=\"text-decoration: none; color: #000\">Mostrar receta de bajo coste</a></p>\n");
      out.write("        <p>&nbsp;</p>\n");
      out.write("        <p>");

                ArrayList<Receta> ultimasVisitadas = (ArrayList<Receta>) session.getAttribute("ultimasRecetasVisitadas");
                if(ultimasVisitadas.size() > 0){
                    out.println("<p>Ãšltimas Recetas Visitadas:</p>");
                    out.println("<p>");
                    for(int i = 0; i < ultimasVisitadas.size(); i++){
                                    out.println(ultimasVisitadas.get(i).getNombre()+"<br />");
                    }	
                    out.println("</p>");
                 }
          
      out.write("</p>\n");
      out.write("        <p>&nbsp;</p></td>\n");
      out.write("        <td width=\"78%\" valign=\"top\"><p>&nbsp;</p>\n");
      out.write("     \n");
      out.write("              <form method=\"post\" action=\"");
      out.print( response.encodeRedirectURL(request.getContextPath()+"/IntroducirReceta"));
      out.write("\">\n");
      out.write("            <table width=\"575\" height=\"576\" border=\"0\">\n");
      out.write("              <tr>\n");
      out.write("                <td width=\"216\" height=\"56\"> Nombre de la Receta: *</td>\n");
      out.write("\n");
      out.write("                <td width=\"343\"><input name=\"name\" type=\"text\" id=\"name\" size=\"60\"></td>\n");
      out.write("              </tr>\n");
      out.write("              <tr>\n");
      out.write("                <td width=\"216\" height=\"56\"> Precio: *</td>\n");
      out.write("                <td width=\"343\"><input name=\"price\" type=\"text\" id=\"price\" size=\"60\"></td>\n");
      out.write("              </tr>\n");
      out.write("              <tr>\n");
      out.write("                <td width=\"216\" height=\"56\"> provincia: *</td>\n");
      out.write("                <td width=\"343\"><input name=\"prov\" type=\"text\" id=\"prov\" size=\"60\"></td>\n");
      out.write("              </tr>\n");
      out.write("              <p>\n");
      out.write("                  <label for=\"category\"></label>\n");
      out.write("                  Tipo plato *\n");
      out.write("                  <select name=\"category\" id=\"category\">\n");
      out.write("                    <option value=\"primero\" selected>primero</option>\n");
      out.write("                    <option value=\"segundo\">segundo</option>\n");
      out.write("                    <option value=\"postre\" selected>postre</option>\n");
      out.write("                    <option value=\"aperitivo\" selected>aperitivo</option>\n");
      out.write("                    </select>\n");
      out.write("                </p>\n");
      out.write("    \n");
      out.write("             <tr>\n");
      out.write("                <td width=\"216\" height=\"56\"> url del video: *</td>\n");
      out.write("                <td width=\"343\"><input name=\"film\" type=\"text\" id=\"film\" size=\"60\"></td>\n");
      out.write("              </tr>\n");
      out.write("              <tr>\n");
      out.write("                <td width=\"216\" height=\"56\"> dibujo relacionado: *</td>\n");
      out.write("                <td width=\"343\"><input name=\"picture\" type=\"text\" id=\"picture\" size=\"60\"></td>\n");
      out.write("              </tr>\n");
      out.write("              <tr>\n");
      out.write("                <td height=\"194\">Modo de elaboraciÃ³n: *</td>\n");
      out.write("                <td><label for=\"howto\"></label>\n");
      out.write("                  <textarea name=\"howto\" id=\"howto\" cols=\"60\" rows=\"10\"></textarea></td>\n");
      out.write("              </tr>\n");
      out.write("              <tr>\n");
      out.write("              <td width=\"500\" height=\"156\"> Campos obligatorios *</td>\n");
      out.write("              </tr>\n");
      out.write("              <tr>\n");
      out.write("                <td height=\"107\" colspan=\"2\" align=\"center\"><input type=\"submit\" name=\"aceptar\" id=\"aceptar\" value=\"Aceptar\"></td>\n");
      out.write("              </tr>\n");
      out.write("            </table>\n");
      out.write("          </form>\n");
      out.write("          <h1></h1>\n");
      out.write("<p>&nbsp;</p>\n");
      out.write("       <td width=\"5%\"><div align=\"center\"> <img src=\"../other/introducir.jpg\" alt=\"TamaÃ±o original\" border=\"3\" height=\"300\"></div>\n");
      out.write("        <td width=\"2%\">&nbsp;</td>\n");
      out.write("      </tr>\n");
      out.write("      <tr>\n");
      out.write("       <td bgcolor=\"#99CCFF\" height=\"36\" colspan=\"3\" align=\"center\">Copyright; All Rights Reserved</td>\n");
      out.write("      </tr>\n");
      out.write("    </table>\n");
      out.write("    <p>&nbsp;</p>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
