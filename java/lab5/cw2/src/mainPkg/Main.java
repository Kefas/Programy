package mainPkg;
import java.io.FileNotFoundException;

import myPkg.DummyMatrix;
import myPkg.DummyMatrixDimensionException;
import myPkg.Matrix;
import myPkg.MatrixDimensionsException;

public class Main {

	public static void main(String[] args)throws MatrixDimensionsException, FileNotFoundException{
		// TODO Auto-generated method stub
		int [][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}}; 
		Matrix temp;
		Matrix temp3;
		Matrix plik;
		DummyMatrix dwa;
		DummyMatrix trzy;
		try{
			temp = new Matrix(3,3,matrix);
			temp3 = new Matrix(4,4,matrix);
			plik = new Matrix("matrix.txt");
			
			
			dwa = new DummyMatrix(3,3,matrix);
			trzy = new DummyMatrix(4,4,matrix);
			
			System.out.println("Dodawanie normalne");
			dwa = dwa.add(dwa);		
			
			for ( int i=0; i<3; i++){
				for(int j=0; j<3; j++){
					
					System.out.print(dwa.matrix[i][j] + " ");
				}
				System.out.println();
			}
			
			
			System.out.println("Dodawanie wyj¹tkowe");
			trzy = trzy.add(dwa);
			
			
		}
		catch ( DummyMatrixDimensionException e){
			e.printStackTrace();
			System.out.println("");
			for ( int i=0; i<e.matrix.length; i++){
				for(int j=0; j<e.matrix[i].length; j++){
					
					System.out.print(e.matrix[i][j] + " ");
				}
				System.out.println();
			}
		}
		
		
		
		
		
	}

}
