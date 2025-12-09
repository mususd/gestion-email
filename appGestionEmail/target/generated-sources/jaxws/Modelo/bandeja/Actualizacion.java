
package Modelo.bandeja;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para actualizacion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="actualizacion"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idBandeja" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="usuarioRemitente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idTipoBandeja" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idEstadoEmail" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="asunto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="mensaje" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fechaEnvio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adjunto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "actualizacion", propOrder = {
    "idBandeja",
    "usuarioRemitente",
    "idTipoBandeja",
    "idEstadoEmail",
    "asunto",
    "mensaje",
    "fechaEnvio",
    "adjunto"
})
public class Actualizacion {

    protected int idBandeja;
    protected String usuarioRemitente;
    protected int idTipoBandeja;
    protected int idEstadoEmail;
    protected String asunto;
    protected String mensaje;
    protected String fechaEnvio;
    protected String adjunto;

    /**
     * Obtiene el valor de la propiedad idBandeja.
     * 
     */
    public int getIdBandeja() {
        return idBandeja;
    }

    /**
     * Define el valor de la propiedad idBandeja.
     * 
     */
    public void setIdBandeja(int value) {
        this.idBandeja = value;
    }

    /**
     * Obtiene el valor de la propiedad usuarioRemitente.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuarioRemitente() {
        return usuarioRemitente;
    }

    /**
     * Define el valor de la propiedad usuarioRemitente.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuarioRemitente(String value) {
        this.usuarioRemitente = value;
    }

    /**
     * Obtiene el valor de la propiedad idTipoBandeja.
     * 
     */
    public int getIdTipoBandeja() {
        return idTipoBandeja;
    }

    /**
     * Define el valor de la propiedad idTipoBandeja.
     * 
     */
    public void setIdTipoBandeja(int value) {
        this.idTipoBandeja = value;
    }

    /**
     * Obtiene el valor de la propiedad idEstadoEmail.
     * 
     */
    public int getIdEstadoEmail() {
        return idEstadoEmail;
    }

    /**
     * Define el valor de la propiedad idEstadoEmail.
     * 
     */
    public void setIdEstadoEmail(int value) {
        this.idEstadoEmail = value;
    }

    /**
     * Obtiene el valor de la propiedad asunto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsunto() {
        return asunto;
    }

    /**
     * Define el valor de la propiedad asunto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsunto(String value) {
        this.asunto = value;
    }

    /**
     * Obtiene el valor de la propiedad mensaje.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Define el valor de la propiedad mensaje.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMensaje(String value) {
        this.mensaje = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaEnvio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaEnvio() {
        return fechaEnvio;
    }

    /**
     * Define el valor de la propiedad fechaEnvio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaEnvio(String value) {
        this.fechaEnvio = value;
    }

    /**
     * Obtiene el valor de la propiedad adjunto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdjunto() {
        return adjunto;
    }

    /**
     * Define el valor de la propiedad adjunto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdjunto(String value) {
        this.adjunto = value;
    }

}
