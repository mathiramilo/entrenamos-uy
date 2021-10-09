package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtActividadDeportivaExt;
import datatypes.DtProfesorExt;
import datatypes.DtUsuarioExt;
import logica.IActividadDeportivaController;
import logica.LaFabrica;
import models.GestorWeb;

// Servlet login. Obedece el protoclo inicio sesión.
// Si la combinación tiene exito. El servlet establece como atributo de sesión al usuario.
@WebServlet ("/usuarios")
public class PerfilUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IActividadDeportivaController IADC;
    public PerfilUsuario() {
        super();
        IADC = LaFabrica.getInstance().obtenerIActDeportivaController();
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
        	//DtUsuarioExt usrLogged = GestorWeb.getInstance().buscarUsuario((String) request.getSession().getAttribute("user"));
        	DtUsuarioExt usr = GestorWeb.getInstance().buscarUsuario((String) request.getParameter("nickname"));
        	request.setAttribute("datoUsuario", usr);
        	//request.setAttribute("datoUsuarioLogged", usrLogged);
        	
        	List<DtActividadDeportivaExt> actIngresadasProfesor = new ArrayList<>();
        	if(usr instanceof DtProfesorExt) {
        		Set<String> actividades = ((DtProfesorExt)usr).getActividadesIngresadas();
        		for (String x : actividades) {
        			actIngresadasProfesor.add(IADC.getActDepExt(((DtProfesorExt)usr).getNombreInstitucion(), x));
        		}
        	}
        	request.setAttribute("actividadesIngresadas", actIngresadasProfesor);
        } catch(Exception e) {
        	e.printStackTrace();
        	response.sendRedirect(request.getContextPath() + "/pages/404.jsp");
        }
        request.getRequestDispatcher("pages/usuarios.jsp").forward(request, response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
	}
}