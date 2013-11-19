package myPkg;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Matrix {
	public int [][] matrix;
	int rows;
	int cols;
	
	public Matrix(int x, int y, int [][] tab){
		rows = x;
		cols = y;
		matrix = new int[rows][cols];
		for( int i=0; i<rows; i++)
			for( int j=0; j<cols; j++)
				matrix[i][j] = tab[i][j];
			
	}
	public Matrix(){
		rows = 3;
		cols = 3;
		matrix = new int[rows][cols];
		for( int i=0; i<rows; i++)
			for( int j=0; j<cols; j++)
				matrix[i][j] = 0;
	}
	public Matrix(String plik) throws FileNotFoundException, MatrixDimensionsException{
		File myfile= new File(plik);
		Scanner in = new Scanner(myfile);
		try{	
			if (!myfile.canRead()) throw new FileNotFoundException();
			String wymiary = in.nextLine();
			char [] dim = wymiary.toCharArray();
			rows = (int)dim[0]-48;
			cols = (int)dim[2]-48;
			matrix = new int[rows][cols];
			String tab = new String();
			while(in.hasNextLine()){
				tab += in.nextLine();
				tab += " ";
			}
			
			char [] tablica = tab.toCharArray();
			int z = 0;
			if( tablica.length / 2 < rows * cols) throw new MatrixDimensionsException();
			
			for( int i=0; i<rows; i++)
				for( int j=0; j<cols; j++){
					if(z < tablica.length)
						matrix[i][j] = (int)tablica[z] -48;
					z += 2;
				}
			
		}
		finally{
			in.close();
		}
			
	}
	
	public Matrix(int cols2, int rows2) {
		this.cols = cols;
		this.rows = rows;
		
	}
	public Matrix add(Matrix temp) throws MatrixDimensionsException{
		if( this.rows != temp.rows || this.cols != temp.cols) throw new MatrixDimensionsException();
		Matrix result = new Matrix();
		for(int i=0;i<this.rows;i++)
			for(int j=0;j<this.cols;j++)
				result.matrix[i][j] = this.matrix[i][j] + temp.matrix[i][j];
		
		return result;
	}
	
	public Matrix sub(Matrix temp) throws MatrixDimensionsException{
		if( this.rows != temp.rows || this.cols != temp.cols) throw new MatrixDimensionsException();
		Matrix result = new Matrix();
		for(int i=0;i<this.rows;i++)
			for(int j=0;j<this.cols;j++)
				result.matrix[i][j] = this.matrix[i][j] - temp.matrix[i][j];
		
		return result;
	}
	
	public Matrix mul(Matrix temp) throws MatrixDimensionsException{
		if( this.rows != temp.rows || this.cols != temp.cols) throw new MatrixDimensionsException();
		Matrix result = new Matrix();
		for(int i=0; i<this.cols;i++)
			for( int j=0; j<this.rows;j++)
				for(int k=0; k<temp.cols; k++)
					result.matrix[i][j] += this.matrix[i][j] * temp.matrix[j][k];
				
		return result;
	}
	
}
