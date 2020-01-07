package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coins {
	 
	 
	 public static void main(String[] args) {
		 int deno[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000}; 
		 int n = deno.length;
		 findMin(deno,n,93);
	}

	private static void findMin(int[] deno, int n, int sum) {
		 List<Integer> solution = new ArrayList<>();
		Arrays.sort(deno);
		for(int i=n-1;i>=0;i--) {
			while(sum-deno[i] >= 0) {
				sum -= deno[i];
				solution.add(deno[i]);
			}
		}
		System.out.println("Minimum Number of Coins are ");
		for(int number : solution) {
			System.out.println(number);
		}
	}	
}
