<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="header.html" %>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 

        <title>Registrar Cliente</title>
    </head>
    <body style="overflow-y: hidden;">  
        <form id="formCliente" method="POST" action="Clientes">
        <div>
        <%@include file="navar.html" %>  
        </div>
        
    
        <div class="container" style="margin-top: 3em; height:500px; overflow-y: scroll">
            
            <div class="row" style="margin-top: 2em;">
                <div class="col-lg-12"><h3>Nombres</h3></div>
                <div class="col-lg-5"> <input type="text" name="txtNombres" value="" class="form-control" required=""/></div>
            </div>
            
            <div class="row" style="margin-top: 2em;">
                <div class="col-lg-12"><h3>Apellidos</h3></div>
                <div class="col-lg-5"> <input type="text" name="txtApellidos" value="" class="form-control" required=""/></div>
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
                <div class="col-lg-5"> <input type="text" name="txtNumDocumento" value="" class="form-control" required=""/></div>
            </div>
            
            <div class="row" style="margin-top: 2em;">
                <div class="col-lg-12"><h3>Direccion</h3></div>
                <div class="col-lg-5"> <input type="text" name="txtDireccion" value="" class="form-control" required=""/></div>
            </div>
            
            <div class="row" style="margin-top: 2em;">
                <div class="col-lg-12"><h3>Telefono</h3></div>
                <div class="col-lg-5"> <input type="number" name="txtTelefono" value="" class="form-control" required=""/></div>
            </div>
            
            <div class="row" style="margin-top: 2em;">
                <div class="col-lg-12"><h3>Email</h3></div>
                <div class="col-lg-5"> <input type="email" name="txtEmail" value="" class="form-control" /></div>
            </div>
            
            <div class="row" style="margin-top: 2em;">
                <div class="col-lg-12">
                    <input type="submit" value="Registrar" name="btnSubmit"  class="btn btn-primary"/>
                </div>
               
            </div>                
            
        </div>
        
        <script>
            $(document).ready(function(){
                
               try {
                var respuesta='${mensaje}';
                
                if(respuesta==""){}
                else{alert(respuesta);}
                
                
                } catch (e) {

                }               
            });
            
        </script>
        
        </form>
    </body>
    <%@include file="header.html" %>
</html>
