import java.awt.*;
import javax.swing.*;
import java.io.Serializable;
public class AfficheurTriangle extends Afficheur implements Serializable{
  Triangle t;
private static final long serialVersionUID = 2942459079997002079L;
  //Constructeurs
  public AfficheurTriangle(){
  }

  public AfficheurTriangle(Triangle t){
    this.t = t;
  }

  //Methodes
  public void dessiner(Graphics g){
    Point p1 = this.t.getPoint();
    Point p2 = this.t.getPoint(2);
    Point p3 = this.t.getPoint(3);
    Color couleur = t.getCouleur();
    g.setColor(couleur);
    int[] tabX = {(int) p1.getX(),(int) p2.getX(),(int) p3.getX()};
    int[] tabY = {(int) p1.getY(),(int) p2.getY(),(int) p3.getY()};
    if(t.getPlein() == true){
      g.fillPolygon(tabX,tabY,3);
    }
    else{
      g.drawPolygon(tabX,tabY,3);
    }
  }

  public void add(Figure f){
    this.t = (Triangle) f;
  }
}
