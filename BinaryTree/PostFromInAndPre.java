package trees;

public class PostFromInAndPre {
	
	static int preIndex = 0;
	
	static int search(int[] in, int start, int end, int key) {
		int i = 0;
		for(i=start;i<end;i++) {
			if(in[i] == key)
				return i;
		}
		return i;
	}
	
	static void print(int []in, int []pre, int start, int end) {
		if(start > end) {
			return;
		}
		
		int index = search(in , start , end, pre[preIndex++] );
		print(in, pre, start, index-1);
		print(in, pre, index+1, end);
		System.out.println(in[index]);
	}
	
	public static void main(String[] args) {
	  int in[] = { 4, 2, 5, 1, 3, 6 }; 
      int pre[] = { 1, 2, 4, 5, 3, 6 };
      int n = in.length;
      print(in,pre,0,n-1);
	}

}
