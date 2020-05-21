package arrays.rearrangement;


public class RearrageArrayOddEven {
	

	static void rearrange(int []arr, int n ) {
		int[] tempArr = arr.clone();
	
		for(int i=0,j=0,k=n-1;i<n;i++) {
			if(i%2 == 0) {
				arr[i] = tempArr[k];
				k--;
			}
			else {
				arr[i] = tempArr[j];
				j++;
			}
		}
		
		for(int i = 0; i<n;i++)
			System.out.println(arr[i]);
		
	}
	
	public static void main(String argc[]){ 
        int[] arr = new int []{ 1, 2, 3, 4, 5, 6, 7 }; 
        int size = arr.length; 
        rearrange(arr, size); 
    } 

}
