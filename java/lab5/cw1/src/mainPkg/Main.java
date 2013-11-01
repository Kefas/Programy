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
		Matrix nowy;
		Matrix plik;
		try{
		temp = new Matrix(3,3,matrix);
		temp3 = new Matrix(4,4,matrix);
		nowy = new Matrix();
		plik = new Matrix("C:/Users/piotr/Documents/GitHub/Programy/java/lab5/cw1/src/matrix.txt");
		}
		finally{
			
		}
		try{
		nowy = temp.add(temp3);
		}
		catch (MatrixDimensionsException wyj){
			
		}
		for ( int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				//System.out.print(nowy.matrix[i][j] + " ");
				System.out.print(plik.matrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
