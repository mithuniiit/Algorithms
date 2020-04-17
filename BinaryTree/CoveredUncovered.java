package trees;

public class CoveredUncovered {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	public static int findLeftSum(Node root) {
		if(root == null)
			return 0;
		
		if(root.left != null)
			return root.data + findLeftSum(root.left);
		else
			return root.data + findLeftSum(root.right);
	}
	
	public static int findRightSum(Node root) {
		if(root == null)
			return 0;
		
		if(root.right != null)
			return root.data + findRightSum(root.right);
		else
			return root.data + findRightSum(root.left);
	}
	
	public static int findTotalSum(Node root) {
		if(root == null)
			return 0;
		
		int leftSum = findTotalSum(root.left);
		int rightSum = findTotalSum(root.right);
		return leftSum + root.data + rightSum;
	}
	
	public static boolean isSame(Node root) {
		int leftSum = 0;
		int rightSum = 0;
		
		if(root.left!=null)
			leftSum = findLeftSum(root.left);
		
		if(root.right != null)
			rightSum = findRightSum(root.right);
		
		int boundarySum = leftSum + rightSum + root.data;
		
		int totalSum = findTotalSum(root);
		
		if(totalSum - boundarySum == boundarySum)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		Node root = new Node(9);
		root.left = new Node(4);
		root.right = new Node(17);
		root.left.left = new Node(3);
		root.left.right = new Node(6);
		root.left.right.left = new Node(5);
		root.left.right.right = new Node(7);
		root.right.right = new Node(22);
		root.right.right.left = new Node(20);
		System.out.println(isSame(root));
	}

}
