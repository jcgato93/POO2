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

/**
 *
 * @author GATO
 */
public class Pago {
    
    private int pagoId;
    private int reservaId;
    private String total_pago;
    private String fecha_emision;
    private String fecha_pago;

    public int getPagoId() {
        return pagoId;
    }

    public void setPagoId(int pagoId) {
        this.pagoId = pagoId;
    }

    public int getReservaId() {
        return reservaId;
    }

    public void setReservaId(int reservaId) {
        this.reservaId = reservaId;
    }

    public String getTotal_pago() {
        return total_pago;
    }

    public void setTotal_pago(String total_pago) {
        this.total_pago = total_pago;
    }

    public String getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(String fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }
    
    
    
     //============== METODOS =========================
    
    
    Conexion conexion=new Conexion();
    
    Connection con=conexion.getConexion();
    String query="";
    
    
   public ArrayList<Pago> getPagos() {
        ArrayList<Pago> lista;
        
        lista = new ArrayList<Pago>();
        Pago pago=new Pago();
        
        query ="SELECT pagoId,reservaId,total_pago,fecha_emision,fecha_pago  FROM pago ";

        try {
            PreparedStatement st = con.prepareStatement(query);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                pago.setPagoId(rs.getInt("pagoId"));  
                pago.setReservaId(rs.getInt("reservaId"));
                pago.setTotal_pago(rs.getString("total_pago"));
                pago.setFecha_emision(rs.getString("fecha_emision"));
                pago.setFecha_pago(rs.getString("fecha_pago"));
                                                          
                lista.add(pago);
            }
           

        } catch (Exception e) {
            lista=null;            
        }
         return lista;
        
        }
        
                    
   //=================INSERTAR DATOS  ====================================================
        
    public String insertar(Pago pago) {
      
        String result="";
        query = "INSERT INTO pago(reservaId,total_pago,fecha_emision,fecha_pago) VALUES (?,?,?,?)";
      
        try {

            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setInt(1,pago.getReservaId());
            pst.setString(2,pago.getTotal_pago());
            pst.setString(3,pago.getFecha_emision());
            pst.setString(4,pago.getFecha_pago());
                
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
    public String actualizar(int pagoId,Pago datosPago) {
      
        String result="";
        query = "UPDATE pago SET total_pago=?,fecha_emision=?,fecha_pago=? WHERE pagoId=?";
        
      
        try {

            PreparedStatement pst = con.prepareStatement(query);
            

            pst.setString(1, datosPago.getTotal_pago());
            pst.setString(2, datosPago.getFecha_emision());  
            pst.setString(3, datosPago.getFecha_pago());
            pst.setInt(4, pagoId);  
 
          
          

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
