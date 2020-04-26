package trees.summation;

public class PrintNodesAtMaxDepth {
	
	public static int printAtLevel(Node root, int max) {
		if(root == null)
			return 0;
		
		if(max == 1)
			return root.data;
		
		return printAtLevel(root.left,max-1) +	printAtLevel(root.right,max-1);
	}
	
	public static int findMaxHeight(Node root) {
		if(root == null)
			return 0;
		
		return 1+ Math.max(findMaxHeight(root.left),findMaxHeight(root.right));
	}
	
	public static void main(String[] args) {
        Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.left = new Node(6); 
        root.right.right = new Node(7);
        int max = findMaxHeight(root);
        System.out.println(printAtLevel(root,max));
	}

}
