package Linkedlist;

public class DeleteFirst {
	
	static Node head;
	static class Node{
		int data;
		Node next;
		Node(int data){
		this.data = data;
		}
	}
	
	public static void deleteFirst(int x) {
		if(head == null)
			return;
		Node current = head;
		Node prev = null;
		
		while(current != null) {
			if(current.data == x) {
				break;
			}
			prev = current;
			current = current.next;
		}
		
		if(prev == null)
			head = head.next;
		else
			prev.next = prev.next.next;
	}
	
	public static void deleteLast(int x) {
		Node current = head;
		Node prev = null;
		Node currentToBeDeleted = null;
		Node prevToBeDeleted = null;
		if(head == null)
			return;
		
		while(current != null) {
			if(current.data == x) {
				currentToBeDeleted = current;
				prevToBeDeleted = prev;
			}
			prev = current;
			current = current.next;
		}
		
		//head node
		if(prevToBeDeleted == null && currentToBeDeleted != null) {
			head = head.next;
		}else if(prevToBeDeleted != null && currentToBeDeleted != null) {
			prevToBeDeleted.next = prevToBeDeleted.next.next;
		}
	}
	
	public static void printNodes() {
		Node temp = head;
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	public static void main(String[] args) {
		head = new Node(1);
		head.next = new Node(1);
		head.next.next = new Node(2);
		head.next.next.next = new Node(2);
		//deleteFirst(1);
		deleteLast(2);
		printNodes();
	}

}
