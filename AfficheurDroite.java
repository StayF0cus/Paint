import java.awt.*;
import javax.swing.*;
import java.io.Serializable;

public class AfficheurDroite extends Afficheur implements Serializable{
  Droite d;
private static final long serialVersionUID = 1228982156631311920L;
  //Constructeurs
  public AfficheurDroite(){
  }

  public AfficheurDroite(Droite d){
    this.d = d;
  }

  //Methodes
  public void dessiner(Graphics g){
    Point p1 = this.d.getPoint();
    Point p2 = this.d.getPoint(2);
    Color couleur = d.getCouleur();
    g.setColor(couleur);
    g.drawLine((int) p1.getX(), (int) p1.getY(), (int) p2.getX(), (int) p2.getY());
  }

  public void add(Figure f){
    this.d = (Droite) f;
  }


}
