package trees;

public class FindDensity {
	
	static class Node{
		int data; 
	    Node left, right; 
	  
	    public Node(int data)  
	    { 
	        this.data = data; 
	        left = right = null; 
	    } 
	}
	
	public static int findHeight(Node root) {
		if(root == null )
			return 0;
		
		return Math.max(findHeight(root.left)+1,findHeight(root.right)+1);
	}
	
	
	public static int  findCount(Node root) {
		if(root == null)
			return 0;
		
		return(findCount(root.left) + findCount(root.right) +1);
	}
	
	public static void printDensity(Node root) {
		int h = findHeight(root);
		int count = findCount(root);
		System.out.println("Density is " + count/h);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		printDensity(root);
	}
	
}
