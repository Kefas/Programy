package myPkg;

public class DummyMatrixDimensionException extends MatrixDimensionsException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int matrix[][];
	public DummyMatrixDimensionException(String t) {
		super(t);
	}
	public DummyMatrixDimensionException() {
		// TODO Auto-generated constructor stub
		super("DMatrixDimensionsExceptions");
	}
	public DummyMatrixDimensionException(int tab[][]){
		this.matrix = tab;
	}
	

}
