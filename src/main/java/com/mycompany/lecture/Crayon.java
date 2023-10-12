package com.mycompany.lecture;

import java.awt.BasicStroke;
import javax.swing.JPanel;
import java.awt.Graphics2D;


public class Crayon implements Dessin {
    
    private final String nomDeLImage ="CRAYON";
    private JPanel panelDroit;
    private String couleur;
    
    public Crayon (JPanel panelDroit, String couleur){
        this.panelDroit = panelDroit;
        this.couleur = couleur;
    }
             
    @Override
    public String getNomImage() {
        return nomDeLImage;
    }
    
    @Override
    public void dessin() {
        Graphics2D graph = (Graphics2D) panelDroit.getGraphics();
        CouleurDessin couleurdessin = new CouleurDessin(couleur);
        graph.setColor(couleurdessin.couleurSelectionnee());
        graph.setStroke(new BasicStroke(4)); // epaisseur du trait en pixels
        graph.drawRect(175, 20, 40, 100);
        graph.drawLine(175,120,195,140);
        graph.drawLine(215,120,195,140);
    }
}