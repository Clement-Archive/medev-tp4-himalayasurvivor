/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cvub.jeudedames;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
    
    public void createDirIfNotExists() {
        File dir = new File(this.pathDir);

        if (!dir.exists()) {
            try {
                if (dir.mkdirs()) {
                    System.out.println("Directory created: " + dir.getAbsolutePath());
                } else {
                    System.out.println("Failed to create directory.");
                }
            } catch (SecurityException e) {
                System.err.println("Permission denied: cannot create directory.");
            }
        }
    }
    
    public String pionToString(Pion p) {
        Case c = p.getC();
        String sc = String.valueOf(c.getX()) + String.valueOf(c.getY());
        if (p.isDame()) {
            return 'D' + sc + " ";
        } else {
            return 'P' + sc + " ";
        }
    }
    
    public ArrayList<Pion> stringToPion(String s) {
        ArrayList<Pion> J = new ArrayList<>();
        if (s != null) {
            int i = 0;
            while(i+2<s.length()) {
                int x = (int) s.charAt(i+1) - '0';
                int y = (int) s.charAt(i+2) - '0';
                if (s.charAt(i) == 'P') {
                    J.add(new Pion(new Case(x,y)));
                } else {
                    J.add(new Pion(new Case(x,y), true));
                }
                i = i+3;
            }
        }
        return J;
    }
    
    public boolean save(Jeu jeu, String file_name) {
        
        createDirIfNotExists();
        File dir = new File(this.pathDir);
        
        String[] files = dir.list();
        for (String file : files) {
            if (file_name.equals(file)) {
                System.out.println("Ce nom de sauvegarde est deja utilise. Vouliez vous remplacer ? [Y/n]");
                try (Scanner sc = new Scanner(System.in)) {
                    String reponse = sc.nextLine().trim().toLowerCase();
                    switch (reponse) {
                        case "y", "yes" -> {
                            System.out.println("Le fichier sera remplacé.");
                        }   
                        default -> {
                            System.out.println("Le fichier ne sera pas sauvegarde.");
                            return false;
                        }
                    }
                }
            }
        }
        
        String file_path = this.pathDir + "/" + file_name;
        BufferedWriter bufferedWriter=null;
        
        try {
            // on attrape l'exception si il y a un probleme lors de l'ecriture
            bufferedWriter = new BufferedWriter(new FileWriter(file_path));

            // On ecrit dans le fichier
            bufferedWriter.write(String.valueOf(jeu.getTourDeJeu()));
            bufferedWriter.newLine();
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
        }
        // on attrape l'exception si il y a un probleme lors de l'ecriture
        catch (IOException ex) {
            System.out.println("Exception : " + ex);
            return false;
        }
        return true;
    }
    
    public Jeu load(String file_name) {
        
        Jeu jeu = new Jeu();
        String file_path = this.pathDir + "/" + file_name;
        File file = new File(file_path);
        FileReader reader=null;
        try{
            reader = new FileReader(file);
        }
        catch(IOException e){
            System.out.println("erreur de lecture du fichier");
            return jeu;
        }
        try {
            
            BufferedReader buffReader = new BufferedReader(reader);
            
            String l0 = buffReader.readLine();
            jeu.setTourDeJeu(Integer.parseInt(l0));
            
            String l1 = buffReader.readLine();
            jeu.setJ1(stringToPion(l1));
            
            String l2 = buffReader.readLine();
            jeu.setJ2(stringToPion(l2));
        }
        catch(IOException e){
            System.out.println("erreur de lecture du fichier");
            return jeu;
        }
        return jeu;
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
