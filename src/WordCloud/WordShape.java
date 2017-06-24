/*
 * Projet d'informatique : Initiation à la programmation objet
 * 
 * __        __            _  ____ _                 _ 
 * \ \      / /__  _ __ __| |/ ___| | ___  _   _  __| |
 *  \ \ /\ / / _ \| '__/ _` | |   | |/ _ \| | | |/ _` |
 *   \ V  V / (_) | | | (_| | |___| | (_) | |_| | (_| |
 *    \_/\_/ \___/|_|  \__,_|\____|_|\___/ \__,_|\__,_|
 *                                                     
 * Auteur : C. Varnier
 *
 */

package WordCloud;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 *
 * @author C Varnier
 */
public class WordShape {
    private Shape forme;
    private Color couleur;

    /**
     * construit une forme à partir de la chaine de caractères mot
     * place la forme à la position (posX, posY) avec une orientation donnée
     * exprimé en radian (0 = horizontal, tourne en sens horaire), la police
     * de caractères font et la couleur de remplissage couleur.
     * @param mot
     * @param posX
     * @param posY
     * @param orientation
     * @param font
     * @param couleur 
     */
    public WordShape(String mot, int posX, int posY, double orientation, Font font, Color couleur) {
        GlyphVector gl;
        gl = font.layoutGlyphVector(new FontRenderContext(null, true, true),
                mot.toCharArray(), 0, mot.length(), Font.LAYOUT_LEFT_TO_RIGHT);
        this.forme = gl.getOutline();
        this.forme = AffineTransform.getRotateInstance(orientation)
                        .createTransformedShape((java.awt.Shape) this.forme);
        this.forme = AffineTransform.getTranslateInstance(posX, posY)
                        .createTransformedShape((java.awt.Shape) this.forme);
        this.couleur = couleur;
    }

    /**
     * déplace la forme courante de dx et dy
     * @param dx
     * @param dy 
     */
    public void translate(int dx, int dy) {
        this.forme = AffineTransform.getTranslateInstance(dx, dy)
                .createTransformedShape(this.forme);
    }

    /**
     * retourne la forme courante
     * @return forme courante
     */
    public Shape getShape(){
        return this.forme;
    }
    
    /**
     * retourne la position de la forme courante
     * @return la position de la forme courante
     */
    public Point2D getPosition(){
        Rectangle2D bounds = this.getShape().getBounds2D();
        Point2D pos = new Point2D.Double(bounds.getMinX(),bounds.getMaxY());
        return pos;
    }
    
    /**
     * retourne la couleur de remplissage de la forme courante
     * @return la couleur de remplissage de la forme courante
     */
    public Color getColor(){
        return this.couleur;
    }
    
    /**
     * déplace la forme courante à la position dont les coordonnées sont
     * (posX, posY)
     * @param posX
     * @param posY 
     */
    public void setPosition(int posX, int posY){
        Point2D pos = this.getPosition() ;
        this.translate(posX-(int)pos.getX(), posY-(int)pos.getY());
    }
    public void setOrienation(double angle){
        this.forme = AffineTransform.getRotateInstance(angle)
                        .createTransformedShape((java.awt.Shape) this.forme);
    }
    
    
    /**
     * affiche la position de la forme courante
     */
    public void affiche(){
        System.out.println(this.getPosition());
    }

    /**
     * retourne true si la forme courante est en intersection avec le rectangle
     * englobant de la forme autre
     * @param autre
     */
    public boolean estEnConflit(WordShape autre) {
        Rectangle2D bounds = autre.forme.getBounds2D();
        bounds = new Rectangle2D.Double(bounds.getMinX()-2,bounds.getMinY()-2,
                    bounds.getMaxX()-bounds.getMinX()+4,
                    bounds.getMaxY()-bounds.getMinY()+4);
        return this.forme.intersects(bounds);
    }

    /**
     * retourne true si la forme courante est dans la forme en entrée
     * @param forme
     */
    public boolean estDans(Shape forme) {
        return (forme.contains(this.getShape().getBounds()));
    }
    
    public void setCouleur(Color c){
        this.couleur = c;
    }
    
    
}