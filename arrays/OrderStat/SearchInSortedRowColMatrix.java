package arrays.OrderStat;

public class SearchInSortedRowColMatrix {
	
	public static void search(int[][] mat,int n, int ele) {
		int i=0, j = n-1;
		
		while(i<n && j>=0) {
			if(mat[i][j] == ele) {
				System.out.println("FOUND");
				return;
			}else if(mat[i][j] > ele)
				j--;
			else
				i++;
		}
		System.out.println("Not Found");
	}
	
	
	public static void main(String[] args) 
    { 
        int mat[][] = { { 10, 20, 30, 40 }, 
                        { 15, 25, 35, 45 }, 
                        { 27, 29, 37, 48 }, 
                        { 32, 33, 39, 50 } }; 
  
        search(mat, 4, 29); 
    } 

}
