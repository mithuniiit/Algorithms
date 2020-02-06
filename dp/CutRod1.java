package dp;
class CutRod{

    public static int cutRodRec(int[] price, int n){
        if(n<=0)
            return 0;

        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(max, price[i] + cutRodRec(price, n-i-1));
        }
        return max;
    }
    
    public static int cutRodDP(int[] price, int n) {
    	int[] val = new int[n+1];
    	val[0]=0;
    	
    	for(int i=1;i<n+1;i++) {
    		int max = Integer.MIN_VALUE;
    		for(int j=0;j<i;j++) {
    			max = Math.max(max,price[j] +  val[i-j-1]);
    		}
    		val[i]=max;
    	}
    	return val[n];
    }
    
    
    
    public static void main(String args[]) 
    { 
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20}; 
        int size = arr.length; 
        System.out.println("Maximum Obtainable Value is "+ 
                            cutRodRec(arr, size)); 
        System.out.println("Maximum Obtainable DP Value is "+ 
                cutRodDP(arr, size)); 
    } 
}
