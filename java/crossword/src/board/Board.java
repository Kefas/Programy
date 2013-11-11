package board;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class Board {
	private BoardCell[][] board;
	
	public Board(int x, int y){
		board = new BoardCell[x][y];
		for(int i=0; i<getWidth();i++){
			for(int j=0; j<getHeight();j++){
				board[i][j] = new BoardCell("");
			}
		}
	}
	public int getWidth(){
		return board.length;
	}
	public int getHeight(){
		return board[0].length;
	}
	
	public BoardCell getCell(int x, int y){
		return board[x][y];
	}
	public void setCell(int x, int y, BoardCell c){
		board[x][y] = c;
	}
	public LinkedList<BoardCell> getStartCells(){
		LinkedList<BoardCell> startCells = new LinkedList<BoardCell>();
		for(int i=0; i<getWidth();i++){
			for(int j=0; j<getHeight();j++){
				if(board[i][j].getPos() == Position.START){
					startCells.add(board[i][j]);
				}
			}
		}
		return startCells;
	}

	 public Pattern createPattern(int fromx, int fromy, int tox, int toy) {
         String pattern = "";
         if (fromx == tox) {
                 for (int i = fromy; i < toy; i++) {
                         if (!getCell(fromx, i).isEmpty())
                                 pattern += getCell(fromx, i).getContent();
                         else
                                 pattern += ".";
                 }
         } else if (fromy == toy) {
                 for (int i = fromx; i < tox; i++) {
                         if (!getCell(i, fromy).isEmpty())
                                 pattern += getCell(i, fromy).getContent();
                         else
                                 pattern += ".";
                 }
         }
         return Pattern.compile(pattern);
	 }	
}
