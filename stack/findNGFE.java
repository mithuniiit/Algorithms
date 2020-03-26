package stack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterFrequencyElement {
	
	static HashMap <Integer,Integer >freq;
	
	public static void findNGFE(int []a, int n) {
		freq = new HashMap<>();
		calcFreq(a,freq,n);
		find(a,freq,n);
	}
	
	private static void find(int[] a, HashMap<Integer, Integer> freq, int n) {
		int[] result = new int[n];
		Stack<Integer> s = new Stack<Integer>();
		s.push(0);
		for(int i=1; i<n; i++ ) {
			while(!s.isEmpty() && freq.get(a[s.peek()]) < freq.get(a[i])) {
				result[s.pop()] = a[i];
			}
			s.push(i);
		}
		
		while(!s.isEmpty()) {
			result[s.pop()] = -1;
		}
		for(int i=0;i<n;i++) {
			System.out.println(result[i]);
		}
	}

	private static void calcFreq(int[] a, HashMap<Integer, Integer> freq,int n) {
		for(int i=0; i<n; i++) {
			freq.put(a[i], freq.getOrDefault(a[i], 0)+1);
		}
	}

	public static void main(String[] args) {
	    int a[] = {1, 1, 2, 3, 4, 2, 1}; 
	    int n = a.length;
	    
	    findNGFE(a,n);
	}
}
