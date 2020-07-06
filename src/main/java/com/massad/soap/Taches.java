//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.06.25 à 11:02:11 AM CEST 
//


package com.massad.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour taches complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="taches">
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
@XmlType(name = "taches", propOrder = {
    "tache"
})
public class Taches {

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
