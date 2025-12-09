
package Modelo.recuperarcontrasena;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para recuperarContrasena complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="recuperarContrasena"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="codigoRecuperacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="estadoSolicitud" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaSolicitud" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idRecuperacion" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "recuperarContrasena", propOrder = {
    "codigoRecuperacion",
    "estadoSolicitud",
    "fechaSolicitud",
    "idRecuperacion",
    "usuario"
})
public class RecuperarContrasena {

    protected String codigoRecuperacion;
    protected String estadoSolicitud;
    protected String fechaSolicitud;
    protected int idRecuperacion;
    protected String usuario;

    /**
     * Obtiene el valor de la propiedad codigoRecuperacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoRecuperacion() {
        return codigoRecuperacion;
    }

    /**
     * Define el valor de la propiedad codigoRecuperacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoRecuperacion(String value) {
        this.codigoRecuperacion = value;
    }

    /**
     * Obtiene el valor de la propiedad estadoSolicitud.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    /**
     * Define el valor de la propiedad estadoSolicitud.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEstadoSolicitud(String value) {
        this.estadoSolicitud = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaSolicitud.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaSolicitud() {
        return fechaSolicitud;
    }

    /**
     * Define el valor de la propiedad fechaSolicitud.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaSolicitud(String value) {
        this.fechaSolicitud = value;
    }

    /**
     * Obtiene el valor de la propiedad idRecuperacion.
     * 
     */
    public int getIdRecuperacion() {
        return idRecuperacion;
    }

    /**
     * Define el valor de la propiedad idRecuperacion.
     * 
     */
    public void setIdRecuperacion(int value) {
        this.idRecuperacion = value;
    }

    /**
     * Obtiene el valor de la propiedad usuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Define el valor de la propiedad usuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

}
