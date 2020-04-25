package trees.summation;

public class MaxSumRootToLeaf {

	public static int findMaxSum(Node root) {
		if(root == null)
			return 0;
		
		int lSum = findMaxSum(root.left);
		int rSum = findMaxSum(root.right);
		
		return Math.max(lSum,rSum) + root.data;
	}
	
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(-2);
		root.right = new Node(7);
		root.left.left = new Node(8);
		root.left.right = new Node(-4);
		System.out.println(findMaxSum(root));
	}
}
