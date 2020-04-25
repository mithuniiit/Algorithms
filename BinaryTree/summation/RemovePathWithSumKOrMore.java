package trees.summation;

public class RemovePathWithSumKOrMore {
	
	public static void print(Node root) {
		if(root == null)
			return;
		
		System.out.println(root.data);
		print(root.left);
		print(root.right);
	}
	
	public static Node pruneUtil(Node root, int sum, int k) {
		if(root == null)
			return null;
		
		root.left = pruneUtil(root.left, sum+root.data, k);
		root.right = pruneUtil(root.right, sum+root.data, k);
		
		if(root.left == null && root.right == null && sum+root.data < k) {
			return null;
		}
		
		return root;
	}
	
	public static void prune(Node root, int k) {
		System.out.println("Before");
		print(root);
		
		pruneUtil(root, 0, k);
		
		System.out.println("After");
		print(root);
	}
	
	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);

		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(13);
		root.right.right.left = new Node(14);
		root.right.right.right = new Node(15);
		
		prune(root,20);
	}

}
