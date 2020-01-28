package dp;
class SCSuperSequence{


    public static int shortestSuperSequence(String X, String Y ){
        int m = X.length();
        int n = Y.length();

        int [][] dp = new int[m+1][n+1];

        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                    continue;
                }
                if(X.charAt(i-1) == Y.charAt(j-1)){
                    dp[i][j] =  1+ dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
     public static void main(String[] args){
        String X = "AGGTAB"; 
        String Y = "GXTXAYB"; 
      
        System.out.println("Length of the shortest supersequence is "+shortestSuperSequence(X, Y)); 
     }

}
