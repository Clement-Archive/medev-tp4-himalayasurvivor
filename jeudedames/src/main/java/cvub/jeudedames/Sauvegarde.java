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

    public Sauvegarde(String pathDir) {
        this.pathDir = pathDir;
    }
    
    public void save(String file_name) throws IOException, FileNotFoundException {
        File dir = new File(this.pathDir);
        if (dir.isDirectory()) {}
        
        String[] files = dir.list();
        for (String file : files) {
            if (file_name.equals(file)) {
                System.out.println("Ce nom de sauvegarde est deja utilise. Vous vouliez remplacer ? [Y|n]");
                Scanner sc = new Scanner(System.in);
                
            }
        }
        
        String path_file = this.pathDir + file_name;
        
        BufferedWriter bufferedWriter=null;

        bufferedWriter = new BufferedWriter(new FileWriter(path_file)); // on attrape l'exception si il y a un probleme lors de l'ecr
        // On ecrit dans le fichier
        for(ElementDeJeu e : elementsDeJeu) {
            bufferedWriter.write(elementDeJeuToString(e));
            bufferedWriter.newLine();
        }
        if (bufferedWriter!=null) {
            // je force l'écriture dans le fichier
            bufferedWriter.flush();
            // puis je le ferme
            bufferedWriter.close();
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
