package aplet1;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Grafika extends Applet {
	public void init(){
		setBackground(Color.orange); // ustawienie koloru tła okna apletu
		setSize(500,400); // zmiana rozmiaru okna apletu
	}
	public void paint(Graphics g){
		g.clearRect(0, 0, getWidth(), getHeight()); 
		//wypełnienie obszaru apletu kolorem tła
		Font f = new Font("SanSerif", Font.ITALIC, 18);
		 //utworzenie czcionki o podanej nazwie, stylu i rozmiarze
		g.setFont(f);
		g.setColor(Color.blue);
		String s="RYSOWANIE WIELOBOKÓW";
		g.drawString(s, (getWidth()-g.getFontMetrics().stringWidth(s))/2, 20); 
		int[] x = {0, getWidth()/2, getWidth()}; 
		// nowa tablica jest tworzona na podstawie opisu jej elementów,
		int[] y = {40, 400, 40}; 
		// oddzielonych przecinkami i zawartych w nawiasach klamrowych
		Wielobok T = new Wielobok(x, y); 
		// wielobok T jest trójkątem równoramiennym o wysokości 160 punktów
		T.rysuj(g, Color.WHITE);
		Lokomotywa lokomotywa = new Lokomotywa();
		lokomotywa.rysuj(g, Color.RED);
		Samochód sam = new Samochód();
		sam.rysuj(g, Color.BLUE);
	}
	
	
}
