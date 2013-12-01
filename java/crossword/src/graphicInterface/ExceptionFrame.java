package graphicInterface;

import java.awt.Graphics;
import javax.swing.JFrame;

public class ExceptionFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public String exc = "NIC";
	
	public ExceptionFrame(Exception e){
		exc = e.toString();
	}
	
	public void paint(Graphics g){
		g.drawString(exc, 100, 50);
	}
	
}
