package trees;

import trees.LevelOrderByNewLine.Node;

public class PrintAllRootToLeafPath {
	
	public static void printPath(Node root, int[] path, int pathIndex) {
		if(root == null)
			return;
		
		path[pathIndex++] = root.data;
		
		if(root.left == null && root.right == null) {
			System.out.println();
			for(int i=0; i<pathIndex; i++)
				System.out.print(" " + path[i]);
			return;
		}
		
		printPath(root.left,path,pathIndex);
		printPath(root.right,path,pathIndex);
		
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		int[]path = new int[1000];
		
		printPath(root,path,0);
	}
}
