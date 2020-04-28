package trees.summation;

import java.util.HashMap;

public class VerticalSUm {
	
	public static void findVerticalSumUtil(Node root, HashMap<Integer,String> h, int vd) {
		if(root == null)
			return;
		
		String val = h.getOrDefault(vd, "");
		h.put(vd, val +" "+ root.data);
		
		findVerticalSumUtil(root.left,h,vd-1);
		findVerticalSumUtil(root.right,h,vd+1);
		
	}

	public static void findVerticalSum(Node root) {
		HashMap<Integer,String> h = new HashMap<>();
		findVerticalSumUtil(root,h,0);
		System.out.println(h.toString());
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		findVerticalSum(root);
	}
}
