package myPkg;

import java.io.FileNotFoundException;


public class DummyMatrix extends Matrix {
	public DummyMatrix(int x, int y, int [][] tab){
		super(x,y,tab);
	}
	public DummyMatrix(){
		super();
	}
	
	public DummyMatrix(String plik) throws FileNotFoundException, MatrixDimensionsException{
		super(plik);
	}
	
	public DummyMatrix(int cols, int rows) {
		super(cols, rows);
	}
	public DummyMatrix add(Matrix temp) throws MatrixDimensionsException{
		int [][] wynik = new int[this.cols][this.rows];
		
		
		if( this.rows != temp.rows || this.cols != temp.cols) {
			if(temp.rows >= this.rows && temp.cols >= this.cols){
				for(int i=0;i<this.rows;i++)
					for(int j=0;j<this.cols;j++)
						wynik[i][j] = this.matrix[i][j] + temp.matrix[i][j];
			}
			else{
				for(int i=0;i<this.rows;i++)
					for(int j=0;j<this.cols;j++)
						if(temp.rows-1<i || temp.cols-1<j)
							wynik[i][j] = this.matrix[i][j] + 1;		
						else
							wynik[i][j] = this.matrix[i][j] + temp.matrix[i][j];
							
			}
			throw new DummyMatrixDimensionException(wynik);
		}
		DummyMatrix result = new DummyMatrix();
		for(int i=0;i<this.rows;i++)
			for(int j=0;j<this.cols;j++)
				result.matrix[i][j] = this.matrix[i][j] + temp.matrix[i][j];
		
		return result;
	}
	
	public DummyMatrix sub(Matrix temp) throws DummyMatrixDimensionException{
		int [][] wynik = new int[this.cols][this.rows];
		
		if( this.rows != temp.rows || this.cols != temp.cols) {
			if(temp.rows >= this.rows && temp.cols >= this.cols){
				for(int i=0;i<this.rows;i++)
					for(int j=0;j<this.cols;j++)
						wynik[i][j] = this.matrix[i][j] - temp.matrix[i][j];
			}
			else{
				for(int i=0;i<this.rows;i++)
					for(int j=0;j<this.cols;j++)
						if(temp.rows-1<i || temp.cols-1<j)
							wynik[i][j] = this.matrix[i][j] - 1;		
						else
							wynik[i][j] = this.matrix[i][j] -  temp.matrix[i][j];
									
			}
			throw new DummyMatrixDimensionException(wynik);
		}
		
		DummyMatrix result = new DummyMatrix();
		for(int i=0;i<this.rows;i++)
			for(int j=0;j<this.cols;j++)
				result.matrix[i][j] = this.matrix[i][j] - temp.matrix[i][j];
		
		return result;
	}
	
	public DummyMatrix mul(Matrix temp) throws DummyMatrixDimensionException{
		
		
		int [][] wynik = new int[this.cols][this.rows];
		
		
		if( this.rows != temp.cols || this.cols != temp.rows) {
			if(temp.rows >= this.rows && temp.cols >= this.cols){
				for(int i=0;i<this.rows;i++)
					for(int j=0;j<this.cols;j++)
						for( int k=0;k<this.rows;k++)
								wynik[i][j] += this.matrix[i][j] * temp.matrix[j][k];
			}
			else{
				for(int i=0;i<this.rows;i++)
					for(int j=0;j<this.cols;j++)
						for( int k=0;k<this.rows;k++)
							if( j>temp.rows-1 || k>temp.cols-1 )
								wynik[i][j] += this.matrix[i][j] * 1;
							else
								wynik[i][j] += this.matrix[i][j] * temp.matrix[j][k];
			}		
			
			throw new DummyMatrixDimensionException(wynik);
		}
		
		DummyMatrix result = new DummyMatrix(this.cols, this.rows);
		for(int i=0; i<this.cols;i++)
			for( int j=0; j<this.rows;j++)
				for(int k=0; k<temp.cols; k++)
					result.matrix[i][j] += this.matrix[i][j] * temp.matrix[j][k];
				
		return result;
	}
}
