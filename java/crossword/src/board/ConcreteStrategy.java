package board;

import java.util.Random;

import dictionary.CwEntry;
import dictionary.Entry;
import dictionary.InteliCwDB;

public class ConcreteStrategy extends Strategy {
	private String password = new String();
	private int i=0;
	

	@Override
	public CwEntry findEntry(Crossword cw) { // funkcja znajduje odpowiednie has³a do g³ównego has³a
		// TODO Auto-generated method stub
		Direction d;
		d = Direction.VERT;
		CwEntry ret = null;
		Entry temp = null; 
		cw.setStrategyInt(0);
		
		if(password.isEmpty()){  // jeœli nie mamy has³a to losujemy
			System.out.println("JUZZ");
			generatePassword(cw);
		}
		while ( temp == null && i<password.length()){ 
			temp = cw.getCwDB().getRandom(password.charAt(i) + ".{1,9}" ); 	// je¿eli nie znajdziemy has³a na konkretn¹ literê
			if(temp == null)
				cw.getBoardCopy().setCell(0, i+1, new BoardCell(password.substring(i,i+1)));
			i++;															// to zwróci siê null, wiêc i++ i szukamy dla kolejnej litery
		}	
		if(temp != null){
			//while(ret == null)
			ret = new CwEntry(temp.getWord(), temp.getClue(), 0, i);       // tworzymy nowe CwEntry na podstawie znalezionego Entry
		//s	updateBoard(cw.getBoardCopy(), ret);							// tego póki co nie pisz
//			tutaj zamiast updateBoard addCwEntry
			//cw.addCwEntry(ret, this);
			
			System.out.println(ret.getWord());								//wypisanie tego znalezionego s³owa
		}
		
		return ret;
	}

	@Override
	public void updateBoard(Board b, CwEntry c) {
		for(int i=0; i<c.getWord().length(); i++){
			if(i==0)
				b.getCell(i, c.getY()).setBoardCell(c.getWord().substring(i,i+1),true, Direction.HORIZ, Position.START);
			else if(i<c.getWord().length()-1)
				b.getCell(i, c.getY()).setBoardCell(c.getWord().substring(i,i+1),false, Direction.HORIZ, Position.INNER);
			else
				b.getCell(i, c.getY()).setBoardCell(c.getWord().substring(i,i+1),false,Direction.HORIZ, Position.END);
		}

	}
	
	public void generatePassword(Crossword crossword){
		Random generator = new Random();
		System.out.println(crossword.getBoardCopy().getHeight());
		int half = crossword.getBoardCopy().getHeight()/2;
		if(half > 7) half = 7;
		
		Entry temp = null;
		while(temp == null){
			int rand = generator.nextInt(crossword.getBoardCopy().getHeight() - half) + half;
		//	System.out.print(crossword.getCwDB());
			temp = crossword.getCwDB().getRandom(rand);			
		}
		this.password = temp.getWord();
		System.out.println(password );	
	}
	
	
	
	

}
