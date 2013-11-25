package board;

import java.util.Random;

import dictionary.CwEntry;
import dictionary.Entry;

public class HardStrategy extends Strategy {

	@Override
	public CwEntry findEntry(Crossword cw) {
		Random generator = new Random();
		Entry temp = null;
		CwEntry ret = null;
		// TODO Auto-generated method stub
		if(cw.getEntries().isEmpty()){
			while(temp == null)
				temp = cw.getCwDB().getRandom(generator.nextInt(5)+cw.getHeight()/2);
			
		}
		if(temp != null){
		//	ret = new CwEntry(temp.getWord(), temp.getClue(), )
			return ret;
		}
		else return null;
	}

	@Override
	public void updateBoard(Board b, CwEntry c) {
		// TODO Auto-generated method stub

	}

}
