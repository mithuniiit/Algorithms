package trees.summation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FindDiagonal {
	
	
	public static void printDiagonalIterative(Node root) {
		if(root == null)
			return;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			Node temp = q.poll();
			
			if(temp == null) {
				System.out.println();
				if(!q.isEmpty())
					q.add(null);
			}else {
				while(temp != null) {
					System.out.print(" " + temp.data);
					if(temp.left != null)
						q.add(temp.left);
					temp = temp.right;
				}	
			}
		}
	}

	public static void printDiagonalRecursiveUtil(Node root, HashMap<Integer,Integer> map, int d) {
		if(root == null)
			return;
		
		map.put(d, map.getOrDefault(d, 0) + root.data);
		
		printDiagonalRecursiveUtil(root.left, map, d+1);
		printDiagonalRecursiveUtil(root.right, map, d);
	}
	
	
	public static void printDiagonalRecursive(Node root) {
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		printDiagonalRecursiveUtil(root,map,0);
		
		for(Integer key : map.keySet())
			System.out.println(key + "  "+ map.get(key));
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
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(11);
		root.right.left.left = new Node(12);
		root.right.left.right = new Node(13);
		root.right.right.left = new Node(14);
		root.right.right.right = new Node(15);
		
		//printDiagonalRecursive(root);
		
		printDiagonalIterative(root);
	}
}
