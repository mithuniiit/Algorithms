package trees;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;

public class PrintDiagonal {
	
	static class Node{
		int data;
		Node left;
		Node right;
		Node next;
		Node(int data){
			this.data = data;
		}
	}
	
	public static void iterate(Node root, HashMap<Integer,Vector<Integer>> hmap,int d) {
		if(root == null)
			return;
		
		Vector<Integer> k = hmap.get(d);
		
		if(k == null) {
			k = new Vector<Integer>();
			hmap.put(d,k);
		}
		
		k.add(root.data);
		
		iterate(root.left,hmap,d-1);
		iterate(root.right,hmap,d);
	}
	
	public static void print(HashMap<Integer,Vector<Integer>> hmap) {
		for (Entry<Integer, Vector<Integer>> entry : hmap.entrySet()) 
        { 
            System.out.println(entry.getValue()); 
        } 
	}
	
	public static void main(String[] args) {
		HashMap<Integer,Vector<Integer>> hmap = new HashMap<>();
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		iterate(root,hmap,0);
		print(hmap);
	}

}
