package Linkedlist;

public class FlattenLinkedList {
	static Node head;

	static class Node 
    { 
        int data; 
        Node right, down; 
        Node(int data) 
        { 
            this.data = data; 
            right = null; 
            down = null; 
        } 
    } 
	
	
	public static Node merge(Node n1, Node n2) {
		if(n1 == null)
			return n2;
		
		if(n2 == null)
			return n1;
		
		Node result;
		
		if(n1.data < n2.data) {
			result = n1;
			result.down = merge(n1.down,n2);
		}
		else {
			result = n2;
			result.down = merge(n2.down,n1);
		}
		
		return result;
	}
	//Strategy is recurse till the end and merge list one by one.
	public static Node flatten(Node root) {
		if(root == null || root.right == null)
			return root;
		
		root.right = flatten(root.right);
		
		root = merge(root,root.right);
		
		return root;
	}
	
	public static void main(String[] args) {
		head = new Node(5);
		head.right = new Node(10);
		head.right.right =new Node(19);
		head.right.right.right =new Node(28);
		
		head.down = new Node(7);
		head.down.down = new Node(8);
		head.down.down.down = new Node(30);
		
		head.right.down = new Node(20);

		head.right.right.down = new Node(22);
		head.right.right.down.down = new Node(50);
		
		head.right.right.right.down = new Node(35);
		head.right.right.right.down.down = new Node(40);
		head.right.right.right.down.down.down = new Node(45);
		
		flatten(head);
	}
}
