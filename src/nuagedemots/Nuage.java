/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuagedemots;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.util.ArrayList;

/**
 *
 * @author jalgera
 */
public class Nuage {    
    private Corpus corpus;                                                      
    private ArrayList<WordGraph> corpusEnWordGraph;                             //Création d'une ArrayList en WordGraph pour simplifier l'utilisation des mots                
    private Frame fenetre;
    private Graphics2D g2d;
    private Font font;
    
    public Nuage(Corpus c, int tailleFenetreX, int tailleFenetreY){
        this.font = new Font("Font de Base", Font.PLAIN, 30) ;
        this.fenetre = new Frame("Nuage de Mots");
        this.fenetre.setSize(tailleFenetreX, tailleFenetreY);
        this.fenetre.setVisible(true);
        this.g2d = (Graphics2D) this.fenetre.getGraphics();
        this.g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        this.corpus = c;
        this.corpusEnWordGraph = new ArrayList<WordGraph>();
        for(int i = 0; i<this.corpus.getListeMot().size(); i++){
            this.corpusEnWordGraph.add(new WordGraph(this.corpus.getListeMot().get(i),this.font,this.g2d));
        }
    }

    public void setG2d(Graphics2D g2d) {
        this.g2d = g2d;
    }
    
    public void setCorpus(String text){
        this.corpus.lectureFichier(text);
    }
    
    public Corpus getCorpus(){
        return this.corpus;
    }
    
    public Graphics2D getG2D(){
        return this.g2d;
    }
     
    public ArrayList<Point> listePointsSpirale(int posX, int posY, double rayonMax, int accroissementParTour){      //Création de la ArrayList de Points sous forme d'une spirale
        double angle = 0.0;                                                                                         //qui seront l'endroit de placement des mots
        double rayon = 0.0;
        double x = 0;
        double y = 0;
        
        ArrayList<Point> listePointsSpirale = new ArrayList<Point>();
        listePointsSpirale.add(new Point((int)x,(int)y));
       
        while (rayon < rayonMax){
            double xPrecedent = x;
            double yPrecedent = y;
            
            x = rayon*Math.cos(angle);
            y = rayon*Math.sin(angle);
            
            rayon += (double)accroissementParTour/360;
            angle = angle + Math.PI/90;
            
            Point nouveauPoint = new Point((int)x + posX,(int) y + posY);
            
            if(!(nouveauPoint.equals(listePointsSpirale.get(listePointsSpirale.size()-1)))){
                listePointsSpirale.add(nouveauPoint);
            }
            
        }
        listePointsSpirale.remove(0);
        return listePointsSpirale;
    }
    
    public void afficherCorpus(ArrayList<Point> listePointsSpirale){                //Affichage du corpus en suivant l'ordre des points de l'ArrayList spirale
        ArrayList<WordGraph> motsDejaPlace = new ArrayList<WordGraph>();

        WordGraph motActuel = this.corpusEnWordGraph.get(0);
        Point point = listePointsSpirale.get(0);
        int decalageX = (int) motActuel.getShape().getBounds().getWidth()/2;
        int decalageY = (int) motActuel.getShape().getBounds().getHeight()/2;
        motActuel.setXY(point.getX()-decalageX, point.getY()-decalageY);
        motActuel.drawWord();
        motsDejaPlace.add(motActuel);
        int j=0;        
        
        for(int i=1; i<this.corpus.getListeMot().size(); i++){                          // i parcrout la liste des mots du corpus
                                                                  
            motActuel = this.corpusEnWordGraph.get(i);
            boolean peutPlacerMot = true;
            boolean motPlace = false;
            
            while(j<listePointsSpirale.size() && !motPlace){                            // j parcourt la liste des points de la spirale
                point = listePointsSpirale.get(j);
                motActuel.setXY(point.getX()-decalageX, point.getY()-decalageY);
                int k = 0;
                while (k < motsDejaPlace.size() && peutPlacerMot ){                     //k parcourt la liste des mots deja placés
                    if(motActuel.estEnConflit(motsDejaPlace.get(k))){
                        peutPlacerMot = false;
                    } else {
                        k++;
                    }
                    
                }
                if (peutPlacerMot){
                    motActuel.drawWord();
                    motsDejaPlace.add(motActuel);
                    motPlace = true;
                } else {
                    peutPlacerMot = true;
                    j++;
                }
            }
        }    
    }
    
