package browser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

import board.Crossword;

public class CwReader implements Reader {
	private File file;
	
	public CwReader(String filePath){
		file = new File(filePath);
		//dopisaæ wyj¹tki tutaj
	}
	@Override
	public LinkedList<Crossword> getAllCws() throws NumberFormatException, IOException {
		LinkedList<Crossword> list = new LinkedList<Crossword>();
		for(File f:file.listFiles()){
			list.add(new Crossword(Long.parseLong(f.getName()), f));
		}
	//	Crossword temp = new Crossword()
		return list;
	}

}
