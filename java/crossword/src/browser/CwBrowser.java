package browser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;

import dictionary.InteliCwDB;
import board.ConcreteStrategy;
import board.Crossword;
import board.Strategy;

public class CwBrowser {
	private LinkedList<Crossword> list;
	private CwReader reader;
	private CwWriter writer;
	private InteliCwDB cwdb;
	private Crossword temp;
	private ListIterator<Crossword> it;

	public CwBrowser(String filePath) throws FileNotFoundException{
		if(filePath == null)
			filePath = "cwdb.txt";
		cwdb = new InteliCwDB(filePath);	
		list = new LinkedList<Crossword>();
		
	}
	
	public void generateCw(int height, int width, Strategy strategy){
		Crossword cw = new Crossword(height,  width, cwdb);
		cw.generate(strategy);
		temp = cw;
		list.add(temp);
	}
	public void save(String folderPath) throws IOException{
		writer = new CwWriter(folderPath);
		writer.write(temp);
	}
	public void load(String folderPath) throws NumberFormatException, IOException{
		reader = new CwReader(folderPath);
		list.addAll(reader.getAllCws());
		temp = list.getLast();	
	}
	public Crossword getCw(){
		return temp;
	}
	public void updateCwBD(String filePath) throws FileNotFoundException{
		cwdb = new InteliCwDB(filePath);
	}

	public void prev() {
			
		
		if( list.indexOf(temp)>0 && list.indexOf(temp)<list.size())
			temp = list.get(list.indexOf(temp)-1);
		
	}
	public void next(){
		if( list.indexOf(temp)>=0 && list.indexOf(temp)<list.size()-1)
			temp = list.get(list.indexOf(temp)+1);
	}
}
