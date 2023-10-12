package com.mycompany.lecture;

import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics2D;


public class Cartable implements Dessin {
    
    private final String nomDeLImage ="CARTABLE";
    private JPanel panelCentre;
    private int R, V, B;
    
    public Cartable (JPanel panelCentre, int R, int V, int B){
        this.panelCentre = panelCentre;
        this.R = R;
        this.V = V;
        this.B = B;
    }
             
    @Override
    public String getNomImage() {
        return nomDeLImage;
    }
    
    @Override
    public void dessin() {
        Graphics2D graph = (Graphics2D) panelCentre.getGraphics();
        graph.setColor(new Color(R, V, B));
        graph.setStroke(new BasicStroke(4)); // epaisseur du trait en pixels
        graph.drawRect(100, 30, 210, 170); // cadre extérieur
        graph.drawLine(100, 110, 310, 110); // ligne du milieu
        graph.drawRect(181, 12, 48, 18); // poignée
        graph.fillRect(181,110,48,18); //fermeture
    }
}