import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Paint extends JFrame {
  private PanelDessin panel;
  private JButton selecteurCouleur;
  private JPanel panelBas;
  private TextArea text;
 private static final long serialVersionUID = -6860769897260834801L;

  //Constructeurs
  public Paint(){
    super("Paint IHM");
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.centreEcran(700,500);
    this.init();
    this.setVisible(true);
  }

  //METHODES

  public void centreEcran(int w,int h){
    Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
    this.setBounds(dim.width/2-w/2,dim.height/2-h/2,w,h);
  }

  public void init(){
    this.setLayout(new BorderLayout());

    //Panel haut
    JPanel panelHaut = this.getPanelHaut();
    this.add(panelHaut, BorderLayout.NORTH);

    //Panel Milieu (Dessin)
    PanelDessin panelDessin = new PanelDessin();
    this.add(panelDessin, BorderLayout.CENTER);
    panelDessin.addMouseListener(new ListenerSouris());

    this.setFocusable(true);
    this.requestFocus();

    this.addKeyListener(new ListenerClavier());
    this.panel = panelDessin;

    //Panel droite
    JPanel panelBas = new JPanel();
    text = new TextArea(1,50);
    JButton boutonValide = new JButton("OK");
    boutonValide.addActionListener(new ListenerOK());
    panelBas.add(text);
    panelBas.add(boutonValide);
    this.add(panelBas,BorderLayout.SOUTH);
  }

  public JPanel getPanelHaut(){
    JPanel panel = new JPanel();

    JButton btnTrue = new JButton("Dans le cercle ?");
    btnTrue.addActionListener(new ListnerTrue());
    panel.add(btnTrue);

    JButton btnCharger = new JButton("Charger");
    btnCharger.addActionListener(new ListenerCharger());
    panel.add(btnCharger);

    JButton btnSauver = new JButton("Sauver");
    btnSauver.addActionListener(new ListenerSauver());
    panel.add(btnSauver);

    this.selecteurCouleur = new JButton("Couleur");
    selecteurCouleur.addActionListener(new ListenerCouleur());
    panel.add(this.selecteurCouleur);

    JButton boutonEffacer = new JButton("Effacer");
    boutonEffacer.addActionListener(new ListenerEffacer());
    panel.add(boutonEffacer);

    JButton boutonReset = new JButton("Figure");
    boutonReset.addActionListener(new ListenerReset());
    panel.add(boutonReset);

    JButton boutonRetour = new JButton("Retour");
    boutonRetour.addActionListener(new ListenerRetour());
    panel.add(boutonRetour);
    return panel;
  }
  public void retour(){
    panel.suppr();
  }
  public void refreshText(String t){
    panel.setText(t);
  }

  public void DansLeCercle(){
    panel.Dans();
    }

  public void clicSouris(int x,int y){
    this.panel.clicSouris(x,y);
  }

  public void refreshFigure(int nb){
    panel.setFigure(nb);
    this.setFocusable(true);
    this.requestFocus();
  }

  public void refreshPlein(boolean b){
    panel.setPlein(b);
  }

  public void Gomme(boolean b){
    panel.setGomme(b);
  }

  //Inner Class
  public class ListenerSouris implements MouseListener{

    public ListenerSouris(){
    }

    public void mouseClicked(MouseEvent e){
      int x = e.getX();
      int y = e.getY();
      clicSouris(x,y);
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }
  }

  public class ListenerClavier implements KeyListener{

      private boolean plein;


    public ListenerClavier(){
    }

    public void keyPressed(KeyEvent e){

      if(e.getKeyCode() == KeyEvent.VK_NUMPAD0){
        this.plein = true;
        refreshPlein(this.plein);
      }
      if(e.getKeyCode() == KeyEvent.VK_NUMPAD1){
        this.plein = false;
        refreshPlein(this.plein);
      }
      if (e.getKeyCode() == KeyEvent.VK_M) {
        refreshFigure(6);
      }
      if (e.getKeyCode() == KeyEvent.VK_D) {
        refreshFigure(1);
      }
      if (e.getKeyCode() == KeyEvent.VK_C) {
        refreshFigure(2);
      }
      if (e.getKeyCode() == KeyEvent.VK_E) {
        refreshFigure(3);
      }
      if (e.getKeyCode() == KeyEvent.VK_R) {
        refreshFigure(4);
      }
      if (e.getKeyCode() == KeyEvent.VK_T) {
        refreshFigure(5);
      }
      if (e.getKeyCode()==46) {
        Gomme(true);
      }
      refreshPlein(this.plein);
    }

    public void keyReleased(KeyEvent e){
      if(e.getKeyCode() == KeyEvent.VK_NUMPAD0){
        this.plein = true;
        refreshPlein(this.plein);
      }
      if(e.getKeyCode() == KeyEvent.VK_NUMPAD1){
        this.plein = false;
        refreshPlein(this.plein);
      }
      if (e.getKeyCode() == KeyEvent.VK_M) {
        refreshFigure(6);
      }
      if (e.getKeyCode() == KeyEvent.VK_D) {
        refreshFigure(1);
      }
      if (e.getKeyCode() == KeyEvent.VK_C) {
        refreshFigure(2);
      }
      if (e.getKeyCode() == KeyEvent.VK_E) {
        refreshFigure(3);
      }
      if (e.getKeyCode() == KeyEvent.VK_R) {
        refreshFigure(4);
      }
      if (e.getKeyCode() == KeyEvent.VK_T) {
        refreshFigure(5);
      }
      if (e.getKeyCode()==46) {
        Gomme(true);
      }
      refreshPlein(this.plein);
    }

    public void keyTyped(KeyEvent e){
    }
  }

  public class ListenerRetour implements ActionListener{
    public ListenerRetour(){
    }

  public void actionPerformed(ActionEvent e){
    retour();
    panel.repaint();
  }

  }
  public class ListenerReset implements ActionListener{
    public ListenerReset(){
    }

    public void actionPerformed(ActionEvent e){
      refreshFigure(1);
    }
  }

  public class ListenerOK implements ActionListener{


    public ListenerOK(){
    }

    public void actionPerformed(ActionEvent e){
      refreshText(text.getText());
    }
  }

  public class ListenerCouleur implements ActionListener{
    private Color couleur;


    public ListenerCouleur(){
      this.couleur = Color.black;
      //this.plein=false;
      //refreshPlein(this.plein)
    }

    public void actionPerformed(ActionEvent e){
      JColorChooser choix = new JColorChooser();
      this.couleur = choix.showDialog(panel,"Choisissez une couleur",Color.black);
      panel.setCouleur(this.couleur);
      panel.requestFocus();
      refreshFigure(1);
    }
  }

  public class ListenerEffacer implements ActionListener{

    public ListenerEffacer(){
    }

    public void actionPerformed(ActionEvent e){
      panel.effacer();
    }
  }

  public class ListenerCharger implements ActionListener {

    public ListenerCharger() {

    }

    public void actionPerformed(ActionEvent e) {
      panel.charger();
    }
  }

  public class ListenerSauver implements ActionListener {

    public ListenerSauver() {

    }

    public void actionPerformed(ActionEvent e) {
      panel.sauver();
    }
  }

  public class ListnerTrue implements ActionListener {

    public ListnerTrue(){
    }

    public void actionPerformed(ActionEvent e){
      DansLeCercle();
      refreshFigure(1);
    }
  }


}
