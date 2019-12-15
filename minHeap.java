
public class minHeap {
	int k;
	public int count;
	public int arr[];
	minHeap(int k){
		this.k = k;
		arr = new int[k];
		count=-1;
	}

	

	private void insertHeap(int i) {
		arr[++count] = i;
		reheapInsert(count);
	}
	
	private void reheapInsert(int i) {
		int parent = i/2;
		if(arr[i] < arr[parent]) {
			int temp = arr[i];
			arr[i] = arr[parent];
			arr[parent] = temp;
			reheapInsert(parent);
		}
	}

	
	private void delete() {
		arr[0]=arr[count];
		count--;
		reheapDelete(0);
	}


	private void reheapDelete(int i) {
		int left = 2*i+1;
		int right = 2*i+2;
		int smallest = i;
		if(i<count && arr[left] < arr[i])
			smallest = left;
		if(i<count && arr[right] < arr[smallest])
			smallest = right;

		
		if(smallest != i ) {
			int temp = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = temp;
			reheapDelete(smallest);
		}
	}



	public static void main(String[] args) {
		minHeap h = new minHeap(10);
		h.insertHeap(1);
		h.insertHeap(5);
		h.insertHeap(2);
		h.insertHeap(3);
		h.insertHeap(4);
		h.delete();
		
		for(int i=0;i<=h.count;i++) {
			System.out.println(h.arr[i]);
		}
	}
}
