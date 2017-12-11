/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Consumo {
    
    private int consumoId;
    private int reservaId;
    private int productoId;
    private int cantidad;
    private String estado;

    public int getConsumoId() {
        return consumoId;
    }

    public void setConsumoId(int consumoId) {
        this.consumoId = consumoId;
    }

    public int getReservaId() {
        return reservaId;
    }

    public void setReservaId(int reservaId) {
        this.reservaId = reservaId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
     //============== METODOS =========================
    
    
    Conexion conexion=new Conexion();
    
    Connection con=conexion.getConexion();
    String query="";
    
    
   public ArrayList<Consumo> getConsumos() {
        ArrayList<Consumo> lista;
        
        lista = new ArrayList<Consumo>();
        Consumo consumo=new Consumo();
        
        query ="SELECT consumoId,reservaId,productoId,cantidad,estado FROM consumo ";

        try {
            PreparedStatement st = con.prepareStatement(query);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                consumo.setConsumoId(rs.getInt("consumoId"));  
                consumo.setReservaId(rs.getInt("reservaId"));
                consumo.setProductoId(rs.getInt("productoId"));
                consumo.setCantidad(rs.getInt("cantidad"));
                consumo.setEstado(rs.getString("estado"));
                                                          
                lista.add(consumo);
            }
           

        } catch (Exception e) {
            lista=null;            
        }
         return lista;
        
        }
   
   
       /**
        * obtine los consumos de un cliente con
        * el numero de identificacion
        * @param numIdentificacion
        * @return 
        */
   public JSONObject getConsumos(String numIdentificacion) {
        JSONObject lista;
        
        lista = new JSONObject();
        JSONArray consumos=new JSONArray();
        
        query ="select max(reserva.reservaId) as reservaId from clientes left join reserva ON clientes.clienteId=reserva.clienteId where clientes.num_documento=?";

        try {
            PreparedStatement st = con.prepareStatement(query);

            st.setString(1, numIdentificacion);
            
            ResultSet rs = st.executeQuery();
        
            int reservaident=0;
            
            while (rs.next()) {
                reservaident=rs.getInt("reservaId");                                
            }
               
            
            lista.put("reservaId",reservaident);   
               
               lista.put("consumos",consumos);
            if(reservaident!=0)
            {
             query="select producto.nombre, producto.precio_venta,consumo.cantidad,consumo.estado from reserva left join consumo on reserva.reservaId=consumo.reservaId left join producto on producto.productoId=consumo.productoId where reserva.reservaId="+reservaident;
             
             st = con.prepareStatement(query);

             rs = st.executeQuery();
             
             
             JSONObject detalle;
             while (rs.next())
             {
                 detalle=new JSONObject();
                 detalle.put("nombre",rs.getString("nombre"));
                 detalle.put("precio",rs.getString("precio_venta"));
                 detalle.put("cantidad",rs.getString("cantidad"));
                 detalle.put("estado", rs.getString("estado"));
                 
                 consumos.add(detalle);
             }
             
             
             
             
            }
            else
            {                
             lista=null;
            }
            
            

        } catch (Exception e) {
            lista=null;            
        }
         return lista;
        
        }
        
                    
   //=================INSERTAR DATOS  ====================================================
        
    public String insertar(Consumo consumo) {
      
        String result="";
        query = "INSERT INTO consumo (reservaId,productoId,cantidad,estado) VALUES (?,?,?,?)";
      
        try {

            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setInt(1,consumo.getReservaId());
            pst.setInt(2,consumo.getProductoId());
            pst.setInt(3,consumo.getCantidad());
            pst.setString(4,consumo.getEstado());
                
            int n = pst.executeUpdate();

            if (n != 0) {
               result="Registro Exitoso";
            } 
            else { result="No se inserto Correctamente";}
        } catch (Exception e) {
            result="Fallo la Operacion";
        }
        return result; 
    }
            
            
            
     //=======================ACTUALIZAR DATOS===============================================
    public String actualizar(int consumoId,Consumo datosConsumo) {
      
        String result="";
        query = "UPDATE consumo SET productoId=?,cantidad=?,estado=? WHERE consumoId=?";
        
      
        try {

            PreparedStatement pst = con.prepareStatement(query);
            

            pst.setInt(1, datosConsumo.getProductoId());
            pst.setInt(2, datosConsumo.getCantidad());  
            pst.setString(3, datosConsumo.getEstado());
            pst.setInt(4, consumoId);  
 
          
          

            int n = pst.executeUpdate();

            if (n>0) {
               result="Se Actualizo Correctamente";
            } 
        } catch (Exception e) {
            
            result="No se actualizo";
        }
        return result; 
    } 
                   
   
   
}
