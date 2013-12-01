package graphicInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;

import javax.swing.JPanel;

import com.itextpdf.awt.PdfGraphics2D;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import dictionary.CwEntry;
import board.Board;
import board.Crossword;
import board.Direction;

public class MyPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	Crossword cw;
	private Iterator<CwEntry> it;
	private boolean solve;
	
	public MyPanel(){
		setPreferredSize(new Dimension(1000,650));
		cw = null;
		solve = false;
	}
	
	/**
	 * Method which printing crossword to pdf
	 * 
	 * @param file File where crossword will be printed
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 */
	public void printToPDF(File file) throws FileNotFoundException, DocumentException{
		Document document = new Document(PageSize.A4.rotate(), 10, 10, 10, 10);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file.getAbsoluteFile() + ".pdf"));
		writer.setViewerPreferences(PdfWriter.PageModeUseOC | PdfWriter.FitWindow);
        writer.setPdfVersion(PdfWriter.VERSION_1_5);
        document.open();
        PdfContentByte canvas = writer.getDirectContent();
        
        Graphics2D g2 = new PdfGraphics2D(canvas, PageSize.A4.getHeight(), PageSize.A4.getWidth());
        g2.scale(0.85,0.85);
        g2.translate(50, 50);
        canvas.moveTo(50, 50);
        this.paint(g2);
        g2.dispose();
        document.close();
	}

	/**
	 * Method painting crossword 
	 */
	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D)g;
		revalidate();

		g2.setColor(Color.black);
		if(cw!=null){
			int  number_poz=1, number_pion=1,number_poz_h=1, number_pion_h=1;
			it = cw.getROEntryIter();
			
			Board b = cw.getBoardCopy();
			for(int i=0; i< b.getWidth();i++){
				for(int j=0; j<b.getHeight();j++){

					if(b.getCell(i, j).getContent() != "."){				
						g2.drawRect((i+1)*30 + 10, (j+1)*30 + 100, 30, 30);				
						if(solve)
							g2.drawString(b.getCell(i,j).getContent(), (i+1)*30 + 22,(j+1)*30 + 117 );
						}
				}
			}
			number_pion = 1;
			number_poz = 1;
			CwEntry temp;
			while(it.hasNext()){
				temp = it.next();
				if (temp.getDir() == Direction.VERT){
					g2.drawString("Pionowo:", 450, 330);
					g2.drawString(Integer.toString(number_pion), temp.getX()*30 + 50, temp.getY()*30 + 129);
					if (temp.getClue() != ""){
						g2.drawString(Integer.toString(number_pion)+". "+temp.getClue(), 450, 330 + 30*number_pion_h);
						number_pion_h++;
					}
					number_pion++;
				}
				else{
					g2.drawString("Poziomo:", 450, 130);
					g2.drawString(Integer.toString(number_poz), temp.getX()*30 + 26, temp.getY()*30 + 150);			
					if (temp.getClue() != ""){
						g2.drawString(Integer.toString(number_poz)+". "+temp.getClue(), 450, 130 + 30*number_poz_h);
						number_poz_h++;
					}

					number_poz++;
				}
			}
				
			
		}
	}			
	
	/**
	 * Method updating current crossword
	 * @param cw actual Crossword
	 */
	public void update(Crossword cw) {
		this.cw = cw;
		solve = false;
	}

	/**
	 * Method setting on/off solving
	 */
	public void setSolve(){
		solve = !solve;
	}
}
