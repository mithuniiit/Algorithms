package queue;

import java.util.HashMap;

public class LRUCache {
	
	int capacity;
	HashMap<Integer,Node> map;
	Node head;
	Node tail;
	
	static class Node{
		int data;
		Node prev;
		Node next;
		
		Node(int data){
			this.data = data;
		}
	}
	
	LRUCache(int capacity){
		this.capacity = capacity;
		map = new HashMap<>(capacity);
	}
	
	private boolean isFull() {
		if(map.size() == capacity) {
			return true;
		}
		return false;
	}
	
	private void addHead(Node n) {
		if(head == null) {
			head = n;
			tail = n;
		}else if(head != n){
			n.next = head;
			head.prev = n;
			head = n;
		}
	}
	
	private void removeTail() {
		if(head == tail) {
			head = tail = null;
		}else {
			tail.prev.next = null;
			tail = tail.prev;
		}
	}
	
	private void addNode(Node n) {
		if(isFull()) {
			map.remove(tail.data);
			removeTail();
		}
		map.put(n.data,n);
		addHead(n);
	}
	
	private void deLinkNode(Node n) {
		if(n != head) {
			n.prev.next = n.next;
			n.next.prev = n.prev;
		}
	}
	
	private void refer(int x) {
		Node n;
		if(!map.containsKey(x)) {
			n = new Node(x);
			addNode(n);
		}else {
			n = map.get(x);
			deLinkNode(n);
			addHead(n);
		}
	}
	
	public void printList() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		cache.refer(1);
		cache.refer(1);
		cache.refer(2);
		cache.refer(3);
		cache.refer(4);
		cache.printList();
	}

}
