package BinaryTree;

public class FindLargestSubTreeSum {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	static int maxSum = 0;
	
	public static int findSum(Node root) {
		if(root == null)
			return 0;
		
		int sum = root.data + findSum(root.left) + findSum(root.right);
		
		if(sum > maxSum)
			maxSum = sum;
		
		return sum;
		
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(-2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(-6);
		root.right.right = new Node(2);
		System.out.println(findSum(root));
	}

}
