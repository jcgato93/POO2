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
public class Reserva {
   
    private int reservaId;
    private int habitacionId;
    private int clienteId;
    private int trabajadorId;
    private String tipo_reserva;
    private String fecha_reserva;
    private String fecha_ingreso;
    private String fecha_salida;
    private String costo_alojamiento;
    private String estado;

    public int getReservaId() {
        return reservaId;
    }

    public void setReservaId(int reservaId) {
        this.reservaId = reservaId;
    }

    public int getHabitacionId() {
        return habitacionId;
    }

    public void setHabitacionId(int habitacionId) {
        this.habitacionId = habitacionId;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getTrabajadorId() {
        return trabajadorId;
    }

    public void setTrabajadorId(int trabajadorId) {
        this.trabajadorId = trabajadorId;
    }

    public String getTipo_reserva() {
        return tipo_reserva;
    }

    public void setTipo_reserva(String tipo_reserva) {
        this.tipo_reserva = tipo_reserva;
    }

    public String getFecha_reserva() {
        return fecha_reserva;
    }

    public void setFecha_reserva(String fecha_reserva) {
        this.fecha_reserva = fecha_reserva;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(String fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getCosto_alojamiento() {
        return costo_alojamiento;
    }

    public void setCosto_alojamiento(String costo_alojamiento) {
        this.costo_alojamiento = costo_alojamiento;
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
    
     
   public ArrayList<Reserva> getReserva() {
        ArrayList<Reserva> lista;
        
        lista = new ArrayList<Reserva>();
        
        Reserva reserva=new Reserva();
        
        query = "select r.reservaId, "
                + "r.habitacionId, "
                + "r.clienteId, "
                + "r.trabajadorId, "
                + "r.tipo_reserva, "
                + "r.fecha_reserva, "
                + "r.fecha_ingreso, "
                + "r.fecha_salida, "
                + "r.costo_alojamiento, "
                + "r.estado "
                + "from  reserva r";

        try {
            PreparedStatement st = con.prepareStatement(query);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                reserva.setReservaId(rs.getInt("reservaId"));  
                reserva.setHabitacionId(rs.getInt("habitacionId"));
                reserva.setClienteId(rs.getInt("clienteId"));
                reserva.setTrabajadorId(rs.getInt("trabajadorId"));
                reserva.setTipo_reserva(rs.getString("tipo_reserva"));
                reserva.setFecha_reserva(rs.getString("fecha_reserva"));
                reserva.setFecha_ingreso(rs.getString("fecha_ingreso"));
                reserva.setFecha_salida(rs.getString("fecha_salida"));
                reserva.setCosto_alojamiento(rs.getString("costo_alojamiento"));
                reserva.setEstado(rs.getString("estado"));
                
                lista.add(reserva);
            }

        } catch (Exception e) {
            lista=null;            
        }
         return lista;        
        }
        
                    
   //=================INSERTAR DATOS  ====================================================
        
    public String insertar(Reserva reserva,Clientes cliente) {
      
        String result="";
        
        
        
        
        query = " INSERT INTO reserva(habitacionId,clienteId,trabajadorId,tipo_reserva,fecha_reserva,fecha_ingreso,fecha_salida,costo_alojamiento,estado) "
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            
            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setInt(1, reserva.getHabitacionId());
            pst.setInt(2, cliente.getClienteId());
            pst.setString(3, "");
            pst.setString(4, "");
            pst.setString(5, reserva.getFecha_reserva());
            pst.setString(6, "");
            pst.setString(7, reserva.getFecha_salida());
            pst.setString(8, "");
            pst.setString(9, "");

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
       public ArrayList<Habitacion> gethabHabitacionsDisponible(String tipo_habitacion) {
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
