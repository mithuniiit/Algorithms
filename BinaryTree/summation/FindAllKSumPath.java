package trees.summation;

import java.util.ArrayList;
import java.util.List;

public class FindAllKSumPath {

	public static void printList(List<Integer>l, int i) {

		for( ; i<l.size(); i++)
			System.out.print(" " + l.get(i));
		System.out.println();
	}
	
	
	public static void print(Node root,int k, List<Integer> l) {
		if(root == null)
			return;
		
		l.add(root.data);
		
		print(root.left,k,l);
		print(root.right,k,l);
		
		int sum = 0;
		for(int i = l.size()-1 ; i>=0 ; i--) {
			sum += l.get(i);
			if(sum == k)
				printList(l , i);
		}
		l.remove(l.size()-1);
	}
	
	public static void printKSumPath(Node root, int k) {
		List<Integer> l = new ArrayList<>();
		print(root,k,l);
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(3);
		root.left.left = new Node(2);
		root.left.right = new Node(1);
		root.left.right.left = new Node(1);
		
		root.right = new Node(-1);
		root.right.left = new Node(4);
		root.right.left.left = new Node(1);
		root.right.left.right = new Node(2);
		root.right.right = new Node(5);
		root.right.right.right = new Node(6);
		
		printKSumPath(root,5);
	}
}
