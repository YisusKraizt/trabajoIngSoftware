package org.apache.jsp.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import clases.Receta;
import java.util.ArrayList;
import BaseDatos.GestorBDRecetas;
import java.sql.ResultSet;;

public final class comoMostrarReceta_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
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

GestorBDRecetas gr = new GestorBDRecetas();
gr.baseDeDatos.conectar();
ResultSet salida=gr.baseDeDatos.ejecutar("select * from receta;");

      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <table width=\"100%\" height=\"571\" border=\"1\">\n");
      out.write("          <tr bgcolor=\"#99CCFF\" align=\"center\">\n");
      out.write("            <th height=\"83\" colspan=\"3\" scope=\"col\"><p>WEB DE RECETAS DE COCINA</p></th>\n");
      out.write("          </tr>\n");
      out.write("          <tr bgcolor=\"#CCFFFF\">\n");
      out.write("            <td width=\"20%\" height=\"444\" valign=\"top\"><p>&nbsp;</p>\n");
      out.write("              <p>OPCIONES</p>\n");
      out.write("               <p><a href=\"");
      out.print( response.encodeRedirectURL(request.getContextPath()+ "/dentro.jsp"));
      out.write("\" style=\"text-decoration: none; color:#000\">Pantalla Principal</a></p>\n");
      out.write("              <p><a href=\"");
      out.print( response.encodeRedirectURL(request.getContextPath()+ "/jsp/introducirReceta.jsp"));
      out.write("\" style=\"text-decoration: none; color:#000\">Introducir una Receta</a></p>\n");
      out.write("              <p><a href=\"");
      out.print( response.encodeRedirectURL(request.getContextPath()+ "/jsp/buscarReceta.jsp"));
      out.write("\" style=\"text-decoration: none; color: #000\">Buscar una Receta</a></p>\n");
      out.write("              <p><a href=\"");
      out.print( response.encodeRedirectURL(request.getContextPath()+ "/jsp/mostrarPorCategoria.jsp"));
      out.write("\" style=\"text-decoration: none; color: #000\">Mostrar las recetas por categoria</a></p>\n");
      out.write("              <p><a href=\"");
      out.print( response.encodeRedirectURL(request.getContextPath()+ "/jsp/recetaPorProvincia.jsp"));
      out.write("\" style=\"text-decoration: none; color: #000\">Mostrar receta de una provincia</a></p>\n");
      out.write("              <p><a href=\"");
      out.print( response.encodeRedirectURL(request.getContextPath()+ "/jsp/recetaBajoCoste.jsp"));
      out.write("\" style=\"text-decoration: none; color: #000\">Mostrar receta de bajo coste</a></p>\n");
      out.write("<p>&nbsp;</p>\n");
      out.write("<p>");

                ArrayList<Receta> ultimasVisitadas = (ArrayList<Receta>) session.getAttribute("ultimasRecetasVisitadas");
                if(ultimasVisitadas.size() > 0){
                    out.println("<p>Ã?ltimas Recetas Visitadas:</p>");
                    out.println("<p>");
                    for(int i = 0; i < ultimasVisitadas.size(); i++){
                                    out.println(ultimasVisitadas.get(i).getNombre()+"<br />");
                    }	
                    out.println("</p>");
                 }
          
      out.write("</p>\n");
      out.write("<p>&nbsp;</p></td>\n");
      out.write("            <td width=\"78%\" valign=\"top\"><p>&nbsp;</p><form name=\"form2\" method=\"post\" action=\"");
      out.print( response.encodeRedirectURL(request.getContextPath()+"/ComoMostrarReceta"));
      out.write("\">\n");
      out.write("\n");
      out.write("        <table width=\"220\" border=\"0\" cellspacing=\"0\" cellpadding=\"1\">\n");
      out.write("            <tr bgcolor=\"#990033\" align=\"center\">\n");
      out.write("                <td><b><font color=\"#FFFFFF\">RECETAS</font></b></td>\n");
      out.write("            </tr>\n");
      out.write("           \n");
      out.write("            ");
while (salida.next())
                    {
                    String nombre = salida.getString("nombre");
            
      out.write("\n");
      out.write("\n");
      out.write("            <tr bgcolor=\"#990033\">\n");
      out.write("                <td>\n");
      out.write("                  <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"4\">\n");
      out.write("                      <tr bgcolor=\"#FFFFFF\">\n");
      out.write("                          <td><a href=\"mostrarReceta.jsp\" target=\"_blank\">");
      out.print(nombre);
      out.write("</a></td>\n");
      out.write("                      </tr>\n");
      out.write("                  </table>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("           ");

           }
           
      out.write("\n");
      out.write("        </table>\n");
      out.write("</form>&nbsp;</td>\n");
      out.write("            <td width=\"2%\">&nbsp;</td>\n");
      out.write("          </tr>\n");
      out.write("          <tr>\n");
      out.write("           <td bgcolor=\"#99CCFF\" height=\"36\" colspan=\"3\" align=\"center\">Copyright; All Rights Reserved</td>\n");
      out.write("          </tr>\n");
      out.write("        </table>\n");
      out.write("        <p>&nbsp;</p>\n");
      out.write("    </body>\n");
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
