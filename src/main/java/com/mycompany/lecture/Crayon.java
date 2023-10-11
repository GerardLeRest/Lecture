package com.mycompany.lecture;

import java.awt.BasicStroke;
import javax.swing.JPanel;
import java.awt.Graphics2D;


public class Crayon implements Dessin {
    
    private final String nomDeLImage ="CRAYON";
    private String couleur;
    private Graphics2D graph;
    private JPanel panelCentre;
    

    public Crayon (String couleur, JPanel panelCentre){
        this.couleur = couleur;
        this.panelCentre = panelCentre;
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
        graph.drawRect(120, 20, 40, 100);
        graph.drawLine(120,120,140,140);
        graph.drawLine(160,120,140,140);
    }
}