package datastructure;

import java.util.Scanner;

public class QueueExample {
public static void main(String[] args) {
	LinkedListQueue queue = new LinkedListQueue();
	Scanner scanner = new Scanner(System.in);
	while(true){
		//System.out.println("Enter the no. of queries.");
		System.out.println("Enter 1 if you want to Add and 2 to Delete and 3 to exit");
		int k=scanner.nextInt();
		if(k==1){
			System.out.println("Enter the element that you want to add");
			QueueNode node1 = new QueueNode(scanner.nextInt());
			System.out.println(queue.enqueue(node1));
		}else if(k==2){
			System.out.println("Element removed: "+queue.dequeue().next);
			System.out.println("Current Queue: "+queue);
		}else{
			break;
		}
	}
	scanner.close();
}
}
class LinkedListQueue{
	QueueNode first;
	QueueNode current;
	public QueueNode getFirst() {
		return first;
	}
	public void setFirst(QueueNode first) {
		this.first = first;
	}
	public QueueNode getCurrent() {
		return current;
	}
	public void setCurrent(QueueNode current) {
		this.current = current;
	}
	public LinkedListQueue enqueue(QueueNode node){
		if(first==null){
			first = node;
			current = first;
		}else{
			/*while (current.next!=null) {
				current = current.next;
			}*/
			current.next=node;
			node.previous=current;
			current = node;
		}
		return this;
		
	}
	
	public QueueNode dequeue(){
		QueueNode head = first;
		if (head.next!=null) {
			first = head.next;
			first.previous=null;
		}else{
			current = null;
		}
		return head;
	}
	
	public String toString(){
		StringBuffer stringBuffer = new StringBuffer();
		QueueNode top = first;
		while(top!=null){
			stringBuffer=stringBuffer.append(top.data+"->");
			top = top.next;
		}
		return(stringBuffer.toString());
	}
}

class QueueNode{
	QueueNode next;
	QueueNode previous;
	Integer data;
	public QueueNode(Integer data) {
		this.data = data;
	}
}