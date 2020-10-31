package verma.slidingwindow;

import java.util.Arrays;

public class LongestSubstringOfSizeK {

	static final int MAX_COUNT = 26;
	
	public LongestSubstringOfSizeK() {
		// TODO Auto-generated constructor stub
	}
	
	public static void kUniques(String s, int k) {
		int n = s.length();
		int[] count = new int[26];
		
		int max = 0;
		for(int i=0; i<n; i++) {
			if(count[s.charAt(i)-'a'] == 0) {
				max++;
			}
			count[s.charAt(i)-'a']++;
		}
		
		if(max < k) {
			System.out.println("No Solution");
			return;
		}
		
		//Reset the array to 0
		Arrays.fill(count,0);
		int maxi=0, maxj = 0;
		for(int i=0,j=0; i<n; i++) {
			count[s.charAt(i)-'a']++;
			while(!isValid(count,k)) {
				count[s.charAt(j)-'a']--;
				j++;
			}
			
			if(i-j > maxi-maxj) {
				maxi = i;
				maxj = j;
			}
		}
		
		System.out.println();
		for(int i=maxj; i<=maxi; i++)
			System.out.print(s.charAt(i));
		
	}
	
	public static boolean isValid(int[]count, int k) {
		int max = 0;
		for(int i=0; i<MAX_COUNT; i++) {
			if(count[i] != 0) {
				max++;
			}
		}
		if(max > k)
			return false;
		
		return true;
	}

	public static void main(String[] args) {
//		String s = "aabacbebebe";  
//      int k = 3;
		
		String s = "aabbcc";  
		int k = 3;
		
        kUniques(s, k);  
	}
}
