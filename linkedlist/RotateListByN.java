package Linkedlist;

public class RotateListByN {

	static Node head;
	
	
	static class Node {
		int data;
		Node next;
		
		Node(){
			next = null;
		}
		
		Node(int x){
			data = x;
			next = null;
		}
	}
	
	static void rotate(int k) {
		Node kThNode = head;
		Node kThNodePrev = null;
		
		int count = k;
		
		while(count >= 0 && kThNode!=null) {
			kThNodePrev = kThNode;
			kThNode=kThNode.next;
			count--;
		}
		
		if(kThNode == null)
			return;
		
		Node endNode = kThNode;
		
		while(endNode.next != null) {
			endNode = endNode.next;
		}
		
		endNode.next = head.next;
		head = kThNode;
		kThNodePrev.next = null;
	}
	
	static void print() {
		Node temp = head;
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	public static void main(String[] args) {
		head = new Node();
		head.next = new Node(1);
		head.next.next = new Node(2);
		head.next.next.next = new Node(3);
		head.next.next.next.next = new Node(4);
		head.next.next.next.next.next = new Node(5);
		head.next.next.next.next.next.next = new Node(6);
		print();
		rotate(2); 
		System.out.println("After Roteate");
		print();
	}
}
