package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class buscarRecetasinlogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Buscar Receta sin estar Inscrito</title>\n");
      out.write("    </head>\n");
      out.write("        <body>\n");
      out.write("        <table width=\"100%\" height=\"571\" border=\"1\">\n");
      out.write("          <tr bgcolor=\"#99CCFF\" align=\"center\">\n");
      out.write("            <th height=\"83\" colspan=\"3\" scope=\"col\"><p>WEB DE RECETAS DE COCINA</p></th>\n");
      out.write("          </tr>\n");
      out.write("          <tr bgcolor=\"#CCFFFF\">\n");
      out.write("            <td width=\"78%\" valign=\"top\" align=\"center\"><p>&nbsp;</p>\n");
      out.write("              <form  name=\"form1\" method=\"post\" action=\"");
      out.print( response.encodeRedirectURL(request.getContextPath()+"/BuscarRecetaSinLogin"));
      out.write("\">\n");
      out.write("                <p>\n");
      out.write("                  <label for=\"criterio\"></label>\n");
      out.write("                             Buscar por\n");
      out.write("                  <select name=\"criterio\" id=\"criterio\">\n");
      out.write("                    <option value=\"nombre\" selected>Nombre</option>\n");
      out.write("                    <option value=\"ingrediente\" selected>Ingrediente</option>\n");
      out.write("                    <option value=\"plato\">Plato</option>\n");
      out.write("                  </select>\n");
      out.write("                  <label for=\"busqueda\"></label>\n");
      out.write("                  <input name=\"busqueda\" type=\"text\" id=\"busqueda\" size=\"60\">\n");
      out.write("                </p>\n");
      out.write("                <blockquote>\n");
      out.write("                  <p>&nbsp; </p>\n");
      out.write("                  <p>\n");
      out.write("                    <input type=\"submit\" name=\"buscar\" id=\"buscar\" value=\"Buscar\">\n");
      out.write("                  </p>\n");
      out.write("                </blockquote>\n");
      out.write("                <p>&nbsp;</p>\n");
      out.write("              </form>\n");
      out.write("              <h1></h1>\n");
      out.write("<p>&nbsp;</p>\n");
      out.write("            <p>&nbsp;</p></td>\n");
      out.write("            <td width=\"2%\">&nbsp;</td>\n");
      out.write("          </tr>\n");
      out.write("          <tr>\n");
      out.write("           <td bgcolor=\"#99CCFF\" height=\"36\" colspan=\"3\" align=\"center\">Copyright; All Rights Reserved</td>\n");
      out.write("          </tr>\n");
      out.write("        </table>\n");
      out.write("\n");
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
