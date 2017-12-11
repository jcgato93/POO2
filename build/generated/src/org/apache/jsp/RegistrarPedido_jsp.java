package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import Models.Producto;
import Models.Clientes;

public final class RegistrarPedido_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Registro de Pedidos</title>\n");
      out.write("         ");
      out.write("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\"/>\r\n");
      out.write("<script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"js/jquery-3.2.1.min.js\" ></script>");
      out.write("\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("   \n");
      out.write("    <body>\n");
      out.write("        <form id=\"formCliente\" method=\"GET\" action=\"ConsumoController\">\n");
      out.write("        <div>\n");
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
      out.write("      <li><a href=\"RegistrarProducto.jsp\">Pedidos</a></li>\r\n");
      out.write("      <li><a href=\"#\">Reportes</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("    <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("      <li><a href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> Sign Up</a></li>\r\n");
      out.write("      <li><a href=\"#\"><span class=\"glyphicon glyphicon-log-in\"></span> Login</a></li>\r\n");
      out.write("    </ul>\r\n");
      out.write("  </div>\r\n");
      out.write("</nav> \r\n");
      out.write("\r\n");
      out.write("  \n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div class=\"container\"><!--Main container-->\n");
      out.write("            \n");
      out.write("            <div class=\"row\" style=\"margin-top: 5em;\">\n");
      out.write("                <h1>Registrar Pedidos</h1>\n");
      out.write("                <div class=\"col-lg-4\">\n");
      out.write("                    <h4>Numero de Identificacion</h4>\n");
      out.write("                    <input type=\"text\" name=\"txtNumDocumento\"  class=\"form-control\" id=\"txtNumDocumento\" />                    \n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-4\">\n");
      out.write("                    <h4>Numero de Reserva</h4>\n");
      out.write("                    <input type=\"text\" name=\"txtReservaId\"  class=\"form-control\" id=\"txtReservaId\" readonly required/>                    \n");
      out.write("                </div>\n");
      out.write("                <div class=\"col-lg-4\">\n");
      out.write("                    <h4>&nbsp;</h4>\n");
      out.write("                    <button type=\"button\" id=\"btnBuscar\"  class=\"btn btn-success\" onclick=\"buscarReserva()\">Buscar</button>\n");
      out.write("                </div>                            \n");
      out.write("            </div>    \n");
      out.write("            \n");
      out.write("            <div class=\"row\" style=\"margin-top: 2em;\">\n");
      out.write("                <div class=\"col-lg-1\">\n");
      out.write("                    <h5><strong>Producos</strong></h5>                   \n");
      out.write("                </div>    \n");
      out.write("                <div class=\"col-lg-4\">\n");
      out.write("                    <select name=\"ddlProductos\" id=\"ddlProductos\" class=\"form-control\">\n");
      out.write("                       ");

                         Producto producto=new Producto();
                        ArrayList<Producto>lista= producto.getProductos();                         
                       
                        for (int i = 0; i < lista.size(); i++) {
                                out.print("<option value='"+lista.get(i).getProductoId()+"'>"+lista.get(i).getNombre()+"</option>");                            
                            }
                        
                        try {
                              String result=request.getParameter("result");
                              out.print("<scritp>alert('"+result+"')</script>");
                            } catch (Exception e) {
                            }
                       
      out.write("\n");
      out.write("                       \n");
      out.write("                    </select>\n");
      out.write("                </div>\n");
      out.write("                       <div class=\"col-lg-2\">\n");
      out.write("                   <select name=\"ddlCantidad\" class=\"form-control\" id=\"ddlCantidad\">\n");
      out.write("                       <option>1</option>\n");
      out.write("                       <option>2</option>\n");
      out.write("                       <option>3</option>\n");
      out.write("                       <option>4</option>\n");
      out.write("                       <option>5</option>\n");
      out.write("                       <option>6</option>\n");
      out.write("                       <option>7</option>\n");
      out.write("                       <option>8</option>\n");
      out.write("                       <option>9</option>\n");
      out.write("                       <option>10</option>\n");
      out.write("                   </select>\n");
      out.write("               </div>\n");
      out.write("                       \n");
      out.write("                <div>\n");
      out.write("                    <div class=\"col-lg-2\">\n");
      out.write("                        <button type=\"button\" value=\"btnAgregarProducto\"  id=\"btnAgregarProducto\" class=\"btn btn-success\" >Agregar Producto</button>\n");
      out.write("                    </div>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("            <div class=\"row\" style=\"margin-top: 5em;\" id=\"tablaResult\"><!--tabla consumos-->                                        \n");
      out.write("            </div><!--tabla consumos-->\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("        </div><!--/Main container-->\n");
      out.write("        \n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("    <script>\n");
      out.write("   \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        $('#btnBuscar').on('click',buscarDocumento());\n");
      out.write("                    \n");
      out.write("                    \n");
      out.write("            function buscarDocumento()\n");
      out.write("            {\n");
      out.write("                var documento = $('#txtNumDocumento').val();\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get\n");
      out.write("                        //envio con ajax\n");
      out.write("\t\t\t$.post('ConsumoController', {\n");
      out.write("\t\t\t\tNumDocumento : documento\t\t\t\t\n");
      out.write("\t\t\t}, function(responseText) {   \n");
      out.write("                            recibeRespuesta(responseText);                               \n");
      out.write("\t\t\t});\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("    \n");
      out.write("            function recibeRespuesta(textJson)\n");
      out.write("            {\n");
      out.write("                \n");
      out.write("                \n");
      out.write("                if($('#mytable').length>0)\n");
      out.write("                {\n");
      out.write("                    $('#mytable').remove();\n");
      out.write("                    $('#txtReservaId').val('');\n");
      out.write("                }\n");
      out.write("                \n");
      out.write("                if(textJson!=null && textJson!=\"\")\n");
      out.write("                {\n");
      out.write("                    var obj=JSON.parse(textJson);\n");
      out.write("                      var tbl=$(\"<table/>\").attr(\"id\",\"mytable\");\n");
      out.write("                      tbl.prop(\"class\",\"table table-responsive\");\n");
      out.write("                        $(\"#tablaResult\").append(tbl);\n");
      out.write("                        var vueltas=obj.consumos.length;\n");
      out.write("                        for(var i=0;i<vueltas;i++)\n");
      out.write("                        {\n");
      out.write("                            var tr=\"<tr>\";\n");
      out.write("                            var td1=\"<td>\"+obj.consumos[i][\"nombre\"]+\"</td>\";\n");
      out.write("                            var td2=\"<td>\"+obj.consumos[i][\"precio\"]+\"</td>\";\n");
      out.write("                            var td3=\"<td>\"+obj.consumos[i][\"cantidad\"]+\"</td>\";\n");
      out.write("                            var td4=\"<td>\"+obj.consumos[i][\"estado\"]+\"</td></tr>\";\n");
      out.write("\n");
      out.write("                           $(\"#mytable\").append(tr+td1+td2+td3+td4); \n");
      out.write("\n");
      out.write("                        } \n");
      out.write("                    $('#txtReservaId').val(obj.reservaId);\n");
      out.write("                 }\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("            \n");
      out.write("            \n");
      out.write("              \n");
      out.write("              $('#btnAgregarProducto').on('click',function(event) {\n");
      out.write("                var reservaId = $('#txtReservaId').val();\n");
      out.write("                var productoId = $('#ddlProductos').val();\n");
      out.write("                var cantidad=$('#ddlCantidad').val();\n");
      out.write("\n");
      out.write("               if(reservaId!=='' && reservaId!==null)\n");
      out.write("               {\n");
      out.write("                    $.get('ConsumoController', {\n");
      out.write("                            reservaId : reservaId,\n");
      out.write("                            productoId:productoId,\n");
      out.write("                            cantidad:cantidad\n");
      out.write("                    }, function(responseText) {   \n");
      out.write("                         alert(responseText);\n");
      out.write("                         buscarDocumento();\n");
      out.write("                    });\n");
      out.write("                }\n");
      out.write("                else\n");
      out.write("                {\n");
      out.write("                    alert('Falta el numero de la reserva');\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("    </script>\n");
      out.write("         ");
      out.write("<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\"/>\r\n");
      out.write("<script src=\"js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"js/jquery-3.2.1.min.js\" ></script>");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
