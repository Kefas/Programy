package mainPkg;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class DrawerProgram extends Frame {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public DrawerProgram(){
	        MyPanel d = new MyPanel();
	        d.setSize(400,400);
	        add(d);
	        
	        addWindowListener(new WindowAdapter(){
	            public void windowClosing(WindowEvent we){
	               System.exit(0);
	            }
	        });
	       
	    }
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 DrawerProgram dp = new DrawerProgram();
	        dp.setSize(450, 450);
	        dp.setVisible(true);
	}

}
