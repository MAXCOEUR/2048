/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vue;

import Modele.Grille;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Maxen
 */
public class MaFenetre extends JFrame {
    VueGrille vu;

    public MaFenetre(Grille g) {
        vu=new VueGrille(g);
        
        
        this.setTitle("2048");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setLocationRelativeTo(null);

        //on place les éléments
        JPanel pano=new JPanel();
        pano.setLayout(new GridBagLayout());
        GridBagConstraints gc=new GridBagConstraints();
        gc.fill=GridBagConstraints.BOTH;
        //on place le composant perso (on le gère comme tout autre composant)
        gc.gridx=0;
        gc.gridy=0;
        pano.add(vu);
        
        

        this.setContentPane(pano);
        this.pack();
        
        
        
        //mettre les acouteur ici
        this.addKeyListener(vu);
        
        this.addComponentListener(vu);
    }
    
    
    
}
