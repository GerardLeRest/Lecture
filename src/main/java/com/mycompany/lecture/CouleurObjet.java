package com.mycompany.lecture;

import java.awt.Color;

public class CouleurObjet {
    
    private String couleur;
    private Color couleurTrait;
    
    public CouleurObjet(String couleur){
        this.couleur = couleur;
    }
    
     public Color couleurSelectionnee(){
         System.out.println("couleur: " + couleur);
        switch (couleur){
            case "Noir" ->   couleurTrait = Color.BLACK;
            case "Bleu" ->   couleurTrait = Color.BLUE;
            case "Vert" ->   couleurTrait = Color.GREEN;
            case "Orange" -> couleurTrait = Color.ORANGE;
        }
         System.out.println("couleur:" + couleurTrait);
        return couleurTrait;
    }   
}