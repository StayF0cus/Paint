import java.awt.*;
import javax.swing.*;
import java.io.Serializable;
public class Afficheurtext extends Afficheur implements Serializable{
  Text t;
private static final long serialVersionUID = 1779533194639850496L;
  //Constructeurs
  public Afficheurtext(){
  }

  public Afficheurtext(Text t){
    this.t = t;
  }

  //Methodes
  public void dessiner(Graphics g){
    Point p1 = this.t.getPoint();
    g.drawString(t.gettext(), (int) p1.getX(), (int) p1.getY());
  }

  public void add(Figure f){
    this.t = (Text) f;
  }
}
