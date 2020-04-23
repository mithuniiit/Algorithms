package trees;

import java.util.ArrayList;
import java.util.List;

import trees.CousineNode.Node;

public class IsSubTreeSingleTraversal {
	
	public static void populateInorder(Node root,List<Integer> list) {
		if(root == null)
			return;
		
		populateInorder(root.left, list);
		list.add(root.data);
		populateInorder(root.right,list);
	}
	
	
	public static void populatePostOrder(Node root,List<Integer> list) {
		if(root == null)
			return;
		
		populatePostOrder(root.left, list);
		populatePostOrder(root.right,list);
		list.add(root.data);
	}
	
	
	public static boolean isSubString(List<Integer>l1, List<Integer>l2) {
		StringBuilder sb1 = new StringBuilder();
		for(Integer n1 : l1) {
			sb1.append(n1.toString());
			sb1.append(" ");
		}
		
		StringBuilder sb2 = new StringBuilder();
		for(Integer n2 : l2) {
			sb2.append(n2.toString());
			sb2.append(" ");
		}
		
		if(sb1.toString().contains(sb2.toString())) {
			return true;
		}
		return false;
	}
	
	public static boolean checkSub(Node root, Node subTree) {
		List<Integer> RootPreList = new ArrayList<>();
		List<Integer> SubTreePreList = new ArrayList<>();
		
		List<Integer> RootPostList = new ArrayList<>();
		List<Integer> SubTreePostList = new ArrayList<>();
		
		populateInorder(root,RootPreList);
		populateInorder(subTree,SubTreePreList);
		populatePostOrder(root,RootPostList);
		populatePostOrder(subTree,SubTreePostList);
		
		
		
		return isSubString(RootPreList,SubTreePreList) && isSubString(RootPostList,SubTreePostList) ;
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		
		Node subTree = new Node(2);
		subTree.left = new Node(4);
		subTree.right = new Node(5);
		
		System.out.println(checkSub(root,subTree));
	}

}
