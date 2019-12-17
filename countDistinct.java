import java.util.HashMap;

public class countDistinct {
	public static void main(String arg[]) 
    { 
        int arr[] =  {1, 2, 1, 3, 4, 2, 3}; 
        int k = 4; 
        countDistinct(arr, k); 
    }

	private static void countDistinct(int[] arr, int k) {
		int dist_count=0;
		HashMap<Integer, Integer> h = new HashMap<Integer,Integer>();
		for(int i=0;i<k;i++) {
			if(h.get(arr[i]) == null) {
				h.put(arr[i], 1);
				dist_count++;
			}else {
				Integer count = new Integer(h.get(arr[i]));
				h.put(arr[i],++count);
			}
		}
	
		for( int i=k; i<arr.length;i++) {
			if(h.get(arr[i-k])==1) {
				dist_count--;
				h.remove(arr[i-k]);
			}else {
				h.put(arr[i-k], h.get(arr[i-k])-1);
			}
			
			if(h.get(arr[i]) == null) {
				h.put(arr[i], 1);
				dist_count++;
			}else {
				Integer count = new Integer(h.get(arr[i]));
				h.put(arr[i],++count);
			}
		}
	} 
}
