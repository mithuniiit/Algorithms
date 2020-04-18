package trees;

public class CousineNode {
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	public static int getLevel(Node root, int key, int level) {
		
		if(root == null)
			return 0;
		
		if(root.data == key)
			return level;
		
		level = getLevel(root.left,key,level+1);
		if(level != 0)
			return level;
		
		return getLevel(root.right,key,level+1);
	}
	
	
	public static boolean checkSameParent(Node root, int key1, int key2) {
		if(root == null)
			return false;
		
		if(root.left != null && root.right != null && root.left.data == key1 && root.right.data == key2)
			return true;
		
		return (checkSameParent(root.left, key1, key2) || checkSameParent(root.right, key1,key2));
		
	}
	
	public static boolean checkCousine(Node root,int key1, int key2) {
		//Cousine are those which are at same level but different parents
		boolean sameLevel = (getLevel(root,key1,0) == getLevel(root,key2,0)) ? true : false;
		
		if(sameLevel) {
			 if(checkSameParent(root,key1,key2))
				 return false;
			 else
				 return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);

		System.out.println(checkCousine(root,4,6));
	}

}
