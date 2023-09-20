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
    private JPanel panelGauche = new JPanel();
    private JPanel panelDroit = new JPanel();
    private JLabel labelHaut = new JLabel();
    private JLabel labelBas = new JLabel();
    private JButton boutonReculer = new JButton(new ImageIcon("images/back.png"));  
    private JButton boutonAvancer = new JButton(new ImageIcon("images/forward.png"));  
    public Fenetre(String NomImage, int index){
        this.NomImage = NomImage;
        this.index = index;
        labelHaut.setText(NomImage);
        labelHaut.setFont(new Font("Serif", Font.BOLD, 20));
        labelBas.setText ("Image " + index);
        // positionnement avec la méthode BorderLayout
        this.add(panelGauche, BorderLayout.NORTH);
        this.add(panelDroit, BorderLayout.CENTER);
        this.add(labelBas, BorderLayout.SOUTH);
        // positionnement des trois éléments avec la méthode FlowLayout
        panelGauche.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        // Mettre une bordure au label labelBas
        labelBas.setBorder(new EmptyBorder(0, 10, 5, 0));
        panelGauche.add(labelHaut);
        panelGauche.add(boutonReculer);
        panelGauche.add(boutonAvancer);
        actionsBoutons();
        // réglage de la Frame
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private void actionsBoutons(){
        
        boutonReculer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("Reculer");
                index-=1;
                if (index == 0){
                    index = 1;
                }
                 // lance la fabrication de l'objet
                System.out.println(index);
                FabriqueDessin fabriqueDessin = new FabriqueDessin(index, panelDroit, NomImage);
                fabriqueDessin.getDessin();
                labelHaut.setText(fabriqueDessin.getNomImage());
                labelBas.setText ("Image " + index);
            }
        });
        
        boutonAvancer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.out.println("Reculer");
                index+=1;
                if (index == 7){
                    index =1;
                }
                // lance la fabrication de l'objet 
                FabriqueDessin fabriqueDessin = new FabriqueDessin(index, panelDroit, NomImage);
                fabriqueDessin.getDessin();
                labelHaut.setText(fabriqueDessin.getNomImage());
                labelBas.setText ("Image " + index);
            }
        });
        
    }
}