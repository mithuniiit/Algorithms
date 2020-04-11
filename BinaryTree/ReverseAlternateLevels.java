package trees;

public class ReverseAlternateLevels {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	
	public static void printInorder(Node root) {
		if(root == null)
			return;
		printInorder(root.left);
		System.out.println(root.data);
		printInorder(root.right);
	}
	
	public static void reverseAlternate(Node root1,Node root2, int lvl) {
		if(root1 == null || root2 == null)
			return;
		
		if(lvl%2 == 0) {
			int data = root1.data;
			root1.data = root2.data;
			root2.data = data;
		}
		reverseAlternate(root1.left,root2.right,lvl+1);
		reverseAlternate(root1.right,root2.left,lvl+1);
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println("Inorder Traversal is");
		printInorder(root);
		System.out.println("Inorder Traversal post change");
		reverseAlternate(root.left,root.right,0);
		printInorder(root);
  	}

}
