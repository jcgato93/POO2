/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Clientes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GATO
 */
@WebServlet(name = "Clientes", urlPatterns = {"/Clientes"})
public class ClientesController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    
          String operacion=request.getParameter("btnSubmit");
        
        switch(operacion)
        {
            case "Registrar":
                Clientes cliente=new Clientes();
                
                cliente.setApellidos(request.getParameter("txtApellidos"));
                cliente.setNombres(request.getParameter("txtNombres"));
                cliente.setTipo_documento(request.getParameter("ddlTipoDocumento"));
                cliente.setNum_documento(request.getParameter("txtNumDocumento"));
                cliente.setDireccion(request.getParameter("txtDireccion"));
                cliente.setTelefono(request.getParameter("txtTelefono"));
                try {
                    cliente.setEmail(request.getParameter("txtEmail"));
                } catch (Exception e) {
                    cliente.setEmail("");
                }
                
                String result= cliente.insertar(cliente);
                
                // para crear variables que se envian por el response
                request.setAttribute("mensaje",result);
                //para redicionar y enviar las variables
                request.getRequestDispatcher("RegistrarCliente.jsp").forward(request, response);
                
                break;
                
            case "Editar":
                break;
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
