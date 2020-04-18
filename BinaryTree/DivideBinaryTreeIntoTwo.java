package trees;

public class DivideBinaryTreeIntoTwo {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	public static int findTotal(Node root) {
		if(root == null) {
			return 0;
		}
		return findTotal(root.left) +  findTotal(root.right) + 1;
	}
	
	public static boolean traverse(Node root, int n) {
		if(root == null)
			return false;
		
		int subTreeSize = findTotal(root);
		if(subTreeSize == n - subTreeSize)
			return true;
		
		return traverse(root.left,n) || traverse(root.right,n);
		
	}
	
	public static boolean divideBinary(Node root) {
		
		int n = findTotal(root);
		
		//Traverse EachNode and check if subtree size
		return traverse(root, n);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(7);
		root.right.right = new Node(4);
		System.out.println(divideBinary(root));
	}

}
