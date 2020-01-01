package backtracking;

class SubSetSum{

	public static boolean isSafe(int[] weights, int index, int currentSum, int targetSum){
		if(currentSum > targetSum)
			return false;
		
		int remainingSum =0;
		for(int i=index+1;i<weights.length;i++)
			remainingSum += weights[i];
		
		if(currentSum + remainingSum < targetSum)
			return false;
		
		return true;
	}

	public static boolean calSubSetSumUtil(int[] weights,int[] finalWeight,int targetSum,int currentSum,int n,int index){
		
		//Final terminating condition
		if(targetSum == currentSum)
			return true;
		
		for(int i=index;i<n;i++){
			currentSum += weights[i];
			finalWeight[i]=1;
			
			if(isSafe(weights,i,currentSum,targetSum)){
				return calSubSetSumUtil(weights,finalWeight,targetSum,currentSum,n,i+1);
			}
			finalWeight[i]=0;
			currentSum -= weights[i];
		}
		return false;
	}

	public static void calSubSetSum(int[] weights,int targetSum,int n){
		int currentSum=0;
		int finalWeight[] = new int[n];
		
		for(int start=0;start<n;start++) {
			resetWeights(finalWeight,n);
			if(calSubSetSumUtil(weights,finalWeight,targetSum,currentSum,n,start)) {
				printSolution(finalWeight,n);
				break;
			}
		}
	}
	
	
	private static void resetWeights(int[] finalWeight, int n) {
		//Initialize
		for(int i=0;i<n;i++){
			finalWeight[i]=0;
		}		
	}

	private static void printSolution(int[] finalWeight, int n) {
		for(int i=0;i<n;i++) {
			System.out.println(" "+finalWeight[i]);
		}
		
	}

	public static void main(String[] args){
		int weights[] = {15, 22, 14, 26, 32, 9, 16, 8};
	    //int weights[] = {10, 7, 5, 18, 12, 20, 15};
		//int weights[] = {3,4,2,1,5};
		int targetSum = 53; 
		int n = weights.length;
		calSubSetSum(weights,targetSum,n);
	}
}
