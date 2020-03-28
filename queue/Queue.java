package queue;

public class Queue {
	int[] q;
	int front;
	int rear;
	int capacity;
	int size;
	
	Queue(int capacity){
		this.capacity = capacity;
		q = new int[capacity];
		front = 0;
		rear = capacity-1;
		size = 0;
	}
	
	public static void main(String[] args) {
		Queue q = new Queue(1000);
		System.out.println(q.dequeue());
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
	}
	
	private void enqueue(int ele) {
		if(size == capacity) {
			System.out.println("Queue is full");
			return;
		}
		rear = (rear+1)%capacity;
		q[rear] = ele;
		size = size+1;
	}
	
	private int dequeue() {
		if(size == 0) {
			System.out.println("Queue is empty");
			return Integer.MIN_VALUE;
		}
		int ele = q[front];
		front = (front+1)%capacity;
		size = size -1;
		return ele;
	}
}
