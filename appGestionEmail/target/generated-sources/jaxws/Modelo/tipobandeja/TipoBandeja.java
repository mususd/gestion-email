
package Modelo.tipobandeja;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoBandeja complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tipoBandeja"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idTipoBandeja" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="nombreTipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoBandeja", propOrder = {
    "idTipoBandeja",
    "nombreTipo"
})
public class TipoBandeja {

    protected int idTipoBandeja;
    protected String nombreTipo;

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
     * Obtiene el valor de la propiedad nombreTipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreTipo() {
        return nombreTipo;
    }

    /**
     * Define el valor de la propiedad nombreTipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreTipo(String value) {
        this.nombreTipo = value;
    }

}
