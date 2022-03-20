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
 * @author L450
 */
@WebServlet(name = "ActualizarDatos", urlPatterns = {"/ActualizarDatos"})
public class ActualizarDatos extends HttpServlet {

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

        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");// Esta línea sirve para recibir los datos del FORMULARIO en 
        // caracteres UTF-8 

        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Actualizar Datos</title>");
            out.println("<link href='https://fonts.googleapis.com/icon?family=Material+Icons' rel='stylesheet'>");
            out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css'>");
            out.println("<link href='./css/styles.css' rel='stylesheet'/>");
            out.println("<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.15.4/css/all.css' />");
            out.println("</head>");
            out.println("<body>");

            out.println("<div class='container'>");
            out.println("<h1>Actualizando Datos</h1>");

            /* ----> ACTUALIZANDO DATOS <---- */
            String idToUpdate = request.getParameter("idToUpdate");
            String newCarrera = request.getParameter("txtNombreCarrera2");
            String newDescrip = request.getParameter("txtDescripcionCarrera2");
//            out.println(idToUpdate);
//            out.println(newCarrera);
//            out.println(newDescrip);
            CarreraDAO dao = new CarreraDAO();
            CarreraDTO dto = new CarreraDTO();
            dto.getEntidad().setIdCarrera(Long.parseLong(idToUpdate));
            dto.getEntidad().setDescripcionCarrera(newDescrip);
            dto.getEntidad().setNombreCarrera(newCarrera);
            try {
                dao.update(dto);

                out.println("<div class='alert alert-primary' role='alert'>");
                out.println("<h2> Registro actualizado correctamente </h2>");
                out.println("</div>");
            } catch (SQLException ex) {
                Logger.getLogger(EliminarCarreraServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("<a href='ListadoCarreraServlet' class='btn btn-primary'> Listado de Alumnos </a>");
            out.println("        </div>");
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
