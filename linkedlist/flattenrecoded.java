package Linkedlist;

public class MergeSortDummy {
	
	static class Node{
		int data;
		Node right;
		Node down;
		Node(int x){
			this.data = x;
		}
	}
	
	public static Node merge(Node head1, Node head2) {
		Node dummyHead = new Node(-1);
		Node dummyTail = dummyHead;
		
		if(head1 == null)
			return head2;
		
		if(head2 == null)
			return  head1;
		
		while(head1 != null && head2 != null) {
			if(head1.data <= head2.data) {
				dummyTail.down = head1;
				head1 = head1.down;
				
			}else {
				dummyTail.down = head2;
				head2 = head2.down;
			}
			dummyTail = dummyTail.down;
		}
		
		if(head1 == null && head2!=null)
			dummyTail.down = head2;
		
		if(head2 == null && head1!=null)
			dummyTail.down = head1;
		
		return dummyHead.down;
	}
	
	public static void print(Node head) {
		while(head != null) {
			System.out.println(head.data);
			head = head.down;
		}
	}
	
	public static Node merge_recur(Node list1, Node list2) {
		if(list1 == null)
			return list2;
		
		if(list2 == null)
			return list1;
		
		Node result;
		if(list1.data < list2.data) {
			result = list1;
			result.down = merge_recur(list1.down, list2);
		}else {
			result = list2;
			result.down = merge_recur(list1, list2.down);
		}
		return result;
	}
	
	public static void main(String[] args) {
		
		Node head = new Node(5);
		head.right = new Node(10);
		head.right.right = new Node(19);
		head.right.right.right = new Node(28);
		
		head.down = new Node(7);
		head.down.down = new Node(8);
		head.down.down.down = new Node(30);
		
		head.right.down = new Node(20);
		
		head.right.right.down = new Node(22);
		head.right.right.down.down = new Node(50);
		
		head.right.right.right.down = new Node(35);
		head.right.right.right.down.down = new Node(40);
		head.right.right.right.down.down.down = new Node(45);
		
//		Node head2;
		
//		head1 = new Node(1);
//		head1.next = new Node(3);
//		head1.next.next = new Node(4);
//		head1.next.next.next = new Node(7);
//		head1.next.next.next.next = new Node(9);
//		
//		head2 = new Node(2);
//		head2.next = new Node(5);
//		head2.next.next = new Node(6);
//		head2.next.next.next = new Node(8);
//		head2.next.next.next.next = new Node(10);
//		
		Node first = head;
		Node second = head.right;
		while(second!=null) {
			first = merge_recur(first,second);
			second=second.right;
		}
		
		print(first);
	}

}
