/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pkg2048;

import Modele.Grille;
import Vue.MaFenetre;




/**
 *
 * @author eric.duchene
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Grille g =new Grille(4);
        MaFenetre fen=new MaFenetre(g);
        
        fen.setVisible(true);
    }
    
}
