package dp;
class EggDrop{

    public static int eggDrop(int n, int k){
        if(k==1 || k==0)
            return k;

        if(n==1)
            return k;

        int min = Integer.MAX_VALUE;

        for(int i=1;i<=k;i++){
        	min = Math.min(min,Math.max(eggDrop(n-1,i-1) , eggDrop(n, k-i)));
        }

        return min+1;
    }
    
    
    public static int eggDropDP(int n, int k) {
    	int[][] floor = new int[n+1][k+1];
    	
    	//zero or one floor
    	for(int i=0;i<n+1;i++) {
    		floor[i][0] = 0;
    		floor[i][1] = 1;
    	}
    	
    	
    	//1 egg will take i attempts
    	for(int i=1;i<k+1;i++) {
    		floor[1][i] = i;
    	}
    	
    	for(int i=2;i<n+1;i++) {
    		for(int j=2;j<k+1;j++) {
    			floor[i][j]=Integer.MAX_VALUE;
    			for(int x=1;x<=j;x++) {
    				floor[i][j] = Math.min(floor[i][j], 1+ Math.max(floor[i-1][j-1], floor[i][j-i]));
    			}
    			
    		}
    	}
    	
    	
    	return floor[n][k];
    	
    }


    public static void main(String args[])  
    {  
        //n eggs, k floor
        int n = 2, k = 10;  
        System.out.print("Minimum number of trials in worst case with "+ n + " eggs and " + k  + " floors is " + eggDrop(n, k));  
    }  
}
