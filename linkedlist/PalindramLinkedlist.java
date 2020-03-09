package Linkedlist;

public class PalindramLinkedlist {
	
	static class Node{
		int data;
		Node(int data){
			this.data = data;
		}
		Node next;
	}
	
	public static boolean isPalindram(Node head) {
		
		//Find Middle
		Node middle = findMiddle(head);
		
		//Reverse
		middle.next = reverse(middle.next);
		
		System.out.println("Reversed Node ");
		
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
		
		//Check
		return check(head,middle.next);
	}
	
	public static boolean check(Node head, Node middle) {
		while(middle != null) {
			if(head.data != middle.data)
				return false;
			middle = middle.next;
			head = head.next;
		}
		
		return true;
	}
	
	private static Node reverse(Node node) {
		Node prev = null;
		Node current = node;
		Node next;

		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}

	private static Node findMiddle(Node head) {
		
		//1 -> 2 -> 3 -> 2 -> 1
		Node fast = head;
		Node slow = head;
		Node prev = null;
		
		while(fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return (fast == null) ? prev : slow;
		
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);
		System.out.println(isPalindram(head));
	}
}
