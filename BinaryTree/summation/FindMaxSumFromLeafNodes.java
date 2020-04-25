package trees.summation;

public class FindMaxSumFromLeafNodes {

	static int maxSum = 0;
	
	public static int findMaxSum(Node root) {
		if(root == null)
			return 0;
		
		int lSum = findMaxSum(root.left);
		int rSum = findMaxSum(root.right);
		
		if(lSum + rSum + root.data > maxSum)
			maxSum = lSum + rSum + root.data;
		
		return Math.max(lSum , rSum ) + root.data;
		
	}
	public static void main(String[] args) {
		Node root = new Node(-15);
		root.left = new Node(5);
		root.right = new Node(6);
		root.left.left = new Node(-8);
		root.left.right = new Node(1);
		root.left.left.left = new Node(2);
		root.left.left.right = new Node(6);
		
		root.right.left = new Node(3);
		root.right.right = new Node(9);
		root.right.right.right = new Node(0);
		root.right.right.right.left = new Node(4);
		root.right.right.right.right = new Node(-1);
		root.right.right.right.right.left = new Node(10);
		findMaxSum(root);
		System.out.println(maxSum);
	}
}
