package arrays.OrderStat;

public class MaxHeap {

	int [] a;
	int size;
	final int MAX = 100;
	
	MaxHeap(){
		a = new int[MAX];
		size = -1;
	}
	
	void swap(int parent, int current) {
		int temp = a[parent];
		a[parent] = a[current];
		a[current] = temp;
	}
	
	int parent(int current) {
		return current/2;
	}
	
	void insert(int ele) {
		a[++size] = ele;
		int parent = parent(size);
		int current = size;
		while(a[parent] < a[current]) {
			swap(parent,current);
			current = parent;
			parent = parent(current);
		}
	}
	
	int getMax() {
		return a[0];
	}
	
	
	boolean isLeaf(int pos) {
		if( pos >= size/2 && pos <= size)
			return true;
		return false;
	}
	
	
	int left(int pos) {
		return 2*pos;
	}
	
	int right(int pos) {
		return 2*pos+1;
	}
	
	void maxHeapify(int pos) {
		if(isLeaf(pos)) {
			return;
		}
		
		if( (a[pos] < a[left(pos)]) || (a[pos] < a[right(pos)])){
			if(a[left(pos)] > a[right(pos)]) {
				swap(pos,left(pos));
				maxHeapify(left(pos));
			}else {
				swap(pos,right(pos));
				maxHeapify(right(pos));
			}
		}
	}
	
	int extractMax() {
		int popped = a[0];
		a[0] = a[size--];
		maxHeapify(0);
		return popped;
	}
	
	public static void main(String[] args) {
		MaxHeap h = new MaxHeap();
		h.insert(15);
		h.insert(10);
		h.insert(20);
		h.insert(7);
		h.insert(4);
		h.insert(3);
		System.out.println(h.extractMax());
	}
}
