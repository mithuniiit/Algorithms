package arrays.rearrangement;

public class DoubleFirstEleAndMoveZeroToEnd {

	
	public static void modify(int []a, int n) {
		if(n==1)
			return;
		
		for(int i=0; i<n-1;) {
			if(a[i] == a[i+1]) {
				a[i] = 2 * a[i];
				a[i+1] = 0;
				i+=2;
				continue;
			}
			i++;
		}
		
		
		//move zero to end
		for(int i=0,j=n-1;i<j;) {
			if(a[i] != 0) {
				i++;
				continue;
			}
			
			if(a[j] == 0) {
				j--;
				continue;
			}
			
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			
		}
	}
	
	public static void main(String[] args) 
    { 
        int arr[] = { 0, 2, 2, 2, 0, 6, 6, 0, 0, 8 }; 
        int n = arr.length; 
  
        modify(arr,n);
        
        for(int i=0;i<n;i++)
        	System.out.println(arr[i]);
    }
}
