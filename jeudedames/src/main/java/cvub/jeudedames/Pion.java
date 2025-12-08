/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvub.jeudedames;

/**
 *
 * @author utaab
 */
public class Pion {
    private Case c;
    private boolean dame;

    public Pion(Case c) {
        this.c = c;
        this.dame = false;
    }
    
    public Pion(Case c, boolean dame) {
        this.c = c;
        this.dame = dame;
    }

    public boolean isDame() {
        return dame;
    }

    public void setDame(boolean dame) {
        this.dame = dame;
    }

    public Case getC() {
        return c;
    }

    public void setC(Case c) {
        this.c = c;
    }
    
    
}
