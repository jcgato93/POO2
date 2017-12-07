<%-- 
    Document   : RegistrarProductos
    Created on : 5/12/2017, 10:50:31 PM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="header.html" %>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <title>Registro de Productos</title>
    </head>
    <body style="overflow-y: hidden;">
        <form id="formProductos" method="POST" action="Productos">
            <div>
                <%@include file="navar.html" %>  
            </div>

            <div class="contnt-header">
                <h1 style="text-align:left">
                    Registro de Productos
                </h1>
            </div>

            <div class="content">
                <div class="row">
                    <div class="col-lg-6" style="margin-top: 2em;"> <!-- Primer panel-->
                        <div class="box box-primary">
                            <div class="box-body"><!--inivio de la clase box-body -->
                                <div class="col-lg-6">
                                    <div class="form-group">
                                        <input type="text" name="txtNombre" required="Campo requerido" class="form-control" placeholder="Nombre" />
                                    </div>  
                               
                                    <div class="form-group">
                                        <input type="text" name="txtDescripcion" required="Campo requerido" class="form-control" placeholder="Descripción" />
                                    </div> 
                                   
                                    <div class="form-group">
                                        <input type="text" name="txtUnidad" required="Campo requerido" class="form-control" placeholder="Unidades" />
                                    </div>                    
                               
                                    <div class="form-group">
                                        <input type="text" name="txtPrecio" required="Campo requerido" class="form-control" placeholder="Precio" />
                                    </div>                    
                               

                                <div class="form-group">
                                <input type="submit" value="Registrar" name="btnSubmit"  class="btn btn-primary" Width="50%"/>
                                </div>
                         
                                    

                                </div>
                        </div> <!--fin de la clase box-body -->

                        </div>
                    </div>
                 </div>
          </div>

        <script>
            $(document).ready(function () {

                try {
                    var respuesta = '${mensaje}';
                    if (respuesta == "") {
                    } else {
                        alert(respuesta);
                    }
                } catch (e) {

                }
            });

        </script>
    </form>
</body>
<%@include file="header.html" %>
</html>
