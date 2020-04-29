package trees.summation;

public class BSTToDLL {
	
	static Node prev;
	static Node head; 

	public static void bstToDllUtil(Node root) {
		if(root == null)
			return;
				
		bstToDllUtil(root.left);
		
		if(head == null) {
			head = root;
			prev = root;
		}else {
			root.left = prev;
			prev.right = root;
			prev = root;
		}
		
		bstToDllUtil(root.right);
	}
	
	public static void bstToDll(Node root) {
		bstToDllUtil(root);
		System.out.println("PRINTING LL");
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.right;
		}
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		bstToDll(root);
	}
}
