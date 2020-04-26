package trees.summation;

public class SumOfOddAndEven {

	
	public static int findSum(Node root, int level) {
		if(root == null)
			return 0;
		
		int sum = findSum(root.left,level+1) +	findSum(root.right,level+1);
		
		if(level%2 == 0)
			return sum + root.data;
		else
			return sum - root.data;
	}
	public static void main(String[] args) {
	 	Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.left = new Node(6); 
        root.right.right = new Node(7);
        System.out.println(findSum(root,0));
	}
}
