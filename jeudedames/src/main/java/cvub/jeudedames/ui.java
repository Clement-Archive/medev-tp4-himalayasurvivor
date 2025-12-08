/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvub.jeudedames;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Clément
 */
public class ui {
    
    public void uiTourDeJeu(boolean tourDuJoueur1)
    {
        
    }
    
    public void
    
    private Case inputCase()
    {
        Scanner sc = new Scanner(System.in);
        int inputCaseID = 0;
        
        while (true)
        {
            System.out.println("Veuillez entrer une case valide (1-50)");
            if (sc.hasNextInt()) {
                inputCaseID = sc.nextInt();
                if(inputCaseID <51 && inputCaseID >0)
                {
                    return new Case(inputCaseID);
                }
                System.out.println("Entree invalide ! Veuillez entrer un nombre entre 1 et 50");
            } else {
                System.out.println("Entree invalide ! Veuillez entrer un nombre");
                sc.next();
            }
        }

    }
}
