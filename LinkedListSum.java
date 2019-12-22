
public class LinkedListSum {

	static Node node1,node2;
	
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data=data;
		}
	}
	
	
	public static void main(String[] args) {
		LinkedListSum list = new LinkedListSum(); 
		list.node1 = new Node(7);
		list.node1.next = new Node(5);
		list.node1.next.next=new Node(9);
		list.node1.next.next.next= new Node(4);
		list.node1.next.next.next.next = new Node(6);
		
		System.out.println("First list is");
		list.print(node1);
		
		 list.node2 = new Node(8); 
	     list.node2.next = new Node(4); 
	     System.out.print("Second List is "); 
	     list.print(node2); 
	     
	     
	     //Add two nodes and return new node
	     Node res = list.add(node1,node2);
	     System.out.println("Output is ");
	     list.print(res);
	}


	private Node add(Node first, Node second) {
		Node res = null;
		Node prev = null;
		Node temp = null;
		int carry = 0,sum=0;
		
		while(first != null || second !=  null) {
			sum = carry + (first!=null ? first.data : 0)
						+ (second!=null ? second.data : 0);
			
			carry = (sum > 10 ) ? 1 : 0;
			sum = sum%10;
			temp = new Node(sum);
			
			if(res == null)
				res = temp;
			else
				prev.next=temp;
			
			prev = temp;
			
			if(first!=null)
				first = first.next;
			
			if(second!=null)
				second=second.next;
			
		}
		
		if(carry >0 )
			temp.next = new Node(carry);
		
		return res;
	}


	private void print(Node node) {
		while(node != null) {
			System.out.println(" "+node.data);
			node = node.next;
		}
	}
}
