package board;

public enum Position {
	START,
	INNER,
	END,
	EMPTY;

	public static String toString(Position pos) {
		if (pos == Position.START)
			return "START";
		else if( pos == Position.INNER)
			return "INNER";
		else if( pos == Position.END)
			return "END";
		else
			return "EMPTY";
	}
}
