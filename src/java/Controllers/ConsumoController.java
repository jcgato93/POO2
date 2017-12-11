/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Consumo;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.JsonObject;
import org.json.simple.parser.JSONParser;





/**
 *
 * @author GATO
 */
@WebServlet(name = "ConsumoController", urlPatterns = {"/ConsumoController"})
public class ConsumoController extends HttpServlet {

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
        
        Consumo consumo=new Consumo();
        try {
        String reservaId=request.getParameter("reservaId");
        consumo.setReservaId(Integer.parseInt(reservaId));  
        String productoId=request.getParameter("productoId");
        consumo.setProductoId(Integer.parseInt(productoId));
        String cantidad=request.getParameter("cantidad");
        consumo.setCantidad(Integer.parseInt(cantidad));
        consumo.setEstado("Pago");
        
        
        String result= consumo.insertar(consumo);
        
        
        
            response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
            response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
            response.getWriter().print(result);       // Write response body.
            
        } catch (Exception e) {
        }

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
        
               response.setContentType("text/html;charset=UTF-8");
        try {
            
            JSONParser parser=new JSONParser();
            String identificacion =request.getParameter("NumDocumento");
            Consumo consumo=new Consumo();
            
            JSONObject json = consumo.getConsumos(identificacion);  
           
                 
         
            response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
            response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
            response.getWriter().print(json);       // Write response body.

             
        } catch (Exception e) {
            e.getMessage();
        }
        
        
        
        
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
