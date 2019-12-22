public class binaryTree {
	Node root;
	
	boolean isBST() {
		return isBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}

	private boolean isBSTUtil(Node root, int min, int max) {
		if(root == null)
			return true;
		
		if(root.data < min && root.data>max) {
			return false;
		}
		
		return isBSTUtil(root.left,min,root.data-1) || isBSTUtil(root.right,root.data+1, max);
	}
	
	public static void main(String args[]) 
    { 
	  	binaryTree tree = new binaryTree(); 
        tree.root = new Node(4); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(5); 
        tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(3); 
  
        if (tree.isBST()) 
            System.out.println("IS BST"); 
        else
            System.out.println("Not a BST"); 
    } 


}
