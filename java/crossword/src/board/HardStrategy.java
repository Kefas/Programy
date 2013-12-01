package board;

import java.util.Random;

import dictionary.CwEntry;
import dictionary.Entry;

public class HardStrategy extends Strategy {
	int counter;
	int x;
	int y;
	Direction d;
	@Override
	
	/**
	 * Mehtod which searching appropriate word
	 * 
	 * @param Crossword 
	 * @return Appropriate CwEntry if available null if not
	 */
	public CwEntry findEntry(Crossword cw) {
		cw.setStrategyInt(1);
		Random generator = new Random();
		Entry temp = null;
		CwEntry entry = null;
		CwEntry ret = null;
		String reg = new String();
		boolean acc = true;
		int licznik = 0;
		int inf = 0;
				
		// co siê dzieje gdy pusta lista - losujemy pierwsze has³o
		if(cw.getEntries().isEmpty()){
			x = cw.getWidth()/2;
			y = 0;
			d = Direction.VERT;
			if(temp == null)
				temp = cw.getCwDB().getRandom(cw.getHeight());
			counter++;
		}
		else{
			// dopóki nie wylosujemy has³a b¹dŸ znajdziemy ju¿ 2
			while((temp == null && counter < 10) && inf<200){
				entry = cw.getEntries().get(generator.nextInt(cw.getEntries().size()));
				licznik = 0;
				reg = "";
				acc = true;
//				co gdy wylosowane entry jest poziome czyli robimy pionowe
				if (entry.getDir() == Direction.HORIZ){
					do{
						x = entry.getX() + generator.nextInt(entry.getWord().length());
						y = entry.getY();
						licznik++;
//						System.out.print(cw.getBoardCopy().getCell(x, y).getContent()+ ",");
					}while(cw.getBoardCopy().getCell(x, y).getAccess() != true && licznik < entry.getWord().length());
				
					if(cw.getBoardCopy().getCell(x, y).getAccess() == true){
						if (y>0)
							y = y - generator.nextInt(y);
						
						for(int i=y; i<cw.getHeight()-y;i++){
							reg += cw.getBoardCopy().getCell(x, i).getContent();
							if(cw.getBoardCopy().getCell(x, i).getAccess() == false)
								acc = false;
							if(x>0) {
								if(cw.getBoardCopy().getCell(x-1, i).getDir() == Direction.VERT)
									acc = false;
//								if(cw.getBoardCopy().getCell(x-1, i).getPos() != Position.END)
//									acc = false;
							}
							if (x<cw.getWidth()-1){
								if(cw.getBoardCopy().getCell(x+1, i).getDir() == Direction.VERT)
									acc =false;
//								if(cw.getBoardCopy().getCell(x+1, i).getPos() != Position.START )
//									acc = false;
							}
					
							if(i==y)
								if(i>0){
									cw.getBoardCopy().getCell(x, i-1).setAccess(false);
									if(cw.getBoardCopy().getCell(x, i-1).getContent() != ".")
										acc = false;
								}
							if(i==cw.getHeight()-y-1)
								if(i<cw.getHeight()-1){
									cw.getBoardCopy().getCell(x, i+1).setAccess(false);
									if(cw.getBoardCopy().getCell(x, i+1).getContent() != ".")
										acc = false;
								}
						}
						
						if(reg.length() < 2 )
							acc=false;
						
						if(acc == true && counter>1){
							acc = false;
							for(int i=0;i<reg.length();i++)	
								if(reg.charAt(i) != '.')
									acc = true;
						}
						
					}
					if(acc == true ){
//						System.out.println(reg);
						temp = cw.getCwDB().getRandom(reg);
						d = Direction.VERT;	
					}
						
				}
				else if( entry.getDir() == Direction.VERT){ // if prev was Direction.Vert
					do{
						x = entry.getX();
						y = entry.getY() + generator.nextInt(entry.getWord().length()); 
						licznik++;
//						System.out.println("Y is " + y);
//						System.out.println(cw.getBoardCopy().getCell(x,y).getAccess());
					}while(cw.getBoardCopy().getCell(x,y).getAccess() != true && licznik < entry.getWord().length());
				
					if(cw.getBoardCopy().getCell(x, y).getAccess() == true){
						if(x>0)
							x = x - generator.nextInt(x);
						for(int i=x; i<cw.getWidth()-x;i++){
							reg += cw.getBoardCopy().getCell(i,y).getContent();
							if(cw.getBoardCopy().getCell(i,y).getAccess() == false)
								acc = false;
							if(y>0){
								if(cw.getBoardCopy().getCell(i, y-1).getDir() == Direction.HORIZ)
									acc = false;
//								if(cw.getBoardCopy().getCell(i, y-1).getPos() != Position.END)
//									acc = false;
							}
							if(y<cw.getHeight()-1){
								if(cw.getBoardCopy().getCell(i, y+1).getDir() == Direction.HORIZ)
									acc = false;
//								if(cw.getBoardCopy().getCell(i, y+1).getPos() != Position.START)
//									acc = false;
							}
							if(i==x)
								if(i>0){
									cw.getBoardCopy().getCell(i-1, y).setAccess(false);
									if(cw.getBoardCopy().getCell(i-1, y).getContent() != ".")
										acc = false;
								}
							if(i==cw.getWidth()-x-1)
								if(i<cw.getWidth()-1){
									cw.getBoardCopy().getCell(i+1, y).setAccess(false);
									if(cw.getBoardCopy().getCell(i+1, y).getContent() != ".")
										acc = false;
								}						
						}	
						if(reg.length() < 2)
							acc=false;			
					}
					if(acc == true){
//						System.out.println(reg);
						temp = cw.getCwDB().getRandom(reg);
						d = Direction.HORIZ;	
					}
				}
				inf++;		
			}
		}	
	
//		System.out.println(inf);
		if(temp != null){
			ret = new CwEntry(temp.getWord(), temp.getClue(),x,y,d);
			counter++;
			if(cw.contains(ret))
				return null;
//			System.out.println(ret.getWord());
			return ret;		
		}
		else return null;
	}	
	/**
	 * Method which updating board
	 *
	 * @param b Board 
	 * @param c Entry
	 */
	@Override
	public void updateBoard(Board b, CwEntry c) {
//		System.out.println(c.getWord());
		int j=0;
		if(c.getDir() == Direction.HORIZ){
			for(int i=c.getX(); i< c.getX()+c.getWord().length(); i++){
				if(b.getCell(i,c.getY()).getContent() == ".")
					b.getCell(i, c.getY()).setAccess(true);
				else{ 
					b.getCell(i, c.getY()).setAccess(false);
					if(c.getY()>0)
						b.getCell(i, c.getY()-1).setAccess(false);
					if(c.getY()<b.getHeight()-1)
						b.getCell(i, c.getY()+1).setAccess(false);					
					if(i>0){
						b.getCell(i-1, c.getY()).setAccess(false);
						if(c.getY()>0){
							b.getCell(i-1, c.getY()-1).setAccess(false);
						}
						if(c.getY()<b.getHeight()-1){
							b.getCell(i-1, c.getY()+1).setAccess(false);	
						}
					}
					if(i<b.getWidth()-1){
						b.getCell(i+1, c.getY()).setAccess(false);
						if(c.getY()>0)
							b.getCell(i+1, c.getY()-1).setAccess(false);
						if(c.getY()<b.getHeight()-1)
							b.getCell(i+1, c.getY()+1).setAccess(false);							
					}
				}
				/*
				if(c.getY()>0)
					b.getCell(i, c.getY()-1).setAccess(false);
				if(c.getY()<b.getHeight())
					b.getCell(i, c.getY()+1).setAccess(false);
				*/			
				b.getCell(i, c.getY()).setContent(c.getWord().substring(j, j+1));	
				j++;
				if(i==c.getX())
					b.getCell(i, c.getY()).setPosition(Position.START);
				else if(i==c.getX()+c.getWord().length()-1)
					b.getCell(i, c.getY()).setPosition(Position.END);
				else 
					b.getCell(i, c.getY()).setPosition(Position.INNER);
				
				b.getCell(i,c.getY()).setDirection(Direction.HORIZ);				
			}			
		}
		else{		
			for(int i=c.getY(); i<c.getY() + c.getWord().length(); i++){
				if(b.getCell(c.getX(),i).getContent() == ".")
					b.getCell(c.getX(),i).setAccess(true);
				else{ 
					b.getCell(c.getX(),i).setAccess(false);
				
					if(c.getX()>0)
						b.getCell(c.getX()-1,i).setAccess(false);
					if(i>0){
						b.getCell(c.getX(),i-1).setAccess(false);
						if(c.getX()>0){
							b.getCell(c.getX()-1,i-1).setAccess(false);		
						}
						if(c.getX()<b.getHeight()){
							b.getCell(c.getX()+1,i).setAccess(false);
							if(i>0)
								b.getCell(c.getX()+1,i-1).setAccess(false);
						}
					}
					if(i<b.getWidth()-1){
						b.getCell(c.getX(),i+1).setAccess(false);
						if(c.getX()>0)
							b.getCell(c.getX()-1,i+1).setAccess(false);
						if(c.getX()<b.getHeight())
							b.getCell(c.getX()+1,i+1).setAccess(false);							
					}
				}
				/*
				if(c.getX()>0)
					b.getCell(c.getX(),i-1).setAccess(false);
				if(c.getX()<b.getHeight())
					b.getCell(c.getX(), i+1).setAccess(false);
				*/
				
				b.getCell(c.getX(),i).setContent(c.getWord().substring(j, j+1));
				if(i==c.getY())
					b.getCell(c.getX(),i).setPosition(Position.START);
				else if(i==c.getY()+c.getWord().length()-1)
					b.getCell(c.getX(),i).setPosition(Position.END);
				else 
					b.getCell(c.getX(),i).setPosition(Position.INNER);
				b.getCell(c.getX(), i).setDirection(Direction.VERT);
				j++;
			}
		}
	}
}
