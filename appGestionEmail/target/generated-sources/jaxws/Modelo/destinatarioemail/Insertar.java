
package Modelo.destinatarioemail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para insertar complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="insertar"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idBandeja" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="usuarioDestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tipoDestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "insertar", propOrder = {
    "idBandeja",
    "usuarioDestinatario",
    "tipoDestinatario"
})
public class Insertar {

    protected int idBandeja;
    protected String usuarioDestinatario;
    protected String tipoDestinatario;

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
     * Obtiene el valor de la propiedad usuarioDestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuarioDestinatario() {
        return usuarioDestinatario;
    }

    /**
     * Define el valor de la propiedad usuarioDestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuarioDestinatario(String value) {
        this.usuarioDestinatario = value;
    }

    /**
     * Obtiene el valor de la propiedad tipoDestinatario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipoDestinatario() {
        return tipoDestinatario;
    }

    /**
     * Define el valor de la propiedad tipoDestinatario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipoDestinatario(String value) {
        this.tipoDestinatario = value;
    }

}
