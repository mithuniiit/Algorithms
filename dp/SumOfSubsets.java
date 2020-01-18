package dp;

class SumOfSubsets{

    public static boolean isSubsetSum(int[]set,int n,int sum){
        boolean subset[][] = new boolean[n+1][sum+1];
        for(int i=0;i<sum+1;i++){
            subset[0][i]=false;
        }

        for(int i=1;i<n+1;i++){
            subset[i][0]=true;
        }

        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(j<set[i-1]){
                    subset[i][j]=false;
                }else if(subset[i][j-1] == true){
                    subset[i][j]=true;                    
                }else if(subset[i][j-set[i-1]] == true){
                    subset[i][j]=true;  
                }else
                    subset[i][j]=false;
            }
        }

        return subset[n][sum];
    }



    public static void main(String[] args){
        int set[] = {3, 34, 4, 12, 5, 2}; 
        int sum = 9; 
        int n = set.length; 
        if (isSubsetSum(set, n, sum) == true) 
            System.out.println("Found a subset"
                          + " with given sum"); 
        else
            System.out.println("No subset with"
                               + " given sum"); 
    }
}
