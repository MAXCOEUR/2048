/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import Modele.Grille;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author eric.duchene
 */
public class VueGrille extends JComponent implements KeyListener, ComponentListener{
    Grille grille;
    int tailleCase;
    
    public VueGrille(Grille g){
        tailleCase=this.getPreferredSize().height/g.getTaille();
        grille=g;
        // ecouteur
    }
    
    public static Color getColor(int valeur){
        switch (valeur) {
            case 2:
                return new Color(23, 220, 189);
            case 4:
                return new Color(35, 220, 175);
            case 8:
                return new Color(47, 220, 161);
            case 16:
                return new Color(59, 221,141);
            case 32:
                return new Color(71, 221, 134);
            case 64:
                return new Color(83, 221, 106);
            case 128:
                return new Color(95, 221, 92);
            case 256:
                return new Color(107, 221, 92);
            case 512:
                return new Color(119, 222, 79);
            case 1024:
                return new Color(131, 222, 65);
            case 2048:
                return new Color(143, 222, 51);
            default:
                break;
        }
        return new Color(50,50,50);
    }
    
    private void affichageGrille(Graphics gra){
        for (int i = 0; i < grille.getTaille()+1; i++) {
            gra.setColor(Color.black);
            gra.drawLine(0, i*tailleCase, tailleCase*grille.getTaille(), i*tailleCase);
            gra.drawLine(i*tailleCase, 0, i*tailleCase,tailleCase*grille.getTaille() );
        }
        
    }
    
    @Override
    protected void paintComponent(Graphics gra) {
        affichageGrille(gra);
         
        for (int i = 0; i < grille.getTaille(); i++) {
            for (int j = 0; j < grille.getTaille(); j++) {
                gra.setColor(getColor(grille.getCase(i, j).getValeur()));
                gra.fillRect(j*tailleCase+1, i*tailleCase+1, tailleCase-1, tailleCase-1);
                gra.setColor(Color.BLACK);
                if (grille.getCase(i, j).getValeur()!=0) {
                    if (grille.getCase(i, j).getValeur()<10) {
                        gra.setFont(new Font("TimesRoman", Font.PLAIN, tailleCase));
                        gra.drawString(grille.getCase(i, j).getValeur()+"", j*tailleCase+tailleCase/4, i*tailleCase+7*tailleCase/8);
                    }
                    else if (grille.getCase(i, j).getValeur()<100) {
                        gra.setFont(new Font("TimesRoman", Font.PLAIN, tailleCase/2));
                        gra.drawString(grille.getCase(i, j).getValeur()+"", j*tailleCase+tailleCase/4, i*tailleCase+7*tailleCase/8);
                    }
                    else if (grille.getCase(i, j).getValeur()<1000){
                        gra.setFont(new Font("TimesRoman", Font.PLAIN, tailleCase/3));
                        gra.drawString(grille.getCase(i, j).getValeur()+"", j*tailleCase+tailleCase/4, i*tailleCase+7*tailleCase/8);
                    }
                    else{
                        gra.setFont(new Font("TimesRoman", Font.PLAIN, tailleCase/4));
                        gra.drawString(grille.getCase(i, j).getValeur()+"", j*tailleCase+tailleCase/4, i*tailleCase+7*tailleCase/8);
                    }
                    
                }
                
            }
        }
    }
    
    @Override
    public final Dimension getPreferredSize() {
        //a modifier
        return new Dimension(600+1,600+1);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        ;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==38) {//UP
            grille.pousserHaut();
            if (!grille.ajoutElementAlea()) {
                JOptionPane.showMessageDialog(null,"!!!! Perdu NULOS !!!!","Perdu",JOptionPane.INFORMATION_MESSAGE);
                grille.reinitialiser();
            }
            repaint();
            
            if (grille.win()) {
                JOptionPane.showMessageDialog(null,"!!!! Vous avez gagner !!!!","Gagner",JOptionPane.INFORMATION_MESSAGE);
                grille.reinitialiser();
                
            }
        }
        if (e.getKeyCode()==37) {//LEFT
            
            grille.pousserGauche();
            if (!grille.ajoutElementAlea()) {
                JOptionPane.showMessageDialog(null,"!!!! Perdu NULOS !!!!","Perdu",JOptionPane.INFORMATION_MESSAGE);
                grille.reinitialiser();
            }
            repaint();
            if (grille.win()) {
                JOptionPane.showMessageDialog(null,"!!!! Vous avez gagner !!!!","Gagner",JOptionPane.INFORMATION_MESSAGE);
                grille.reinitialiser();
            }
        }
        if (e.getKeyCode()==39) {//RIGHT
            
            grille.pousserDroite();
            if (!grille.ajoutElementAlea()) {
                JOptionPane.showMessageDialog(null,"!!!! Perdu NULOS !!!!","Perdu",JOptionPane.INFORMATION_MESSAGE);
                grille.reinitialiser();
            }
            repaint();
            if (grille.win()) {
                JOptionPane.showMessageDialog(null,"!!!! Vous avez gagner !!!!","Gagner",JOptionPane.INFORMATION_MESSAGE);
                grille.reinitialiser();
            }
        }
        if (e.getKeyCode()==40) {//DOWN
            
            grille.pousserBas();
            if (!grille.ajoutElementAlea()) {
                JOptionPane.showMessageDialog(null,"!!!! Perdu NULOS !!!!","Perdu",JOptionPane.INFORMATION_MESSAGE);
                grille.reinitialiser();
            }
            repaint();
            if (grille.win()) {
                JOptionPane.showMessageDialog(null,"!!!! Vous avez gagner !!!!","Gagner",JOptionPane.INFORMATION_MESSAGE);
                grille.reinitialiser();
            }
        }
        
        if (e.getKeyCode()==107) {// ADD
            int i=grille.getTaille();
            grille.reinitialiser(++i);
            tailleCase=this.getPreferredSize().height/i;
        }
        if (e.getKeyCode()==109) {//subtract
            int i=grille.getTaille();
            grille.reinitialiser(--i);
            tailleCase=this.getPreferredSize().height/i;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        ;
    }

    @Override
    public void componentResized(ComponentEvent e) {
        
        
        repaint();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        ;
    }

    @Override
    public void componentShown(ComponentEvent e) {
        ;
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        ;
    }


   
}
