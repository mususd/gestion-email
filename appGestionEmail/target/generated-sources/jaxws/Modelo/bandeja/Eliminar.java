
package Modelo.bandeja;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para eliminar complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="eliminar"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idBandeja" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eliminar", propOrder = {
    "idBandeja"
})
public class Eliminar {

    protected int idBandeja;

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

}
