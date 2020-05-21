import java.awt.*;
import java.io.Serializable;

public abstract class Figure implements Serializable{
  private Boolean plein;
  private Color couleur = Color.black;
  protected Point p1;
  private static final long serialVersionUID = 108487824206213291L;
  
  //Constructeurs
  public Figure(Boolean plein,Point p1){
    this.plein = plein;
    this.p1 = p1;
  }

  public Figure(Boolean plein, int x , int y){
    Point p1 = new Point(x,y);
    this.plein = plein;
    this.p1 = p1;
  }



  //Methodes
  public Color getCouleur(){
      return this.couleur;
  }

  public void setCouleur(Color couleur){
    this.couleur = couleur;
  }

  public Point getPoint(){
    return this.p1;
  }

  public Boolean getPlein(){
    return this.plein;
  }

  public int getX(){
    return (int) this.p1.getX();
  }

  public int getY(){
    return (int) this.p1.getY();
  }

  public abstract Point getPoint(int nb);

}
