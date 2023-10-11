package com.mycompany.lecture;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Livre implements Dessin {
    
    private final String nomDeLImage ="LIVRE";
    private String couleur;
    private Graphics2D graph;
    private JPanel panelCentre;
    
    
    public Livre (String couleur, JPanel panelCentre){
         this.couleur = couleur;
         this.panelCentre = panelCentre;
         System.out.println("Livre.java");
    }
             
    @Override
    public String getNomImage() {
        return nomDeLImage;
    }
    
    @Override
    public void dessin() {
        Graphics2D graph = (Graphics2D) panelCentre.getGraphics();
        graph.setStroke(new BasicStroke(4)); // epaisseur du trait en pixels
        CouleurObjet couleurobjet = new CouleurObjet(couleur);
        graph.setColor(couleurobjet.couleurSelectionnee());
        graph.drawRect(20, 20, 280, 160); // cadre extérieur
        graph.drawLine(150,20,150,180); // dessin de la ligne du milieu
        // dessin des trois lignes de gauche
        for (int i=0; i<3;i++){
            graph.drawLine(30,60+40*i,130,60+40*i);
        }
        // dessin des trois lignes de droite
        for (int i=0; i<3;i++){
            graph.drawLine(170,60+40*i,270,60+40*i);
        }
        System.out.println("Desssin Livre fini");
    }
}