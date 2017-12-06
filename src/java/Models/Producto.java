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
public class Producto {
    
    private int productoId;
    private String nombre;
    private String descripcion;
    private String unidad_medida;
    private String precio_venta;

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public String getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(String precio_venta) {
        this.precio_venta = precio_venta;
    }
    
    
    
    //============== METODOS =========================
    
    
    Conexion conexion=new Conexion();
    
    Connection con=conexion.getConexion();
    String query="";
    
    
   public ArrayList<Producto> getProductos() {
        ArrayList<Producto> lista;
        
        lista = new ArrayList<Producto>();
        Producto producto=new Producto();
        
        query ="SELECT productoId,nombre,descripcion,unidad_medida,precio_venta FROM producto ";

        try {
            PreparedStatement st = con.prepareStatement(query);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                producto.setProductoId(rs.getInt("productoId"));  
                producto.setNombre(rs.getString("nombre"));  
                producto.setDescripcion(rs.getString("descripcion"));  
                producto.setUnidad_medida(rs.getString("unidad_medida"));  
                producto.setPrecio_venta(rs.getString("precio_venta"));  
                                                          
                lista.add(producto);
            }
           

        } catch (Exception e) {
            lista=null;            
        }
         return lista;
        
        }
        
                    
   //=================INSERTAR DATOS  ====================================================
        
    public String insertar(Producto producto) {
      
        String result="";
        query = "INSERT INTO producto(nombre,descripcion,unidad_medida,precio_venta) VALUES (?,?,?,?)";
      
        try {

            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setString(1,producto.getNombre());
            pst.setString(2,producto.getDescripcion());
            pst.setString(3,producto.getUnidad_medida());
            pst.setString(4,producto.getPrecio_venta());
                
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
    public String actualizar(int productoId,Producto datosProducto) {
      
        String result="";
        query = "UPDATE producto SET nombre=?,descripcion=?,unidad_medida=?,precio_venta=? WHERE productoId=?";
              
        try {

            PreparedStatement pst = con.prepareStatement(query);
            
            pst.setString(1, datosProducto.getNombre());
            pst.setString(2, datosProducto.getDescripcion());  
            pst.setString(3, datosProducto.getUnidad_medida());
            pst.setString(4, datosProducto.getPrecio_venta());
            pst.setInt(5, productoId);  
 
          
          

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
