package servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import datatypes.DtFecha;
import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import excepciones.UsuarioNoExisteException;
import models.GestorWeb;
import tools.Parametrizer;
import models.IUsuarioController;
import models.LaFabricaWS;

@MultipartConfig
@WebServlet ("/signup")
public class Signup extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private IUsuarioController IUC;
    public Signup() {
        super();
        IUC = LaFabricaWS.getInstance().obtenerIUsuarioController();
    }
    protected void processRequest(HttpServletRequest request,  HttpServletResponse response) throws ServletException,  IOException {
    	String r = request.getParameter("miurl");
        try {
        	request.setCharacterEncoding("utf-8");
        	response.setCharacterEncoding("utf-8");
        	byte [] bimgn = null;
        	if (request.getPart("imgPerfil")!=null && request.getPart("imgPerfil").getSize()>0) {
        		Part filePart = request.getPart("imgPerfil");
        		String [] s = Paths.get(filePart.getSubmittedFileName()).getFileName().toString().split("[.]");
        		String ext = s[s.length-1];
        		bimgn = (rp(request, "nickk")+"."+ext).getBytes();
        	}
        	String [] d = rp(request, "nac").split("-");
	        if (rp(request, "tipoU").equals("0")) {
	        	if (IUC.ingresarDatosUsuario(new DtSocio(rp(request, "nickk"), rp(request, "nomm"), rp(request, "ape"), 
	        			rp(request, "emaill"),  rp(request, "pas1"),  new DtFecha(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2]), 0, 0, 0),  bimgn))!=0) {
	        		r=Parametrizer.addParam(r,  "e",  "2");
	        		response.sendRedirect(r);
	        		return;
	        	}
	        }
	        else {
	        	if (IUC.ingresarDatosUsuario(new DtProfesor(rp(request, "nickk"), rp(request, "nomm"), rp(request, "ape"), 
	        			rp(request, "emaill"),  rp(request, "pas1"),  new DtFecha(Integer.parseInt(d[0]), Integer.parseInt(d[1]), Integer.parseInt(d[2]), 0, 0, 0), 
	        			rp(request, "instit"),  rp(request, "descRU"),  rp(request, "bioRU") , rp(request, "websRU"), 
	        			bimgn))!=0) {
	        		r=Parametrizer.addParam(r,  "e",  "2");
	        		response.sendRedirect(r);
	        		return;
	        	}
	        }
	        if (request.getPart("imgPerfil")!=null && request.getPart("imgPerfil").getSize()>0) {
	        	Part filePart = request.getPart("imgPerfil");
        		String [] s = Paths.get(filePart.getSubmittedFileName()).getFileName().toString().split("[.]");
        		String ext = s[s.length-1];
	        	request.setAttribute("type", "usu");
	        	request.setAttribute("id", rp(request, "nickk")+"."+ext);
	        	request.setAttribute("attribute_asset_transfer", filePart);
	        	ContentHandler.postContent(request,response);
	        }
	        r=Parametrizer.remParam(r,  "e", "1");
	        r=Parametrizer.remParam(r,  "e", "2");
	        r=Parametrizer.addParam(r,  "e",  "3");
	        request.getSession().setAttribute("loggedUser", GestorWeb.buscarUsuario(rp(request, "nickk")));
        } catch(Exception e) {
        	e.printStackTrace();
        	r=Parametrizer.addParam(r,  "e",  "2");
        }
        response.sendRedirect(r);
    }
    protected void validator(HttpServletRequest request,  HttpServletResponse response) throws ServletException,  IOException {
    	request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
        String nick = request.getParameter("nick");
        String email = request.getParameter("email");
        PrintWriter stream = response.getWriter();
        if(nick==null || email==null) {
        	stream.println("BAD_FORMAT");
        	return;
        }
        DtUsuario dn,de;
        try {
			 dn = IUC.seleccionarUsuario(nick);
		} catch (UsuarioNoExisteException e) {
			dn = null;
		}
        try {
        	de = IUC.seleccionarUsuarioEmail(email);
		} catch (UsuarioNoExisteException e1) {
			de = null;
		}
        if(dn!=null)
        	stream.println("BAD_NICK");
        if(de!=null)
        	stream.println("BAD_MAIL");
        if(de==null && dn==null)
        	stream.println("OK");
        return;
    } 
	protected void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException,  IOException {
    	request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
        processRequest(request,  response);
	}
	protected void doGet(HttpServletRequest request,  HttpServletResponse response) throws ServletException,  IOException {
		validator(request,response);
	}
	private String rp(HttpServletRequest request, String param) {
		return request.getParameter(param);
	}
}
