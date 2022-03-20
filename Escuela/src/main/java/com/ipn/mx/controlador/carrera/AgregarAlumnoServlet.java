package com.ipn.mx.controlador.carrera;

import com.ipn.mx.modelo.dao.Alumno;
import com.ipn.mx.modelo.dto.AlumnoDTO;
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
 * @author deb
 */
@WebServlet(name = "AgregarAlumnoServlet", value = "/AgregarAlumnoServlet")
public class AgregarAlumnoServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            /* ---> IMPRIMIENDO EL HTML <--- */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Agregar Carrera</title>");
            
            // Agregando librerías de BOOTSTRAP
            out.println("<link href='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css' rel='stylesheet'>");
            out.println("<script src='https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js' ></script>");

            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            
            
            //Da el ContextPath o Carpeta Raíz de Acceso a los servlets 
            out.println("<h1> Insertando registro ...</h1>");

            AlumnoDTO dto = new AlumnoDTO();
            dto.getEntidad().setNombreAlumno(request.getParameter("txtNombreAlumno")); // Fijando un nombre de la carrera en la entidad  
            dto.getEntidad().setPaternoAlumno(request.getParameter("txtApellidoPat"));  //Fijando una descripción en la entidad 
            dto.getEntidad().setMaternoAlumno(request.getParameter("txtApellidoMat"));  //Fijando una descripción en la entidad 
            dto.getEntidad().setEmailAlumno(request.getParameter("txtMail"));  //Fijando una descripción en la entidad 
            dto.getEntidad().setIdCarrera(Integer.parseInt(request.getParameter("idCarrera")));  //Fijando una descripción en la entidad 
            Alumno dao = new Alumno();  //Creando el objeto para acceder a las consultas
            try {
                dao.create(dto);    //Inserta datos a la BD
                   out.println("<div class='alert alert-primary' role='alert'>");
                   out.println("<h2> Registro insertado satisfactoriamente </h2>");
                   out.println("</div>");
                  
            } catch (SQLException ex) {
                Logger.getLogger(AgregarCarreraServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

           out.println("<a href='ListadoAlumnoServlet' class='btn btn-primary'> Listado de alumnos </a>");
            
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
