----> README <-----

CONTEXT PATH permite acceder a los SERVLETS. 
CONTEXT PATH de cierta forma determina una ruta de acceso a los Servlets, el context path 
asigna un nombre para la carpeta raíz de acceso. 

Para encontrarla se hace lo siguiente. 

1. Ir al icono del proyecto(el que es un mundo) y  dar CLICK DERECHO 
2. Properties>Run>Context Path 


Checar como se utilizó, mirando las WEB PAGES > carrera > nuevo.html > línea 24


NOTA: No copiar y pegar archivos SERVLET solamente, por que puede haber confusiones entre quién se abrirá.
@WebServlet(name = "ActualizarCarreraServlet2", value = "/ActualizarCarreraServlet2") --- >SIEMPRE CAMBIAR ESA RUTA 