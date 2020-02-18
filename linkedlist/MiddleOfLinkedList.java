package Linkedlist;

public class MiddleOfLinkedList {

	static Node head;
	
	static class Node{
		int data;
		Node next;
		Node(int d){
			this.data = d;
			this.next = null;
		}
	}
	
	private static void addNode(int i) {
		Node temp = new Node(i);
		temp.next = head;
		head = temp;
	}
	
	public static void main(String [] args) 
    { 
		head = new Node(1);
        addNode(2);
        addNode(3);
        addNode(4);
        addNode(5);
        //print(head);
        findMiddle(head);
    }

	private static void print(Node head) {
		Node temp = head;
		while(temp!=null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		
	}

	private static void findMiddle(Node head) {
		Node fastPtr = head;
		Node slowPtr = head;
		while(fastPtr != null && fastPtr.next != null) {
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}
		System.out.println(slowPtr.data);
	}
}
