package trees;

import trees.CousineNode.Node;

public class IsHeighBalancedLikeRedBlack {
	
	static class Height{
		int h;
		Height(int h){
			this.h = h;
		}
	}

	public static boolean findHeight(Node root, Height maxh, Height minh) {
		if(root == null) {
			maxh.h = 0;
			minh.h = 0;
			return true; 
		}
		
		Height lmaxh = new Height(0);
		Height rmaxh = new Height(0);
		Height lminh = new Height(0);
		Height rminh = new Height(0);
		
		if(!findHeight(root,lminh,lmaxh)) {
			return false;
		}
		
		if(!findHeight(root,rminh,lminh)) {
			return false;
		}
		
		minh.h = Math.min(lminh.h,rminh.h);
		maxh.h = Math.max(lmaxh.h,rmaxh.h);
		
		if(maxh.h > 2*minh.h)
			return false;
		
		return true;
	}
	
	
	public static void main(String[] args) {
		Height maxh = new Height(0);
		Height minh = new Height(0);
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.left.left = new Node(5);
		root.left.left.left.left = new Node(6);
		root.left.left.left.left.left = new Node(7);
		System.out.println(findHeight(root,maxh,minh));
	}
	
}
