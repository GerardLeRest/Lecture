package com.mycompany.lecture;

import java.awt.Color;

public class CouleurDessin {
    
    private String couleur;
    private Color couleurTrait;
    
    public CouleurDessin(String couleur){
        this.couleur = couleur;
    }
    
     public Color couleurSelectionnee(){
        switch (couleur){
            case "Rouge" ->   couleurTrait = Color.RED;
            case "Orange" ->   couleurTrait = Color.ORANGE;
            case "Bleu" -> couleurTrait = Color.BLUE;
        }
        return couleurTrait;
    }   
}
