
public class TreeFromParentArray {
	
	Node root;
	
	public static void main(String[] args) {
		TreeFromParentArray tree = new TreeFromParentArray();
		int []parent = new int[]{-1, 0, 0, 1, 1, 3, 5};
		int n = parent.length;
		Node node = tree.createTree(parent,n);
        System.out.println("Inorder traversal of constructed tree "); 
        tree.inorder(node); 
	}

	private void inorder(Node node) {
		if(node != null) {
			inorder(node.left);
			System.out.println(node.data);
			inorder(node.right);
		}
		
	}

	private Node createTree(int[] parent, int n) {
		Node[] created = new Node[n];
		for(int i=0;i<n;i++) {
			created[i]=null;
		}
		
		for(int i=0;i<n;i++) {
			createNode(parent,i,created);
		}
		return root;
	}

	private void createNode(int[] parent, int i, Node[] created) {
		if(created[i]!=null) {
			return;
		}

		created[i] = new Node(i);
		if(parent[i]==-1) {
			root = created[i];
			return;
		}
		
		if(created[parent[i]]!=null)
			createNode(parent,parent[i],created);
		
		Node p = created[parent[i]];
		
		if(p.left == null)
			p.left = created[i];
		else
			p.right = created[i];
	}
}
