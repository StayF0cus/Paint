import java.awt.*;
import java.math.*;
import java.io.Serializable;
import java.util.*;
public class Cercle extends Figure implements Serializable{
  private Point p2;
  public ArrayList<Point> Point = new ArrayList<Point>();
private static final long serialVersionUID = -3785826459069848831L;
  //Constructeurs
  public Cercle(Boolean plein,Point p1,Point p2){
    super(plein,p1);
    this.p2 = p2;
  }

  public Cercle(Boolean plein,int p1X,int p1Y,int p2X,int p2Y){
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

  public int getRayon(){
    double cote1 = Math.abs(this.p2.getX() - this.p1.getX());
    double cote2 = Math.abs(this.p2.getY() - this.p1.getY());
    return (int) Math.round(Math.sqrt( Math.pow(cote1,2) + Math.pow(cote2,2) ) );
  }

  public int getDiametre(){
    return this.getRayon() * 2;
  }

  public int Perimetre(){
    return 2 * (int)Math.PI * this.getRayon();
  }

public void g(){
  for (int i = 0; i< this.Perimetre() ; i++ ) {
    Point p4 = new Point((int)this.p1.getX()+this.getRayon(),(int)this.p1.getY()+this.getRayon());
    this.Point.add(p4);
  }
}

public boolean IN(Point p){
  double cote1 = Math.abs(p.getX() - this.p1.getX());
  double cote2 = Math.abs(p.getY() - this.p1.getY());
  int a = (int) Math.round(Math.sqrt( Math.pow(cote1,2) + Math.pow(cote2,2) ) );
  System.out.println("RAYON");
  System.out.println(a<= getRayon());
  if (a <= getRayon()) {
    return true;
  }
  return false;
}

}
