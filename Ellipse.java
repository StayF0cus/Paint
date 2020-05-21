import java.awt.*;
import java.io.Serializable;
public class Ellipse extends Figure implements Serializable{
  private Point p2;
  private Point p3;
private static final long serialVersionUID = -2260230985434499724L;
  //Constructeurs
  public Ellipse(Boolean plein,Point p1,Point p2,Point p3){
    super(false,p1);
    this.p2 = p2;
    this.p3 = p3;
  }

  public Ellipse(Boolean plein,int p1X,int p1Y,int p2X,int p2Y,int p3X,int p3Y){
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

  public int getHauteur(){
    if(Math.abs(this.p2.getY() - this.p1.getY()) > Math.abs(this.p3.getY() - this.p1.getY())){
      return (int) Math.abs(this.p2.getY() - this.p1.getY())*2;
    }
    else{
      return (int) Math.abs(this.p3.getY() - this.p1.getY())*2;
    }
  }

  public int getLargeur(){
    if(Math.abs(this.p2.getX() - this.p1.getX()) > Math.abs(this.p3.getX() - this.p1.getX())){
      return (int) Math.abs(this.p2.getX() - this.p1.getX())*2;
    }
    else{
      return (int) Math.abs(this.p3.getX() - this.p1.getX())*2;
    }
  }



}
