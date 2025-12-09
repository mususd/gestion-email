
package Modelo.estadoemail;

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
 *         &lt;element name="idEstadoEmail" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
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
    "idEstadoEmail"
})
public class Eliminar {

    protected int idEstadoEmail;

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

}
