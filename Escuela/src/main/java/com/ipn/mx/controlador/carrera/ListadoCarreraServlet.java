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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author darkdestiny
 */
@WebServlet(name = "ListadoCarreraServlet", value = "/ListadoCarreraServlet")
public class ListadoCarreraServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
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
            out.println("<h1>Carreras de la Escuela </h1>");
            out.println("</div>");

            out.println("<div class='container'>");
            out.println("<table class='table table-striped'>");
            out.println("<tr>");
            out.println("<th>Ver Carrera</th>");
            out.println("<th>Id Carrera</th>");
            out.println("<th>Nombre Carrera</th>");
            out.println("<th>Descripción Carrera</th>");
            out.println("<th>Eliminar</th>");
            out.println("<th>Actualizar</th>");
            out.println("</tr>");

            CarreraDAO dao = new CarreraDAO(); // Objeto que hace consultas  
            CarreraDTO dto = new CarreraDTO(); // Objeto que accede a los registros expresados en dto 

            try {
                List lista = dao.readAll();
                for (int i = 0; i < lista.size(); i++) {
                    dto = (CarreraDTO) lista.get(i);
                    out.println("<tr>");
                    // La referencia está al mismo nivel de este Servlet 
                    out.println("<td><a href='VerCarreraServlet?id=" + dto.getEntidad().getIdCarrera() + "' class='btn btn-small btn-outline-info'>"
                            + "Ver"
                            + "</a></td>");
                    out.println("<td>" + dto.getEntidad().getIdCarrera()
                            + "</a></td>");
                    out.println("<td>" + dto.getEntidad().getNombreCarrera() + "</td>");
                    out.println("<td>" + dto.getEntidad().getDescripcionCarrera() + "</td>");
                    // ----> ELIMINANDO UN REGISTRO <----
                    // En la línea 78 se está mandando, a través de la URL, el id del elemento que se va a eliminar 
                    out.println("<td> <a href='EliminarCarreraServlet?id=" + dto.getEntidad().getIdCarrera() + "' class='btn btn-small danger'>Eliminar</a></td>");
                    out.println("<td> <a href='ActualizarCarreraServlet2?id=" + dto.getEntidad().getIdCarrera() + "' class='btn btn-small success'>"
                            + "Actualizar"
                            + "</a></td>");
                    out.println("</tr>");
                }

                //out.println(dao.readAll());
                //dao.create(dto);
                //dao.delete(dto);
            } catch (SQLException ex) {
                Logger.getLogger(ListadoCarreraServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("</table>");
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
