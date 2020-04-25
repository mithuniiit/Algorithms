public class Sum {

	public static int sum(Node root) {
		if(root == null)
			return 0;
		
		return root.data + sum(root.left) + sum(root.right);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println(sum(root));
	}
}
