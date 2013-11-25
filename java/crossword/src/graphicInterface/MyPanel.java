package graphicInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Iterator;
import java.util.ListIterator;

import javax.swing.JPanel;

import dictionary.CwEntry;
import board.Board;
import board.Crossword;
import board.Direction;
import board.Position;

public class MyPanel extends JPanel {
	Crossword cw;
	private Iterator<CwEntry> it;
	private boolean solve;
	
	public MyPanel(){
		setPreferredSize(new Dimension(1000,650));
		cw = null;
		solve = false;
	}

	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		revalidate();
		
		
		g2.setColor(Color.black);
		if(cw!=null){
			int licznik=1, number=1;
			it = cw.getROEntryIter();
			Board b = cw.getBoardCopy();
			for(int i=0; i< b.getWidth();i++)
				for(int j=0; j<b.getHeight();j++){
					if(b.getCell(i, j).getContent() != ""){				
						g2.drawRect((i+1)*30 + 10, (j+1)*30 + 100, 30, 30);
						if(solve)
							g2.drawString(b.getCell(i,j).getContent(), (i+1)*30 + 22,(j+1)*30 + 117 );
						if(b.getCell(i, j).getPos() != Position.INNER && b.getCell(i, j).getPos() != Position.END){
							if(b.getCell(i, j).getDir() == Direction.VERT)
								g2.drawString(Integer.toString(licznik), i*30 +1, j*30 + 145);
							else
								g2.drawString(Integer.toString(licznik), i*30 +5, j*30 + 150);
						}
						if(i==0){
							if(it.hasNext() && b.getCell(i, j).getPos() == Position.START){
								g2.drawString(Integer.toString(licznik) + ". " + it.next().getClue(), 450, (number)*32 + 140);
								number++;
							}
							licznik++;
						}
						
					}
				}
			}			
								
			
		
	}

	public void update(Crossword cw) {
		this.cw = cw;
		solve = false;
	}

	public void setSolve(){
		solve = !solve;
	}
}
