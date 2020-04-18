package trees;

public class LevesAtSameLevel {

	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	public static int levelsAtLevel(Node root) {
		if(root == null)
			return 0;
		
		int lh = levelsAtLevel(root.left);
		int rh = levelsAtLevel(root.right);
		
		if(lh == rh || lh == 0 || rh == 0)
			return Math.max(lh,rh) + 1;
		
		return -1;
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		if(levelsAtLevel(root) == -1)
			System.out.println("Not at same level");
		else
			System.out.println("At same level");
	}
}
