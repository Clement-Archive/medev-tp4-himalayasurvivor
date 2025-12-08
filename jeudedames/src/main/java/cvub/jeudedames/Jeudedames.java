/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cvub.jeudedames;

import java.io.IOException;

/**
 *
 * @author Clément
 */
public class Jeudedames {

    public static void main(String[] args) throws IOException {
        
        Jeu jeu = new Jeu();
        jeu.initJeu();
        
//        Sauvegarde s = new Sauvegarde();
//        jeu.getJ1().add(new Pion(new Case(3,3), true));
//        s.save(jeu, "1.dame");
//        jeu.getJ1().get(0).setDame(false);
//        System.out.println("estDame : " + jeu.getJ1().get(0).isDame());
//        jeu = s.load("1.dame");
//        System.out.println("J1 length : " + jeu.getJ1().size());
//        System.out.println("Ok");
//        System.out.println("estDame : " + jeu.getJ1().get(0).isDame());

        Ui ui = new Ui();
        ui.displayJeu(jeu);
    }
}
