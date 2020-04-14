package trees;

public class ChildrenSum {

	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	public static int checkSum(Node root) {
		if(root == null)
			return 0;
		
		int leftVal = 0, rightVal = 0;
		
		leftVal = checkSum(root.left);
		if( leftVal == -1)
			return -1;
	
		rightVal = checkSum(root.right);
		if( rightVal == -1)
			return -1;
		
		//means LeafNode
		if(leftVal + rightVal == 0)
			return root.data;
		else if(root.data == leftVal+rightVal)
			return root.data;
		else
			return -1;
	}
	
	public static void main(String[] args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(2);
		if(checkSum(root) == -1)
			System.out.println("Not CheckSum Tree");
		else
			System.out.println("CheckSum Tree");
	}
}
