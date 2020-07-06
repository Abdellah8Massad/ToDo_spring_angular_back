package com.massad.todo.cucumber;

import io.cucumber.java.ParameterType;

public class ParametreTypeCum {

    @ParameterType("chambreA|ChambreB")
    public Chambre chambre(String nom){
        return new Chambre(nom);
    }
}
