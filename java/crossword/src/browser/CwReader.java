package browser;

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
	public CwReader(String filePath) throws IOException{
		file = new File(filePath);	
	}
	
	/**
	 * Method which returning list of crosswords
	 * 
	 * @return list of crosswords
	 */
	@Override
	public LinkedList<Crossword> getAllCws() throws NumberFormatException, IOException {
		LinkedList<Crossword> list = new LinkedList<Crossword>();
		for(File f:file.listFiles())
			list.add(new Crossword(Long.parseLong(f.getName()), f));
		
		return list;
	}

}
