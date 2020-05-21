import java.awt.*;
import java.math.*;
import java.io.Serializable;

public class Rectangle extends Figure implements Serializable{
  private Point p2;
  private static final long serialVersionUID = -4356425102663464041L;

  //Constructeurs
  public Rectangle(Boolean plein,Point p1,Point p2){
    super(plein,p1);
    this.p2 = p2;
  }

  public Rectangle(Boolean plein,int p1X,int p1Y,int p2X,int p2Y){
    super(plein,p1X,p1Y);
    Point p2 = new Point(p2X,p2Y);
    this.p2 = p2;
  }

  //Methodes
  public Point getPoint(int nb){
    if(nb == 1){
      return this.p1;
    }
    else{
      return this.p2;
    }
  }

  public int getHauteur(){
    double hauteur = this.p2.getY() - this.p1.getY();
    return (int) hauteur;
  }

  public int getLongueur(){
    double longueur = this.p2.getX() - this.p1.getX();
    return (int) longueur;
  }


}
