package board;

import dictionary.CwEntry;
import dictionary.Entry;

public class ConcreteStrategy extends Strategy {
	private String password = new String();
	private int i=0;
	
	/**
	 * Mehtod which searching appropriate word
	 * 
	 * @param Crossword 
	 * @return Appropriate CwEntry if available null if not
	 */
	@Override
	public CwEntry findEntry(Crossword cw) { 
		CwEntry ret = null;
		Entry temp = null; 
		cw.setStrategyInt(0);
		
		if(password.isEmpty()){  // jeœli nie mamy has³a to losujemy
			generatePassword(cw);
		}
		while( temp == null && i<password.length()){
			int size = cw.getWidth()-1;
			temp = cw.getCwDB().getRandom(password.charAt(i) + ".{1,"+ size + "}" ); 
			if(temp == null){
				temp = new Entry(password.substring(i,i+1), "");
			//	i++;
			}
		}
		if(temp != null){
			ret = new CwEntry(temp.getWord(), temp.getClue(), 0, i);  
			ret.setDir(Direction.HORIZ);
		}
		i++;
		return ret;
	}

	/**
	 * Method which updating board
	 *
	 * @param b Board 
	 * @param c Entry
	 */
	@Override
	public void updateBoard(Board b, CwEntry c) {
//m.out.println("BZD " + c.getWord());
		for(int i=0; i<c.getWord().length(); i++){
			//System.out.println(c.getWord().substring(i,i+1) + " " + i + " " + c.getY() );
			if(i==0)
				b.getCell(i, c.getY()).setBoardCell(c.getWord().substring(i,i+1),true, Direction.HORIZ, Position.START);
			else if(i<c.getWord().length()-1)
				b.getCell(i, c.getY()).setBoardCell(c.getWord().substring(i,i+1),false, Direction.HORIZ, Position.INNER);
			else
				b.getCell(i, c.getY()).setBoardCell(c.getWord().substring(i,i+1),false,Direction.HORIZ, Position.END);
				
		}

	}
	
	/**
	 * Method which generating main Entry
	 * 
	 * @param crossword  Concrete crossword
	 */
	public void generatePassword(Crossword crossword){
		//Random generator = new Random();
//		System.out.println(crossword.getBoardCopy().getHeight());
		
		Entry temp = null;
		while(temp == null){
			temp = crossword.getCwDB().getRandom(crossword.getHeight());			
		}
		this.password = temp.getWord();
//		System.out.println(password );	
	}	

}
