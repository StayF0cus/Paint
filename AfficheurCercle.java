import java.awt.*;
import javax.swing.*;
import java.io.Serializable;

public class AfficheurCercle extends Afficheur implements Serializable{
  public  Cercle c;
private static final long serialVersionUID = -8945439960410393415L;
  //Constructeurs
  public AfficheurCercle(){
  }

  public AfficheurCercle(Cercle c){
    this.c = c;
  }
  public Cercle getCercle(){
    return c;
  }
  //Methodes
  public void dessiner(Graphics g){
    Point p1 = this.c.getPoint();
    Point p2 = this.c.getPoint(2);
    Color couleur = c.getCouleur();
    g.setColor(couleur);
    if(c.getPlein() == true){
      g.fillOval((int) p1.getX()- c.getRayon(),(int) p1.getY()- c.getRayon(),c.getDiametre(),c.getDiametre()); //cercle rempli
    }
    else{
      g.drawOval((int) p1.getX()- c.getRayon(),(int) p1.getY() - c.getRayon(),c.getDiametre(),c.getDiametre());// cercle non rempli
    }
  }

  public void add(Figure f){
    this.c = (Cercle) f;
  }

public String toString(){
  return "Cercle";
}
}
