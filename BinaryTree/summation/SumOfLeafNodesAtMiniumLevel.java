package trees.summation;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeafNodesAtMiniumLevel {
	
	
	public static int findSum(Node root) {
		int sum = 0;
		boolean isLeaf = false; 
		
		Queue<Node> q = new LinkedList<>();

		q.add(root);
		
		while(!isLeaf &&  !q.isEmpty()) {
			int size = q.size();
			
			while(size-- > 0) {
				Node temp = q.poll();
				if(temp.left == null && temp.right == null) {
					sum += temp.data;
					isLeaf = true;
				}
				if( temp.left != null) {
					q.add(temp.left);
				}
				if(temp.right != null) {
					q.add(temp.right);
				}
			}
		}
		
		return sum;
	}
	public static void main(String[] args) {
		Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.right.left = new Node(6); 
        root.left.right = new Node(5); 
        root.right.right = new Node(7);
        root.left.right.left = new Node(8);
        root.right.left.right = new Node(9);
        System.out.println(findSum(root));
	}

}
