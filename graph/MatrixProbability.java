//https://www.geeksforgeeks.org/a-matrix-probability-question/

package graphs;

public class MatrixProbability {

	
	static boolean isSafe(int m, int n, int i, int j) {
		if(i>=0 && i<m && j>=0 && j<n)
			return true;
		return false;
	}
	
	static double  findProb(int m,int n, int i, int j,int N) {
		double prob = 0.0;
		
		if(!isSafe(m,n,i,j)) {
			return 0.0;
		}
		
		if(N==0)
			return 1;
		
		prob += findProb(m,n,i-1,j,N-1) * 0.25;
		
		prob += findProb(m,n,i,j-1,N-1) * 0.25;
		
		prob += findProb(m,n,i+1,j,N-1) * 0.25;
		
		prob += findProb(m,n,i,j+1,N-1) * 0.25;
		
		return prob;
	}
	
	
	public static void main(String[] args) {
		int m=5 , n=5;
		int i=1 , j=1;
		int N=2;
		
		System.out.println(findProb(m,n,i,j,N));
		
	}
}
