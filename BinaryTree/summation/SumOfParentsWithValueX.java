package trees.summation;


public class SumOfParentsWithValueX {

	public static int sum(Node root, int x) {
		if(root == null)
			return 0;
		
		if(root.left != null && root.left.data == x || root.right != null && root.right.data == x)
			return root.data + sum(root.left,x) + sum(root.right,x);
		
		return sum(root.left,x) + sum(root.right,x);
	}
	
	public static void main(String[] args) {
		Node root = new Node(4);
		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(7);
		root.left.right = new Node(2);
		root.right.left = new Node(2);
		root.right.right = new Node(3);
		System.out.println(sum(root,2));
	}
}
