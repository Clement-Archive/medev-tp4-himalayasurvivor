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
    private int tourDeJeu;
    
    public void initJeu(){
        for (int y = 0; y<4; y++) {
            for (int x = 0; x<5; x++) {
                this.J1.add(new Pion(new Case(x,y)));
                this.J2.add(new Pion(new Case(x,y+6)));
            }
        }
    }
    
    public boolean coupValide(Case inTile, Case outTile) {
        int inData = dataTile(inTile);
        int outData = dataTile(outTile);
        int inType = typeTile(inTile);
        int outType = typeTile(outTile);
        
        // case deja occupe
        if (outData != 0) {return false; }
        
        return true;
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

    public int getTourDeJeu() {
        return tourDeJeu;
    }

    public void setTourDeJeu(int tourDeJeu) {
        this.tourDeJeu = tourDeJeu;
    }
    
    public Jeu() {
        this.J1 = new ArrayList<>();
        this.J2 = new ArrayList<>();
        this.tourDeJeu = 0;
    }
    
    public Jeu(ArrayList<Pion> J1, ArrayList<Pion> J2, int tourDeJeu) {
        this.J1 = J1;
        this.J2 = J2;
        this.tourDeJeu = tourDeJeu;
    }
    
    // 0 if free, 1 if P1, 2 if P2
    public int dataTile(Case c)
    {
        for (Pion pion : J1) {
            if(pion.getC().equals(c)) {return 1;}
        }
        for (Pion pion : J2) {
            if(pion.getC().equals(c)) {return 2;}
        }
        return 0;
    }
    
    // 0 if free, 1 if P, 2 if d
    public int typeTile(Case c)
    {
        for (Pion pion : J1) {
            if (pion.getC().equals(c)) {
                if (pion.isDame()) {
                    return 2;
                } else {
                    return 1;
                }
            }
        }
        for (Pion pion : J2) {
            if (pion.getC().equals(c)) {
                if (pion.isDame()) {
                    return 2;
                } else {
                    return 1;
                }
            }
        }
        return 0;
    }
}
