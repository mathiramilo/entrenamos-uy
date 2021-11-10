package webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 2.7.9
 * 2021-11-09T11:33:16.485-03:00
 * Generated source version: 2.7.9
 * 
 */
@WebService(targetNamespace = "http://webServices/", name = "WSUsuarioController")
@XmlSeeAlso({ObjectFactory.class, net.java.dev.jaxb.array.ObjectFactory.class})
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface WSUsuarioController {

    @WebMethod
    public void dejarDeSeguir(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        java.lang.String arg1
    ) throws UsuarioNoExisteException_Exception;

    @WebMethod
    @WebResult(name = "return", targetNamespace = "http://webServices/", partName = "return")
    public int ingresarDatosUsuario(
        @WebParam(partName = "arg0", name = "arg0")
        DtUsuarioWS arg0
    ) throws InstitucionException_Exception;

    @WebMethod
    @WebResult(name = "return", targetNamespace = "http://webServices/", partName = "return")
    public DtUsuarioWS seleccionarUsuario(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    ) throws UsuarioNoExisteException_Exception;

    @WebMethod
    @WebResult(name = "return", targetNamespace = "http://webServices/", partName = "return")
    public boolean verificarIdentidadNickname(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        java.lang.String arg1
    );

    @WebMethod
    public void comprarCuponera(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        java.lang.String arg1,
        @WebParam(partName = "arg2", name = "arg2")
        DtFechaWS arg2
    ) throws UsuarioNoExisteException_Exception, CuponeraNoExisteException_Exception;

    @WebMethod
    @WebResult(name = "return", targetNamespace = "http://webServices/", partName = "return")
    public DtSocioWS seleccionarSocio(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    ) throws UsuarioNoExisteException_Exception;

    @WebMethod
    public void valorarProfesor(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        java.lang.String arg1,
        @WebParam(partName = "arg2", name = "arg2")
        java.lang.String arg2,
        @WebParam(partName = "arg3", name = "arg3")
        java.lang.String arg3,
        @WebParam(partName = "arg4", name = "arg4")
        int arg4
    ) throws UsuarioNoExisteException_Exception, ClaseException_Exception, InstitucionException_Exception;

    @WebMethod
    public void favoritearActividad(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        java.lang.String arg1,
        @WebParam(partName = "arg2", name = "arg2")
        java.lang.String arg2
    ) throws UsuarioNoExisteException_Exception, InstitucionException_Exception;

    @WebMethod
    @WebResult(name = "return", targetNamespace = "http://webServices/", partName = "return")
    public DtCapsula obtenerUsuarios();

    @WebMethod
    @WebResult(name = "return", targetNamespace = "http://webServices/", partName = "return")
    public DtProfesorWS seleccionarProfesor(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    ) throws UsuarioNoExisteException_Exception;

    @WebMethod
    @WebResult(name = "return", targetNamespace = "http://webServices/", partName = "return")
    public java.lang.String ping();

    @WebMethod
    @WebResult(name = "return", targetNamespace = "http://webServices/", partName = "return")
    public boolean verificarIdentidadEmail(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        java.lang.String arg1
    );

    @WebMethod
    @WebResult(name = "return", targetNamespace = "http://webServices/", partName = "return")
    public DtUsuarioWS seleccionarUsuarioEmail(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0
    ) throws UsuarioNoExisteException_Exception;

    @WebMethod
    @WebResult(name = "return", targetNamespace = "http://webServices/", partName = "return")
    public DtCapsula obtenerInstituciones();

    @WebMethod
    public void seguir(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        java.lang.String arg1
    ) throws UsuarioNoExisteException_Exception;

    @WebMethod
    public void editarDatosBasicos(
        @WebParam(partName = "arg0", name = "arg0")
        java.lang.String arg0,
        @WebParam(partName = "arg1", name = "arg1")
        DtUsuarioWS arg1
    ) throws UsuarioNoExisteException_Exception;
}