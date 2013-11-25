package browser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;

import board.Crossword;

public interface Reader {
	public LinkedList<Crossword> getAllCws() throws NumberFormatException, FileNotFoundException, IOException;
}
