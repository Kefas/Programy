package mainPkg;
import java.io.FileNotFoundException;
import myPkg.DummyMatrix;
import myPkg.Matrix;
import myPkg.MatrixDimensionsException;

public class Main {

	public static void main(String[] args)throws MatrixDimensionsException, FileNotFoundException{
		// TODO Auto-generated method stub
		int [][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}}; 
		//Matrix temp;
		//Matrix temp3;
		//Matrix plik;
		DummyMatrix dwa;
		DummyMatrix trzy;
		try{
//			temp = new Matrix(3,3,matrix);
//			temp3 = new Matrix(4,4,matrix);
//			plik = new Matrix("C:/Users/piotr/Documents/GitHub/Programy/java/lab5/cw1/src/matrix.txt");
			dwa = new DummyMatrix(3,3,matrix);
			trzy = new DummyMatrix(4,4,matrix);
			trzy.mul(dwa);
			
			for ( int i=0; i<4; i++){
				for(int j=0; j<4; j++){
					//System.out.print(nowy.matrix[i][j] + " ");
					System.out.print(trzy.matrix[i][j] + " ");
				}
				System.out.println();
			}
		}
		catch ( MatrixDimensionsException e){
			for ( int i=0; i<4; i++){
				for(int j=0; j<4; j++){
					//System.out.print(nowy.matrix[i][j] + " ");
					System.out.print(e.matrix[i][j] + " ");
				}
				System.out.println();
			}
		}
		
		
		
		
		
	}

}
