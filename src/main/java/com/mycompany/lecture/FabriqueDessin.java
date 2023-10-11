package com.mycompany.lecture;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Color;

public class FabriqueDessin{
   private int index;
   private JPanel panelCentre;
   private String NomImage;
   private String couleur;
   private Graphics2D graph;

    public FabriqueDessin(int index, JPanel panelCentre, String couleur) {
        this.index = index;
        this.panelCentre = panelCentre;
        this.couleur = couleur;
        System.out.println(panelCentre);
    }
      
    public void getDessin(){
         // dessine l'objet sélectionné dans le panel haut
        switch (index) {
            case 0 -> effacerPanelDroit();
            case 1 -> { 
                effacerPanelDroit();
                Dessin cartable = new Cartable( couleur, panelCentre);    
                NomImage = cartable.getNomImage();
            }
            case 2 -> { 
                Dessin cartable = new Cartable(couleur, panelCentre);
                NomImage = cartable.getNomImage();
                cartable.dessin();
            }
            case 3 -> {
                effacerPanelDroit();
                Dessin livre = new Livre(couleur, panelCentre);
                NomImage = livre.getNomImage();
            }
            case 4 -> {
                System.out.println("Fabrique.java");
                Dessin livre = new Livre(couleur, panelCentre);
                NomImage = livre.getNomImage();
                livre.dessin();
            }
            case 5 -> {
                effacerPanelDroit();
                Dessin crayon = new Crayon(couleur, panelCentre);
                NomImage = crayon.getNomImage();
            }
            case 6 ->{
                Dessin crayon = new Crayon(couleur, panelCentre);
                NomImage = crayon.getNomImage();
                crayon.dessin();
            }
        }
    }
 
    public void effacerPanelDroit(){
        Graphics2D graph = (Graphics2D) panelCentre.getGraphics();
        graph.setColor(Color.WHITE);
        graph.fillRect(10, 0, 300, 290); // cadre extérieur
    }
    
    public String getNomImage(){
        return NomImage;
    }
}