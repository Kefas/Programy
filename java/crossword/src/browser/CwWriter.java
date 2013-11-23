package browser;

import java.io.File;
import java.io.IOException;

import board.Crossword;

public class CwWriter implements Writer {
	private File file;
	
	public CwWriter(String filePath) {
		// TODO Auto-generated constructor stub
		file = new File(filePath);
	}
	
	@Override	
	public void write(Crossword cw) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public long getUniqueID() {
		// TODO Auto-generated method stub
		return 0;
	}

}
