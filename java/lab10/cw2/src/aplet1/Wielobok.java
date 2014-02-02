package aplet1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class Wielobok extends Polygon {

	public Wielobok() {
		// TODO Auto-generated constructor stub
	}

	public Wielobok(int[] arg0, int[] arg1) {
		super(arg0, arg1, Math.min(arg0.length, arg1.length));
	}
	void rysuj(Graphics g, Color k) {
		Color b = g.getColor(); g.setColor(k);
		 //zapamiętanie i zmiana bieżącego koloru dla kanwy graficznej
		g.fillPolygon(this); 
		// narysowanie wieloboku o kształcie obiektu klasy Wielobok (Polygon)
		g.setColor(b); // przywrócenie bieżącego koloru kanwy
	}	

}
