package board;

import java.util.Random;

import dictionary.CwEntry;
import dictionary.Entry;
import dictionary.InteliCwDB;

public class ConcreteStrategy extends Strategy {
	private String password = new String();
	private static int i=0;
	

	@Override
	public CwEntry findEntry(Crossword cw) { // funkcja znajduje odpowiednie has�a do g��wnego has�a
		// TODO Auto-generated method stub
		Direction d;
		d = Direction.VERT;
		CwEntry ret = null;
		Entry temp = null;  
		
		if(password.isEmpty())   // je�li nie mamy has�a to losujemy
			generatePassword(cw);
		
		while ( temp == null && i<password.length()){ 
			temp = cw.getCwDB().getRandom(password.charAt(i) + ".{1,9}" ); 	// je�eli nie znajdziemy has�a na konkretn� liter�
			if(temp == null)
				cw.getBoardCopy().setCell(0, i+1, new BoardCell(password.substring(i,i+1)));
			i++;															// to zwr�ci si� null, wi�c i++ i szukamy dla kolejnej litery
		}	
		if(temp != null){
			ret = new CwEntry(temp.getWord(), temp.getClue(), 0, i);       // tworzymy nowe CwEntry na podstawie znalezionego Entry
			updateBoard(cw.getBoardCopy(), ret);							// tego p�ki co nie pisz
			System.out.println(ret.getWord());								//wypisanie tego znalezionego s�owa
		}
		
		return ret;
	}

	@Override
	public void updateBoard(Board b, CwEntry c) {
		for(int i=0; i<c.getWord().length(); i++){
			b.getCell(i, c.getY()).setContent(c.getWord().substring(i,i+1));
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
			temp = crossword.getCwDB().getRandom(rand);
			
		}
		this.password = temp.getWord();
		System.out.println(password );	
	}
	
	
	
	

}
