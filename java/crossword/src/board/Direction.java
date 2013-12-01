package board;

public enum Direction {
	HORIZ,
	VERT;

	public static String toString(Direction dir) {
		if (dir == Direction.VERT)
			return "VERT";
		else
			return "HORIZ";
	}
}
