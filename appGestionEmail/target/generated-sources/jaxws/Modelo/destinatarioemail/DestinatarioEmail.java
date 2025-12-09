
package Modelo.destinatarioemail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para destinatarioEmail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="destinatarioEmail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idBandeja" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="idDestinatario" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="tipoDestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="usuarioDestinatario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "destinatarioEmail", propOrder = {
    "idBandeja",
    "idDestinatario",
    "tipoDestinatario",
    "usuarioDestinatario"
})
public class DestinatarioEmail {

    protected int idBandeja;
    protected int idDestinatario;
    protected String tipoDestinatario;
    protected String usuarioDestinatario;

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
     * Obtiene el valor de la propiedad idDestinatario.
     * 
     */
    public int getIdDestinatario() {
        return idDestinatario;
    }

    /**
     * Define el valor de la propiedad idDestinatario.
     * 
     */
    public void setIdDestinatario(int value) {
        this.idDestinatario = value;
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

}
