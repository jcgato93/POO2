<%@page import="java.util.ArrayList"%>
<%@page import="Models.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <%@include file="header.html" %>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    </head>
    <body>
        
        
<%
    Clientes cliente=new Clientes();
     ArrayList<Clientes> lista=cliente.getClientes();
    
     
     pageContext.setAttribute("lista", lista);
%>
        <form id="formActulizaCliente" action="ClientesController" method="POST">
        <div class="container">
            <div class="row" style="margin: 1em;">
                <h1>Atualizar Cliente</h1>                    
            </div>            
            
            
            <div class="row" style="margin: 1em;">
                <table class="table table-responsive table-hover table-bordered">
                    <thead>
                        <tr>
                            <th>Identificacion</th>
                            <th>Nombres</th>
                            <th>Apellidos</th>
                            <th>Tipo_Documento</th>
                            <th>Direccion</th>
                            <th>Telefono</th>
                            <th>Email</th>
                            <th>ClienteId</th>
                            <th>Editar</th>                            
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="lista" items="${lista}">
                      
                        <tr>
                            <td> <input type="text" name="txtIdentificacion" value="${lista.getNum_documento()}" class="form-control" required/></td>
                            <td> <input type="text" name="txtNombres" value="${lista.getNombres()}" required="" class="form-control"/> </td>
                            <td> <input type="text" name="txtApellidos" value="${lista.getApellidos()}" required="" class="form-control" /></td>
                            <td> <select name="ddlTipoDocumento" id="ddlTipoDocumento" class="form-control" >
                                    <option>CC</option>
                                    <option>CE</option>
                                    <option>PASAPORTE</option>
                                </select>
                                
                            </td>
                            <td> <input type="text" name="txtDireccion" value="${lista.getDireccion()}" required="" class="form-control" /> </td>
                            <td> <input type="text" name="txtTelefono" value="${lista.getTelefono()}" required="" class="form-control" /> </td>
                            <td> <input type="text" name="txtEmail" value="${lista.getEmail()}" required="" class="form-control" /> </td>
                            <td>
                                <input type="text" name="txtClienteId" value="${lista.getClienteId()}" class="form-control" readonly=""/>                                
                            </td>
                            <td>
                                <input type="submit" value="Editar" name="btnSubmit" class="btn btn-warning" />
                            </td>
                        </tr>
                         </c:forEach> 
                    </tbody>
                </table>

                
                
            </div>            
   
                
                    
        </div>
       </form>
        
       <script>
         $(document).ready(funtion()
         {
            $("#ddlTipoDocumento").prop('select',${lista.getTipo_documento()});
             
         });
     </script>
    </body>
     <%@include file="header.html" %>
     
   
</html>