    public void afficherCorpusAleatoirement(ArrayList<Point> listePointsSpirale){           //Affichage du corpus en prenant un point aléatoire de l'ArrayList spirale
        ArrayList<WordGraph> motsDejaPlace = new ArrayList<WordGraph>();
        
        WordGraph motActuel = this.corpusEnWordGraph.get(0);
        Point point = listePointsSpirale.get(0);
        motActuel.setXY(point.getX()-motActuel.getShape().getBounds2D().getWidth()/2, point.getY()-motActuel.getShape().getBounds2D().getHeight()/2);
        motActuel.drawWord();
        motsDejaPlace.add(motActuel);
                
        
        for(int i=1; i<this.corpus.getListeMot().size(); i++){                          // i parcrout la liste des mots du corpus
            motActuel = this.corpusEnWordGraph.get(i);
            boolean peutPlacerMot = true;
            boolean motPlace = false;
            int limite = 0;
            
            while(limite < 100 && !motPlace){                                           // j désigne un point aléatoire de la spirale
                int j=(int)(Math.random()*listePointsSpirale.size());
                point = listePointsSpirale.get(j);
                motActuel.setXY(point.getX(), point.getY());
                int k = 0;
                while (k < motsDejaPlace.size() && peutPlacerMot ){                     //k parcourt la liste des mots deja placés
                    if(motActuel.estEnConflit(motsDejaPlace.get(k))){
                        peutPlacerMot = false;
                    } else {
                        k++;
                    }
                    
                }
                if (peutPlacerMot){
                    motActuel.drawWord();
                    motsDejaPlace.add(motActuel);
                    motPlace = true;
                } else {
                    peutPlacerMot = true;
                    j=(int)(Math.random()*listePointsSpirale.size());
                }
                limite ++;
            }
        } 
    }
    
    public void changerTailleMotsEtCouleur(int tailleMin, int tailleMax, String couleur){           //Change les tailles minimale et maximale et la couleur des mots du corpus
        ArrayList<Integer> listeFreqDuCorpus = new ArrayList<Integer>();             
        for (int i=0; i<this.corpus.getListeMot().size(); i++){
            int freqDuMotActuel = this.corpus.getListeMot().get(i).getFrequence();
            if (!listeFreqDuCorpus.contains(freqDuMotActuel)){
                listeFreqDuCorpus.add(freqDuMotActuel);                                             //On change la taille du mot proportionnellement à sa fréquence d'apparition
            }
        }
        
        int freqMax = listeFreqDuCorpus.get(0);
        if (couleur.equals("ROUGE")){
            this.corpusEnWordGraph.set(0, new WordGraph(this.corpus.getListeMot().get(0),this.font,this.g2d, tailleMax, new Color(255,0,0)));
        } else if (couleur.equals("VERT")){
            this.corpusEnWordGraph.set(0, new WordGraph(this.corpus.getListeMot().get(0),this.font,this.g2d, tailleMax, new Color(0,255,0)));
        } else if (couleur.equals("BLEU")) {
            this.corpusEnWordGraph.set(0, new WordGraph(this.corpus.getListeMot().get(0),this.font,this.g2d, tailleMax, new Color(0,0,255)));
        } else if (couleur.equals("NOIR")) {
            this.corpusEnWordGraph.set(0, new WordGraph(this.corpus.getListeMot().get(0),this.font,this.g2d, tailleMax, new Color(0,0,0)));
            for (int i=1; i<this.corpus.getListeMot().size(); i++){
                Mot motActuel = this.corpus.getListeMot().get(i);
                int tailleDuMotActuel =(int) (((double)motActuel.getFrequence()/(double)freqMax)*(tailleMax-tailleMin) + tailleMin);
                this.corpusEnWordGraph.set(i, new WordGraph(motActuel, this.font, this.g2d, tailleDuMotActuel, new Color(0,0,0)));
            }
        }
        if (!couleur.equals("NOIR")){                                           //Si la couleur n'est pas noir, on change la couleur des mots en nuance de la couleur choisie
            for (int i=1; i<this.corpus.getListeMot().size(); i++){
                Mot motActuel = this.corpus.getListeMot().get(i);
                int tailleDuMotActuel =(int) (((double)motActuel.getFrequence()/(double)freqMax)*(tailleMax-tailleMin) + tailleMin);
                this.corpusEnWordGraph.set(i, new WordGraph(motActuel, this.font, this.g2d, tailleDuMotActuel, this.nuanceCouleur(couleur)));
            }
        }
                
    }
    
