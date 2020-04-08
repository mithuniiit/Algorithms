package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class SumInOderPredSucc {
	
	static Node root;
	
	static class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data = data;
		}
	}
	
	static void storeInorder(Node root, List<Integer> l) {
		if(root == null)
			return;
		storeInorder(root.left , l);
		l.add(root.data);
		storeInorder(root.right, l);
	}
	
	static void findSum() {
		List<Integer> l = new ArrayList<>();
		l.add(0);
		storeInorder(root,l);
		l.add(0);
		replaceInorder(root,l,index);
	}
	
	static int index = 1;
	
	static void replaceInorder(Node root, List<Integer> l , int index) {
		if(root == null)
			return;
		replaceInorder(root.left, l, index);
		root.data = l.get(index-1) + l.get(index+1);
		index++;
		replaceInorder(root.right, l, index);
	}
	
	static void print(Node root) {
		if(root == null)
			return;
		print(root.left);
		System.out.println(root.data);
		print(root.right);
		
	}

	public static void main(String[] args) {
		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		System.out.println("================");
		print(root);
		findSum();
		System.out.println("================");
		print(root);
	}
}
