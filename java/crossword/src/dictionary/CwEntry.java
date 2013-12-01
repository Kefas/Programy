package dictionary;

import board.Direction;


public class CwEntry extends Entry {

	private int x;
	private int y;
	private Direction d;
	
	/**
	 * Constructor with 4 parameters
	 * 
	 * @param word Word
	 * @param clue Clue
	 * @param x Width
	 * @param y Height
	 */
	public CwEntry(String word, String clue, int x, int y) {
		super(word, clue);
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Constructor with 5 parameters
	 * 
	 * @param word Word
	 * @param clue Clue
	 * @param x Width
	 * @param y Height
	 * @param d Direction of word
	 */
	public CwEntry(String word, String clue, int x,int y, Direction d){
		super(word, clue);
		this.x = x;
		this.y = y;
		this.d = d;
	}

	/**
	 * Setter Direction
	 * @param d Direction of entry
	 */
	public void setDir(Direction d){
		this.d = d;
	}

	/**
	 * Getter width
	 * @return width
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Getter Height
	 * @return height
	 */
	public int getY() {
		return y;
	}

	/**
	 * Getter Direction
	 * @return Direction of Entry
	 */
	public Direction getDir() {
		return d;
	}
	/**
	 * To String method
	 * @param class to string
	 */
	public String toString(){
		int dir;
		if( d == Direction.HORIZ)
			dir = 0;
		else
			dir = 1;
		return this.getWord() + "\n" + this.getClue() + "\n" + Integer.toString(this.getX()) + " " + Integer.toString(this.getY()) + " " + Integer.toString(dir);	
	}
}
