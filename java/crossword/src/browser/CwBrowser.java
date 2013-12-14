package browser;
import graphicInterface.MyException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

import dictionary.InteliCwDB;
import board.Crossword;
import board.Strategy;

public class CwBrowser {
	private LinkedList<Crossword> list;
	private CwReader reader;
	private CwWriter writer;
	private InteliCwDB cwdb;
	private Crossword temp;
	/**
	 * Constructor with filePath parameter
	 * 
	 * @param filePath filePath to Crossword Database file
	 * @throws FileNotFoundException
	 */
	public CwBrowser(String filePath) throws MyException{
		if(filePath == null)
			filePath = "cwdb.txt";
		try{
		cwdb = new InteliCwDB(filePath);	
		list = new LinkedList<Crossword>();
		}
		catch (IOException e){
			throw new MyException("Nie mo¿na otworzyæ pliku z has³ami");
		}
		
	}
	
	/**
	 * Method which generating Crossword
	 * 
	 * @param height Height of Board
	 * @param width Width of Board
	 * @param strategy Strategy of crossword
	 */
	public void generateCw(int height, int width, Strategy strategy) throws MyException{
		Crossword cw = new Crossword(height,  width, cwdb);
		cw.generate(strategy);
		temp = cw;
		list.add(temp);
	}
	
	/**
	 * Method save
	 * 
	 * @param folderPath folderPath where Crossword should be saved
	 * @throws Exception 
	 */
	public void save(String folderPath) throws MyException{
		writer = new CwWriter(folderPath);
		writer.write(temp);

	}
	
	/**
	 * Method load
	 * 
	 * @param folderPath folderPath from where Crossword should be loaded
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public void load(String folderPath) throws MyException{
		reader = new CwReader(folderPath);
		list.addAll(reader.getAllCws());
		temp = list.getLast();	
	}
	
	/**
	 * Method which returning actual Crossword
	 * 
	 * @return actual crossword
	 */
	public Crossword getCw(){
		return temp;
	}
	
	/**
	 * Method which updating Crossword Dtabase
	 * 
	 * @param filePath FilePath 
	 * @throws FileNotFoundException
	 */
	public void updateCwBD(String filePath) throws MyException{
		try{
//			System.err.println("emm");
			cwdb = new InteliCwDB(filePath);
		}
		catch (FileNotFoundException e){
			throw new MyException("Nie mo¿na odnaleŸæ pliku");
		}
	}

	/**
	 * Method which setting actual Crossword on previous
	 */
	public void prev() {
		if( list.indexOf(temp)>0 && list.indexOf(temp)<list.size())
			temp = list.get(list.indexOf(temp)-1);	
	}
	
	/**
	 * Method which setting actual Crossword on next
	 */
	public void next(){
		if( list.indexOf(temp)>=0 && list.indexOf(temp)<list.size()-1)
			temp = list.get(list.indexOf(temp)+1);
	}
}
