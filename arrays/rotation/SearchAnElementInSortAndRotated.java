package arrays.rotation;

public class SearchAnElementInSortAndRotated {
	
	static int search(int[]arr,int n,int key, int l, int h) {
		
		if(l>h)
			return -1;
		
		int mid = (l+h)/2;
		
		if(key == arr[mid])
			return mid;
		
		
		if(arr[l] < arr[mid]) {
			if(key>=arr[l] && key<= arr[mid]) {
				return search(arr,n,key,l,mid-1);
			}
			return search(arr,n,key,mid+1,h);
		}
		
		if(key >= arr[mid] && key <= arr[h]) {
			return search(arr,n,key,mid+1,h);
		}
		return search(arr,n,key,l,mid-1);
	}
	
	public static void main(String[] args) {
        int arr[] = {4, 5, 6, 7, 8, 9, 1, 2, 3};         
        int n = arr.length;
        int key = 6; 
        System.out.println(search(arr,n,key,0,n));
	}

}
