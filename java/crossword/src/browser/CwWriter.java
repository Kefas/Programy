package browser;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.Iterator;

import dictionary.CwEntry;
import board.Crossword;

public class CwWriter implements Writer {
	private File file;
	
	/**
	 * Constructor with file Path parameter
	 * 
	 * @param filePath path to folder where should be file saved
	 */
	public CwWriter(String filePath) {
		// TODO Auto-generated constructor stub
		file = new File(filePath);
		//wyj¹tki
	}
	
	/**
	 * Method saving the crossword
	 * @throws Exception 
	 */
	@Override	
	public void write(Crossword cw) throws Exception{
	
		FileWriter writer = null;
		try{
			//throw new Exception("No crossword to save");
			Iterator<CwEntry> iter = cw.getROEntryIter();
			if(!iter.hasNext())
				throw new Exception("No crossword to save");
			writer = new FileWriter(file.getAbsolutePath() + "\\" + Long.toString(getUniqueID()));
		
			writer.write(cw.getHeight() + " " + cw.getWidth() + " " + cw.getStrategyInt() + "\n");
		
			while(iter.hasNext()){
				writer.write(iter.next().toString() + "\n");
			}
		}
		catch (NullPointerException e){
			throw new Exception("Null pointer exception");
		}
		catch (Exception e){
			throw e;
			
		}
		finally{
			System.out.println("close");
			writer.close();
		}
	}

	/**
	 * Getter ID
	 * 
	 * @return time of function execution in mileseconds
	 */
	@Override
	public Long getUniqueID() {
		// TODO Auto-generated method stub
		return new Long(new Date().getTime());
	}

}
