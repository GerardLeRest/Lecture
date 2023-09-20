package com.mycompany.lecture;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Color;

public class FabriqueDessin{
   private int index;
   private JPanel panelCentre;
   private String NomImage;

    public FabriqueDessin(int index, JPanel panelCentre, String NomImage) {
        this.index = index;
        this.panelCentre = panelCentre;
        this.NomImage = NomImage;
    };
      
    public void getDessin(){
         // dessine l'objet sélectionné dans le panel de droite
        System.out.println("index: " + index);
        switch (index) {
            case 0 -> effacerPanelDroit();
            case 1 -> { 
                effacerPanelDroit();
                Dessin cartable = new Cartable(panelCentre);    
                NomImage = cartable.getNomImage();
            }
            case 2 -> { 
                Dessin cartable = new Cartable(panelCentre);
                NomImage = cartable.getNomImage();
                cartable.dessin();
            }
            case 3 -> {
                effacerPanelDroit();
                Dessin livre = new Livre(panelCentre);
                NomImage = livre.getNomImage();
            }
            case 4 -> {
                Dessin livre = new Livre(panelCentre);
                NomImage = livre.getNomImage();
                livre.dessin();
            }
            case 5 -> {
                effacerPanelDroit();
                Dessin crayon = new Crayon(panelCentre);
                NomImage = crayon.getNomImage();
            }
            case 6 ->{
                Dessin crayon = new Crayon(panelCentre);
                NomImage = crayon.getNomImage();
                crayon.dessin();
            }
        }
    }
        
    public String getNomImage(){
        return NomImage;
    }

    public void effacerPanelDroit(){
        Graphics2D graph = (Graphics2D) panelCentre.getGraphics();
        graph.setColor(Color.WHITE);
        graph.fillRect(0, 0, 300, 300); // cadre extérieur
    }
}