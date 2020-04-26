package trees.summation;

public class SubTreeWithGivenSum {

	
	static class INT{
		int a;
		INT(int a){
			this.a = a;
		}
	}
	
	public static boolean sumSubTreeUtil(Node root, int sum, INT cur_sum) {
		if(root == null) {
			return false;
		}

		if(sumSubTreeUtil(root.left, sum, cur_sum) || sumSubTreeUtil(root.right, sum, cur_sum))
			return true;
		
		cur_sum.a += root.data; 
		
		if(sum == cur_sum.a)
			return true;
		
 		return false;
	}
	
	public static boolean sumSubTree(Node root, int sum) {
		INT cur_sum = new INT(0);
		return sumSubTreeUtil(root,sum,cur_sum);
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		System.out.println(sumSubTree(root,11));
	}
}
