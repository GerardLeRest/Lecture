package com.mycompany.lecture;

import javax.swing.JPanel;

public class FabriqueDessin{
   private int index;
   private JPanel panelDroit;
   private String NomImage;

    public FabriqueDessin(int index, JPanel panelDroit, String NomImage) {
        this.index = index;
        this.panelDroit = panelDroit;
        this.NomImage = NomImage;
    }
      
    public void getDessin(){
         // dessine l'objet sélectionné dans le panel de droite
        System.out.println("procedure");  
        switch (index) {
            case 1 -> {
                // cartable bleu
                System.out.println("case 1");
                Cartable cartable = new Cartable(panelDroit);
                NomImage = cartable.getNomImage();
                cartable.dessin();
            }
            case 2 -> {
                //livre rouge
                System.out.println("case 2");
            }
            case 3 ->{
                //crayonnjaune
                System.out.println("case 3");
            }
        }
    }
        
    public String getNomImage(){
        return NomImage;
    }
}