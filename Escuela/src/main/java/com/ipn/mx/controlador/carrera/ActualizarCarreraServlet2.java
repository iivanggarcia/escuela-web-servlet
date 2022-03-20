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
@WebServlet(name = "ActualizarCarreraServlet2", value = "/ActualizarCarreraServlet2")
public class ActualizarCarreraServlet2 extends HttpServlet {

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
//        request.setCharacterEncoding("UTF-8");  // Esta línea sirve para recibir los datos del FORMULARIO en 
        // caracteres UTF-8

        try (PrintWriter out = response.getWriter()) {

            // ---> RECUPERANDO EL id del registro que se va a eliminar <-----
            String idToUpdate = request.getParameter("id");

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
            out.println("<h1><center>Nuevos Datos de la Carrera</center></h1>                                                                                              ");
            out.println("            </header>                                                                                              ");
            out.println("            <main>                                                                                                 ");
            out.println("                <article class='container'>                                                                                          ");
            out.println("                    <!-- ESCUELA -->                                                                               ");
            out.println("                    <form method='post' action='/Escuela/ActualizarDatos' name='frmDatos'>                          ");
            out.println("                        <div class='mb-3'>                                                                         ");
            out.println("                            <label for='txtNombreCarrera2' class='form-label'><h4>Nombre de Carrera</h4></label> 			");
            out.println("                        <input type='text' name='txtNombreCarrera2' id='txtNombreCarrera2'                           ");
            out.println("                               placeholder='Nuevo nombre de la carrera'                                            ");
            out.println("                               class='form-control'                                                                ");
            out.println("                               required                                                                            ");
            out.println("                               maxlength='50'/>                                                                    ");
            out.println("                        </div>                                                                                     ");
            out.println("                        <div>                                                                                      ");
            out.println("                            <label for='txtDescripcion2' class='form-label'><h4>Descripción</h4></label>                     ");
            out.println("                        <input name='txtDescripcionCarrera2' id='txtDescripcion2'                                    ");
            out.println("                               placeholder='Nueva descripción'                                                     ");
            out.println("                               maxlength='100'                                                                     ");
            out.println("                               required                                                                            ");
            out.println("                               class='form-control'                                                                ");
            out.println("                            />                                                                                     ");
            out.println("                        </div>                                                                                     ");
            out.println("                        <div class='mb-3'></div>                                                                   ");

            out.println("                        <input type='submit' name='cmdEnviar' value='Enviar' class='btn btn-outline-primary'/>     ");
            out.println("<input id='idToUpdate' name='idToUpdate' type='hidden' value='" + idToUpdate + "'>");
            out.println("                    </form>                                                                                        ");
            out.println("                </article>                                                                                         ");
            out.println("            </main>                                                                                                ");
            out.println("            <footer>                                                                                               ");

            out.println("            </footer>                                                                                              ");
            out.println("    </body>                                                                                                        ");

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
