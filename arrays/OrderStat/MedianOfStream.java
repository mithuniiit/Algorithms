package arrays.OrderStat;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfStream {

	public static void printMedian(int[] a) {
		//Smaller is a max heap
		//Bigger is a min heap
		
		PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> greater = new PriorityQueue<>();
		
		int med = a[0];
		smaller.add(a[0]);
		
		for(int i=1; i<a.length; i++) {
			System.out.println(med);
			if(smaller.size() > greater.size()) {
				if(a[i] < med) {
					greater.add(smaller.poll());
					smaller.add(a[i]);
				}else {
					greater.add(a[i]);
				}
				med = (smaller.peek() + greater.peek())/2;
			}else if(smaller.size() == greater.size()) {
				if(a[i] < med) {
					smaller.add(a[i]);
					med = smaller.peek();
				}else {
					greater.add(a[i]);
					med = greater.peek();
				}
			}else {
				if(a[i] < med) {
					smaller.add(a[i]);
				}else {
					smaller.add(greater.poll());
					greater.add(a[i]);
				}
				med = (smaller.peek() + greater.peek())/2;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] arr = new int[]{5, 15, 10, 20, 3}; 
        printMedian(arr); 
	}
}
