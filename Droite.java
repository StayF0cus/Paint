import java.awt.*;
import java.io.Serializable;
public class Droite extends Figure implements Serializable{
  private Point p2;
private static final long serialVersionUID = 5086604023291903997L;
  //Constructeurs
  public Droite(Point p1,Point p2){
    super(false,p1);
    this.p2 = p2;
  }

  public Droite(Boolean plein,int p1X,int p1Y,int p2X,int p2Y){
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

}
