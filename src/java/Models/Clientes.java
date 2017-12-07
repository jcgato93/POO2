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


public class Clientes {
    
    private int clienteId;
    private String nombres;
    private String apellidos;
    private String tipo_documento;
    private String num_documento;
    private String direccion;
    private String telefono;
    private String email;
    
    
    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    
    
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Conexion getConexion() {
        return conexion;
    }

    public void setConexion(Conexion conexion) {
        this.conexion = conexion;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
     //============== METODOS =========================
    
    
    private Conexion conexion=new Conexion();
    
    private Connection con=conexion.getConexion();
    private String query="";
    
    /**
     * Retorna la lista de todos los clientes
     * @return 
     */
   public ArrayList<Clientes> getClientes() {
        ArrayList<Clientes> lista;
        
        lista = new ArrayList<>();
        Clientes clientes=new Clientes();
        
        query ="SELECT [clienteId]" +
        ",[nombres]" +
        ",[apellidos]" +
        ",[tipo_documento]" +
        ",[num_documento]" +
        ",[direccion]" +
        ",[telefono]" +
        ",[email] " +
        "FROM [Clientes]";

        try {
            PreparedStatement st = con.prepareStatement(query);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                clientes=new Clientes();
                clientes.setClienteId(rs.getInt("ClienteId"));               
                clientes.setNombres(rs.getString("nombres"));
                clientes.setApellidos(rs.getString("apellidos"));
                clientes.setTipo_documento(rs.getString("tipo_documento"));
                clientes.setNum_documento(rs.getString("num_documento"));
                clientes.setDireccion(rs.getString("direccion"));
                clientes.setTelefono(rs.getString("telefono"));
                clientes.setEmail(rs.getString("email"));
                
                             
                lista.add(clientes);
            }
           

        } catch (Exception e) {
            lista=null;            
        }
         return lista;
        
        }
   
   
   
   /**
    * Obtiene un objeto cliente
    * con la informacion de un cliente 
    * que concuerde con la identificacion
    * @param identificacion
    * @return 
    */
   public Clientes getClientes(int clienteId) {
       
        Clientes clientes=new Clientes();
        
        query ="SELECT [clienteId]" +
        ",[nombres]" +
        ",[apellidos]" +
        ",[tipo_documento]" +
        ",[num_documento]" +
        ",[direccion]" +
        ",[telefono]" +
        ",[email] " +
        "FROM [clientes] WHERE clienteId="+clienteId;

        try {
            PreparedStatement st = con.prepareStatement(query);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                clientes.setClienteId(rs.getInt("ClienteId"));               
                clientes.setNombres(rs.getString("nombres"));
                clientes.setApellidos(rs.getString("apellidos"));
                clientes.setTipo_documento(rs.getString("tipo_documento"));
                clientes.setNum_documento(rs.getString("num_documento"));
                clientes.setDireccion(rs.getString("direccion"));
                clientes.setTelefono(rs.getString("telefono"));
                clientes.setEmail(rs.getString("email"));                                                            
            }
           

        } catch (Exception e) {
            clientes=null;            
        }
         return clientes;
        
        }
        
                    
   //=================INSERTAR DATOS  ====================================================
        
    public String insertar(Clientes cliente) {
      
        String result="";
        query = "INSERT INTO  clientes(nombres,apellidos,tipo_documento,num_documento,direccion,telefono,email) VALUES(?,?,?,?,?,?,?)";
      
        try {                        
            PreparedStatement pst = con.prepareStatement(query);
            

            pst.setString(1,cliente.getNombres());
            pst.setString(2,cliente.getApellidos());
            pst.setString(3,cliente.getTipo_documento());
            pst.setString(4,cliente.getNum_documento());
            pst.setString(5,cliente.getDireccion());
            pst.setString(6,cliente.getTelefono());
            pst.setString(7,cliente.getEmail());
      
          

            int n = pst.executeUpdate();

            result="Se inserto correctamente";
     
            
        
        
        } catch (Exception e) {
           result=e.getMessage();
        }
        return result; 
    }
            
            
            
     //=======================ACTUALIZAR DATOS===============================================
    /**
     * Actualiza la informacion de un Cliente
     * @param ClienteId
     * @param datosCliente
     * @return 
     */
    public String actualizar(int ClienteId,Clientes datosCliente) {
      
        String result="";
        query = "UPDATE clientes "
                + "SET nombres=?,"
                + "apellidos=?,"
                + "tipo_documento=?,"
                + "num_documento=?,"
                + "direccion=?,"
                + "telefono=?,"
                + "email=?  "
                + "WHERE clienteId=?";
        
      
        try {

            PreparedStatement pst = con.prepareStatement(query);
            

            pst.setString(1, datosCliente.getNombres());
            pst.setString(2, datosCliente.getApellidos());  
            pst.setString(3, datosCliente.getTipo_documento());
            pst.setString(4, datosCliente.getNum_documento());
            pst.setString(5, datosCliente.getDireccion());
            pst.setString(6, datosCliente.getTelefono());
            pst.setString(7, datosCliente.getEmail());
            pst.setInt(8, ClienteId);
          
          

            int n = pst.executeUpdate();

            if (n>0) {
               result="Se Actualizo Correctamente";
            } 
        } catch (Exception e) {
            
            result=e.getMessage();
        }
        return result; 
    } 
                   
   
    //=========================VERIFICA si existe cliente=============================================
        public boolean verificaCliente(int num_documento) {
              
        query ="SELECT * FROM clientes WHERE  num_documento=? ";

        int contador=0;
        boolean result=false;
        
        try {
            PreparedStatement st = con.prepareStatement(query);
            
           st.setInt(1, num_documento);
            
            ResultSet rs = st.executeQuery();

            
            
            while (rs.next()) {
              contador++;
            }
            
            if(contador>0)
            {
            result=true;
            }

        } catch (Exception e) {
           
        }
          return result;
       }

}
