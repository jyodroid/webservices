
package ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-2b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "wsCalc1", targetNamespace = "http://ws/", wsdlLocation = "http://localhost:8080/WsCalc1Server/wsCalc1?wsdl")
public class WsCalc1_Service
    extends Service
{

    private final static URL WSCALC1_WSDL_LOCATION;
    private final static WebServiceException WSCALC1_EXCEPTION;
    private final static QName WSCALC1_QNAME = new QName("http://ws/", "wsCalc1");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/WsCalc1Server/wsCalc1?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WSCALC1_WSDL_LOCATION = url;
        WSCALC1_EXCEPTION = e;
    }

    public WsCalc1_Service() {
        super(__getWsdlLocation(), WSCALC1_QNAME);
    }

    public WsCalc1_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), WSCALC1_QNAME, features);
    }

    public WsCalc1_Service(URL wsdlLocation) {
        super(wsdlLocation, WSCALC1_QNAME);
    }

    public WsCalc1_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WSCALC1_QNAME, features);
    }

    public WsCalc1_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WsCalc1_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WsCalc1
     */
    @WebEndpoint(name = "wsCalc1Port")
    public WsCalc1 getWsCalc1Port() {
        return super.getPort(new QName("http://ws/", "wsCalc1Port"), WsCalc1.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WsCalc1
     */
    @WebEndpoint(name = "wsCalc1Port")
    public WsCalc1 getWsCalc1Port(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws/", "wsCalc1Port"), WsCalc1.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WSCALC1_EXCEPTION!= null) {
            throw WSCALC1_EXCEPTION;
        }
        return WSCALC1_WSDL_LOCATION;
    }

}
