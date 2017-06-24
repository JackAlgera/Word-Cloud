/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nuagedemots;

import java.util.Objects;

/**
 *
 * @author jalgera
 */
public class Mot implements Comparable {
    //Attributs
    private String mot;
    private int frequence;

    public Mot(String mot) {
        this.mot = mot;
        this.frequence = 1;
    }    
    
    public String getMot() {
        return mot;
    }

    public int getFrequence() {
        return frequence;
    }

    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }
    
    public void incrementationFrequence(){
        this.frequence = this.getFrequence() + 1;
    }

    public void setMot(String mot) {
        this.mot = mot;
    }
    
    
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mot other = (Mot) obj;
        if (!Objects.equals(this.mot, other.mot)) {
            return false;
        }
        return true;
    }
    
    public int compareTo(Object obj){
        Mot mot = (Mot) obj;
        if (this.frequence<mot.getFrequence())
            return -1;
        else if (this.frequence>mot.getFrequence())
            return 1;
        else 
            return 0;
                
    } 
}
