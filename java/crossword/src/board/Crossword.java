package board;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import dictionary.CwEntry;
import dictionary.InteliCwDB;

public class Crossword {
	private LinkedList<CwEntry> entries;    // lista hase³ w krzy¿ówce
	private Board b;						// tablica krzy¿ówki
	private InteliCwDB cwdb;				// metoda do znajdywania hase³
	private long ID;				// some random shit
	private int strat;
	private Strategy strategy;
	
	public Crossword(Board b, InteliCwDB cwdb){
		this.b = b;
		this.cwdb = cwdb;
		entries = new LinkedList<CwEntry>();
		ID = -1;
//		temporarty
		//strategy = new ConcreteStrategy();
	}
	
	public Crossword(int height, int width, InteliCwDB cwdb) {
		// TODO Auto-generated constructor stub
		b = new Board(height, width);
		this.cwdb = cwdb;
		entries = new LinkedList<CwEntry>();
		ID = -1;
		//temporary 
		//strategy = new ConcreteStrategy();
	}

	public Crossword(long ID, File f) throws IOException {
		if(entries == null)
			entries = new LinkedList<CwEntry>();
		this.ID = ID;
		
		BufferedReader reader = new BufferedReader(new FileReader(f));
		String line = reader.readLine();
		String tab[] = line.split(" ");
		b = new Board(Integer.parseInt(tab[0]), Integer.parseInt(tab[1]));
		if(Integer.parseInt(tab[2]) == 0)
			strategy = new ConcreteStrategy();
		while((line = reader.readLine()) != null){
			String word = line;
			String clue = reader.readLine();
			tab = reader.readLine().split(" ");
			addCwEntry(new CwEntry(word, clue, Integer.parseInt(tab[0]), Integer.parseInt(tab[1])), strategy);		
		}
			
		reader.close();
	}

	public Iterator<CwEntry> getROEntryIter(){
		return Collections.unmodifiableList(getEntries()).iterator();
		
	}
	public LinkedList<CwEntry> getEntries() {
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
	public int getHeight(){
		return b.getHeight();
	}
	public int getWidth(){
		return b.getWidth();
	}
	public void setStrategyInt(int x){
		this.strat = x;
	}
	public int getStrategyInt(){
		return strat;
	}
	public void setStrategy(Strategy strat){
		strategy = strat;
	}
	public Strategy getStrategy(){
		return strategy;
	}
	
	
}