    public void changerTailleMotsAvecCouleursAleatoire(int tailleMin, int tailleMax){           //Chaque mot a une couleur aléatoire
        ArrayList<Integer> listeFreqDuCorpus = new ArrayList<Integer>();            
        for (int i=0; i<this.corpus.getListeMot().size(); i++){
            int freqDuMotActuel = this.corpus.getListeMot().get(i).getFrequence();
            if (!listeFreqDuCorpus.contains(freqDuMotActuel)){
                listeFreqDuCorpus.add(freqDuMotActuel);
            }
        }
        
        int freqMax = listeFreqDuCorpus.get(0);
        
        for (int i=0; i<this.corpus.getListeMot().size(); i++){
            Mot motActuel = this.corpus.getListeMot().get(i);
            int tailleDuMotActuel =(int) (((double)motActuel.getFrequence()/(double)freqMax)*(tailleMax-tailleMin) + tailleMin);
            this.corpusEnWordGraph.set(i, new WordGraph(motActuel, this.font, this.g2d, tailleDuMotActuel, this.randomCouleur()));
        }
                
    }
    
    
    public Color randomCouleur (){                  //Créer une couleur aléatoire
        int R,B,G;
        int troisiemeCouleur =(int)(Math.random()*3);
        if (troisiemeCouleur == 3){
            R = (int) (Math.random()*255);
            G = (int) (Math.random()*255);
            if(R<200 && G<200){
                B = (int) (Math.random()*255);
            } else {
                B = (int) (Math.random()*200);
            }
        } else if (troisiemeCouleur == 2){
            R = (int) (Math.random()*255);
            B = (int) (Math.random()*255);
            if(R<200 && B<200){
                G = (int) (Math.random()*255);
            } else {
                G = (int) (Math.random()*200);
            }
        } else {
            G = (int) (Math.random()*255);
            B = (int) (Math.random()*255);
            if(G<200 && B<200){
                R = (int) (Math.random()*255);
            } else {
                R = (int) (Math.random()*200);
            }
        }
        return new Color(R,G,B);
    }
    
    public Color nuanceCouleur (String couleur){            //Créer une nuance aléatoire d'une couleur donnée
        int R,B,G;
        if (couleur.equals("ROUGE")){
            R = (int) (Math.random()*255);
            G = 0;
            B = 0;
        } else if (couleur.equals("VERT")){
            R = 0;
            G = (int) (Math.random()*255);
            B = 0;
        } else {
            R = 0;
            G = 0;
            B = (int) (Math.random()*255);
        }
        return new Color(R,G,B);
    }
    
  
    
    public void setFreqMin(int freqMin){                                           //Enleve les mots dont la fréquence est inférieure à la fréquence minimale choisie
        ArrayList<Mot> tempArray = new ArrayList<Mot>();
        for(int i=0; i<this.corpus.getListeMot().size(); i++){
            if (this.corpus.getListeMot().get(i).getFrequence() >= freqMin){
                tempArray.add(this.corpus.getListeMot().get(i));
            }
        }
        this.corpus.setListeMot(tempArray);
    } 
}
