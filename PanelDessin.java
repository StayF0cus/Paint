import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.io.*;

public class PanelDessin extends JPanel implements Serializable{
    private Dessin afficheurs = new Dessin();
  private ArrayList<Point> clics = new ArrayList<Point>();
    private ArrayList<Point> clics1 = new ArrayList<Point>();
  private int figure;
  private boolean plein;
  private Color couleur;
  private boolean gomme;
  private String text;
  private boolean dans;
  private File fichier = new File("dessin.ser");
  private static final long serialVersionUID = 8329388419345012898L;

  //Constructeurs
  public PanelDessin(){
    super();
    this.figure = 1;
  }

  //METHODES
  public void suppr(){
    int d = afficheurs.size()-1;
    afficheurs.remove(d);
  }

  public void setText(String t){
    this.text = t;
  }

  public void setGomme(boolean b){
    this.gomme=b;
  }
  public void setFigure(int nb){
    if(nb <= 6 && nb >= 1){
      System.out.println("OK");
      this.figure = nb;
    }
    this.clics.clear();
  }

  public int getFigure(){
    return this.figure;
  }

  public void setCouleur(Color couleur){
    this.couleur = couleur;
  }

  public void setPlein(boolean b){
    this.plein = b;
  }

  public void paintComponent(Graphics g){
    super.paintComponent(g);
    for(int i=0; i < this.afficheurs.size(); i++){
      this.afficheurs.get(i).dessiner(g);
    }
  }

  public void sauver() {
    try {
      ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(fichier));

      oos.writeObject(this.afficheurs);
      oos.close();
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }

  public void charger() {
    try {
      ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(fichier));
      this.afficheurs = (Dessin)ois.readObject();
      this.repaint();
      ois.close();
    }
    catch (Exception e) {
      System.out.println(e);
    }
  }

  public void creerFigure(){
    if (this.figure == 6) {
      System.out.println(this.text);
      System.out.println("OK");
      Text t = new Text(this.text,this.clics.get(0));
      this.afficheurs.add(new Afficheurtext(t));
    }
    if(this.figure == 1){
      Droite d = new Droite(this.clics.get(0),this.clics.get(1));
      d.setCouleur(this.couleur);
      this.afficheurs.add(new AfficheurDroite(d));
    }

    else if(this.figure == 2){
      System.out.println(this.plein);
      System.out.println(this.couleur);
      Cercle c = new Cercle(this.plein,this.clics.get(0),this.clics.get(1));
      c.setCouleur(this.couleur);
      this.afficheurs.add(new AfficheurCercle(c));
    }
    else if(this.figure == 3){
      Ellipse e = new Ellipse(this.plein,this.clics.get(0),this.clics.get(1),this.clics.get(2));
      e.setCouleur(this.couleur);
      this.afficheurs.add(new AfficheurEllipse(e));
    }
    else if(this.figure == 4 ){
      Rectangle r = new Rectangle(this.plein,this.clics.get(0),this.clics.get(1));
      r.setCouleur(this.couleur);
      this.afficheurs.add(new AfficheurRectangle(r));
    }
    else if(this.figure == 5){
      Triangle t = new Triangle(this.plein,this.clics.get(0),this.clics.get(1),this.clics.get(2));
      t.setCouleur(this.couleur);
      this.afficheurs.add(new AfficheurTriangle(t));
    }
    this.clics.clear();
  }

  public void clicSouris(int x,int y){
    System.out.println("x : " + x + " | y : " + y);
    this.clics.add(new Point(x,y));
    try{
    if (this.clics.size() == 1 && dans == true) {
      this.clics1.addAll(this.clics);
      System.out.println("-------------");
      //System.out.println("JE SUIS LA");
      for (int i = this.afficheurs.size()-1; i>=0 ; i-- ) {
        System.out.println(this.afficheurs.size());
        //System.out.println("JE SUIS LA");

        if (this.afficheurs.get(i) instanceof AfficheurCercle) {
          System.out.println("JE SUIS LA");
          System.out.println(this.afficheurs.get(i));
            AfficheurCercle A = (AfficheurCercle) this.afficheurs.get(i);
          //  System.out.println(i);
           System.out.println(A.c.IN(this.clics1.get(this.clics.size()-1)));
            System.out.println("-------------");

            if ( A.c.IN(this.clics1.get(this.clics.size()-1))== true) {
              System.out.println("TRUE");
              this.afficheurs.remove(i);
            }
        }

      }

      dans = false;

    }

  }
  catch(Exception e){
    e.printStackTrace();
  }
  this.clics1.clear();
    if (this.clics.size() == 1 && this.figure == 6) {
      this.creerFigure();
    }
    if(this.clics.size() == 2 && (this.figure != 3 || this.figure != 5)){
      this.creerFigure();
    }
    else if(this.clics.size() == 3){
      this.creerFigure();
    }
    this.repaint();
  }

  public void effacer(){
    afficheurs.clear();
    this.repaint(); //lance paintComponent
  }
public void Dans(){
  this.dans = true;
}


}
