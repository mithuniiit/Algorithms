package Linkedlist;

public class RemoveDuplicate {
	
	static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
		}
	}
	
	public static void removeDuplicate(Node head) {
		Node curr = head;
		while(curr != null) {
			Node temp = curr.next;
			while(temp!=null && temp.data == curr.data) {
				temp = temp.next;
			}
			curr.next = temp;
			curr = curr.next;
		}
	}
	
	public static void print(Node head) {
		while(head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(1);
		head.next.next = new Node(2);
		head.next.next.next = new Node(2);
		//print(head);
		removeDuplicate(head);
		print(head);
	}
	
	
}
