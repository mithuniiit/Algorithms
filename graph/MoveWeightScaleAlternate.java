package graphs;

import java.util.Arrays;

public class MoveWeightScaleAlternate {


	public static boolean dfs(int[] arr, int N, int steps,int currStep, int diffSum, int []sol) {
		if(currStep >= steps-1) {
			return true;
		}
		
		for(int i=0; i<N; i++) {
			if(currStep == -1 || (sol[currStep] != arr[i] && arr[i] > diffSum)) {
				sol[++currStep] = arr[i];
				diffSum = arr[i] - diffSum;
				if(dfs(arr,N,steps,currStep,diffSum,sol))
					return true;
			}
		}
		
		return false;
	}

	public static void printWeightOnScale(int []arr,int N, int steps) {
		int []sol = new int[steps];
		if(dfs(arr,N,steps,-1,0,sol)) {
			System.out.println(Arrays.toString(sol));
		}else
			System.out.println("No Sol");
	}

	public static void main(String[] args) {
		int[] arr = { 2, 3, 5, 6 }; 
		int N = arr.length; 
		int steps = 10; 
		printWeightOnScale(arr,N,steps);
	}
}
