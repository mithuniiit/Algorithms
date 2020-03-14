package Linkedlist;

public class PairWiseSwap {
	
	static Node head;
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}
	}
	
	public static Node pairWiseSwap(Node node) {
		if(node == null || node.next == null)
			return node;
		
		//Initialize current and prev
		Node prev = node;
		Node current = node.next;
		
		//Initialize Head
		node = current;
		
		while(true) {
			//Swap the links
			Node next = current.next;
			current.next = prev;
			
			if(next == null || next.next == null) {
				prev.next = next;
				break;
			}
			
			//Change the prev
			prev.next = next.next;
			
			//Update prev and current
			prev = next;
			current = prev.next;
		}
		
		return node;
	}
	
	public static void print() {
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
		head = pairWiseSwap(head);
		print();
	}
}
