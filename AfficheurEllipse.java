import java.awt.*;
import javax.swing.*;
import java.io.Serializable;
public class AfficheurEllipse extends Afficheur implements Serializable{
  Ellipse e;
private static final long serialVersionUID = 8186456491703968930L;
  //Constructeurs
  public AfficheurEllipse(){
  }

  public AfficheurEllipse(Ellipse e){
    this.e = e;
  }

  //Methodes
  public void dessiner(Graphics g){
    Point p1 = this.e.getPoint();
    Color couleur = e.getCouleur();
    g.setColor(couleur);
    if(e.getPlein() == true){
      g.fillOval((int) p1.getX()- e.getLargeur()/2,(int) p1.getY()- e.getHauteur()/2,e.getLargeur(),e.getHauteur());
    }
    else{
      g.drawOval((int) p1.getX()- e.getLargeur()/2,(int) p1.getY() - e.getHauteur()/2,e.getLargeur(),e.getHauteur());
    }
  }

  public void add(Figure f){
    this.e = (Ellipse) f;
  }
}
