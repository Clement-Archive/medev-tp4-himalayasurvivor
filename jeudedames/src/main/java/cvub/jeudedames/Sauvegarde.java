/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvub.jeudedames;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author utaab
 */
public class Sauvegarde {
    private String pathDir;
    
    public Sauvegarde() {
        this.pathDir = "parties";
    }
    
    public String pionToString(Pion p) {
        Case c = p.getC();
        if (p.isDame()) {
            return 'D' + p.get
        } else {
        }
    }
    
    public boolean save(Jeu jeu, String file_name) throws IOException, FileNotFoundException {
        File dir = new File(this.pathDir);
        if (dir.isDirectory()) {}
        
        String[] files = dir.list();
        for (String file : files) {
            if (file_name.equals(file)) {
                System.out.println("Ce nom de sauvegarde est deja utilise. Vous vouliez remplacer ? [Y|n]");
                try (Scanner sc = new Scanner(System.in)) {
                    String reponse = sc.nextLine().trim().toLowerCase();

                    switch (reponse) {
                        case "y", "yes" -> {
                            System.out.println("Le fichier sera remplacé.");
                        }   
                        default -> {
                            System.out.println("Le fichier ne sera pas sauvegarder.");
                            return false;
                        }
                    }
                }
            }
        }
        
        String file_path = this.pathDir + file_name;
        BufferedWriter bufferedWriter=null;

        // on attrape l'exception si il y a un probleme lors de l'ecriture
        bufferedWriter = new BufferedWriter(new FileWriter(file_path));

        // On ecrit dans le fichier
        for(Pion p : jeu.getJ1()) {
            bufferedWriter.write(pionToString(p));
        }
        bufferedWriter.newLine();
        for(Pion p : jeu.getJ2()) {
            bufferedWriter.write(pionToString(p));
        }

        if (bufferedWriter!=null) {
            // je force l'écriture dans le fichier
            bufferedWriter.flush();
            // puis je le ferme
            bufferedWriter.close();
        }
        
        return false;
    }

    public String getPath() {
        return pathDir;
    }

    public void setPath(String pathDir) {
        this.pathDir = pathDir;
    }
    
    public Sauvegarde(String pathDir) {
        this.pathDir = pathDir;
    }
}
