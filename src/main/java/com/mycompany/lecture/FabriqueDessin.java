package com.mycompany.lecture;

import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.Color;

public class FabriqueDessin {

    private int index;
    private JPanel panelCentre;
    private String NomImage;
    private int R, V, B;

    public FabriqueDessin(int index, JPanel panelCentre, String NomImage, int R, int V, int B) {
        this.index = index;
        this.panelCentre = panelCentre;
        this.NomImage = NomImage;
        this.R = R;
        this.V = V;
        this.B = B;
                
    }

    public void getDessin() {
        // dessine l'objet sélectionné dans le panel de droite
        switch (index) {
            case 0 ->
                effacerPanelDroit();
            case 1 -> {
                effacerPanelDroit();
                Dessin cartable = new Cartable(panelCentre, R, V, B);
                NomImage = cartable.getNomImage();
            }
            case 2 -> {
                Dessin cartable = new Cartable(panelCentre, R, V, B);
                NomImage = cartable.getNomImage();
                cartable.dessin();
            }
            case 3 -> {
                effacerPanelDroit();
                Dessin livre = new Livre(panelCentre, R, V, B);
                NomImage = livre.getNomImage();
            }
            case 4 -> {
                Dessin livre = new Livre(panelCentre, R, V, B);
                NomImage = livre.getNomImage();
                livre.dessin();
            }
            case 5 -> {
                effacerPanelDroit();
                Dessin crayon = new Crayon(panelCentre, R, V, B);
                NomImage = crayon.getNomImage();
            }
            case 6 -> {
                Dessin crayon = new Crayon(panelCentre, R, V, B);
                NomImage = crayon.getNomImage();
                crayon.dessin();
            }
        }
    }

    public String getNomImage() {
        return NomImage;
    }

    public void effacerPanelDroit() {
        Graphics2D graph = (Graphics2D) panelCentre.getGraphics();
        graph.setColor(Color.WHITE);
        graph.fillRect(55,0, 300, 300); // cadre extérieur
    }
}
