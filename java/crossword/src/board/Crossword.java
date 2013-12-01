package board;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import dictionary.CwEntry;
import dictionary.InteliCwDB;

public class Crossword {
	private LinkedList<CwEntry> entries;    
	private Board b;						
	private InteliCwDB cwdb;				
	private long ID;				        
	private int strat;
	private Strategy strategy;
	
	
	/**
	 * Constructor with Board and InteliCwDB parameters
	 * 
	 * @param b Board
	 * @param cwdb Crossword Database
	 */
	public Crossword(Board b, InteliCwDB cwdb){
		this.b = b;
		this.cwdb = cwdb;
		entries = new LinkedList<CwEntry>();
		setID(-1);
	}
	
	/**
	 * Constructor with height, width and InteliCwDB parameters
	 * 
	 * @param height Height of Board
	 * @param width Width of Board
	 * @param cwdb Crossword Database
	 */
	public Crossword(int height, int width, InteliCwDB cwdb) {
		b = new Board(height, width);
		this.cwdb = cwdb;
		entries = new LinkedList<CwEntry>();
		setID(-1);
	}

	/**
	 * Constructor with ID and File parameters
	 * 
	 * @param ID ID
	 * @param f File 
	 * @throws IOException
	 */
	public Crossword(long ID, File f) throws IOException {
		if(entries == null)
			entries = new LinkedList<CwEntry>();
		this.setID(ID);
		
		BufferedReader reader = new BufferedReader(new FileReader(f));
		String line = reader.readLine();
		String tab[] = line.split(" ");
		b = new Board(Integer.parseInt(tab[0]), Integer.parseInt(tab[1]));
		if(Integer.parseInt(tab[2]) == 0)
			strategy = new ConcreteStrategy();
		else
			strategy = new HardStrategy();
		
		while((line = reader.readLine()) != null){
			String word = line;
			String clue = reader.readLine();
			tab = reader.readLine().split(" ");
			Direction d;
			if(Integer.parseInt(tab[2])  == 0)
				d = Direction.HORIZ;
			else
				d = Direction.VERT;
			addCwEntry(new CwEntry(word, clue, Integer.parseInt(tab[0]), Integer.parseInt(tab[1]), d), strategy);		
		}	
		reader.close();
	}

	/**
	 * Getter Iterator
	 * 
	 * @return Iterator to list of entries
	 */
	public Iterator<CwEntry> getROEntryIter(){
		return Collections.unmodifiableList(getEntries()).iterator();
	}
	
	/**
	 * Getter LinkedList
	 * 
	 * @return LinkedList of CwEntry
	 */
	public LinkedList<CwEntry> getEntries() {
		return entries;
	}
	
	/**
	 * Getter copy of board
	 * 
	 * @return Copy of Board
	 */
	public Board getBoardCopy(){
		return b;
	}
	
	/**
	 * Getter Crossword Database
	 * 
	 * @return Crossword Database
	 */
	public InteliCwDB getCwDB(){
		return cwdb;
	}
	
	/**
	 * Setter Crossword Database
	 * 
	 * @param cwdb Crossword Database
	 */
	public void setCwDB(InteliCwDB cwdb){
		this.cwdb = cwdb;
	}
	
	/**
	 * Method which checking if word is in Crossword Database
	 * 
	 * @param word Word to check
	 * @return True if contain False if not
	 */
	public boolean contains(String word){
		if(cwdb.get(word) != null)
			return true;
		else
			return false;
	}
	
	/**
	 * Method which checking if CwEntry is in List of CwEntry
	 * 
	 * @param entry CwEntry to check
	 * @return True if containe False if not
	 */
	public boolean contains(CwEntry entry){
		for(int i=0;i<entries.size();i++)
			if(entries.get(i).getWord().equals(entry.getWord()))
				return true;
		return false;
	}
	
	/**
	 * Method which adding new CwEntry to list and updating board
	 * 
	 * @param cwe CwEntry which will be add
	 * @param s Strategy of Crossword composition
	 */
	public final void addCwEntry(CwEntry cwe, Strategy s){
		  entries.add(cwe);
		  s.updateBoard(b,cwe);
	}	
	
	/**
	 * Method which generating all CwEntrys
	 * 
	 * @param s Strategy of Crossword composition
	 */
	public final void generate(Strategy s){
		CwEntry e = null;
		while((e = s.findEntry(this)) != null){ 
			addCwEntry(e,s);
		}
	}

	/**
	 * Getter height
	 * 
	 * @return height of board
	 */
	public int getHeight(){
		return b.getHeight();
	}
	
	/**
	 * Getter width
	 * @return width of board
	 */
	public int getWidth(){
		return b.getWidth();
	}
	
	/**
	 * Method which setting strategy number
	 * 
	 * @param x  0 if Easy 1 if Hard
	 */
	public void setStrategyInt(int x){
		this.strat = x;
	}
	
	/**
	 * Getter Strategy int
	 * 
	 * @return 0 if easy 1 if hard
	 */
	public int getStrategyInt(){
		return strat;
	}
	
	/**
	 * Setter strategy
	 * 
	 * @param strat Strategy of Crossword
	 */
	public void setStrategy(Strategy strat){
		strategy = strat;
	}
	
	/**
	 * Getter strategy
	 * 
	 * @return strategy od Crossword
	 */
	public Strategy getStrategy(){
		return strategy;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}
}
