package Linkedlist;

public class DetectLoop {
	
	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
		}
	}
	
	
	public static boolean detectLoop(Node head) {
		Node slow = head;
		Node fast = head;
		boolean flag = false;
		
		while(fast != null && fast.next != null ) {
			slow = slow.next;
			fast = fast.next.next;

			if(slow == fast) {
				flag = true;
				break;
			}
		}
		
		if(!flag)
			return false;
		
		slow = head;
		while(slow.next != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}
		fast.next = null;
		return true;
	}
	
	public static void print(Node head) {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		Node temp = head.next.next;
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = temp;
		
		System.out.println(detectLoop(head));
		print(head);
	}

}
