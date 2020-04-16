package trees;

public class SumTree {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	public static int sumTree(Node root) {
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null)
			return root.data;
	
		int leftSum = sumTree(root.left);
		
		if(leftSum == -1)
			return -1;
		
		int rightSum = sumTree(root.right);
		
		if(rightSum == -1)
			return -1;
		
		if(root.data == leftSum + rightSum)
			return root.data + leftSum + rightSum;
		else
			return -1;
		
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(26);
		root.left = new Node(10);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(6);
		root.right.right = new Node(3);
		
		if(sumTree(root) == -1) 
			System.out.println("Not Sum");
		else
			System.out.println("Sum Tree");
	}

}
