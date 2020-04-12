package trees;

public class PrintBoundary {
	
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	public static void print(Node root) {
		if(root == null)
			return;
		
		//print root
		System.out.println(root.data);
		
		//print left except leaf
		printLeft(root.left);
		
		printLeaf(root);
		
		//print right except leaf
		printRight(root.right);
	}
	
	
	public static void printLeaf(Node root) {
		if(root == null)
			return;
		
		if(root.left == null && root.right == null) {
			System.out.println(root.data);
			return;
		}
		
		printLeaf(root.left);
		printLeaf(root.right);
	}
		
	public static void printLeft(Node root) {
		if(root == null)
			return;
		
		if(root.left != null) {
			System.out.println(root.data);
			printLeft(root.left);
		}
		else if(root.right !=null) {
			System.out.println(root.data);
			printLeft(root.right);
		}
	}
	
	public static void printRight(Node root) {
		if(root == null)
			return;
		
		if(root.right != null) {
			System.out.println(root.data);
			printRight(root.right);
		}
		else if(root.left !=null) {
			System.out.println(root.data);
			printRight(root.left);
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		print(root);
	}

}