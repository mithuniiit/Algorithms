package DivideConquer;

public class LeastCommonPrefix {

	
	static String commonPrefixUtil(String str1, String str2) {
		String result = "";
		
		int n1 = str1.length();
		int n2 = str2.length();
		
		for(int i=0,j=0; i<n1 && j<n2; i++,j++) {
			if(str1.charAt(i) != str2.charAt(j)) {
				break;
			}
			result += str1.charAt(i);
		}
		return result;
	}
	
	static String commonPrefix(String[]a, int l,int r) {
		if(l == r)
			return a[l];
		
		if(l < r) {
			int mid = (l+r)/2;
			
			String str1 = commonPrefix(a, l, mid);
			String str2 = commonPrefix(a,mid+1,r);
			
			return commonPrefixUtil(str1,str2);
		}
		return null;
	}
	

	public static void main(String[] args) {
		String arr[] = {"geeksforgeeks", "geeks", "geek", "geezer"}; 
	        int n = arr.length; 
	  
	        String ans = commonPrefix(arr, 0, n - 1); 
	  
	        if (ans.length() != 0) { 
	            System.out.println("The longest common prefix is "
	                    + ans); 
	        } else { 
	            System.out.println("There is no common prefix"); 
	        } 
	}
}
