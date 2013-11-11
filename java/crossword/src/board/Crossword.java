package board;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;

import dictionary.CwEntry;
import dictionary.InteliCwDB;

public class Crossword {
	private LinkedList<CwEntry> entries;    // lista hase³ w krzy¿ówce
	private Board b;						// tablica krzy¿ówki
	private InteliCwDB cwdb;				// metoda do znajdywania hase³
	private final long ID = -1;				// some random shit
	
	public Crossword(Board b, InteliCwDB cwdb){
		this.b = b;
		this.cwdb = cwdb;
		entries = new LinkedList<CwEntry>();
	}
	
	public Iterator<CwEntry> getROEntryIter(){
		return Collections.unmodifiableList(getEntries()).iterator();
		
	}
	private LinkedList<CwEntry> getEntries() {
		return entries;
	}
	public Board getBoardCopy(){
		return b;
	}
	
	public InteliCwDB getCwDB(){
		return cwdb;
	}
	
	public void setCwDB(InteliCwDB cwdb){
		this.cwdb = cwdb;
	}
	
	public boolean contains(String word){
		if(cwdb.get(word) != null)
			return true;
		else
			return false;
	}
	
	public final void addCwEntry(CwEntry cwe, Strategy s){
		  entries.add(cwe);
		  s.updateBoard(b,cwe);
	}	
	
	public final void generate(Strategy s){
		CwEntry e = null;
		while((e = s.findEntry(this)) != null){ 
			addCwEntry(e,s);
		}
	}
	public void show(){
		for (int i=0; i<b.getHeight();i++){
			for(int j=0; j<b.getWidth();j++)
			System.out.print(b.getCell(j, i).getContent() + " ");
			System.out.println("");
		}
	}
	
}
