/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvub.jeudedames;

/**
 *
 * @author Clément
 */
public class Case {
    
    private int x; //between 0 and 4    
    private int y; //between 0 and 9


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    public Case(int coordUI)
    {
        coordUI--;
        this.x = coordUI % 5;
        this.y = coordUI % 5;
    }
    
    public Case(int ix, int iy)
    {
        this.x=ix;
        this.y=iy;
    }
}
