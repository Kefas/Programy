package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class CwDB {
	protected LinkedList<Entry> dict;
	
	public CwDB(String filename) throws FileNotFoundException {
		dict = new LinkedList<Entry>();
		createDB(filename);	
	}
	public void add(String word, String clue){
		if(!Character.isAlphabetic(word.charAt(0)) ){
			dict.add(new Entry(word.substring(1), clue));
		}
		else
			dict.add(new Entry(word, clue));
	}
	
	public Entry get(String word){
		for(int i=0; i<dict.size(); i++)
			if( dict.get(i).getWord().equals(word))
				return dict.get(i);
			
		return null;
	}
	
	public void remove(String word){
		for(int i=0; i<dict.size(); i++)
			if( dict.get(i).getWord().equals(word))
				dict.remove(i);
	}
	
	public void saveDB(String filename) throws IOException{
		PrintWriter out = new PrintWriter(filename, "UTF-8");
		for(int i=0; i<getSize();i++){
			out.println(dict.get(i).getWord());
			out.println(dict.get(i).getClue());
		}
		out.close();
		
	}
	
	public int getSize(){
		return dict.size();
	}
	
	protected void createDB(String filename) throws FileNotFoundException{
		File myfile = new File(filename);
		Scanner in = new Scanner(myfile, "UTF-8");
		
		while(in.hasNextLine()){
			add(in.nextLine(), in.nextLine());
		}
		in.close();
	}
	
	
}
