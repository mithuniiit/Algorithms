package trees.summation;


public class SumOfLeaves {

	public static int sum(Node root) {
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null)
			return root.data + sum(root.left) + sum(root.right);
		
		return sum(root.left) + sum(root.right);
	}
	
	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(7);
		root.left.right = new Node(2);
		root.right.left = new Node(2);
		root.right.right = new Node(3);
		System.out.println(sum(root));
	}
}
