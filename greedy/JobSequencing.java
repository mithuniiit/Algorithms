package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JobSequencing {

	static class Job{
		char id;
		int deadline;
		int profit;
		
		Job(char id, int deadline, int profit){
			this.id = id;
			this.deadline = deadline;
			this.profit = profit;
		}
	}
	
	public static void printJobScheduling(ArrayList<Job> jlist, int n) {
		
		Collections.sort(jlist, new Comparator<Job>() {
			@Override
			public int compare(Job j1, Job j2) {
				return (j1.profit < j2.profit) ? 1 : -1;
			}
		});
		
		char[] slot = new char[n];
		for(int i=0; i<n; i++) {
			slot[i] = '\0';
		}
		
		for(Job j : jlist) {
			for(int i = Math.min(j.deadline,n)-1; i>=0 ; i--) {
				if(slot[i] == '\0') { //unassigned
					slot[i] = j.id;
					break;
				}
			}
		}
		
		for(int i=0;i<n;i++) {
			System.out.println(slot[i]);
		}
	}
	
	public static void main(String[] args) {
		
		ArrayList<Job> j = new ArrayList<Job>();
		
		j.add(new Job('a',2,100));
		j.add(new Job('b',1,19));
		j.add(new Job('c',2,27));
		j.add(new Job('d',1,25));
		j.add(new Job('e',3,15));
		
		int n = 5;
		printJobScheduling(j,n);
	}
}
