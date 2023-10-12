package com.mycompany.lecture;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Livre implements Dessin {
    
    private final String nomDeLImage ="LIVRE";
    private JPanel panelCentre;
    private String couleur;
    
    public Livre (JPanel panelCentre, String couleur){
        this.panelCentre = panelCentre;
        this.couleur = couleur;
    }
             
    @Override
    public String getNomImage() {
        return nomDeLImage;
    }
    
    @Override
    public void dessin() {
        Graphics2D graph = (Graphics2D) panelCentre.getGraphics();
        CouleurDessin couleurdessin = new CouleurDessin(couleur);
        graph.setColor(couleurdessin.couleurSelectionnee());
        graph.setStroke(new BasicStroke(4)); // epaisseur du trait en pixels
        graph.drawRect(10, 20, 280, 160); // cadre extérieur
        graph.drawLine(150,20,150,180); // dessin de la ligne du milieu
        // dessin des trois lignes de gauche
        for (int i=0; i<3;i++){
            graph.drawLine(30,60+40*i,130,60+40*i);
        }
        // dessin des trois lignes de droite
        for (int i=0; i<3;i++){
            graph.drawLine(170,60+40*i,270,60+40*i);
        }
    }
}