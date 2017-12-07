<%-- 
    Document   : ActualizaCliente
    Created on : 6/12/2017, 08:32:26 PM
    Author     : GATO
--%>

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
       <body style="overflow-y: hidden;">  
           <form id="formCliente" method="POST" action="Clientes">
        <div>
        <%@include file="navar.html" %>  
        </div>
        <%
             Clientes cliente=new Clientes();
             int id=Integer.parseInt(request.getParameter("btnSubmit"));
             cliente=cliente.getClientes(id);//submit que viene del formulario TablaClientes.jsp
       
              pageContext.setAttribute("cliente", cliente);
        %>
    
        <div class="container" style="margin-top: 3em; height:500px; overflow-y: scroll">
            
            <div class="row" style="margin-top: 2em;">
                <div class="col-lg-12"><h3>Nombres</h3></div>
                <div class="col-lg-5"> <input type="text" name="txtNombres" value="${cliente.getNombres()}" class="form-control" required=""/></div>
            </div>
            
            <div class="row" style="margin-top: 2em;">
                <div class="col-lg-12"><h3>Apellidos</h3></div>
                <div class="col-lg-5"> <input type="text" name="txtApellidos" value="${cliente.getApellidos()}" class="form-control" required=""/></div>
            </div>
            
            <div class="row" style="margin-top: 2em;">
                <div class="col-lg-12"><h3>Tipo de Documento</h3></div>
                <div class="col-lg-5"> <select name="ddlTipoDocumento" class="form-control">
                        <option>CC</option>
                        <option>CE</option>
                        <option>Pasaporte</option>
                    </select> </div>
            </div>
            
            <div class="row" style="margin-top: 2em;">
                <div class="col-lg-12"><h3>Numero de Documento</h3></div>
                <div class="col-lg-5"> <input type="text" name="txtNumDocumento" value="${cliente.getNum_documento()}" class="form-control" required=""/></div>
            </div>
            
            <div class="row" style="margin-top: 2em;">
                <div class="col-lg-12"><h3>Direccion</h3></div>
                <div class="col-lg-5"> <input type="text" name="txtDireccion" value="${cliente.getDireccion()}" class="form-control" required=""/></div>
            </div>
            
            <div class="row" style="margin-top: 2em;">
                <div class="col-lg-12"><h3>Telefono</h3></div>
                <div class="col-lg-5"> <input type="number" name="txtTelefono" value="${cliente.getTelefono()}" class="form-control" required=""/></div>
            </div>
            
            <div class="row" style="margin-top: 2em;">
                <div class="col-lg-12"><h3>Email</h3></div>
                <div class="col-lg-5"> <input type="email" name="txtEmail" value="${cliente.getEmail()}" class="form-control" /></div>
            </div>
            
            <div class="row" style="margin-top: 2em;">            
                <div class="col-lg-5"> <input type="text" name="txtClienteId" value="${cliente.getClienteId()}" class="form-control"  readonly=""/></div>
            </div>
            
            <div class="row" style="margin-top: 2em;">
                <div class="col-lg-12">
                    <input type="submit" value="Actualizar" name="btnSubmit"  class="btn btn-primary"/>
                </div>
               
            </div>                
            
        </div>
                                               
        </form>
    </body>
    <%@include file="header.html" %>
    
    
</html>
