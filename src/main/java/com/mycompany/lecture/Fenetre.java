package com.mycompany.lecture;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class Fenetre extends JFrame
{
    private String NomImage; // Nom de l'image à ;
    private int index; // correspond au numéro du dessin
    private String couleur;
    private String[] couleurs = new String[] {"Noir", "Bleu", "Vert", "Orange"};
    private JComboBox<String> combobox = new JComboBox<>(couleurs); 
    private JPanel panelhaut = new JPanel();
    private JPanel panelCentre = new JPanel();
    private JLabel labelHaut = new JLabel();
    private JLabel labelBas = new JLabel();
    private JButton boutonReculer = new JButton(new ImageIcon("images/back.png"));  
    private JButton boutonAvancer = new JButton(new ImageIcon("images/forward.png"));  
   
    public Fenetre(String NomImage, int index, String couleur){
        // label haut
        this.NomImage = NomImage;
        this.index = index;
        this.couleur = couleur;
        // construction des composants
        //label haut
        
        labelHaut.setText(NomImage);
        labelHaut.setFont(new Font("Serif", Font.BOLD, 20));
        // label bas
        labelBas.setText ("Image " + index);
        // Mettre une bordure au label labelBas
        labelBas.setBorder(new EmptyBorder(0, 10, 5, 0));
        //adaptation du texte du Jcombobo
        combobox.setFont(new Font("Serif", Font.BOLD, 20));
        // positionnement avec la méthode BorderLayout
        this.add(panelhaut, BorderLayout.NORTH);
        this.add(panelCentre, BorderLayout.CENTER);
        this.add(labelBas, BorderLayout.SOUTH); 
        // positionnement des quatre éléments du hazut avec la méthode FlowLayout
        panelhaut.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelhaut.add(combobox);
        panelhaut.add(boutonReculer);
        panelhaut.add(boutonAvancer);
        panelhaut.add(labelHaut);
        // acytions des boutons et de la comBoBox
        actionsComposants();
        // réglage de la Frame
        this.setSize(420, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private void actionsComposants(){
        
        boutonReculer.addActionListener((ActionEvent event) -> {
            index -= 1;
            if (index == 0){
                index = 1;
            }
            else if (index ==-1){
                index = 1;
            }
            dessiner();
            });
        
        boutonAvancer.addActionListener((ActionEvent event) -> {
            index += 1;
            if (index == 7){
                index =1;
            }
            dessiner();
        });
   
        combobox.addActionListener((ActionEvent event) -> {
            couleur = combobox.getSelectedItem().toString();
            switch (couleur) {
                case "Noir" ->   labelHaut.setForeground(Color.BLACK);
                case "Bleu" ->   labelHaut.setForeground(Color.BLUE);
                case "Vert" ->   labelHaut.setForeground(Color.GREEN);
                case "Orange" -> labelHaut.setForeground(Color.ORANGE);
            }
            dessiner();
        });
    }
    
    private void dessiner(){
        // lance la fabrication de l'objet
        FabriqueDessin fabriqueDessin = new FabriqueDessin(index, panelCentre, couleur);
        fabriqueDessin.getDessin();
        //mis à jour des labels
        labelHaut.setText(fabriqueDessin.getNomImage());
        labelBas.setText ("Image " + index);
    }
}