package trees.summation;

public class SumOfHeights {
	
	
	public static int height(Node root) {
		if(root == null)
			return 0;
		
		return Math.max(height(root.left),height(root.right)) + 1;
	}
	
	public static int sumHeight(Node root) {
		if(root == null)
			return 0;
		
		return height(root) + sumHeight(root.left) + sumHeight(root.right);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		System.out.println(sumHeight(root));
	}

}
