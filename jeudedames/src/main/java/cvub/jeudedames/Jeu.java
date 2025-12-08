/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvub.jeudedames;

import java.util.ArrayList;

/**
 *
 * @author utaab
 */
public class Jeu {
    private ArrayList<Pion> J1;
    private ArrayList<Pion> J2;
    
    public void initJeu(){
        for (int y = 0; y<4; y++) {
            for (int x = 0; x<5; x++) {
                this.J1.add(new Pion(new Case(x,y)));
                this.J2.add(new Pion(new Case(x,y+6)));
            }
        }
    }

    public ArrayList<Pion> getJ1() {
        return J1;
    }

    public void setJ1(ArrayList<Pion> J1) {
        this.J1 = J1;
    }

    public ArrayList<Pion> getJ2() {
        return J2;
    }

    public void setJ2(ArrayList<Pion> J2) {
        this.J2 = J2;
    }
    
    public Jeu(ArrayList<Pion> J1, ArrayList<Pion> J2) {
        this.J1 = J1;
        this.J2 = J2;
    }
}
