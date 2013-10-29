package myPkg;

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
	
	public Matrix add(Matrix temp){
		Matrix result = new Matrix();
		for(int i=0;i<this.rows;i++)
			for(int j=0;j<this.cols;j++)
				result.matrix[i][j] = this.matrix[i][j] + temp.matrix[i][j];
		
		return result;
	}
	
	public Matrix sub(Matrix temp){
		Matrix result = new Matrix();
		for(int i=0;i<this.rows;i++)
			for(int j=0;j<this.cols;j++)
				result.matrix[i][j] = this.matrix[i][j] - temp.matrix[i][j];
		
		return result;
	}
	
	public Matrix mul(Matrix temp){
		Matrix result = new Matrix();
		for(int i=0; i<this.cols;i++)
			for( int j=0; j<this.rows;j++)
				for(int k=0; k<temp.cols; k++)
					result.matrix[i][j] += this.matrix[i][j] * temp.matrix[j][k];
				
		return result;
	}
	
}
