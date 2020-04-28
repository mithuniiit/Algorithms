package trees;

import trees.TwoLevelOrder.Node;

public class VerticalSumLinkedList {
	
	static class DLList{
		int data;
		DLList left;
		DLList right;
		
		DLList(int data){
			this.data = data;
		}
	}
	
	
	public static void findSumUtil(Node root, DLList dll) {
		
		dll.data += root.data;
		
		if(root.left != null) {
			if(dll.left == null) {
				dll.left = new DLList(0);
				dll.left.right = dll;
			}
			findSumUtil(root.left, dll.left);
		}
		
		if(root.right != null) {
			if(dll.right == null) {
				dll.right = new DLList(0);
				dll.right.left = dll;
			}
			findSumUtil(root.right, dll.right);
		}
	}
	
	
	public static void findSum(Node root) {
		if(root == null)
			return;
		
		DLList dll = new DLList(0);
		
		findSumUtil(root,dll);
		//PRINT LL
		while(dll.left != null)
			dll = dll.left;
		
		while(dll != null) {
			System.out.println(dll.data);
			dll = dll.right;
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
		findSum(root);
	}

}
