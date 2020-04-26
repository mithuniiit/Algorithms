package trees.summation;

import java.util.LinkedList;
import java.util.Queue;

public class MaxLevelSum {
	
	//lets do level order traversal and calculate sum at each level
	public static int findMaxSum(Node root) {
		if(root == null)
			return 0;
		
		int maxSum = 0;
		
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			int levelSum = 0;
			int count = q.size();
			
			while(count-- > 0) {
				Node temp = q.poll();
				levelSum += temp.data;
				if(temp.left != null)
					q.add(temp.left);
				if(temp.right != null)
					q.add(temp.right);
			}
			
			if(levelSum > maxSum)
				maxSum = levelSum;
			
			levelSum = 0;
		}
		
		return maxSum;
	}
	
	
	public static void main(String[] args) {
		Node root = new Node(4); 
        root.left = new Node(2); 
        root.right = new Node(-5); 
        root.left.left = new Node(-1); 
        root.left.right = new Node(3); 
        root.right.left = new Node(-2); 
        root.right.right = new Node(6);
        System.out.println(findMaxSum(root));
	}

}
