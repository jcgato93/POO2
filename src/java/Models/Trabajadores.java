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
import java.util.List;

/**
 *
 * @author GATO
 */
public class Trabajadores {

    private int trabajadoresId;
    private String nombres;
    private String apellidos;
    private String tipo_documento;
    private String num_documento;
    private String direccion;
    private String telefono;
    private String email;
    private String sueldo;
    private String rol;
    private String login;
    private String password;

    public int getTrabajadoresId() {
        return trabajadoresId;
    }

    public void setTrabajadoresId(int trabajadoresId) {
        this.trabajadoresId = trabajadoresId;
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

    public String getSueldo() {
        return sueldo;
    }

    public void setSueldo(String sueldo) {
        this.sueldo = sueldo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //============== METODOS =========================
    Conexion conexion = new Conexion();

    Connection con = conexion.getConexion();
    String query = "";

    public ArrayList<Trabajadores> getTrabajadores() {
        ArrayList<Trabajadores> lista;

        lista = new ArrayList<Trabajadores>();
        Trabajadores t = new Trabajadores();

        query = "SELECT t.trabajadoresId,"
                + "t.nombres,"
                + "t.apellidos,"
                + "t.tipo_documento,"
                + "t.num_documento,"
                + "t.direccion,"
                + "t.telefono,"
                + "t.email,"
                + "t.sueldo,"
                + "t.rol,"
                + "t.login,"
                + "t.password"
                + "FROM trabajadores t";

        try {
            PreparedStatement st = con.prepareStatement(query);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                t.setTrabajadoresId(rs.getInt("trabajadoresId"));
                t.setNombres(rs.getString("nombres"));
                t.setApellidos(rs.getString("apellidos"));
                t.setTipo_documento(rs.getString("tipo_documento"));
                t.setNum_documento(rs.getString("num_documento"));
                t.setDireccion(rs.getString("direccion"));
                t.setTelefono(rs.getString("telefono"));
                t.setEmail(rs.getString("email"));
                t.setSueldo(rs.getString("sueldo"));
                t.setRol(rs.getString("rol"));
                t.setLogin(rs.getString("login"));
                t.setPassword(rs.getString("password"));

                lista.add(t);
            }

        } catch (Exception e) {
            lista = null;
        }
        return lista;
    }

    //=================INSERTAR DATOS  ====================================================
    public String insertar(Trabajadores trabajador) {

        Conexion conexion = new Conexion();
        Connection con = conexion.getConexion();

        String result = "";

        query = "INSERT INTO trabajadores ("
                + "nombres,"
                + "apellidos,"
                + "tipo_documento,"
                + "num_documento,"
                + "direccion,"
                + "telefono,"
                + "email,"
                + "sueldo,"
                + "rol,"
                + "login,"
                + "password) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, trabajador.getNombres());
            pst.setString(2, trabajador.getApellidos());
            pst.setString(3, trabajador.getTipo_documento());
            pst.setString(4, trabajador.getNum_documento());
            pst.setString(5, trabajador.getDireccion());
            pst.setString(6, trabajador.getTelefono());
            pst.setString(7, trabajador.getEmail());
            pst.setString(8, trabajador.getSueldo());
            pst.setString(9, trabajador.getRol());
            pst.setString(10, trabajador.getLogin());
            pst.setString(11, trabajador.getPassword());

            int n = pst.executeUpdate();

            if (n != 0) {
                result = "Registro Exitoso";
            } else {
                result = "No se inserto Correctamente";
            }
        } catch (Exception e) {
            result = "Fallo la Operacion";
        }
        return result;
    }

    //=======================ACTUALIZAR DATOS===============================================
    public String actualizar(int trabajadorId, Trabajadores datosTrabajador) {

        String result = "";
        query = "UPDATE trabajadores "
                + "SET nombres=?,"
                + "apellidos=?,"
                + "tipo_documento=?,"
                + "num_documento=?,"
                + "direccion=?,"
                + "telefono=?,"
                + "email=?,"
                + "rol=?,"
                + "login=?,"
                + "password=?"
                + "WHERE trabajadoresId=?";

        try {

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1, datosTrabajador.getNombres());
            pst.setString(2, datosTrabajador.getApellidos());
            pst.setString(3, datosTrabajador.getTipo_documento());
            pst.setString(4, datosTrabajador.getNum_documento());
            pst.setString(5, datosTrabajador.getDireccion());
            pst.setString(6, datosTrabajador.getTelefono());
            pst.setString(7, datosTrabajador.getEmail());
            pst.setString(8, datosTrabajador.getRol());
            pst.setString(9, datosTrabajador.getLogin());
            pst.setString(10, datosTrabajador.getPassword());

            int n = pst.executeUpdate();

            if (n > 0) {
                result = "Se Actualizo Correctamente";
            }
        } catch (Exception e) {

            result = "No se actualizo";
        }
        return result;
    }

    //=========================VERIFICA si existe cliente=============================================
    public boolean verificaTrabajador(int num_documento) {

        query = "SELECT * FROM trabajadores WHERE  num_documento=? ";

        int contador = 0;
        boolean result = false;

        try {
            PreparedStatement st = con.prepareStatement(query);

            st.setInt(1, num_documento);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                contador++;
            }

            if (contador > 0) {
                result = true;
            }

        } catch (Exception e) {

        }
        return result;
    }
}
