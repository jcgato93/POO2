
<%@page import="Models.Clientes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Pedidos</title>
         <%@include file="header.html" %>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    </head>
   
    <body>
        <form id="formCliente" method="POST" action="Clientes">
        <div>
        <%@include file="navar.html" %>  
        </div>
        
        <div class="container"><!--Main container-->
            
            <div class="row" style="margin-top: 5em;">
                <h1>Registrar Pedidos</h1>
                <div class="col-lg-4">
                    <h4>Numero de Identificacion</h4>
                    <input type="text" name="txtNumDocumento"  class="form-control" id="txtNumDocumento"/>                    
                </div>
                <div class="col-lg-4">
                    <h4>Numero de Reserva</h4>
                    <input type="text" name="txtReservaId"  class="form-control" id="txtReservaId" readonly/>                    
                </div>
                <div class="col-lg-4">
                    <h4>&nbsp;</h4>
                    <button type="button" id="btnBuscar"  class="btn btn-success" onclick="buscarReserva()">Buscar</button>
                </div>                            
            </div>    
            
           
            <div class="row" style="margin-top: 3em;" id="tablaResult"><!--tabla consumos-->
                
         

                
            </div><!--tabla consumos-->
            
            
            
        </div><!--/Main container-->
        
        </form>
        
        
    <script>
   
        
        
        $('#btnBuscar').on('click',function(event) {
			var documento = $('#txtNumDocumento').val();
			
			// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
                        //envio con ajax
			$.post('ConsumoController', {
				NumDocumento : documento				
			}, function(responseText) {   
                            recibeRespuesta(responseText);                               
			});
                    });
                    
                    
                    
            function recibeRespuesta(textJson)
            {
                var obj=JSON.parse(textJson)
                
                
                  var tbl=$("<table/>").attr("id","mytable");
                  tbl.prop("class","table table-responsive");
                    $("#tablaResult").append(tbl);
                    var vueltas=obj.consumos.length
                    for(var i=0;i<vueltas;i++)
                    {
                        var tr="<tr>";
                        var td1="<td>"+obj.consumos[i]["nombre"]+"</td>";
                        var td2="<td>"+obj.consumos[i]["precio"]+"</td>";
                        var td3="<td>"+obj.consumos[i]["cantidad"]+"</td>";
                        var td4="<td>"+obj.consumos[i]["estado"]+"</td></tr>";

                       $("#mytable").append(tr+td1+td2+td3+td4); 

                    } 
                $('#txtReservaId').val(obj.reservaId);
            }
    </script>
         <%@include file="header.html" %>
    </body>
</html>
