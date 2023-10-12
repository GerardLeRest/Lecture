package com.mycompany.lecture;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
public class Fenetre extends JFrame
{
    private String NomImage; // Nom de l'image à ;
    private int index; // correspond au numéro du dessin
    // case à cocher
    private JCheckBox checkboxR = new JCheckBox("R"); // case à cocher
    private JCheckBox checkboxV = new JCheckBox("V"); // case à cocher
    private JCheckBox checkboxB = new JCheckBox("B"); // case à cocher
    // valeur RVB (0 ou 255)déterminée par les cases à cocher
    private int R, V, B;
    private ButtonGroup groupeBoutons = new ButtonGroup();         
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
        //labelHaut.setForeground(Color.RED);
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
        // ajouter les boutons radios au panelhaut
        panelhaut.add(checkboxR);
        panelhaut.add(checkboxV);
        panelhaut.add(checkboxB);
        R = V = B = 0;
        // boutons reculer et avancer
        panelhaut.add(boutonReculer);
        // le mot à lire
        panelhaut.add(boutonAvancer);
        panelhaut.add(labelHaut);
        actionsBoutons();
        // réglage de la Frame
        this.setSize(440, 320);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false); 
        this.setVisible(true);
    }
    
    private void actionsBoutons(){
        
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
        
        checkboxR.addActionListener((ActionEvent event) -> {
            boolean state = checkboxR.isSelected();
            if (state) {
               R = 255;
            } 
            else {
               R = 0;
            }
            dessiner();
        });
        
        checkboxV.addActionListener((ActionEvent event) -> {
            boolean state = checkboxV.isSelected();
            if (state) {
               V = 255;
            }
            else {
               V = 0;
            }
            dessiner();
        });
        
        checkboxB.addActionListener((ActionEvent event) -> {  
            boolean state = checkboxB.isSelected();
            if (state) {
               B = 255;
            }
            else {
               B = 0;
            }
            dessiner();
        });
        
    }
    
    private void dessiner(){
        // lance la fabrication de l'objet
            FabriqueDessin fabriqueDessin = new FabriqueDessin(index, panelCentre, NomImage, R, V, B);
            fabriqueDessin.getDessin();
            // mise à jour des labels
            labelHaut.setText(fabriqueDessin.getNomImage());
            labelHaut.setForeground(new Color(R, V, B));       
            labelBas.setText ("Image " + index);
    }
}