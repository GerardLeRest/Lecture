package com.mycompany.lecture;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Color;

public class FabriqueDessin{
   private int index;
   private JPanel panelDroit;
   private String NomImage;

    public FabriqueDessin(int index, JPanel panelDroit, String NomImage) {
        this.index = index;
        this.panelDroit = panelDroit;
        this.NomImage = NomImage;
    };
      
    public void getDessin(){
         // dessine l'objet sélectionné dans le panel de droite
        System.out.println("index: " + index);
        switch (index) {
            case 0 -> effacerPanelDroit();
            case 1 -> { 
                effacerPanelDroit();
                Dessin cartable = new Cartable(panelDroit);    
                NomImage = cartable.getNomImage();
            }
            case 2 -> { 
                Dessin cartable = new Cartable(panelDroit);
                NomImage = cartable.getNomImage();
                cartable.dessin();
            }
            case 3 -> {
                effacerPanelDroit();
                Dessin livre = new Livre(panelDroit);
                NomImage = livre.getNomImage();
            }
            case 4 -> {
                Dessin livre = new Livre(panelDroit);
                NomImage = livre.getNomImage();
                livre.dessin();
            }
            case 5 -> effacerPanelDroit();
            case 6 ->{
                //crayonnjaune
                System.out.println("case 3");
            }
        }
    }
        
    public String getNomImage(){
        return NomImage;
    }

    public void effacerPanelDroit(){
        Graphics2D graph = (Graphics2D) panelDroit.getGraphics();
        graph.setColor(Color.WHITE);
        graph.fillRect(0, 0, 300, 300); // cadre extérieur
    }
}