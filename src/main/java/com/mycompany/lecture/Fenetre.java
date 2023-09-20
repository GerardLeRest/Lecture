package com.mycompany.lecture;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre extends JFrame 
{
    protected String mot; // mot à lire
    protected int index = 1;
    private JFrame frame = new JFrame("Lecture"); 
    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private JLabel texte = new JLabel(mot);
    private JButton boutonReculer = new JButton(new ImageIcon("images/back.png"));  
    private JButton boutonAvancer = new JButton(new ImageIcon("images/forward.png"));  
    
    public Fenetre(String mot){
        this.mot = mot;
        texte.setText(mot);
        texte.setFont(new Font("Serif", Font.BOLD, 20));
        // positionnement avec la méthode BorderLayout
        this.frame.add(panel, BorderLayout.NORTH);
        this.frame.add(panel2, BorderLayout.CENTER);
        // positionnement des trois éléments avec la méthode FlowLayout
        panel.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        panel.add(texte);
        panel.add(boutonReculer);
        panel.add(boutonAvancer);
        //panel.setBackground(Color.GREEN);
        //panel2.setBackground(Color.ORANGE);
        //frame.pack();
        actionsBoutons();
        this.frame.setSize(300, 300);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }
    
    private void actionsBoutons(){
        //boutonReculer
        boutonReculer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // gestion de l'index
                index-=1;
                if (index == 0){
                    index =1;
                }
                System.out.println(index);
            }
        });
        boutonAvancer.addActionListener(new ActionListener() {
            // gestion de l'index
            @Override
            public void actionPerformed(ActionEvent event) {
                index+=1;
                if (index == 4){
                    index =3;
                }
                System.out.println(index);
            }
        });
        
    }
}
