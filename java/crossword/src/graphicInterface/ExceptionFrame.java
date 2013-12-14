package graphicInterface;

import java.awt.Graphics;
import javax.swing.JFrame;

public class ExceptionFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public String exc = "Unnamed  Error";
	
	public ExceptionFrame(Exception e){
		if(e.getMessage() != null)
			exc = e.getMessage();
	}
	
	public void paint(Graphics g){
		g.drawString(exc, 110, 75);
	}
	
}
