package mainPkg;
import myPkg.Matrix;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}}; 
		
		Matrix temp = new Matrix(3,3,matrix);
		
		Matrix nowy = temp.mul(temp);
		for ( int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				System.out.print(nowy.matrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}
