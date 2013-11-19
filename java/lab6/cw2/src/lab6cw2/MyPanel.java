package lab6cw2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class MyPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final int sx=650,sy=400;
	double x[], y[];
	int n;
	
	public MyPanel(double[] x, double[] y, int n) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.n = n;
	}

	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		int [] xi = new int[n+1];
		int [] yi = new int[n+1];
		double skala, skala2;
		
		
		g2.drawLine(sx-300, sy, sx+300, sy);
		g2.drawLine(sx+290, sy-5, sx+300, sy);
		g2.drawLine(sx+290, sy+5, sx+300, sy);
		g2.drawLine(sx, sy-300, sx, sy+300);
		g2.drawLine(sx-5, sy-290, sx, sy-300);
		g2.drawLine(sx+5, sy-290, sx, sy-300);
		
		for(int i=1; i<12; i++){
			g2.drawLine(sx+25*i, sy+5, sx+25*i, sy-5);
			g2.drawLine(sx-25*i, sy+5, sx-25*i, sy-5);
			g2.drawLine(sx-5, sy+25*i, sx+5, sy+25*i);
			g2.drawLine(sx-5, sy-25*i, sx+5, sy-25*i);
		}
		
		if (modul(x[0]) > modul(x[n]))
			skala = 250/ x[0];
		else
			skala = 250 / x[n];
		if (skala < 0)
			skala = -250/x[0];
		
		
		double max=0;
		for(int i=0;i<n+1;i++){
			if (modul(y[i])>max)
				max = modul(y[i]);
		}
		skala2 = 250/max;
		
		//line.moveTo(x[0] + sx, sy - y[0]);
		for(int i=0;i<n+1;i++){
			xi[i] = (int)(skala*x[i] + sx);
			yi[i] = -(int)(skala2*y[i]) + sy;
			if(i>0)
				g2.drawLine(xi[i-1], yi[i-1], xi[i], yi[i]);
		}
		g2.drawString(Double.toString(max), sx+10, sy-245);
		g2.drawString(Double.toString(x[n]), sx+240, sy+20);
		
	}
	
	public double modul(double x){
		if (x<0)
			x = -x;
		return x;
	}

}
