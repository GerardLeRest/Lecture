package com.mycompany.lecture;

import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics2D;


public class Cartable implements Dessin {
    
    private final String nomDeLImage ="CARTABLE";
    private JPanel panelCentre;
    
    public Cartable (JPanel panelCentre){
        this.panelCentre = panelCentre;
    }
             
    @Override
    public String getNomImage() {
        return nomDeLImage;
    }
    
    @Override
    public void dessin() {
        Graphics2D graph = (Graphics2D) panelCentre.getGraphics();
        graph.setColor(Color.BLUE);
        graph.setStroke(new BasicStroke(4)); // epaisseur du trait en pixels
        graph.drawRect(10, 20, 280, 160); // cadre extérieur
        graph.drawLine(10, 100, 290, 100); // ligne du milieu
        graph.drawRect(115, 2, 50, 18); // poignée
        graph.fillRect(115,100,50,18); //fermeture
    }
}