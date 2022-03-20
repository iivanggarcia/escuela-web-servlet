package com.ipn.mx.controlador.carrera;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author deb
 */
@WebServlet(name = "ActualizarAlumnoServlet2", value = "/ActualizarAlumnoServlet2")
public class ActualizarAlumnoServlet2 extends HttpServlet {
   
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
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
            out.println("                <h1>                                                                                               ");
            out.println("                    Nuevos Datos del alumno                                                                    ");
            out.println("                </h1>                                                                                              ");
            out.println("            </header>                                                                                              ");
            out.println("            <main>                                                                                                 ");
            out.println("                <article>                                                                                          ");
            out.println("                    <!-- ESCUELA -->                                                                               ");
            out.println("                    <form method='post' action='/Escuela/ActualizarDatosAlumno' name='frmDatos'>                          ");
            out.println("                        <div class='mb-3'>                                                                         ");
            out.println("                            <label for='txtNombreAlumno2' class='form-label'>Nombre</label> 			");
            out.println("                        <input type='text' name='txtNombreAlumno2' id='txtNombreAlumno2'                           ");
            out.println("                               placeholder='Nuevo nombre'                                            ");
            out.println("                               class='form-control'                                                                ");
            out.println("                               required                                                                            ");
            out.println("                               maxlength='50'/>                                                                    ");
            out.println("                        </div>                                                                                     ");
            out.println("                        <div>                                                                                      ");
            out.println("                            <label for='txtApellidoPat2' class='form-label'>Apellido paterno</label>                     ");
            out.println("                        <input name='txtApellidoPat2' id='txtApellidoPat2'                                    ");
            out.println("                               placeholder='Nueva apellido paterno'                                                     ");
            out.println("                               maxlength='100'                                                                     ");
            out.println("                               required                                                                            ");
            out.println("                               class='form-control'                                                                ");
            out.println("                            />                                                                                     ");
            out.println("                        </div>                                                                                     ");
            out.println("                        <div>                                                                                      ");
            out.println("                            <label for='txtApellidoMat2' class='form-label'>Apellido materno</label>                     ");
            out.println("                        <input name='txtApellidoMat2' id='txtApellidoMat2'                                    ");
            out.println("                               placeholder='Nueva apellido materno'                                                     ");
            out.println("                               maxlength='100'                                                                     ");
            out.println("                               required                                                                            ");
            out.println("                               class='form-control'                                                                ");
            out.println("                            />                                                                                     ");
            out.println("                        </div>                                                                                     ");
            out.println("                        <div>                                                                                      ");
            out.println("                            <label for='txtMail2' class='form-label'>Correo</label>                     ");
            out.println("                        <input name='txtMail2' id='txtMail2'                                    ");
            out.println("                               placeholder='Nueva correo'                                                     ");
            out.println("                               maxlength='100'                                                                     ");
            out.println("                               required                                                                            ");
            out.println("                               class='form-control'                                                                ");
            out.println("                            />                                                                                     ");
            out.println("                        </div>                                                                                     ");
            out.println("                        <div>                                                                                      ");
            out.println("                            <label for='idCarrera2' class='form-label'>Descripción</label>                     ");
            out.println("                        <input name='idCarrera2' id='idCarrera2'                                    ");
            out.println("                               placeholder='Nueva carrera'                                                     ");
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
            out.println("        </div>                                                                                                     ");
            out.println("    </body>                                                                                                        ");

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
