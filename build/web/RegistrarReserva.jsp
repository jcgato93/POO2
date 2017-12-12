
<%@page import="java.util.ArrayList"%>
<%@page import="Models.Habitacion"%>
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
        <%@include file="navar.html" %>  
        <form id="formRegistrarReserva" action="ReservaController" method="POST" >
            
            <div class="container" style="margin-top: 5em">
                
                <div class="row"><h1>Registro Reservas</h1></div>
                
                <div class="row" style="margin-top: 3em">
                    <div class="col-lg-12"><strong>Habitacion</strong>
                        
                        <select name="ddlHabitacion" id="ddlHabitacion" class="form-control">                        
                        
                    <%
                        try {
                                
                            Habitacion hb=new Habitacion();
                            ArrayList<Habitacion> lista =hb.getHabitaciones();
                            
                            for (int i = 0; i < lista.size(); i++) 
                            {
                              out.print("<option value="+lista.get(i).getHabitacionId()+">"+lista.get(i).getTipo_habitacion()+"</option>");
                            }
                            
                            } catch (Exception e) {
                            }
                            
                    %>
                    </select>  
                    </div>
                </div>
                    
                    <div class="row" style="margin-top: 3em;">
                    <div class="col-lg-1">
                        <strong>ClienteId</strong>
                    </div>
                        <div class="col-lg-4">
                            <input type="text" name="txtClienteId" value="" id="txtClienteId" class="form-control"/>
                        </div>                          
                    </div>
                    
                    <div class="row" style="margin-top: 3em;">
                    <div class="col-lg-1">
                        <strong>Fecha reserva</strong>
                    </div>
                        <div class="col-lg-4">
                            <input type="date" name="txtFechaReserva" value="" id="txtFechaReserva" class="form-control"/>
                        </div>                          
                    </div>
                    
                    
                            <div class="row" style="margin-top: 3em;">
                    <div class="col-lg-1">
                        <strong>Fecha Salida</strong>
                    </div>
                        <div class="col-lg-4">
                            <input type="date" name="txtFechaSalida" value="" id="txtFechaSalida" class="form-control"/>
                        </div>                          
                    </div>
                    
                    
                    
                    <div class="row" style="margin-top: 3em;">
                        
                        <div class="col-lg-4">
                            <input type="submit" value="btnRegistrar" class="btn btn-primary" />
                        </div>
                        
                    </div>
                    
                    
            </div>
            
            
        </form>
           <script>
            $(document).ready(function(){
                
               try {
                var respuesta='${result}';
                
                if(respuesta==""){}
                else{alert(respuesta);}
                
                
                } catch (e) {

                }               
            });
            
        </script>
    </body>
</html>
