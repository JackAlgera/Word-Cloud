/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuagedemots;

import WordCloud.WordShape;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.util.ArrayList;

/**
 *
 * @author jalgera
 */
public class WordGraph {
    
    //Attributs
    private Graphics2D fenetre;
    private WordShape word;
    
    //Constructeur
    public WordGraph(Mot mot, Font f, Graphics2D fenetre){
        this.fenetre=fenetre;
        this.word = new WordShape(mot.getMot(),0,0,0,f, new Color(0,0,0));
    }

    public void setFenetre(Graphics2D fenetre) {
        this.fenetre = fenetre;
    }
    
    public WordGraph(Mot mot, Font f, Graphics2D fenetre, int taille){
        this.fenetre=fenetre;
        this.word = new WordShape(mot.getMot(),0,0,0,new Font(f.getFontName(),f.getStyle(),taille), new Color(0,0,0));
    }
    
    public WordGraph(Mot mot, Font f, Graphics2D fenetre, int taille, Color couleur){
        this.fenetre=fenetre;
        this.word = new WordShape(mot.getMot(),0,0,0,new Font(f.getFontName(),f.getStyle(),taille), couleur);
    } 
    
    public void setXY(double X, double Y){
        this.word.setPosition((int)X,(int) Y);
    }
    
    public Shape getShape(){
        return this.word.getShape();
    }
    
    public void drawWord(){
        this.fenetre.setColor(this.word.getColor());
        this.fenetre.fill(this.word.getShape());
    }
    
    public void setCouleur(Color c){
        this.word.setCouleur(c);
    }
    
    public boolean estEnConflit(WordGraph w){
        return this.word.estEnConflit(w.word);
    }
    
    public boolean estDans(Shape shape){
        return this.word.estDans(shape);
    }

    @Override
    public String toString() {
        return "WordGraph{" + "word=" + word + '}';
    }  
}
