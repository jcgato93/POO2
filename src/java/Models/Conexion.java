/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author GATO
 */
public class  Conexion {
    
     String db="basereserva";
     String url="jdbc:sqlserver://localhost:1433;databaseName="+db+";";
     String user="Invitado";
     String pass="123";
 
     Connection conexion;
    
    
    public  Conexion(){}
    
    
    public  Connection getConexion()
    {
    
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion=DriverManager.getConnection(this.url,this.user,this.pass);
            
        } catch (Exception ex) {
           
        }
    return conexion;
    }
    
}
