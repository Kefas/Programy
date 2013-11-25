package dictionary;


public class CwEntry extends Entry {

	private int x;
	private int y;
	private enum Direction{HORIZ, VERT};
	private Direction d;
	
	public CwEntry(String word, String clue, int x, int y) {
		super(word, clue);
		this.x = x;
		this.y = y;
		this.d = Direction.VERT;
	}

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public Direction getDir() {
		return d;
	}
	public String toString(){
		return this.getWord() + "\n" + this.getClue() + "\n" + Integer.toString(this.getX()) + " " + Integer.toString(this.getY());
		
	}
	

}
