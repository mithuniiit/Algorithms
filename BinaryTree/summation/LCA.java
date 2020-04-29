package trees.summation;

public class LCA {
	
	public static Node findLCA(Node root, int key1, int key2) {
		if(root == null)
			return null;
		
		if(root.data == key1 || root.data == key2)
			return root;
		
		Node left = findLCA(root.left,key1,key2);
		Node right = findLCA(root.right,key1,key2);
		
		if(left != null && right != null)
			return root;
		
		if(left != null )
			return left;
		
		if(right != null)
			return right;
					
		return null;
		
	}
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.left = new Node(10);
		int key1 = 7;
		int key2 = 10;
		Node result = findLCA(root,key1,key2);
		if(result == null)
			System.out.println("No LCA");
		else
			System.out.println(result.data);
	}
}
