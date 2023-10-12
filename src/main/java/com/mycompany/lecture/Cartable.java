package com.mycompany.lecture;

import java.awt.BasicStroke;
import javax.swing.JPanel;
import java.awt.Graphics2D;


public class Cartable implements Dessin {
    
    private final String nomDeLImage ="CARTABLE";
    private JPanel panelCentre;
    private String couleur;
    
    public Cartable (JPanel panelCentre, String couleur){
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
        //graph.setColor(Color.BLUE);
        graph.setStroke(new BasicStroke(4)); // epaisseur du trait en pixels
        graph.drawRect(100, 30, 210, 170); // cadre extérieur
        graph.drawLine(100, 110, 310, 110); // ligne du milieu
        graph.drawRect(181, 12, 48, 18); // poignée
        graph.fillRect(181,110,48,18); //fermeture
    }
}