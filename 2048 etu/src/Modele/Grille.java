/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

import java.util.ArrayList;

/**
 *
 * @author eric.duchene
 */
public class Grille {
    Case grille[][];
    int taille;
    
    public Grille(int taille){
        this.taille=taille;
        initGrille(taille);
        ajoutElementAlea();
        ajoutElementAlea();
    }
    
    public boolean win(){
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if (grille[i][j].getValeur()==2048) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void reinitialiser(int taille){
        System.out.println(taille);
        this.taille=taille;
        initGrille(taille);
        ajoutElementAlea();
        ajoutElementAlea();
    }
    public void reinitialiser(){
        initGrille(taille);
        ajoutElementAlea();
        ajoutElementAlea();
    }
    
    public void initGrille(int taille){
        grille=new Case[taille][taille];
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                grille[i][j]=new Case(i,j);
            }
        }
    }
    
    public boolean ajoutElementAlea(){//return false si plein et pas possible
        ArrayList<Case>listeVide = new ArrayList<>();
        
        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                if (grille[i][j].getValeur()==0) {
                    listeVide.add(grille[i][j]);
                }
            }
        }
        
        if (listeVide.isEmpty()) {
            return false;
        }
        
        Case tmp=listeVide.get((int) (Math.random() * listeVide.size()));
        
        
        if ((int) (Math.random() * 10)>=3) {
            grille[tmp.getLigne()][tmp.getColonne()].setValeur(2);
        }
        else{
            grille[tmp.getLigne()][tmp.getColonne()].setValeur(4);
        }
        return true;
    }
    
    private ArrayList<Case> ListeSansNullHorizontal(int i){
        ArrayList<Case> tmp=new ArrayList<>();
        for (int j = 0; j < taille; j++) {
            if (grille[i][j].getValeur()!=0) {
                tmp.add(grille[i][j]);
            }
            
        }
        return tmp;
    }
    
    private ArrayList<Case> ListeSansNullVertical(int i){
        ArrayList<Case> tmp=new ArrayList<>();
        for (int j = 0; j < taille; j++) {
            //System.out.print(grille[j][i].getValeur());
            if (grille[j][i].getValeur()!=0) {
                tmp.add(grille[j][i]);
            }
        }
        
        return tmp;
    }
    
   public void pousserGauche(){
        ArrayList<Case>[] tmp=new ArrayList[taille]; //tableau de liste de case
        for (int i = 0; i < taille; i++) {
            tmp[i]=ListeSansNullHorizontal(i);
        }
        for(ArrayList<Case> ligne:tmp){
            for (int i = 0; i < ligne.size()-1; i++) {
                if (ligne.get(i).getValeur()==ligne.get(i+1).getValeur()) {
                    ligne.get(i).setValeur(ligne.get(i).getValeur()*2);
                    ligne.remove(i+1);
                }

            }
        }
       
        for(ArrayList<Case> ligne:tmp){
            for (int i = ligne.size(); i < taille; i++) {
                ligne.add(new Case(0,0));
            }
        }

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                tmp[i].get(j).setLigne(i);
                tmp[i].get(j).setColonne(j);
                grille[i][j]=tmp[i].get(j);
            }
        }
    }
    
    public void pousserHaut(){
        ArrayList<Case>[] tmp=new ArrayList[taille]; //tableau de liste de case
        for (int i = 0; i < taille; i++) {
            tmp[i]=ListeSansNullVertical(i);
        }
        

        
        
        for(ArrayList<Case> ligne:tmp){
            for (int i = 0; i < ligne.size()-1; i++) {
                if (ligne.get(i).getValeur()==ligne.get(i+1).getValeur()) {
                    ligne.get(i).setValeur(ligne.get(i).getValeur()*2);
                    ligne.remove(i+1);
                }

            }
        }
       
        for(ArrayList<Case> ligne:tmp){
            for (int i = ligne.size(); i < taille; i++) {
                ligne.add(new Case(0,0));
            }
        }

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                tmp[i].get(j).setLigne(j);
                tmp[i].get(j).setColonne(i);
                grille[i][j]=tmp[j].get(i);
            }
        }
    }
    
     public void pousserBas(){
         ArrayList<Case>[] tmp=new ArrayList[taille]; //tableau de liste de case
        for (int i = 0; i < taille; i++) {
            tmp[i]=ListeSansNullVertical(i);
        }
        

        
        
        for(ArrayList<Case> ligne:tmp){
            for (int i = ligne.size()-1; i >=1 ; i--) {
                if (ligne.get(i).getValeur()==ligne.get(i-1).getValeur()) {
                    ligne.get(i).setValeur(ligne.get(i).getValeur()*2);
                    ligne.remove(i-1);
                    ligne.add(0, new Case(0,0));
                }

            }
        }
       
        for(ArrayList<Case> ligne:tmp){
            for (int i = ligne.size(); i < taille; i++) {
                ligne.add(0,new Case(0,0));
            }
        }

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                tmp[i].get(j).setLigne(j);
                tmp[i].get(j).setColonne(i);
                grille[i][j]=tmp[j].get(i);
            }
        }
    }
     
     public void pousserDroite(){
         ArrayList<Case>[] tmp=new ArrayList[taille]; //tableau de liste de case
        for (int i = 0; i < taille; i++) {
            tmp[i]=ListeSansNullHorizontal(i);
        }
        for(ArrayList<Case> ligne:tmp){
            for (int i = ligne.size()-1; i >=1 ; i--) {
                if (ligne.get(i).getValeur()==ligne.get(i-1).getValeur()) {
                    ligne.get(i).setValeur(ligne.get(i).getValeur()*2);
                    ligne.remove(i-1);
                    ligne.add(0, new Case(0,0));
                }

            }
        }
       
        for(ArrayList<Case> ligne:tmp){
            for (int i = ligne.size(); i < taille; i++) {

                ligne.add(0, new Case(0,0));
            }
        }

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                tmp[i].get(j).setLigne(i);
                tmp[i].get(j).setColonne(j);
                grille[i][j]=tmp[i].get(j);
            }
        }
    }
    
     public int getTaille() {
        return taille;
    }
     
     public Case getCase(int i,int j){
         //a modifier
         return grille[i][j];
     }
     
    /**
     *
     * @return
     */
    @Override
     public String toString(){
         String tmp="";
         
         for(Case[] g1:grille){
             for(Case g2:g1){
                 if (g2.getValeur()==0) {
                     tmp+="_|";
                 }
                 else{
                     tmp+=g2.getValeur()+"|";
                 }
                 
             }
             tmp+="\n";
         }
         
         return tmp;
     }
}
