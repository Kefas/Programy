package lab10cw1;

import java.lang.*;
import java.applet.*;
import java.awt.*;
public class Appletnr1 extends java.applet.Applet
 {
  public void paint(Graphics g)
   {
    g.setColor(Color.blue);//ustawianie koloru czcionki
    Font f4=new Font("Courier",Font.BOLD,24);
    String s="Java jest ekstra";
    g.setFont(f4);//ustawianie bierzącej czcionki
    g.drawString(s,10,25);
    }
  }