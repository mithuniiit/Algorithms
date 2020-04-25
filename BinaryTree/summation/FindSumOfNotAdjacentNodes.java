package BinaryTree;

public class FindSumOfNotAdjacentNodes {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	
	public static int findSumGrand(Node root) {
		if(root == null)
			return 0;
		
		int sum = 0;
		
		if(root.left != null)
			sum += findSumGrand(root.left.left) + findSumGrand(root.left.right);
		
		if(root.right != null)
			sum += findSumGrand(root.right.left) + findSumGrand(root.right.right);
		
		return sum + root.data;
	}
	
	public static int findSum(Node root) {
		if(root == null)
			return 0;
		
		//Find max between current level and alternate level
		return Math.max(findSumGrand(root), findSumGrand(root.left) + findSumGrand(root.left));
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(1);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
		
		System.out.println(findSum(root));
	}

}
