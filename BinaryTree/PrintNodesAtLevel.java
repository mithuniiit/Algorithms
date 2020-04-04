package trees;

public class PrintNodesAtLevel {
	
	static Node root;
	
	static class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data = data;
		}
	}
	
	public static void printNodeAtLevel(Node node, int level) {
		if(node == null)
			return;
		if(level == 0)
			System.out.println(node.data);
		printNodeAtLevel(node.left, level-1);
		printNodeAtLevel(node.right, level-1);
	}
	
	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		printNodeAtLevel(root, 2);
	}
}
