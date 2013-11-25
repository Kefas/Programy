package browser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;

import dictionary.CwEntry;
import board.Crossword;

public class CwWriter implements Writer {
	private File file;
	
	public CwWriter(String filePath) {
		// TODO Auto-generated constructor stub
		file = new File(filePath);
		//wyj¹tki
	}
	
	@Override	
	public void write(Crossword cw) throws IOException {
		// TODO Auto-generated method stub
		FileWriter writer = new FileWriter(file.getAbsolutePath() + "\\" + Long.toString(getUniqueID()));
		
		writer.write(cw.getHeight() + " " + cw.getWidth() + " " + cw.getStrategyInt() + "\n");
		Iterator<CwEntry> iter = cw.getROEntryIter();
		while(iter.hasNext()){
			writer.write(iter.next().toString() + "\n");
		}
		writer.close();
	}

	@Override
	public Long getUniqueID() {
		// TODO Auto-generated method stub
		return new Long(new Date().getTime());
	}

}
