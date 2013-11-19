package mainPkg;
import java.io.FileNotFoundException;

import myPkg.Matrix;
import myPkg.MatrixDimensionsException;
public class Main {

	public static void main(String[] args)throws MatrixDimensionsException, FileNotFoundException{
		// TODO Auto-generated method stub
		int [][] matrix = {{1,2,3,4}, {4,5,6,7}, {7,8,9,10}, {0,1,0,0}}; 
		Matrix temp;
		Matrix temp3;
		Matrix plik;
		
		try{
			temp = new Matrix(3,3,matrix);
			temp3 = new Matrix(4,4,matrix);
			plik = new Matrix("matrix.txt");
			
			temp.add(temp3);
			
			for ( int i=0; i<3; i++){
				for(int j=0; j<3; j++){
					System.out.print(plik.matrix[i][j] + " ");
				}
				System.out.println();
			}
		}
		catch (MatrixDimensionsException e){
			e.printStackTrace();
		}
		
	}

}
