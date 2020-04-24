package trees;

import java.util.Stack;

import trees.LevelOrderByNewLine.Node;

public class IsTreeIdenticalIterative {

	
	public static boolean check(Node root1, Node root2) {
		Stack<Node> s1 = new Stack<>();
		Stack<Node> s2 = new Stack<>();
		
		
		while(true) {
			
			while(root1 != null && root2 != null) {
				s1.push(root1);
				s2.push(root2);
				
				if(root1.data != root2.data)
					return false;
				
				root1 = root1.left;
				root2 = root2.left;
			}
			
			if(!(root1 == null && root2 == null)) {
				return false;
			}
			
			if(!s1.isEmpty() && !s2.isEmpty()) {
				root1 = s1.pop();
				root2 = s2.pop();
				
				root1 = root1.right;
				root2 = root2.right;
			}else
				break;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		Node root1 = new Node(1);
		root1.left = new Node(2);
		root1.right = new Node(3);
		root1.left.left = new Node(4);
		root1.left.right = new Node(5);
		
		Node root2 = new Node(1);
		root2.left = new Node(2);
		root2.right = new Node(3);
		root2.left.left = new Node(4);
		root2.left.right = new Node(5);
		System.out.println(check(root1,root2));
	}
}
