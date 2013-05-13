
package ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SumarResponse_QNAME = new QName("http://ws/", "sumarResponse");
    private final static QName _MultiplicarResponse_QNAME = new QName("http://ws/", "multiplicarResponse");
    private final static QName _Sumar_QNAME = new QName("http://ws/", "sumar");
    private final static QName _Multiplicar_QNAME = new QName("http://ws/", "multiplicar");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Multiplicar }
     * 
     */
    public Multiplicar createMultiplicar() {
        return new Multiplicar();
    }

    /**
     * Create an instance of {@link Sumar }
     * 
     */
    public Sumar createSumar() {
        return new Sumar();
    }

    /**
     * Create an instance of {@link MultiplicarResponse }
     * 
     */
    public MultiplicarResponse createMultiplicarResponse() {
        return new MultiplicarResponse();
    }

    /**
     * Create an instance of {@link SumarResponse }
     * 
     */
    public SumarResponse createSumarResponse() {
        return new SumarResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SumarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "sumarResponse")
    public JAXBElement<SumarResponse> createSumarResponse(SumarResponse value) {
        return new JAXBElement<SumarResponse>(_SumarResponse_QNAME, SumarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link MultiplicarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "multiplicarResponse")
    public JAXBElement<MultiplicarResponse> createMultiplicarResponse(MultiplicarResponse value) {
        return new JAXBElement<MultiplicarResponse>(_MultiplicarResponse_QNAME, MultiplicarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Sumar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "sumar")
    public JAXBElement<Sumar> createSumar(Sumar value) {
        return new JAXBElement<Sumar>(_Sumar_QNAME, Sumar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Multiplicar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws/", name = "multiplicar")
    public JAXBElement<Multiplicar> createMultiplicar(Multiplicar value) {
        return new JAXBElement<Multiplicar>(_Multiplicar_QNAME, Multiplicar.class, null, value);
    }

}
