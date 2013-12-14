package browser;

import graphicInterface.MyException;

import java.util.LinkedList;

import board.Crossword;

public interface Reader {
	public LinkedList<Crossword> getAllCws() throws  MyException;
}
