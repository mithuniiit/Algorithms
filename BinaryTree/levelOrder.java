package BinaryTree;

public class levelOrder {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	public static int findHeight(Node root) {
		if(root == null)
			return -1;
		return Math.max(findHeight(root.left)+1, findHeight(root.right)+1);
	}
	
	public static void parseLevelOrder(Node root) {
		int height = findHeight(root);
		for(int i=0;i<height;i++) {
			System.out.println("Nodes at level "+i);
			printLevel(root,i);
		}
	}
	
	public static void printLevel(Node root, int level) {
		if(root == null)
			return;
		if(level == 0)
			System.out.println(root.data);
		printLevel(root.left, level-1);
		printLevel(root.right, level-1);
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
		parseLevelOrder(root);
	}

}
