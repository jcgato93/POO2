
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

public class Habitacion {
    
    private int habitacionId;
    private String numero;
    private String piso;
    private String caracteristicas;
    private String precio_diario;
    private String estado;
    private String tipo_habitacion;

    public int getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(int habitacionId) {
        this.habitacionId = habitacionId;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getPiso() {
        return piso;
    }

    public void setPiso(String piso) {
        this.piso = piso;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getPrecio_diario() {
        return precio_diario;
    }

    public void setPrecio_diario(String precio_diario) {
        this.precio_diario = precio_diario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo_habitacion() {
        return tipo_habitacion;
    }

    public void setTipo_habitacion(String tipo_habitacion) {
        this.tipo_habitacion = tipo_habitacion;
    }
    
    
      //============== METODOS =========================
    
    
    Conexion conexion=new Conexion();
    
    Connection con=conexion.getConexion();
    String query="";
    
    
   public ArrayList<Habitacion> getHabitaciones() {
        ArrayList<Habitacion> lista;
        
        lista = new ArrayList<Habitacion>();
        
        Habitacion habitaciones=new Habitacion();
        
        query ="select h.habitacionId, "
                + "h.numero, "
                + "h.piso, "
                + "h.caracteristicas, "
                + "h.precio_diario, "
                + "h.estado, "
                + "h.tipo_habitacion "
                + "from habitacion h";

        try {
            PreparedStatement st = con.prepareStatement(query);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                habitaciones.setHabitacionId(rs.getInt("habitacionId"));  
                habitaciones.setNumero(rs.getString("numero"));
                habitaciones.setPiso(rs.getString("piso"));
                habitaciones.setCaracteristicas(rs.getString("caracteristicas"));
                habitaciones.setPrecio_diario(rs.getString("precio_diario"));
                habitaciones.setEstado(rs.getString("estado"));
                habitaciones.setTipo_habitacion(rs.getString("tipo_habitacion"));
                
                lista.add(habitaciones);
            }

        } catch (Exception e) {
            lista=null;            
        }
         return lista;        
        }
        
                    
   //=================INSERTAR DATOS  ====================================================
        
    public String insertar(Habitacion habitacion) {
      
        String result="";
        
        query = "INSERT INTO habitacion ("
                + "numero,"
                + "piso,"
                + "caracteristicas,"
                + "precio_diario,"
                + "estado,"
                + "tipo_habitacion) "
                + "VALUES (?,?,?,?,?,?)";
        try {
            
            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setString(1, habitacion.getNumero());
            pst.setString(2, habitacion.getPiso());
            pst.setString(3, habitacion.getCaracteristicas());
            pst.setString(4, habitacion.getPrecio_diario());
            pst.setString(5, habitacion.getEstado());
            pst.setString(6, habitacion.getTipo_habitacion());

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
    public String actualizar(int HabitacionId,Habitacion datosHabitacion) {
      
        String result="";
        query = "UPDATE habitacion set "
                + "numero=?, "
                + "piso=?, "
                + "caracteristicas=?, "
                + "precio_diario=?, "
                + "estado=?, "
                + "tipo_habitacion=? "
                + "where habitacionId=?";
        try {

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, datosHabitacion.getNumero());
            pst.setString(2, datosHabitacion.getPiso());  
            pst.setString(3, datosHabitacion.getCaracteristicas());
            pst.setString(4, datosHabitacion.getPrecio_diario());
            pst.setString(5, datosHabitacion.getEstado());
            pst.setString(6, datosHabitacion.getTipo_habitacion());
            
            pst.setInt(7, HabitacionId);
            
            int n = pst.executeUpdate();

            if (n>0) {
               result="Se Actualizo Correctamente";
            } 
        } catch (Exception e) {
            
            result="No se actualizo";
        }
        return result; 
    } 
                   
   
    //=========================VERIFICA si hay habitaciones Disponibles=============================================
       public ArrayList<Habitacion> getHabitacionesDisponible(String tipo_habitacion) {
        ArrayList<Habitacion> lista;
        
        lista = new ArrayList<Habitacion>();
        
        Habitacion habitaciones=new Habitacion();
        
        query ="select h.habitacionId, "
                + "h.numero, "
                + "h.piso, "
                + "h.caracteristicas, "
                + "h.precio_diario, "
                + "h.estado, "
                + "h.tipo_habitacion "
                + "from habitacion h "
                + "where tipo_habitacion="+tipo_habitacion+" "
                + "and estado='Disponible'";

        try {
            PreparedStatement st = con.prepareStatement(query);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                habitaciones.setHabitacionId(rs.getInt("habitacionId"));  
                habitaciones.setNumero(rs.getString("numero"));
                habitaciones.setPiso(rs.getString("piso"));
                habitaciones.setCaracteristicas(rs.getString("caracteristicas"));
                habitaciones.setPrecio_diario(rs.getString("precio_diario"));
                habitaciones.setEstado(rs.getString("estado"));
                habitaciones.setTipo_habitacion(rs.getString("tipo_habitacion"));
                
                lista.add(habitaciones);
            }

        } catch (Exception e) {
            lista=null;            
        }
         return lista;        
        }
    
}
