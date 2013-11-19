package lab6cw2;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SwingConsole {
	public static void run(final SubmitSwingProgram frame, final int width, final int height){
		SwingUtilities.invokeLater(new Runnable() {	
			@Override
			public void run() {
				frame.setTitle(frame.getClass().getSimpleName());
				frame.setResizable(false);
			
				
				frame.setLocation(0,0);
				frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true); 
			}
		});
	}
}
