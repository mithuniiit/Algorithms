package queue;

public class KQueues {
	static int k;
	static int n;
	static int free;
	static int[] arr;
	static int[] next;
	static int[] front;
	static int[] rear;
	
	
	private static void init() {
		for(int i=0;i<n;i++) {
			next[i] =i+1;
		}
		next[n-1] = -1;
		
		for(int i=0;i<k;i++ )
			front[i] = rear[i] = -1;
		
		free = 0;
	}

	
	public static void enqueue(int ele, int qno) {
		if(free == -1) {
			System.out.println("Queue is full");
			return;
		}
		
		int nextFree = next[free];
		
		//handle empty queue
		if(front[qno] == -1) {
			front[qno] = rear[qno] = free;
		}
		else {
			next[rear[qno]] = free;
			rear[qno] = free;
		}
		
		next[free] = -1;
		arr[free] = ele;
		free = nextFree;
		
		System.out.println("Element " + ele + " done in " + qno);
	}
	
	public static int dequeue(int qno) {
		if(front[qno] == -1) {
			System.out.println("Queue is empty");
			return Integer.MIN_VALUE;
		}
		
		int frontIndex = front[qno];
		
		front[qno] = next[frontIndex];
		next[frontIndex] = free;
		free = frontIndex;
		
		return arr[frontIndex];
	}
	
	
	public static void main(String[] args) {
		k = 3;
		n = 10;
		
		front = new int[k];
		rear = new int[k];
		next = new int[n];
		arr = new int[n];
		
		init();
		enqueue(10,0);
		enqueue(20,0);
		enqueue(30,0);
		enqueue(40,1);
		enqueue(50,1);
		enqueue(60,1);
		enqueue(70,2);
		enqueue(80,2);
		enqueue(90,2);
		System.out.println(dequeue(0));
		System.out.println(dequeue(0));
		System.out.println(dequeue(0));
		System.out.println(dequeue(1));
		System.out.println(dequeue(1));
		System.out.println(dequeue(1));
		System.out.println(dequeue(2));
		System.out.println(dequeue(2));
		System.out.println(dequeue(2));
		System.out.println(dequeue(2));
	}
}
