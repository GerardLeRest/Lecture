package com.mycompany.lecture;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
public class Fenetre extends JFrame
{
    private String NomImage; // Nom de l'image à ;
    private int index; // correspond au numéro du dessin
    private String couleur;
    private JRadioButton bRadio1, bRadio2, bRadio3; // boutons radios
    private ButtonGroup groupeBoutons = new ButtonGroup();         
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
        // Créer les boutons radio
        bRadio1 = new JRadioButton("R");
        bRadio2 = new JRadioButton("V");
        bRadio3 = new JRadioButton("B");
        //label haut
        labelHaut.setText(NomImage);
        labelHaut.setFont(new Font("Serif", Font.BOLD, 20));
        labelHaut.setForeground(Color.RED);
        // label bas
        labelBas.setText ("Image " + index);
        // Mettre une bordure au label labelBas
        labelBas.setBorder(new EmptyBorder(0, 10, 5, 0));
        // positionnement avec la méthode BorderLayout
        this.add(panelhaut, BorderLayout.NORTH);
        this.add(panelCentre, BorderLayout.CENTER);
        this.add(labelBas, BorderLayout.SOUTH); 
        // positionnement des éléments du hazut avec la méthode FlowLayout
        panelhaut.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        // boutons radios
        panelhaut.add(bRadio1);
        panelhaut.add(bRadio2);
        panelhaut.add(bRadio3);
        // grouper les boutons
        groupeBoutons.add(bRadio1);
        groupeBoutons.add(bRadio2);
        groupeBoutons.add(bRadio3);
        // boutons reculer et avancer
        panelhaut.add(boutonReculer);
        // le mot à lire
        panelhaut.add(boutonAvancer);
        panelhaut.add(labelHaut);
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
            dessiner();
        });
        
        boutonAvancer.addActionListener((ActionEvent event) -> {
            System.out.println("Reculer");
            index += 1;
            if (index == 7){
                index =1;
            }
            dessiner();
        });
        
        bRadio1.addActionListener((ActionEvent event) -> {
            couleur="Rouge";
            System.out.println(couleur);
            labelHaut.setForeground(Color.RED);
            dessiner();
        });
        
        bRadio2.addActionListener((ActionEvent event) -> {
            couleur="Vert";
            System.out.println(couleur);
            labelHaut.setForeground(Color.GREEN);
            dessiner();
        });
        
        bRadio3.addActionListener((ActionEvent event) -> {  
            couleur="Bleu";
            System.out.println(couleur);
            labelHaut.setForeground(Color.BLUE);
            dessiner();
        });
        
    }
    
    private void dessiner(){
        // lance la fabrication de l'objet
            System.out.println(index);
            FabriqueDessin fabriqueDessin = new FabriqueDessin(index, panelCentre, NomImage, couleur);
            fabriqueDessin.getDessin();
            // mise à jour des labels
            labelHaut.setText(fabriqueDessin.getNomImage());
            labelBas.setText ("Image " + index);
    }
}