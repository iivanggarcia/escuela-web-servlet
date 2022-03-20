/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.ipn.mx.controlador.carrera;

import com.ipn.mx.modelo.dao.CarreraDAO;
import com.ipn.mx.modelo.dto.CarreraDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author darkdestiny
 */
@WebServlet(name = "VerCarreraServlet", value = "/VerCarreraServlet")
public class VerCarreraServlet extends HttpServlet {

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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Lista de Carreras</title>");
            out.println("<link href='https://fonts.googleapis.com/icon?family=Material+Icons' rel='stylesheet'>");
            out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css'>");
            out.println("<link href='./css/styles.css' rel='stylesheet'/>");
            out.println("<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.15.4/css/all.css' />");

            out.println("</head>");
            out.println("<body>");

            out.println("<nav class='white' role='navigation'>");
            out.println("<div class='nav-wrapper container'>");
            out.println("    <a id='logo-container' href='index.html' class='brand-logo'>Escuela Web</a>");
            out.println("    <ul class='right hide-on-med-and-down'>");
            out.println("        <li><a href='index.html'>Home</a></li>");
            out.println("        <li><a href='./carrera/nuevaCarrera.html'>Agregar Carrera</a></li>");
            out.println("        <li><a href='./alumno/nuevoAlumno.html'>Agregar Alumno</a></li>");
            out.println("        <li><a href='ListadoCarreraServlet'>Lista de Carreras</a></li>");
            out.println("        <li><a href='ListadoAlumnoServlet'>Lista de Alumnos</a></li>");
            out.println("    </ul>");

            out.println("    <ul id='nav-mobile' class='sidenav'>");
            out.println("        <li><a href='index.html'>Home</a></li>");
            out.println("        <li><a href='./carrera/nuevaCarrera.html'>Agregar Carrera</a></li>");
            out.println("        <li><a href='./alumno/nuevoAlumno.html'>Agregar Alumno</a></li>");
            out.println("        <li><a href='ListadoCarreraServlet'>Lista de Carreras</a></li>");
            out.println("        <li><a href='ListadoAlumnoServlet'>Lista de Alumnos</a></li>");
            out.println("    </ul>");
            out.println("    <a href='#' data-target='nav-mobile' class='sidenav-trigger'><i class='material-icons'>menu</i></a>");
            out.println("</div>");
            out.println("</nav>");
            
            out.println("<div class='container'>");
            out.println("<h1>Datos de la Carrera</h1>");

            // Recibiendo el ID para mostrar el registro correspondiente 
            String idVerCarrera = request.getParameter("id");
            CarreraDTO dto = new CarreraDTO();
            CarreraDTO dtoToShow = new CarreraDTO();    //Guardará el registro que encuentre dada la CONSULTA SQL en la línea 56 
            dto.getEntidad().setIdCarrera(Long.parseLong(idVerCarrera));
            CarreraDAO dao = new CarreraDAO();
            try {
                dtoToShow = dao.read(dto);  //

                out.println("<br> <h4>Id: " + dtoToShow.getEntidad().getIdCarrera() + "</h4>  <hr />");
                out.println("<h4>Carrera: " + dtoToShow.getEntidad().getNombreCarrera() + "</h4> <hr />");
                out.println("<h4>Descripción: " + dtoToShow.getEntidad().getDescripcionCarrera() + "</h4> <br>");

            } catch (SQLException ex) {
                Logger.getLogger(VerCarreraServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("<br> <a href='ListadoCarreraServlet' class='btn btn-primary'> Ver Listado de Carreras </a>");
            out.println("</div>");
            out.println("<script src='https://code.jquery.com/jquery-2.1.1.min.js'></script>");
            out.println("<script src='js/materialize.js'></script>");
            out.println("<script src='js/init.js'></script>");
            out.println("</body>");
            out.println("</html>");
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
