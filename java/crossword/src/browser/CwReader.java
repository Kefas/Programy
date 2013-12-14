package browser;

import graphicInterface.MyException;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import board.Crossword;

public class CwReader implements Reader {
	private File file;
	
	/**
	 * Constuctor with parameter 
	 * 
	 * @param filePath Path to Folder with crosswords
	 */
	public CwReader(String filePath) throws MyException{
		try{
			file = new File(filePath);	
		}catch (Exception e){
			throw new MyException("Nie mo¿na otworzyæ tego pliku");
		}
	}
	
	/**
	 * Method which returning list of crosswords
	 * 
	 * @return list of crosswords
	 * @throws MyException 
	 */
	@Override
	public LinkedList<Crossword> getAllCws() throws MyException {
		LinkedList<Crossword> list = new LinkedList<Crossword>();
		try{
		for(File f:file.listFiles())
			list.add(new Crossword(Long.parseLong(f.getName()), f));
		}
		catch (NumberFormatException e){
			throw new MyException("Z³y format pliku");
		}
		catch (IOException e){
			throw new MyException("B³ad odczytu z pliku");
		}
		
		return list;
	}

}
