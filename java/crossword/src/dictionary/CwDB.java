package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class CwDB {
	protected LinkedList<Entry> dict;
	
	/**
	 * Constructor with String path to Crossword Database
	 * 
	 * @param filename path to Crossword Database
	 * @throws FileNotFoundException
	 */
	public CwDB(String filename) throws FileNotFoundException {
		dict = new LinkedList<Entry>();
		createDB(filename);	
	}
	
	/**
	 * Method which adding a new Entry
	 * 
	 * @param word Word
	 * @param clue Clue
	 */
	public void add(String word, String clue){
		if(!Character.isAlphabetic(word.charAt(0)) ){
			dict.add(new Entry(word.substring(1), clue));
		}
		else
			dict.add(new Entry(word, clue));
	}
	
	/**
	 * Getter Entry
	 * 
	 * @param word
	 * @return Entry with param word
	 */
	public Entry get(String word){
		for(int i=0; i<dict.size(); i++)
			if( dict.get(i).getWord().equals(word))
				return dict.get(i);
			
		return null;
	}
	
	/**
	 * Method removing 
	 * 
	 * @param word
	 */
	public void remove(String word){
		for(int i=0; i<dict.size(); i++)
			if( dict.get(i).getWord().equals(word))
				dict.remove(i);
	}
	
	/**
	 * Method which saving processed Crossword Database
	 * 
	 * @param filename String path to new file
	 * @throws IOException
	 */
	public void saveDB(String filename) throws IOException{
		PrintWriter out = new PrintWriter(filename, "UTF-8");
		for(int i=0; i<getSize();i++){
			out.println(dict.get(i).getWord());
			out.println(dict.get(i).getClue());
		}
		out.close();	
	}
	
	/**
	 * Getter size of Crossword Database
	 * 
	 * @return Size of Crossword Database
	 */
	public int getSize(){
		return dict.size();
	}
	
	/**
	 * Method creating a new Crossword Database
	 * 
	 * @param filename String path to new Crossword Database
	 * @throws FileNotFoundException
	 */
	protected void createDB(String filename) throws FileNotFoundException{
		File myfile = null;
		Scanner in = null;
//		System.err.println("here");
		try{
			myfile = new File(filename);
			in = new Scanner(myfile, "UTF-8");
		
			while(in.hasNextLine()){
				add(in.nextLine(), in.nextLine());
			}
		}
		finally{
			in.close();
		}
	}	
}
