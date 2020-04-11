package trees;

import java.util.LinkedList;
import java.util.Queue;

public class IterativeDiagonalPrint {
	
	static class Node{
		Node left,right;
		int data;
		Node(int data){
			this.data = data;
		}
	}
	
	public static void iterate(Node root) {
		Queue<Node> q = new LinkedList();
		
		if(root == null)
			return;
		
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			
			if(temp == null) {
				if(q.isEmpty())
					return;
				System.out.println();
				q.add(null);
				
			}else {
				while(temp!=null) {
					System.out.print(temp.data + " ");
					if(temp.left != null)
						q.add(temp.left);
					temp = temp.right;
				}
			}
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
		iterate(root);
	}

}
