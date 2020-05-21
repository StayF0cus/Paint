import java.awt.*;
import java.io.Serializable;

public class Triangle extends Figure{
  private Point p2;
  private Point p3;
 private static final long serialVersionUID = 8614555064496543792L;
 
  //Constructeurs
  public Triangle(Boolean plein,Point p1,Point p2,Point p3){
    super(plein,p1);
    this.p2 = p2;
    this.p3 = p3;
  }

  public Triangle(Boolean plein,int p1X,int p1Y,int p2X,int p2Y,int p3X,int p3Y){
    super(plein,p1X,p1Y);
    Point p2 = new Point(p2X,p2Y);
    this.p2 = p2;
    Point p3 = new Point(p3X,p3Y);
    this.p3 = p3;
  }

  //Methodes
  public Point getPoint(int nb){
    if(nb == 1){
      return this.p1;
    }
    else if(nb == 2){
      return this.p2;
    }
    else{
      return this.p3;
    }
  }


}
