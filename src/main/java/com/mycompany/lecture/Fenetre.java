package com.mycompany.lecture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.EmptyBorder;

public class Fenetre extends JFrame {
    private String NomImage; // Nom de l'image
    private int index; // correspond au numéro du dessin
    // cases à cocher
    private JCheckBox checkboxR = new JCheckBox("R");
    private JCheckBox checkboxV = new JCheckBox("V");
    private JCheckBox checkboxB = new JCheckBox("B");
    // valeur RVB (0 ou 255) déterminée par les cases à cocher
    private int R, V, B;
    private JPanel panelhaut = new JPanel();
    private JPanel panelCentre = new JPanel();
    private JLabel labelHaut = new JLabel();
    private JLabel labelBas = new JLabel();
    private JButton boutonReculer;
    private JButton boutonAvancer;

    public Fenetre(String NomImage, int index) {
        this.NomImage = NomImage;
        this.index = index;

        // Chargement de la première image
        try {
            Image img1 = ImageIO.read(getClass().getResourceAsStream("/images/back.png"));
            boutonReculer = new JButton(new ImageIcon(img1));
        } catch (IOException e) {
            System.err.println("back.png not found!");
        }

        // Chargement de la deuxième image
        try {
            Image img2 = ImageIO.read(getClass().getResourceAsStream("/images/forward.png"));
            boutonAvancer = new JButton(new ImageIcon(img2));
        } catch (IOException e) {
            System.err.println("forward.png not found!");
        }

        // label haut
        labelHaut.setText(NomImage);
        labelHaut.setFont(new Font("Serif", Font.BOLD, 20));

        // label bas
        labelBas.setText("Image " + index);
        labelBas.setBorder(new EmptyBorder(0, 10, 5, 0));

        // positionnement avec la méthode BorderLayout
        this.add(panelhaut, BorderLayout.NORTH);
        this.add(panelCentre, BorderLayout.CENTER);
        this.add(labelBas, BorderLayout.SOUTH);

        // positionnement des éléments du haut avec la méthode FlowLayout
        panelhaut.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        // ajouter les boutons radios au panelhaut
        panelhaut.add(checkboxR);
        panelhaut.add(checkboxV);
        panelhaut.add(checkboxB);
        R = V = B = 0;
        // boutons reculer et avancer
        panelhaut.add(boutonReculer);
        panelhaut.add(boutonAvancer);
        panelhaut.add(labelHaut);
        actionsBoutons();

        // réglage de la Frame
        this.setSize(440, 320);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    private void actionsBoutons() {
        boutonReculer.addActionListener((ActionEvent event) -> {
            index -= 1;
            if (index == 0 || index == 1) {
                index = 1;
            } else if (index == -1) {
                index = 1;
            }
            dessiner();
        });

        boutonAvancer.addActionListener((ActionEvent event) -> {
            index += 1;
            if (index == 7) {
                index = 1;
            }
            dessiner();
        });

        checkboxR.addActionListener((ActionEvent event) -> {
            boolean state = checkboxR.isSelected();
            if (state) {
                R = 255;
            } else {
                R = 0;
            }
            dessiner();
        });

        checkboxV.addActionListener((ActionEvent event) -> {
            boolean state = checkboxV.isSelected();
            if (state) {
                V = 255;
            } else {
                V = 0;
            }
            dessiner();
        });

        checkboxB.addActionListener((ActionEvent event) -> {
            boolean state = checkboxB.isSelected();
            if (state) {
                B = 255;
            } else {
                B = 0;
            }
            dessiner();
        });
    }

    private void dessiner() {
        // lance la fabrication de l'objet
        FabriqueDessin fabriqueDessin = new FabriqueDessin(index, panelCentre, NomImage, R, V, B);
        fabriqueDessin.getDessin();
        // mise à jour des labels
        labelHaut.setText(fabriqueDessin.getNomImage());
        labelHaut.setForeground(new Color(R, V, B));
        labelBas.setText("Image " + index);
    }

    public static void main(String[] args) {
        new Fenetre("Example Image", 1);
    }
}
