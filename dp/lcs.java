package dp;

public class lcs {
	
	public static int findLcs(String s1, String s2, int m, int n) {
		int  l[][] = new int[m+1][n+1];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(i==0 || j==0)
					l[i][j]=0;
				else if(s1.charAt(i-1) == s2.charAt(j-1))
					l[i][j] = l[i-1][j-1] + 1;
				else
					l[i][j] = Math.max(l[i-1][j], l[i][j-1]);
			}
		}
		return l[m][n];
	}

	public static void main(String[] args) {
		String s1 = "AGGTAB"; 
	    String s2 = "GXTXAYB"; 
	    System.out.println("Length is "+findLcs(s1,s2,s1.length(),s2.length()));
	}
}
