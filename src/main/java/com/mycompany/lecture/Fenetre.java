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

public class Fenetre extends JFrame
{
    private String NomImage; // Nom de l'image à lire
    private int index; // correspond au numéro du dessin
    private JPanel panelGauche = new JPanel();
    private JPanel panelDroit = new JPanel();
    private JLabel texte = new JLabel();
    private JButton boutonReculer = new JButton(new ImageIcon("images/back.png"));  
    private JButton boutonAvancer = new JButton(new ImageIcon("images/forward.png"));  
    
    public Fenetre(String NomImage, int index){
        this.NomImage = NomImage;
        this.index = index;
        texte.setText(NomImage);
        texte.setFont(new Font("Serif", Font.BOLD, 20));
        // positionnement avec la méthode BorderLayout
        this.add(panelGauche, BorderLayout.NORTH);
        this.add(panelDroit, BorderLayout.CENTER);
        // positionnement des trois éléments avec la méthode FlowLayout
        panelGauche.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panelGauche.add(texte);
        panelGauche.add(boutonReculer);
        panelGauche.add(boutonAvancer);
        actionsBoutons();
        // réglage de la Frame
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
    private void actionsBoutons(){
        //boutonReculer
        boutonReculer.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent event) {
                // gestion de l'index
                System.out.println("Reculer");
                index-=1;
                if (index == 0){
                    index = 1;
                }
                 // lance la fabrication de l'objet
                System.out.println(index);
                FabriqueDessin fabriqueDessin = new FabriqueDessin(index, panelDroit, NomImage);
                fabriqueDessin.getDessin();
                texte.setText(fabriqueDessin.getNomImage());
            }
        });
        boutonAvancer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // gestion de l'index
                index+=1;
                if (index == 4){
                    index =3;
                }
                // lance la fabrication de l'objet 
                FabriqueDessin fabriqueDessin = new FabriqueDessin(index, panelDroit, NomImage);
                fabriqueDessin.getDessin();
                texte.setText(fabriqueDessin.getNomImage());
            }
        });
        
    }
}