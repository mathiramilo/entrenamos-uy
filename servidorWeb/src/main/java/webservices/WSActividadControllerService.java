package webservices;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;

import servlets.ConfigListener;

import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.7.9
 * 2021-11-09T16:09:53.086-03:00
 * Generated source version: 2.7.9
 * 
 */
@WebServiceClient(name = "WSActividadControllerService", 
                  targetNamespace = "http://webServices/") 
public class WSActividadControllerService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://webServices/", "WSActividadControllerService");
    public final static QName WSActividadControllerPort = new QName("http://webServices/", "WSActividadControllerPort");
    static {
        URL url = null;
        try {
            url = new URL(ConfigListener.cfg.getProperty("actividadControllerURL"));
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(WSActividadControllerService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", ConfigListener.cfg.getProperty("actividadControllerURL"));
        }
        WSDL_LOCATION = url;
    }

    public WSActividadControllerService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public WSActividadControllerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WSActividadControllerService() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WSActividadControllerService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WSActividadControllerService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    //This constructor requires JAX-WS API 2.2. You will need to endorse the 2.2
    //API jar or re-run wsdl2java with "-frontend jaxws21" to generate JAX-WS 2.1
    //compliant code instead.
    public WSActividadControllerService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     *
     * @return
     *     returns WSActividadController
     */
    @WebEndpoint(name = "WSActividadControllerPort")
    public WSActividadController getWSActividadControllerPort() {
        return super.getPort(WSActividadControllerPort, WSActividadController.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WSActividadController
     */
    @WebEndpoint(name = "WSActividadControllerPort")
    public WSActividadController getWSActividadControllerPort(WebServiceFeature... features) {
        return super.getPort(WSActividadControllerPort, WSActividadController.class, features);
    }

}
