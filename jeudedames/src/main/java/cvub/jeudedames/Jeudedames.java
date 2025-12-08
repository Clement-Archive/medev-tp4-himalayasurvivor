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
        
        Ui ui = new Ui();
        ui.displayJeu(jeu);
        
        
        
    }
}
