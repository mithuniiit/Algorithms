package greedy;
import java.util.Comparator;
import java.util.PriorityQueue;

class MyNode{
    int data;
    char c;
    MyNode left;
    MyNode right;
}

class MyComparator implements Comparator<MyNode> {

	@Override
    public int compare(MyNode x, MyNode y){
        return x.data - y.data;
    }
	
}
class HuffMan{
	
	public HuffMan(){
        
    }
	
	public static void main(String[] args){
        int n=6;
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' }; 
        int[] charfreq = { 5, 9, 12, 13, 16, 45 }; 

        PriorityQueue<MyNode> q = new PriorityQueue<MyNode>(n, new MyComparator());

        for(int i=0;i<n;i++){
        	MyNode mynode = new MyNode();
            mynode.c = charArray[i];
            mynode.data = charfreq[i];
            mynode.left = null;
            mynode.right = null;
            q.add(mynode);
        }
        
        MyNode root = buildHuffmanTree(q);
        printCode(root, "");
    }

	private static void printCode(MyNode root, String s) {
		if(root.left == null && root.right == null && Character.isLetter(root.c)) {
			 System.out.println(root.c + ":" + s);
			 return;
		}
		printCode(root.left,s+"0");
		printCode(root.right,s+"1");
	}

	private static MyNode buildHuffmanTree(PriorityQueue<MyNode> q) {
		MyNode root = null;
		while(q.size() > 1) {
			MyNode x = q.poll();
			MyNode y = q.poll();
			
			MyNode node = new MyNode();
			node.data = x.data + y.data;
			node.c = '-';
			node.left = x;
			node.right = y;
			root = node;
			q.add(node);
		}
		return root;
	}
}
