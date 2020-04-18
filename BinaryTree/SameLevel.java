package trees;

public class SameLevel {

	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	public static int getLevel(Node root, int key) {
		if(root == null )
			return 0;
		
		if(root.data == key)
			return 1;
		
		int x = getLevel(root.left,key);
		if(x != 0)
			return x+1;
		
		return getLevel(root.right,key)+1;
			
	}
	
	public static boolean checkLevel(Node root, int key1, int key2) {
		int level1 = getLevel(root,key1);
		int level2 = getLevel(root,key2);
		if(level1 == level2)
			return true;
		return false;
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);

		System.out.println(checkLevel(root,2,6));
	}
}
