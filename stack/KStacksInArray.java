package stack;

public class KStacksInArray {
	
	static int[] ele;
	static int[] next;
	static int[] top; 
	static int free;
	
	public static void main(String[] args) {
		int k = 3, n = 10; 
		intiKStacks(k,n);
		
		push(11, 0); 	
		push(9, 0); 	
		push(7, 0); 
		
		push(17, 1); 
		push(49, 1); 
		push(39, 1);
		
		push(15,2);
		push(45,2);
		
		pop(0);
		pop(1);
		pop(2);
	}

	private static void push(int element,int stackno) {
		if(free == -1) {
			System.out.println("Stack is full");
			return;
		}
		ele[free] = element;
		int temp = next[free];
		next[free] = top[stackno];
		top[stackno]=free;
		free = temp;
	}
	
	private static int pop(int stackno) {
		//base condition
		if(top[stackno] == -1) {
			System.out.println("Stack is empty");
			return -1;
		}
			
		int temp = top[stackno];
		top[stackno] = next[temp];
		next[temp]=free;
		free=temp;
		
		return ele[temp];
	}

	private static void intiKStacks(int k, int n) {
		ele = new int[n];
		next = new int[n];
		top = new int[k];
		free = 0;

		//init next to next free slot i.e i+1
		for(int i=0;i<n;i++) {
			next[i]=i+1;
		}
		next[n-1]=-1;
		
		//init top to -1
		for(int i=0;i<k;i++) {
			top[i]=-1;
		}
	}
}
