package BinaryTree;

public class NthNodeInorder {
	
	static int count = 5;
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	private static void nthInorder(Node root) {
		if(root == null)
			return;
		nthInorder(root.left);
		if(count == 0 )
			System.out.println(root.data);
		count--;
		nthInorder(root.right);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		nthInorder(root);
	}

}
