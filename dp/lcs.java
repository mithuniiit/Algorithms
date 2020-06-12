package dp;

public class lcs {

	static int findLcsOptimal(String s1, String s2, int m , int n) {
		if(m==0 || n==0)
			return 0;

		if(s1.charAt(m-1) == s2.charAt(n-1)) {
			return 1 + findLcsOptimal(s1, s2, m-1, n-1);
		}else { 
			return Math.max(findLcsOptimal(s1, s2, m, n-1), findLcsOptimal(s1, s2, m-1, n));
		}
	}


	static int findLcs(String s1, String s2, int m, int n) {
		int L[][] = new int[m+1][n+1];

		for(int i=0; i<m+1; i++) {
			for(int j=0; j<n+1; j++) {
				if(i ==0 || j==0) {
					L[i][j] = 0;
				}else if(s1.charAt(i-1) == s2.charAt(j-1)) {
					L[i][j] = 1 + L[i-1][j-1];
				}else {
					L[i][j] = Math.max(L[i-1][j] , L[i][j-1]);
				}
			}
		}

		return L[m][n];
	}

	public static void main(String[] args) {
		String s1 = "AGGTAB"; 
		String s2 = "GXTXAYB"; 
		System.out.println("Length is "+findLcsOptimal(s1,s2,s1.length(),s2.length()));

		System.out.println("Length is "+findLcs(s1,s2,s1.length(),s2.length()));
	}
}
