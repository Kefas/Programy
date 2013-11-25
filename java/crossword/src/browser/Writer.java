package browser;

import java.io.IOException;

import board.Crossword;

public interface Writer {
	public void write(Crossword cw) throws IOException;
	public Long getUniqueID();
}
