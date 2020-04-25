package trees.summation;

public class SumLongestPathFromRootToLeaf {
	
	static int maxSum =0;
	static int maxHeight = 0;

	public static void findPathUtil(Node root, int sum, int height) {
		if(root ==null)
			return;
		
		sum += root.data;
		
		if(height > maxHeight) {
			maxHeight = height;
			maxSum = sum; 
		}
		
		findPathUtil(root.left, sum, height+1);
		findPathUtil(root.right, sum, height+1);
		
	}
	
	public static void findLongestPathSum(Node root) {
		int sum = 0, height = 0; 
		
		findPathUtil(root,sum,height);
		System.out.println("Sum " + maxSum + " Height "+maxHeight);
	}
	
	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(7);
		root.left.right = new Node(1);
		root.left.right.left = new Node(6);
		root.right.left = new Node(2);
		root.right.right = new Node(3);
		findLongestPathSum(root);
	}

}
