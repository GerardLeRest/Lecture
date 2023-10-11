package com.mycompany.lecture;

import java.awt.BasicStroke;
import javax.swing.JPanel;
import java.awt.Graphics2D;


public class Cartable implements Dessin {
    
    private final String nomDeLImage ="CARTABLE";
    private String couleur;
    private Graphics2D graph;
    private JPanel panelCentre;
    

    public Cartable (String couleur, JPanel panelCentre){
        this.couleur = couleur;
        this.panelCentre = panelCentre;
        System.out.println(panelCentre);
    }
    
    @Override
    public String getNomImage() {
        return nomDeLImage;
    }
    
    @Override
    public void dessin() {
        Graphics2D graph = (Graphics2D) panelCentre.getGraphics();
        CouleurObjet couleurobjet = new CouleurObjet(couleur);
        graph.setColor(couleurobjet.couleurSelectionnee());
        graph.setStroke(new BasicStroke(4)); // epaisseur du trait en pixels
        graph.drawRect(20, 20, 280, 160); // cadre extérieur
        graph.drawLine(20, 100, 290, 100); // ligne du milieu
        graph.drawRect(115, 2, 50, 18); // poignée
        graph.fillRect(115,100,50,18); //fermeture
    }
}