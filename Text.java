import java.awt.*;
import java.math.*;
import java.io.Serializable;

public class Text extends Figure implements Serializable{
  private String text;
 private static final long serialVersionUID = -4946644930736361408L;
  public Text(String t, Point p1){
    super(false,p1);
    this.text = t;
  }

  public Text(Boolean estPlein,int p1X,int p1Y,String txt){
     super(estPlein,p1X,p1Y);
     this.text = txt;
   }

   public String gettext() {
       return this.text;
   }

   public void settext(String txt) {
       this.text = txt;
   }

   public Point getPoint(int b){
     return this.p1;
   }
}
