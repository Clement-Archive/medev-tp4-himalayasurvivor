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
public class Ui {
    
    public void uiTourDeJeu(Jeu jeu, boolean tourDuJoueur1)
    {
        displayJeu(jeu);
        System.out.println("Tour du joueur " + (tourDuJoueur1?"1":"2"));
        System.out.println("Sélectionnez votre pion");
        Case caseSelec = inputCase();
    }
    
    public void displayJeu(Jeu jeu) //un X pour les noirs et un O pour les blancs
    {
        //-----------------affichage top-----------------
        System.out.println("      1   2   3   4   5   ");
        
        //----------------affichage lignes----------------
        boolean ligneStartCaseBlanche = true;
        List<String> legendLignes = Arrays.asList("5 "," 6","15","16","25","26","35","36","45","46");
        
        int nbLignes = 10;
        for(int iLigne = 0;iLigne<nbLignes;iLigne++)
        {
            System.out.print(!ligneStartCaseBlanche?legendLignes.get(iLigne) + " ":"   | ");
            //affichage ligne
            int nbCol = 5;
            for (int iCol = 0; iCol < nbCol; iCol++) {
                int dataCase = jeu.dataTile(new Case(iCol,iLigne));
                if(dataCase==0){System.out.print("| |");}
                if(dataCase==1){System.out.print("|O|");}
                if(dataCase==2){System.out.print("|X|");}
                if(iCol<nbCol-1) {System.out.print(" ");}
            }
            
            System.out.println(ligneStartCaseBlanche?" "+legendLignes.get(iLigne):" |   ");
            //if(iLigne<nbLignes-1) {System.out.println("  ---------------------  ");}
            
            ligneStartCaseBlanche=!ligneStartCaseBlanche;
        }
        
        //----------------affichage bottom----------------
        System.out.println("   46  47  48  49  50     ");
    }    
    
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
