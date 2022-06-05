/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

/**
 *
 * @author eric.duchene
 */
public class Case {
    int ligne,colonne;
    int valeur; //si 0: case vide

    public Case(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.valeur=0;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    
    public void setValeur(int valeur) {
        this.valeur=valeur;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public int getValeur() {
        return valeur;
    }

    @Override
    public String toString() {
        return "Case{" + "ligne=" + ligne + ", colonne=" + colonne + ", valeur=" + valeur + '}';
    }
    
    
    
}
