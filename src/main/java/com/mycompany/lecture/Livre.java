package com.mycompany.lecture;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Livre implements Dessin {
    
    private final String nomDeLImage ="LIVRE   ";
    private JPanel panelDroit;
    
    public Livre (JPanel panelDroit){
        this.panelDroit = panelDroit;
    }
             
    @Override
    public String getNomImage() {
        return nomDeLImage;
    }
    
    @Override
    public void dessin() {
        Graphics2D graph = (Graphics2D) panelDroit.getGraphics();
        graph.setColor(Color.RED);
        graph.setStroke(new BasicStroke(4)); // epaisseur du trait en pixels
        graph.drawRect(10, 20, 280, 160); // cadre extérieur
        graph.drawLine(150,20,150,180); // dessin de la ligne du milieu
        // dessin des trois lignes de gauche
        graph.drawLine(30,60,130,60);
        graph.drawLine(30,100,130,100);
        graph.drawLine(30,140,130,140);
        // dessin des trois lignes de droite
        graph.drawLine(170,60,270,60);
        graph.drawLine(170,100,270,100);
        graph.drawLine(170,140,270,140);
    }
}