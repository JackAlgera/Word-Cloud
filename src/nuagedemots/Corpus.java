/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuagedemots;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author jalgera
 */
public class Corpus {
    private ArrayList <Mot> listeMot;
    
    public Corpus(String text){
        listeMot = new ArrayList <Mot> ();
        this.lectureFichier(text);
    }

    public ArrayList<Mot> getListeMot() {
        return listeMot;
    }

    public void setListeMot(ArrayList<Mot> listeMot) {
        this.listeMot = listeMot;
    }
    
    public void ajouterMot(Mot mot){
        this.listeMot.add(mot);
    }
   
    public String toString() {
        String string = "";
        for (int i=0; i<this.listeMot.size();i++){
            string = string + this.listeMot.get(i).getMot() + " ";  
        }
        return string;
    }
    

    public void enMinuscule(){                                          //Réécrire tous les mots du corpus en minuscules
        for(int i=0; i<this.listeMot.size();i++){
            this.listeMot.get(i).setMot(this.listeMot.get(i).getMot().toLowerCase());
        }
    }
    
    
    public ArrayList<Mot> premierTrieDuCorpus(ArrayList<String> motsIndesirables){   //Trie le corpus, en enlevant les mots d'une taille inférieure strictement à 3 lettres et ceux de la liste motsIndésirables
        ArrayList<Mot> motsDesirables = new ArrayList<Mot>();
        for (int i=0; i<this.listeMot.size() ; i++){
            String motActuel = this.listeMot.get(i).getMot();
            
            if (!(motActuel.equals("") || ((motActuel.length() < 3) && !(motActuel.equals("os") || motActuel.equals("nu"))) || motsIndesirables.contains(motActuel))){
                
                Mot mot = new Mot(motActuel);
                
                if (motsDesirables.contains(mot)){
                    int indiceDuMotActuel = this.listeMot.indexOf(mot);
                    this.listeMot.get(indiceDuMotActuel).incrementationFrequence();
                } else {
                    this.listeMot.get(i).setMot(motActuel);
                    motsDesirables.add(this.listeMot.get(i));
                }
            }    
        }
        
        return motsDesirables;      
    }
    
    public void lectureFichier (String file){  //Ajouter tous les mots d'un texte dans le corpus, en les triant par leur frequence d'apparition
        try {
            BufferedReader fichier = new BufferedReader (new FileReader (file));
            while (fichier.ready()) {
                int compteur = 0;  
                String ligne = fichier.readLine() + " ";
                for (int i=0; i<ligne.length(); i++){
                    String lettre = ligne.substring(i, i+1);
                    if (lettre.equals(" ") || lettre.equals(".") || lettre.equals(",") || lettre.equals(";") || lettre.equals("!") || lettre.equals("?") || lettre.equals(":") || lettre.equals("(") || lettre.equals(")") || lettre.equals("'") || lettre.equals("-")){
                        this.listeMot.add(new Mot(ligne.substring(i-compteur, i)));
                        compteur = 0;
                    }
                    else {
                        compteur ++;
                    }
                    
                }
            }
            fichier.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        this.enMinuscule();                                                         //Rend tout les lettres de chaque mot en minuscule
        
        ArrayList<String> motsIndesirableString = new ArrayList<String>(Arrays.asList("donc","ces","celle","ont","ses","son","aux","celles","tout","pour","des","dont","qui","était","les","toi","sur","est","tes","plus","par","surtout",
                                                                                      "puis","abord","ensuite","enfin","une","part","autre","non","seulement","mais","avec","quant","que","premierement","ensuite","cependant","toutefois"
                                                                                      ,"pourtant","néanmoins","malgré","sauf","hormis","tandis","pendant","alors","quel","parce","autant","étant","ainsi","mon","ton","elle","elles","ils",
                                                                                      "nous","vous","cet","cette","cela","entre","dans"));
        
        ArrayList<Mot> motsDesirableString = this.premierTrieDuCorpus(motsIndesirableString);
        
        this.setListeMot(motsDesirableString); 
        Collections.sort(this.listeMot,Collections.reverseOrder());
    } 
}
