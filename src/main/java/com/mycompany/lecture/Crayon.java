package com.mycompany.lecture;

import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics2D;


public class Crayon implements Dessin {
    
    private final String nomDeLImage ="CARTABLE";
    private JPanel panelCentre;
    private int R, V, B;
    
    public Crayon (JPanel panelCentre, int R, int V, int B){
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
        graph.drawRect(175, 20, 40, 100);
        graph.drawLine(175,120,195,140);
        graph.drawLine(215,120,195,140);
    }
}