package dictionary;

public class Entry {
	private String word;
	private String clue;
	
	/**
	 * Constructor with Word and Clue parameter
	 * 
	 * @param word Word
	 * @param clue Clue
	 */
	public Entry( String word, String clue){
		this.word = word;
		this.clue = clue;
	}
	
	/**
	 * Getter Word
	 * @return Word
	 */
	public String getWord(){
		return word;
	}
	
	/**
	 * Getter Clue
	 * @return Clue
	 */
	public String getClue() {
		return clue;
	}		
}
