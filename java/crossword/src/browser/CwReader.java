package browser;

import java.io.File;
import java.util.LinkedList;

import board.Crossword;

public class CwReader implements Reader {
	private File file;
	
	public CwReader(String filePath){
		file = new File(filePath);
		//dopisa� wyj�tki tutaj
	}
	@Override
	public LinkedList<Crossword> getAllCws() {
		LinkedList<Crossword> list = new LinkedList<Crossword>();
		
		return null;
	}

}
