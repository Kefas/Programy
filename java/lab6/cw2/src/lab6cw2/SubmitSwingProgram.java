package lab6cw2;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class SubmitSwingProgram extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -773998298165427324L;
	static SubmitSwingProgram ssp;
	JButton but;
	private JTextField rownanie;
	private JTextField zakres;
	private JTextField krok;
	private ButtonListener bl = new ButtonListener();
	public MyPanel panel;
	
	
	
	public SubmitSwingProgram(){
		super("Ahoj");
		
		this.setLayout(new FlowLayout());
		
		
		rownanie = new JTextField( 25);
		add(new JLabel("Equation:"));
		add(rownanie);
		
		zakres = new JTextField("-10,10",25);
		add(new JLabel("Scope"));
		add(zakres);
		
		krok = new JTextField("1", 5);
		add(new JLabel("Step"));
		add(krok);
		
		but = new JButton("pierwszy");
		but.addActionListener(bl);
		this.add(but);	
		
		pack();
	}
	
	public static void main(String[] args) throws InterruptedException {
		ssp = new SubmitSwingProgram();
		SwingConsole.run(ssp, 1366,866);
	}
	
	class ButtonListener implements ActionListener{
		Scanner in;
		String eq;
		String sc;
		String st;
		double start,end,step;
		double x[],y[];
		@Override
		public void actionPerformed(ActionEvent e) {
			revalidate();
			repaint();
			
			//Walidacja równania
			eq = rownanie.getText();
			eq = eq.replace(" ", "");
			eq = eq.replace("+", " +");
			eq = eq.replace("-", " -");
			String eqTab[] = eq.split(" ");
			Double facTab[] = new Double[eqTab.length];
			int powTab[] = new int[eqTab.length];
			String s2[] = null;
			
			for (int i = 0; i < eqTab.length; i++) {
				s2 = eqTab[i].replace("x", "x ").split("x");
				try{
					facTab[i] = new Double(Double.parseDouble(s2[0]));
				}
				catch (Exception exc){
					facTab[i] = new Double(1);
				}
				if (s2.length > 1) {
					if ( s2[1].equals(" ") )
						powTab[i] = 1;
					else
						powTab[i] = new Integer( s2[1].replace("{", "").replace("}", "").replace("^", "").trim() );
				} else
					powTab[i] = 0;
			}
			for (int i = 0; i < eqTab.length; i++)
				System.out.println(facTab[i] + " ^ " + powTab[i]);
			
			sc = zakres.getText();
			String tab[] = sc.split(",");
			start = Double.parseDouble(tab[0]);
			end = Double.parseDouble(tab[1]);
			
			st = krok.getText();
			step = Double.parseDouble(st);
			
			//rysowanie wykresu
			int n=0;
			n = end-start>0 ? (int)((end-start)/step) : (int)(-(end-start)/step);
		
			x = new double[n+1];
			y = new double[n+1];
			for(int i=0;i<n+1;i++){
				x[i] = start + i*step;
				for(int j=0;j<eqTab.length;j++)
					y[i] += Math.pow(x[i],powTab[j]) * facTab[j];
				System.out.println(x[i] + " " + y[i]);
			}
			    
			panel = new MyPanel(x,y,n);
			add(panel);	
			
			panel.setSize(1000,1000);
			
		}
		
	}

}


