class CoinChange{

    public static int coinChangeRec(int[] s, int m, int n){
        if(n==0)
            return 1;

        if(m<=0 || n<0)
            return 0;
        
        return coinChangeRec(s,m-1,n) + coinChangeRec(s,m,n-s[m-1]);
    }

    public static int coinChangeDp(int[] s, int m, int n){
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            dp[i][0] = 1;
        }

        for(int i=0;i<n;i++){
            dp[0][i] = 0;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = dp[i-1][j];
                if(j-s[i-1] >= 0){
                    dp[i][j] += dp[i][j-s[i-1]];
                }

            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int []s ={1,2,3};
        int n = 4;
        int m = s.length;
        System.out.println("Total combinations recursive "+coinChangeRec(s,m,n));
        System.out.println("Total combinations dp "+coinChangeDp(s,m,n));
    }

    
}
