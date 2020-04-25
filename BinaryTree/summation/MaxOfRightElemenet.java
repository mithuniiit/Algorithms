package trees.summation;

public class MaxOfRightElemenet {
	
	
	public static int findMax(Node root) {
		if(root == null)
			return -1;
		
		int sum = Integer.MIN_VALUE;
		
		if(root.right != null)
			sum = root.right.data;
		
		return (Math.max(sum,Math.max(findMax(root.left),findMax(root.right))));
	}
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(findMax(root));
	}
}
