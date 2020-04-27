package trees.summation;


public class MergeTwoBinaryTrees {
	
	
	
	public static void print(Node root) {
		if(root == null)
			return;
		print(root.left);
		System.out.println(root.data);
		print(root.right);
	}
	
	public static Node mergeTree(Node root1, Node root2) {
		if(root1 == null)
			return root2;
		
		if(root2 == null)
			return root1;
		
		root1.data += root2.data;
		
		root1.left = mergeTree(root1.left,root2.left);
		root1.right = mergeTree(root2.right, root2.right);
		
		return root1;
		
	}
	
	
	public static void main(String[] args) {
		Node root1 = new Node(2); 
        root1.left = new Node(1); 
        root1.right = new Node(4); 
        root1.left.left = new Node(5);
        
        Node root2 = new Node(3); 
        root2.left = new Node(6); 
        root2.right = new Node(1); 
        root2.left.right = new Node(2);
        root2.right.right = new Node(7);

        Node root3 = mergeTree(root1,root2);
        
        print(root3);
	}

}
