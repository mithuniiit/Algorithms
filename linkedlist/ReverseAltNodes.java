package Linkedlist;

public class ReverseAltNodes {
	
	static Node head;
	
	static class Node{
		int data;
		Node(int data){
			this.data = data;
		}
		Node next;
	}

	public static Node reverseNodes(Node localHead, int k) {
		Node prev = null;
		Node next = null;
		Node current = localHead;
		int count = 0;
		
		//Reverse first K elements
		while(current != null && count < k) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			count++;
		}
		
		if(next != null)
			localHead.next = next;
		
		current = next;
		count = 0; 
		//Skip next K elements
		while(current != null && count<k-1) {
			current = current.next;
			count++;
		}
		
		if(current != null) {
			current.next = reverseNodes(current.next,k);
		}
		
		return prev;
	}
	
	static void printNodes() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
			
	}
	
	public static void main(String[] args) {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		head = reverseNodes(head, 3);
		printNodes();
	}
}
