//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.7 
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.06.25 à 11:02:11 AM CEST 
//


package com.massad.soap;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.techprimers.spring_boot_soap_example package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.techprimers.spring_boot_soap_example
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetTacheResponse }
     * 
     */
    public GetTacheResponse createGetTacheResponse() {
        return new GetTacheResponse();
    }

    /**
     * Create an instance of {@link AddTacheResponse }
     *
     */
    public AddTacheResponse createAddTacheResponse() {
        return new AddTacheResponse();
    }

    /**
     * Create an instance of {@link AddTacheRequest }
     *
     */
    public AddTacheRequest createAddTacheRequest() {
        return new AddTacheRequest();
    }

    /**
     * Create an instance of {@link Tache }
     * 
     */
    public Tache createTache() {
        return new Tache();
    }

    /**
     * Create an instance of {@link GetTacheRequest }
     * 
     */
    public GetTacheRequest createGetTacheRequest() {
        return new GetTacheRequest();
    }

    /**
     * Create an instance of {@link Taches }
     * 
     */
    public Taches createTaches() {
        return new Taches();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

}
