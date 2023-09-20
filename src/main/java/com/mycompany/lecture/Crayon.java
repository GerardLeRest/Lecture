package com.mycompany.lecture;

import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Graphics2D;


public class Crayon implements Dessin {
    
    private final String nomDeLImage ="CRAYON";
    private JPanel panelDroit;
    
    public Crayon (JPanel panelDroit){
        this.panelDroit = panelDroit;
    }
             
    @Override
    public String getNomImage() {
        return nomDeLImage;
    }
    
    @Override
    public void dessin() {
        Graphics2D graph = (Graphics2D) panelDroit.getGraphics();
        graph.setColor(Color.GREEN);
        graph.setStroke(new BasicStroke(4)); // epaisseur du trait en pixels
        graph.drawRect(120, 20, 40, 100);
        graph.drawLine(120,120,140,140);
        graph.drawLine(160,120,140,140);
    }
}
