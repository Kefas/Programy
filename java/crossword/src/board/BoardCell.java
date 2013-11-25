package board;

public class BoardCell {
	private boolean acces;
	private Direction d;
	private Position p;
	private String content;
	
	public BoardCell(String content, boolean state, Direction d, Position p){
		this.content = content;
		acces = state;
		this.d = d;
		this.p = p;
	}
	
	public BoardCell(String content) {
		this.content = content;
	}

	
	public void setBoardCell(String content, boolean state, Direction d, Position p){
		this.content = content;
		acces = state;
		this.d = d;
		this.p = p;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public Direction getDir(){
		return d;
	}
	
	public Position getPos(){
		return p;
	}
	public boolean isEmpty(){
		if(content.length() > 0)
			return false;
		else
			return true;
	}
	
	
	
	
}
