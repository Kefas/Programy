package graphicInterface;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import board.ConcreteStrategy;
import browser.CwBrowser;

public class GraphicInterface extends JFrame implements ActionListener{
	static GraphicInterface gui;
	private JSpinner height;
	private JSpinner width;
	private JLabel lab1;
	private JLabel lab2;
	private JLabel lab3;
	private JButton but1;
	private JButton but2;
	private JButton but3;
	private JButton but4;
	private JTextField txt1;
	private JMenuBar menu;
	private JMenuItem save;
	private JMenuItem open;
	private JMenuItem print;
	private JMenuItem exit;
	private JMenu option;
	private JFileChooser jfc;
	private String filePath;
	private CwBrowser browser;
	private String cwdbFilePath;
	private JLabel lab4;
	private JLabel lab5;
	private MyPanel panel;
	private JButton but5;
	private JRadioButton easy;
	private JLabel lab6;
	private JLabel lab7;
	private JRadioButton hard;
	private ButtonGroup radioPanel;
	
	
	public GraphicInterface() throws FileNotFoundException {
		// TODO Auto-generated constructor stub
		this.setLayout(new FlowLayout());
		browser = new CwBrowser(cwdbFilePath);
		initComponent();
	}
	
	public void initComponent(){
		
		
		height = new JSpinner();
		width = new JSpinner();
		lab1 = new JLabel(" Szerokoœæ: ");
		lab2 = new JLabel(" Wysokoœæ: ");
		lab3 = new JLabel("               ");
		lab4 = new JLabel("               ");
		lab5 = new JLabel("               Plik z has³ami do krzy¿ówki: ");
		txt1 = new JTextField("cwdb.txt", 20);
		but2 = new JButton(" ... ");
		
		
		easy = new JRadioButton("Strategia prosta");
		easy.setSelected(true);
		easy.addActionListener(this);
		hard = new JRadioButton("Strategia trudna");
		hard.addActionListener(this);
		
		radioPanel = new ButtonGroup();
		but1 = new JButton(" Generuj ");
		but3 = new JButton(" Poprzednia ");
		but4 = new JButton(" Nastêpna ");
		but5 = new JButton(" Rozwi¹¿ ");
		panel = new MyPanel();
		radioPanel.add(easy);
		radioPanel.add(hard);
		
		but1.addActionListener(this);
		but2.addActionListener(this);
		but3.addActionListener(this);
		but4.addActionListener(this);
		but5.addActionListener(this);
		
	
		menu = new JMenuBar();
		option = new JMenu(" Option    ");
	
		
		save = new JMenuItem("Zapisz");
		save.addActionListener(this);
		open = new JMenuItem("Otwórz");
		open.addActionListener(this);
		print = new JMenuItem("Drukuj");
		print.addActionListener(this);
		exit = new JMenuItem("Wyjœcie");
		exit.addActionListener(this);
		
		//add(height);
		add(panel);
	
		setJMenuBar(menu);
		menu.add(option);
		menu.add(lab3);
		menu.add(lab1);
		menu.add(height);
		menu.add(lab2);
		menu.add(width);
		menu.add(lab5);
		menu.add(txt1);
		menu.add(but2);
		menu.add(easy);
		menu.add(hard);
		menu.add(but1);	
		menu.add(lab4);
		menu.add(but3);
		menu.add(but4);
		menu.add(but5);
		option.add(save);
		option.add(open);
		option.add(print);
		option.add(exit);		
		
		pack();	
		
	}
	
	static public void main(String args[]) throws FileNotFoundException{
		gui = new GraphicInterface();
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				gui.setTitle("Generator krzy¿ówek");
				gui.setResizable(false);
				gui.setLocation(0,0);
				gui.setSize(Toolkit.getDefaultToolkit().getScreenSize());
				gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				gui.setVisible(true); 
			}
		});
	}

	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		revalidate();
		repaint();
		jfc = new JFileChooser();
		Object z = arg0.getSource();
		if (z == save){
			if(jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
				filePath = jfc.getSelectedFile().getPath();			
				try {
					browser.save(filePath.substring(0,filePath.lastIndexOf('\\')));
				//System.out.println(filePath.substring(0,filePath.lastIndexOf('\\')));
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		else if( z == open){
			if(jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
				filePath = jfc.getSelectedFile().getPath();
				
				try {
					browser.load(filePath.substring(0,filePath.lastIndexOf('\\')));
					
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				revalidate();
				repaint();
				panel.update(browser.getCw());
				
			}
		}
		else if(z == exit){
			System.exit(NORMAL);
		}
		//generate
		else if(z == but1){		
			
			if(easy.isSelected())
				browser.generateCw((int)height.getValue(), (int)width.getValue(), new ConcreteStrategy());
			else{
					
			}
			panel.update(browser.getCw());		
		}
		else if(z == but2){
			if(jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
			
//				tu mo¿na rzuciæ wyjatek co jeœli plik nie jest .txt				
				cwdbFilePath = jfc.getSelectedFile().getAbsolutePath();
				txt1.setText(cwdbFilePath);
				try {
					browser.updateCwBD(cwdbFilePath);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
		} 
		else if(z == print){
//			finish'em
			
		}
		else if(z == but3){
			browser.prev();			
			panel.update(browser.getCw());
		}
		else if(z == but4){
			
			browser.next();		
			panel.update(browser.getCw());
		}
		else if(z == but5){
			panel.setSolve();
		}
		
		
	}

	
	
}
