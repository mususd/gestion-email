
package Modelo.tipobandeja;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para listarPorID complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="listarPorID"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idTipoBandeja" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listarPorID", propOrder = {
    "idTipoBandeja"
})
public class ListarPorID {

    protected int idTipoBandeja;

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

}
