package dictionary;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Random;



public class InteliCwDB extends CwDB {

	public InteliCwDB(String filename) throws FileNotFoundException {
		super(filename);
	}
	
	public LinkedList<Entry> findAll(String pattern){
		LinkedList<Entry> words = new LinkedList<Entry>();
		for(int i=0; i<dict.size();i++){
			if(dict.get(i).getWord().matches(pattern))
				words.add(dict.get(i));			
		}
		return words;
	}
	
	public Entry getRandom(){
		Random rand = new Random();
		return dict.get(rand.nextInt(dict.size()));
	}
	
	public Entry getRandom(int length){
		Random rand = new Random();
		LinkedList<Entry> words = new LinkedList<Entry>();
		for(int i=0; i<dict.size();i++){
			if(dict.get(i).getWord().length() == length)
				words.add(dict.get(i));
		}
		if (words.isEmpty())
			return null;
		else
			return words.get(rand.nextInt(words.size()));
	}
	
	public Entry getRandom(String pattern){
		Random rand = new Random();
		LinkedList<Entry> list = findAll(pattern);
		if (list.isEmpty())
			return null;
		else
			return list.get(rand.nextInt(list.size()));
	}
	
	public void add(String word, String clue){
		int i=0;
		for(i=0;i <dict.size();i++){
			if ( word.compareToIgnoreCase(dict.get(i).getWord()) < 0) break;		
		}
		
		if(!Character.isAlphabetic(word.charAt(0)) ){
			dict.add(i, new Entry(word.substring(1), clue));
		}
		else
			dict.add(i, new Entry(word, clue));
	}
	

}
