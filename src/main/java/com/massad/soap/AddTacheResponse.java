package com.massad.soap;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour anonymous complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tache" type="{http://techprimers.com/spring-boot-soap-example}tache"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "tache"
})
@XmlRootElement(name = "addTacheResponse")
public class AddTacheResponse {

    @XmlElement(required = true)
    protected Tache tache;

    /**
     * Obtient la valeur de la propriété tache.
     *
     * @return
     *     possible object is
     *     {@link Tache }
     *
     */
    public Tache getTache() {
        return tache;
    }

    /**
     * Définit la valeur de la propriété tache.
     *
     * @param value
     *     allowed object is
     *     {@link Tache }
     *
     */
    public void setTache(Tache value) {
        this.tache = value;
    }
}
