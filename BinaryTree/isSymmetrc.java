package trees;

public class isSymmetrc {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	public static boolean isSymmetric(Node root1, Node root2) {
		if(root1 == null && root2 == null)
			return true;
		
		if(root1!=null && root2!=null && root1.data == root2.data 
				&& isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left)) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(4);
		root.right.left = new Node(4);
		root.right.right = new Node(3);
		Node temp = root;
		System.out.println(isSymmetric(temp,temp));
	}

}
