
<%@page import="java.util.ArrayList"%>
<%@page import="Models.Producto"%>
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
        <form id="formCliente" method="GET" action="ConsumoController">
        <div>
        <%@include file="navar.html" %>  
        </div>
        
        <div class="container"><!--Main container-->
            
            <div class="row" style="margin-top: 5em;">
                <h1>Registrar Pedidos</h1>
                <div class="col-lg-4">
                    <h4>Numero de Identificacion</h4>
                    <input type="text" name="txtNumDocumento"  class="form-control" id="txtNumDocumento" />                    
                </div>
                <div class="col-lg-4">
                    <h4>Numero de Reserva</h4>
                    <input type="text" name="txtReservaId"  class="form-control" id="txtReservaId" readonly required/>                    
                </div>
                <div class="col-lg-4">
                    <h4>&nbsp;</h4>
                    <button type="button" id="btnBuscar"  class="btn btn-success" onclick="buscarReserva()">Buscar</button>
                </div>                            
            </div>    
            
            <div class="row" style="margin-top: 2em;">
                <div class="col-lg-1">
                    <h5><strong>Producos</strong></h5>                   
                </div>    
                <div class="col-lg-4">
                    <select name="ddlProductos" id="ddlProductos" class="form-control">
                       <%
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
                       %>
                       
                    </select>
                </div>
                       <div class="col-lg-2">
                   <select name="ddlCantidad" class="form-control" id="ddlCantidad">
                       <option>1</option>
                       <option>2</option>
                       <option>3</option>
                       <option>4</option>
                       <option>5</option>
                       <option>6</option>
                       <option>7</option>
                       <option>8</option>
                       <option>9</option>
                       <option>10</option>
                   </select>
               </div>
                       
                <div>
                    <div class="col-lg-2">
                        <button type="button" value="btnAgregarProducto"  id="btnAgregarProducto" class="btn btn-success" >Agregar Producto</button>
                    </div>
            </div>
            
            
            
            <div class="row" style="margin-top: 5em;" id="tablaResult"><!--tabla consumos-->                                        
            </div><!--tabla consumos-->
            
            
            
        </div><!--/Main container-->
        
        </form>
        
        
    <script>
   
        
        
        $('#btnBuscar').on('click',function()
        {
            buscarDocumento();
        });
                    
                    
            function buscarDocumento()
            {
                var documento = $('#txtNumDocumento').val();
			
			// Si en vez de por post lo queremos hacer por get, cambiamos el $.post por $.get
                        //envio con ajax
			$.post('ConsumoController', {
				NumDocumento : documento				
			}, function(responseText) {   
                            recibeRespuesta(responseText);                               
			});
                
            }
    
            function recibeRespuesta(textJson)
            {
                
                
                if($('#mytable').length>0)
                {
                    $('#mytable').remove();
                    $('#txtReservaId').val('');
                }
                
                if(textJson!==null && textJson!=="")
                {
                    var obj=JSON.parse(textJson);
                      var tbl=$("<table/>").attr("id","mytable");
                      tbl.prop("class","table table-responsive");
                        $("#tablaResult").append(tbl);
                        var vueltas=obj.consumos.length;
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
            }
            
            
            
              
              $('#btnAgregarProducto').on('click',function(event) {
                var reservaId = $('#txtReservaId').val();
                var productoId = $('#ddlProductos').val();
                var cantidad=$('#ddlCantidad').val();

               if(reservaId!=='' && reservaId!==null)
               {
                    $.get('ConsumoController', {
                            reservaId : reservaId,
                            productoId:productoId,
                            cantidad:cantidad
                    }, function(responseText) {   
                         alert(responseText);
                         buscarDocumento();
                    });
                }
                else
                {
                    alert('Falta el numero de la reserva');
                }
            });
    </script>
         <%@include file="header.html" %>
    </body>
</html>
