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
@WebServlet(name = "ActualizarDatosAlumno", value = "/ActualizarDatosAlumno")
public class ActualizarDatosAlumno extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Actualizar Datos Alumno</title>");
            out.println("<link href='https://fonts.googleapis.com/icon?family=Material+Icons' rel='stylesheet'>");
            out.println("<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css'>");
            out.println("<link href='./css/styles.css' rel='stylesheet'/>");
            out.println("<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.15.4/css/all.css' />");
            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>																																													");
            out.println("            <nav class='navbar navbar-expand-lg navbar-light bg-light'>																																	");
            out.println("                <div class='container-fluid'>                                                                                                                                                              ");
            out.println("                    <a class='navbar-brand' href='./'>Escuela</a>                                                                                                                                           ");
            out.println("                    <button class='navbar-toggler' type='button' data-bs-toggle='collapse' data-bs-target='#navbarNav' aria-controls='navbarNav' aria-expanded='false' aria-label='Toggle navigation'>     ");
            out.println("                        <span class='navbar-toggler-icon'></span>                                                                                                                                          ");
            out.println("                    </button>                                                                                                                                                                              ");
            out.println("                    <div class='collapse navbar-collapse' id='navbarNav'>                                                                                                                                  ");
            out.println("                        <ul class='navbar-nav'>                                                                                                                                                            ");
            out.println("                            <li class='nav-item'>                                                                                                                                                          ");
            out.println("                                <a class='nav-link' href='./carrera/nuevo.html'>Agregar Carrera</a>                                                                                                        ");
            out.println("                                <!-- <a class='nav-link' href='./CarreraServlet'>Carrera</a>-->                                                                                                            ");
            out.println("                            </li>                                                                                                                                                                          ");
            out.println("                            <li class='nav-item'>                                                                                                                                                          ");
            out.println("                                <a class='nav-link' href='ListadoServlet'>Listado de Carreras</a>                                                                                                          ");
            out.println("                            </li>                                                                                                                                                                          ");
            out.println("                        </ul>                                                                                                                                                                              ");
            out.println("                    </div>                                                                                                                                                                                 ");
            out.println("                </div>                                                                                                                                                                                     ");
            out.println("            </nav>                                                                                                                                                                                         ");
            out.println("</div>");

            out.println("<div class='container'>");
            out.println("<h1>Actualizando Datos</h1>");

            /* ----> ACTUALIZANDO DATOS <---- */
            String idToUpdate = request.getParameter("idToUpdate");
            String newNombre = request.getParameter("txtNombreAlumno2");
            String newApPat = request.getParameter("txtApellidoPat2");
            String newApMat = request.getParameter("txtApellidoMat2");
            String newMail = request.getParameter("txtMail2");
            String newIdCarrera = request.getParameter("idCarrera2");
//            out.println(idToUpdate);
//            out.println(newCarrera);
//            out.println(newDescrip);
            Alumno dao = new Alumno();
            AlumnoDTO dto = new AlumnoDTO();
            dto.getEntidad().setIdAlumno(Long.parseLong(idToUpdate));
            dto.getEntidad().setNombreAlumno(newNombre);
            dto.getEntidad().setPaternoAlumno(newApPat);
            dto.getEntidad().setPaternoAlumno(newApMat);
            dto.getEntidad().setPaternoAlumno(newMail);
            dto.getEntidad().setPaternoAlumno(newIdCarrera);
            
            try {
                dao.update(dto);

                out.println("<div class='alert alert-primary' role='alert'>");
                out.println("<h2> Registro alumno actualizado correctamente </h2>");
                out.println("</div>");
            } catch (SQLException ex) {
                Logger.getLogger(EliminarCarreraServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("<a href='ListadoAlumnoServlet' class='btn btn-primary'> Listado de Carreras </a>");
            out.println("        </div>");
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
