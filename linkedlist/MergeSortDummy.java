package Linkedlist;

public class MergeSortDummy {
	
	static Node head1;
	static Node head2;
	
	static class Node{
		int data;
		Node next;
		Node(int x){
			this.data = x;
		}
	}
	
	public static void merge() {
		Node dummyHead = null;
		Node dummyTail = dummyHead;

		while(head1 != null && head2 != null) {
			if(head1.data < head2.data) {
				if(dummyHead == null) {
					dummyHead = head1;
					dummyTail = head1;
				}else {
					dummyTail.next = head1;
				}
				dummyTail = head1;
				head1 = head1.next;
			}else {
				if(dummyHead == null) {
					dummyHead = head2;
					dummyTail = head2;
				}else {
					dummyTail.next = head2;
				}
				dummyTail = head2;
				head2 = head2.next;
			}
		}
		
		if(head1 == null)
			dummyTail = head2;
		
		if(head2 == null)
			dummyTail = head1;
		
		head1 = dummyHead;
	}
	
	public static void print() {
		while(head1 != null) {
			System.out.println(head1.data);
			head1 = head1.next;
		}
			
	}
	
	public static void main(String[] args) {
		head1 = new Node(1);
		head1.next = new Node(3);
		head1.next.next = new Node(4);
		head1.next.next.next = new Node(7);
		head1.next.next.next.next = new Node(9);
		
		head2 = new Node(2);
		head2.next = new Node(5);
		head2.next.next = new Node(6);
		head2.next.next.next = new Node(8);
		head2.next.next.next.next = new Node(10);
		
		merge();
		print();
	}

}
