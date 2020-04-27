package trees.summation;


public class SumOfAllRootToLeafPathSum {
	
	
	public static boolean findSum(Node root, int sum) {
		if(root == null)
			return sum == 0;
		
		return findSum(root.left, sum - root.data) || 	findSum(root.right, sum - root.data);
		
	}
	public static void main(String[] args) {
		Node root = new Node(10); 
        root.left = new Node(8); 
        root.right = new Node(2); 
        root.left.left = new Node(3); 
        root.right.left = new Node(5); 
        root.left.right = new Node(2); 
        System.out.println(findSum(root,21));
	}

}
