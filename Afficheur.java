import java.awt.*;
import java.io.Serializable;

public abstract class Afficheur implements Serializable{
 private static final long serialVersionUID = 6242812678384503454L;
  public Afficheur(){
  }

  public abstract void dessiner(Graphics g);

  public abstract void add(Figure f);
}
