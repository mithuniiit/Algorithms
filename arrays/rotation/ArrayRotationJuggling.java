package arrays.rotation;

public class ArrayRotationJuggling {

	public static int gcd(int a, int b) {
		if(b==0)
			return a;
		
		return gcd(b,a%b);
	}
	
	public static void rotate(int []arr, int n,int d) {
		int gcd = gcd(n,d);
		
		for(int i=0;i<gcd;i++) {
			
			int prev = i;
			int next = (i+d)%n;
			
			int temp = arr[prev];
			
			while(true) {
				if(next == i) {
					arr[prev] = temp;
					break;
				}
				
				arr[prev] = arr[next];
				
				prev = next;
				next = (next+d)%n;
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		rotate(arr,arr.length,3);
		
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
}
