package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class RegistrarCliente_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.html");
    _jspx_dependants.add("/navar.html");
  }

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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        ");
      out.write("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\"/>\r\n");
      out.write("<script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"js/jquery-3.2.1.min.js\" ></script>");
      out.write("\r\n");
      out.write("        \r\n");
      out.write(" \r\n");
      out.write("\r\n");
      out.write("        <title>Registrar Cliente</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body style=\"overflow-y: hidden;\">  \r\n");
      out.write("        <form id=\"formCliente\" method=\"POST\" action=\"Clientes\">\r\n");
      out.write("        <div>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("  <nav class=\"navbar navbar-inverse\">\r\n");
      out.write("  <div class=\"container-fluid\">\r\n");
      out.write("    <div class=\"navbar-header\">\r\n");
      out.write("      <a class=\"navbar-brand\" href=\"#\">Hotel Summer</a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <ul class=\"nav navbar-nav\">\r\n");
      out.write("      <li class=\"active\"><a href=\"#\">Home</a></li>\r\n");
      out.write("      <li class=\"dropdown\">\r\n");
      out.write("          <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Clientes <span class=\"caret\"></span></a>\r\n");
      out.write("          <ul class=\"dropdown-menu\">\r\n");
      out.write("            <li><a href=\"RegistrarCliente.jsp\">Registrar</a></li>\r\n");
      out.write("            <li><a href=\"TablaClientes.jsp\">Actualizar</a></li>       \r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("       <li class=\"dropdown\">\r\n");
      out.write("          <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Trabajadores <span class=\"caret\"></span></a>\r\n");
      out.write("          <ul class=\"dropdown-menu\">\r\n");
      out.write("            <li><a href=\"RegistrarTrabajadores.jsp\">Registrar</a></li>\r\n");
      out.write("            <li><a href=\"ActualizarTrabajadores.jsp\">Actualizar</a></li>       \r\n");
      out.write("          </ul>\r\n");
      out.write("        </li>\r\n");
      out.write("      <li><a href=\"#\">Registro Reservas</a></li>\r\n");
      out.write("      <li><a href=\"#\">Pedidos</a></li>\r\n");
      out.write("      <li><a href=\"#\">Reportes</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("    <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("      <li><a href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> Sign Up</a></li>\r\n");
      out.write("      <li><a href=\"#\"><span class=\"glyphicon glyphicon-log-in\"></span> Login</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("  </div>\r\n");
      out.write("</nav> \r\n");
      out.write("\r\n");
      out.write("  \r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("    \r\n");
      out.write("        <div class=\"container\" style=\"margin-top: 3em; height:500px; overflow-y: scroll\">\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"row\" style=\"margin-top: 2em;\">\r\n");
      out.write("                <div class=\"col-lg-12\"><h3>Nombres</h3></div>\r\n");
      out.write("                <div class=\"col-lg-5\"> <input type=\"text\" name=\"txtNombres\" value=\"\" class=\"form-control\" required=\"\"/></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"row\" style=\"margin-top: 2em;\">\r\n");
      out.write("                <div class=\"col-lg-12\"><h3>Apellidos</h3></div>\r\n");
      out.write("                <div class=\"col-lg-5\"> <input type=\"text\" name=\"txtApellidos\" value=\"\" class=\"form-control\" required=\"\"/></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"row\" style=\"margin-top: 2em;\">\r\n");
      out.write("                <div class=\"col-lg-12\"><h3>Tipo de Documento</h3></div>\r\n");
      out.write("                <div class=\"col-lg-5\"> <select name=\"ddlTipoDocumento\" class=\"form-control\">\r\n");
      out.write("                        <option>CC</option>\r\n");
      out.write("                        <option>CE</option>\r\n");
      out.write("                        <option>Pasaporte</option>\r\n");
      out.write("                    </select> </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"row\" style=\"margin-top: 2em;\">\r\n");
      out.write("                <div class=\"col-lg-12\"><h3>Numero de Documento</h3></div>\r\n");
      out.write("                <div class=\"col-lg-5\"> <input type=\"text\" name=\"txtNumDocumento\" value=\"\" class=\"form-control\" required=\"\"/></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"row\" style=\"margin-top: 2em;\">\r\n");
      out.write("                <div class=\"col-lg-12\"><h3>Direccion</h3></div>\r\n");
      out.write("                <div class=\"col-lg-5\"> <input type=\"text\" name=\"txtDireccion\" value=\"\" class=\"form-control\" required=\"\"/></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"row\" style=\"margin-top: 2em;\">\r\n");
      out.write("                <div class=\"col-lg-12\"><h3>Telefono</h3></div>\r\n");
      out.write("                <div class=\"col-lg-5\"> <input type=\"number\" name=\"txtTelefono\" value=\"\" class=\"form-control\" required=\"\"/></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"row\" style=\"margin-top: 2em;\">\r\n");
      out.write("                <div class=\"col-lg-12\"><h3>Email</h3></div>\r\n");
      out.write("                <div class=\"col-lg-5\"> <input type=\"email\" name=\"txtEmail\" value=\"\" class=\"form-control\" /></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("            <div class=\"row\" style=\"margin-top: 2em;\">\r\n");
      out.write("                <div class=\"col-lg-12\">\r\n");
      out.write("                    <input type=\"submit\" value=\"Registrar\" name=\"btnSubmit\"  class=\"btn btn-primary\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("               \r\n");
      out.write("            </div>                \r\n");
      out.write("            \r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <script>\r\n");
      out.write("            $(document).ready(function(){\r\n");
      out.write("                \r\n");
      out.write("               try {\r\n");
      out.write("                var respuesta='");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mensaje}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("';\r\n");
      out.write("                \r\n");
      out.write("                if(respuesta==\"\"){}\r\n");
      out.write("                else{alert(respuesta);}\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                } catch (e) {\r\n");
      out.write("\r\n");
      out.write("                }               \r\n");
      out.write("            });\r\n");
      out.write("            \r\n");
      out.write("        </script>\r\n");
      out.write("        \r\n");
      out.write("        </form>\r\n");
      out.write("    </body>\r\n");
      out.write("    ");
      out.write("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\"/>\r\n");
      out.write("<script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"js/jquery-3.2.1.min.js\" ></script>");
      out.write("\r\n");
      out.write("</html>\r\n");
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
