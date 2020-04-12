package trees;

public class depthFromPreOrder {

	private static int findDepth(String tree, int n, int index) {
		if( index >= n || tree.charAt(index) == 'l' ) {
			return 0;
		}

		return Math.max(findDepth(tree,n,++index),findDepth(tree,n,++index) ) + 1;
	}
	
	public static void main(String[] args) {
		String tree = "nlnll"; 
		int n = tree.length(); 
		System.out.println(findDepth(tree,n,0));
	}
}
