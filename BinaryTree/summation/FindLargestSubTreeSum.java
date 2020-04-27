package trees.summation;

public class FindLargestSubTreeSum {

	static int maxSum = Integer.MIN_VALUE;
	
	
	public static int findMax(Node root, int sum) {
		if(root == null)
			return 0;
		
		sum = root.data + findMax(root.left,sum) + findMax(root.right,sum);
		
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
        
        findMax(root,0);
        
        System.out.println(maxSum);
	}
}
