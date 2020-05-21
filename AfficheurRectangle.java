import java.awt.*;
import javax.swing.*;
import java.io.Serializable;
public class AfficheurRectangle extends Afficheur implements Serializable{
  Rectangle r;
private static final long serialVersionUID = -7066530006684452417L;
  //Constructeurs
  public AfficheurRectangle(){
  }

  public AfficheurRectangle(Rectangle r){
    this.r = r;
  }

  //Methodes
  public void dessiner(Graphics g){
    Point p1 = this.r.getPoint();
    Color couleur = r.getCouleur();
    g.setColor(couleur);
    if(r.getPlein() == true){
      g.fillRect((int) p1.getX(),(int) p1.getY(),r.getLongueur(),r.getHauteur());
    }
    else{
      g.drawRect((int) p1.getX(),(int) p1.getY(),r.getLongueur(),r.getHauteur());
    }
  }

  public void add(Figure f){
    this.r = (Rectangle) f;
  }
}
