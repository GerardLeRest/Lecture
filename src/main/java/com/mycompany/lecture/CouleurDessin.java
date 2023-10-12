package com.mycompany.lecture;

import java.awt.Color;

public class CouleurDessin {
    
    private String couleur;
    private Color couleurTrait;
    
    public CouleurDessin(String couleur){
        this.couleur = couleur;
    }
    
     public Color couleurSelectionnee(){
         System.out.println("couleur: " + couleur);
        switch (couleur){
            case "Rouge" ->   couleurTrait = Color.RED;
            case "Vert" ->   couleurTrait = Color.GREEN;
            case "Bleu" -> couleurTrait = Color.BLUE;
        }
         System.out.println("couleur:" + couleurTrait);
        return couleurTrait;
    }   
}
