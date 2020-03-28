package queue;

public class QueueUsingList {

	static Node head;
	static Node tail;

	static class Node{
		int data;
		Node prev;
		Node next;
		Node(int x){
			this.data = x;
		}
	}

	public static void main(String[] args) {
		enqueue(1);
		enqueue(2);
		System.out.println(dequeue());
		System.out.println(dequeue());
		System.out.println(dequeue());
	}

	private static void enqueue(int data) {
		Node n = new Node(data);
		if(head == null) {
			head = n;
			tail = n;
		}else {
			tail.next = n;
			n.prev = tail;
			tail = n;
		}
	}

	private static int dequeue() {
		if(head == null) {
			System.out.println("Queue is empty");
			return Integer.MIN_VALUE;
		}

		int temp = head.data;
		head = head.next;
		if(head == null) {
			tail = head;
		}
		return temp;
	}
}
