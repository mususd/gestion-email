
package Modelo.recuperarcontrasena;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the Modelo.recuperarcontrasena package. 
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

    private final static QName _Actualizacion_QNAME = new QName("http://wsServicios/", "actualizacion");
    private final static QName _ActualizacionResponse_QNAME = new QName("http://wsServicios/", "actualizacionResponse");
    private final static QName _Eliminar_QNAME = new QName("http://wsServicios/", "eliminar");
    private final static QName _EliminarResponse_QNAME = new QName("http://wsServicios/", "eliminarResponse");
    private final static QName _Insertar_QNAME = new QName("http://wsServicios/", "insertar");
    private final static QName _InsertarResponse_QNAME = new QName("http://wsServicios/", "insertarResponse");
    private final static QName _Listar_QNAME = new QName("http://wsServicios/", "listar");
    private final static QName _ListarPorID_QNAME = new QName("http://wsServicios/", "listarPorID");
    private final static QName _ListarPorIDResponse_QNAME = new QName("http://wsServicios/", "listarPorIDResponse");
    private final static QName _ListarResponse_QNAME = new QName("http://wsServicios/", "listarResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: Modelo.recuperarcontrasena
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Actualizacion }
     * 
     */
    public Actualizacion createActualizacion() {
        return new Actualizacion();
    }

    /**
     * Create an instance of {@link ActualizacionResponse }
     * 
     */
    public ActualizacionResponse createActualizacionResponse() {
        return new ActualizacionResponse();
    }

    /**
     * Create an instance of {@link Eliminar }
     * 
     */
    public Eliminar createEliminar() {
        return new Eliminar();
    }

    /**
     * Create an instance of {@link EliminarResponse }
     * 
     */
    public EliminarResponse createEliminarResponse() {
        return new EliminarResponse();
    }

    /**
     * Create an instance of {@link Insertar }
     * 
     */
    public Insertar createInsertar() {
        return new Insertar();
    }

    /**
     * Create an instance of {@link InsertarResponse }
     * 
     */
    public InsertarResponse createInsertarResponse() {
        return new InsertarResponse();
    }

    /**
     * Create an instance of {@link Listar }
     * 
     */
    public Listar createListar() {
        return new Listar();
    }

    /**
     * Create an instance of {@link ListarPorID }
     * 
     */
    public ListarPorID createListarPorID() {
        return new ListarPorID();
    }

    /**
     * Create an instance of {@link ListarPorIDResponse }
     * 
     */
    public ListarPorIDResponse createListarPorIDResponse() {
        return new ListarPorIDResponse();
    }

    /**
     * Create an instance of {@link ListarResponse }
     * 
     */
    public ListarResponse createListarResponse() {
        return new ListarResponse();
    }

    /**
     * Create an instance of {@link RecuperarContrasena }
     * 
     */
    public RecuperarContrasena createRecuperarContrasena() {
        return new RecuperarContrasena();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Actualizacion }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Actualizacion }{@code >}
     */
    @XmlElementDecl(namespace = "http://wsServicios/", name = "actualizacion")
    public JAXBElement<Actualizacion> createActualizacion(Actualizacion value) {
        return new JAXBElement<Actualizacion>(_Actualizacion_QNAME, Actualizacion.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ActualizacionResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ActualizacionResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://wsServicios/", name = "actualizacionResponse")
    public JAXBElement<ActualizacionResponse> createActualizacionResponse(ActualizacionResponse value) {
        return new JAXBElement<ActualizacionResponse>(_ActualizacionResponse_QNAME, ActualizacionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Eliminar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Eliminar }{@code >}
     */
    @XmlElementDecl(namespace = "http://wsServicios/", name = "eliminar")
    public JAXBElement<Eliminar> createEliminar(Eliminar value) {
        return new JAXBElement<Eliminar>(_Eliminar_QNAME, Eliminar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EliminarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link EliminarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://wsServicios/", name = "eliminarResponse")
    public JAXBElement<EliminarResponse> createEliminarResponse(EliminarResponse value) {
        return new JAXBElement<EliminarResponse>(_EliminarResponse_QNAME, EliminarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Insertar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Insertar }{@code >}
     */
    @XmlElementDecl(namespace = "http://wsServicios/", name = "insertar")
    public JAXBElement<Insertar> createInsertar(Insertar value) {
        return new JAXBElement<Insertar>(_Insertar_QNAME, Insertar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InsertarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link InsertarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://wsServicios/", name = "insertarResponse")
    public JAXBElement<InsertarResponse> createInsertarResponse(InsertarResponse value) {
        return new JAXBElement<InsertarResponse>(_InsertarResponse_QNAME, InsertarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Listar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Listar }{@code >}
     */
    @XmlElementDecl(namespace = "http://wsServicios/", name = "listar")
    public JAXBElement<Listar> createListar(Listar value) {
        return new JAXBElement<Listar>(_Listar_QNAME, Listar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarPorID }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarPorID }{@code >}
     */
    @XmlElementDecl(namespace = "http://wsServicios/", name = "listarPorID")
    public JAXBElement<ListarPorID> createListarPorID(ListarPorID value) {
        return new JAXBElement<ListarPorID>(_ListarPorID_QNAME, ListarPorID.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarPorIDResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarPorIDResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://wsServicios/", name = "listarPorIDResponse")
    public JAXBElement<ListarPorIDResponse> createListarPorIDResponse(ListarPorIDResponse value) {
        return new JAXBElement<ListarPorIDResponse>(_ListarPorIDResponse_QNAME, ListarPorIDResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ListarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://wsServicios/", name = "listarResponse")
    public JAXBElement<ListarResponse> createListarResponse(ListarResponse value) {
        return new JAXBElement<ListarResponse>(_ListarResponse_QNAME, ListarResponse.class, null, value);
    }

}
