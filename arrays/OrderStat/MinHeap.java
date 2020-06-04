package arrays.OrderStat;

public class MinHeap {
	int [] a;
	int size;
	final int MAX = 100;
	
	MinHeap(){
		a = new int[MAX];
		size = -1;
	}
	
	int parent(int size) {
		return size/2;
	}

	void swap(int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	void insert(int ele) {
		a[++size] = ele;
		int current = size;
		
		while(a[parent(current)] > a[current]) {
			swap(parent(current),current);
			current = parent(current);
		}
	}
	
	boolean isLeaf(int pos) {
		if(pos >= size/2 && pos < size)
			return true;
		
		return false;
	}
	
	int left(int pos) {
		return a[2*pos];
	}
	
	int right(int pos) {
		return a[2*pos + 1];
	}
	
	void minHeapify(int pos) {
		if(isLeaf(pos)) {
			return;
		}
		
		int l = left(pos);
		int r = right(pos);
		
		int small = pos;
		
		if( (l < size && a[l] < a[pos]) ) {
			small = l;
		}
		
		if( (r < size && a[r] < a[small]) ) {
			small = r;
		}
		
		if(small != pos) {
			swap(small,pos);
			minHeapify(small);
		}
		
	}
	
	int extractMin() {
		int popped = a[0];
		a[0] =  a[size--];
		
		minHeapify(0);
		
		return popped;
	}
	
	public static void main(String[] args) {
		MinHeap h = new MinHeap();
		h.insert(15);
		h.insert(10);
		h.insert(20);
		h.insert(7);
		h.insert(4);
		h.insert(3);
		System.out.println(h.extractMin());
	}
}
