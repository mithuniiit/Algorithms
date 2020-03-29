package queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class FIFOPageReplacement {
	
	public static void main(String[] args) {
		int pages[] =  {7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2};
		int capacity = 4;
		calculate(pages,capacity);
	}

	private static void calculate(int[] pages, int capacity) {
		int hit = 0;
		int miss = 0;
		int n = pages.length;
		Queue<Integer> queue = new LinkedList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>(capacity);
		
		for(int i=0;i<n;i++) {
			if(set.contains(pages[i])) {
				hit++;
			} else {
				miss++;
				if(set.size() == capacity) {
					set.remove(queue.poll());
				}
				set.add(pages[i]);
				queue.add(pages[i]);
			}
				
		}
		
		System.out.println("Hits " + hit + " misses "+miss);
	}
	
}
