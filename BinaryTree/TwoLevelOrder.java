package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TwoLevelOrder {

	static final int MAXLEVEL = 2; 
	
	static class Node{
		Node left,right;
		int data;
		Node(int data){
			this.data = data;
		}
	}
	
	public static void print(Node root) {
		Queue<Node> q = new LinkedList<>();
		Stack<Node> s = new Stack<>();
		
		boolean leftToRight = true;
		int level = 0;
		
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			Node temp = q.poll();

			if(leftToRight) {
				if(temp == null && !q.isEmpty()) {
					q.add(null);
					level++;
				}else
					System.out.println(temp.data);
			}else {
				if(temp == null) {
					while(!s.isEmpty())
						  System.out.println(s.pop().data);
					level++;
					
					if(!q.isEmpty())
						q.add(null);
				}else
					s.push(temp);
			}
			
			if(temp!= null && temp.left != null)
				q.add(temp.left);
			if(temp!= null && temp.right != null)
				q.add(temp.right);
			
			if(level == MAXLEVEL) {
				leftToRight = !leftToRight;
				level = 0;
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
  		root.left.left.left = new Node(8);
		root.left.left.right = new Node(9);
		print(root);
	}
}
