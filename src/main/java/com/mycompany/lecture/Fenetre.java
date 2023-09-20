package com.mycompany.lecture;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
public class Fenetre extends JFrame
{
    private String NomImage; // Nom de l'image à ;
    private int index; // correspond au numéro du dessin
    private JPanel panelhaut = new JPanel();
    private JPanel panelCentre = new JPanel();
    private JLabel labelHaut = new JLabel();
    private JLabel labelBas = new JLabel();
    private JButton boutonReculer = new JButton(new ImageIcon("images/back.png"));  
    private JButton boutonAvancer = new JButton(new ImageIcon("images/forward.png"));  
   
    public Fenetre(String NomImage, int index){
        // label haut
        this.NomImage = NomImage;
        this.index = index;
        //label haut
        labelHaut.setText(NomImage);
        labelHaut.setFont(new Font("Serif", Font.BOLD, 20));
        // label bas
        labelBas.setText ("Image " + index);
        // Mettre une bordure au label labelBas
        labelBas.setBorder(new EmptyBorder(0, 10, 5, 0));
        // boutons radio
        //
        //
        // positionnement avec la méthode BorderLayout
        this.add(panelhaut, BorderLayout.NORTH);
        this.add(panelCentre, BorderLayout.CENTER);
        this.add(labelBas, BorderLayout.SOUTH); 
        // positionnement des trois éléments du hazut avec la méthode FlowLayout
        panelhaut.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelhaut.add(boutonReculer);
        panelhaut.add(boutonAvancer);
        panelhaut.add(labelHaut);
        // positionnement des deux éléments du bas avec la méthode FlowLayout
        //
        //
        actionsBoutons();
        // réglage de la Frame
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private void actionsBoutons(){
        
        boutonReculer.addActionListener((ActionEvent event) -> {
            System.out.println("Reculer");
            index -= 1;
            if (index == 0){
                index = 1;
            }
            else if (index ==-1){
                index = 1;
            }
            // lance la fabrication de l'objet
            System.out.println(index);
            FabriqueDessin fabriqueDessin = new FabriqueDessin(index, panelCentre, NomImage);
            fabriqueDessin.getDessin();
            // mise à jour des labels
            labelHaut.setText(fabriqueDessin.getNomImage());
            labelBas.setText ("Image " + index);
        });
        
        boutonAvancer.addActionListener((ActionEvent event) -> {
            System.out.println("Reculer");
            index += 1;
            if (index == 7){
                index =1;
            }
            // lance la fabrication de l'objet
            FabriqueDessin fabriqueDessin = new FabriqueDessin(index, panelCentre, NomImage);
            fabriqueDessin.getDessin();
            //mis à jour des labels
            labelHaut.setText(fabriqueDessin.getNomImage());
            labelBas.setText ("Image " + index);
        });
        
    }
}
