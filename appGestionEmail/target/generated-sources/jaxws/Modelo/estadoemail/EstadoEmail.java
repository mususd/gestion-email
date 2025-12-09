
package Modelo.estadoemail;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para estadoEmail complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="estadoEmail"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idEstadoEmail" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nombreEstado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "estadoEmail", propOrder = {
    "idEstadoEmail",
    "nombreEstado"
})
public class EstadoEmail {

    protected int idEstadoEmail;
    protected String nombreEstado;

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
     * Obtiene el valor de la propiedad nombreEstado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreEstado() {
        return nombreEstado;
    }

    /**
     * Define el valor de la propiedad nombreEstado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreEstado(String value) {
        this.nombreEstado = value;
    }

}
