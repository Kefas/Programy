package board;

public class BoardCell {
	private boolean access;        
	private Direction direction;   
	private Position position;     
	private String content;		   
	
	
	/**
	 * Constructor with all parameters
	 * 
	 * @param content String which BoardCell contain
	 * @param state   Bool value determinate access to this cell
	 * @param direction Enum direction determinate direction of the whole word       
	 * @param position Enum determinate position of cell in whole word
	 */
	public BoardCell(String content, boolean state, Direction direction, Position position){
		this.content = content;
		this.access = true;
		this.direction = direction;
		this.position = position;
	}
	
	/**
	 * Constructor with String parameter
	 * 
	 * @param content String which BoardCell contain
	 */
	public BoardCell(String content) {
		this.content = content;
		this.access = true;
		this.position = Position.EMPTY;
		
	}

	/**
	 * Method which is setting all parameters
	 * 
	 * @param content String which BoardCell contain
	 * @param state
	 * @param d
	 * @param p
	 */
	public void setBoardCell(String content, boolean state, Direction d, Position p){
		this.content = content;
		this.access = state;
		this.direction = d;
		this.position = p;
	}
	
	/**
	 * Getter content
	 * 
	 * @return String with BoardCell content
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * Setter content
	 * 
	 * @param content String with new BoardCell content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Getter BoardCell Direction
	 * 
	 * @return Direction of BoardCell
	 */
	public Direction getDir(){
		return direction;
	}
	
	/**
	 * Getter position
	 * 
	 * @return Position of BoardCell
	 */
	public Position getPos(){
		return position;
	}
	
	/**
	 * Method checking if BoardCell is empty
	 * 
	 * @return True if is empty False if is not empty
	 */
	public boolean isEmpty(){
		if(content.length() > 0 && Character.isAlphabetic(content.charAt(0)))
			return false;
		else
			return true;
	}
	
	/**
	 * Getter Access
	 * 
	 * @return True if BoardCell is available False if is not available
	 */
	public boolean getAccess(){
		return access;
	}
	
	/**
	 * Setter access
	 * 
	 * @param state Boolean value which describing access to BoardCell
	 */
	public void setAccess(boolean state){
		access = state;
	}
	
	/**
	 * Setter Position
	 * 
	 * @param position Position of BoardCell in whole CwEntry
	 */
	public void setPosition(Position position) {
		this.position = position;
	}

	/**
	 * Setter Direction
	 * 
	 * @param direction Direction of BoardCell
	 */
	public void setDirection(Direction direction) {
		// TODO Auto-generated method stub
		this.direction = direction;
	}
		
}
