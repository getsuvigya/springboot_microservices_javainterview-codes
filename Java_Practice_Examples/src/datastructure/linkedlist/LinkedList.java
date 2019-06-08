package datastructure.linkedlist;

public class LinkedList {
public Node head;
public LinkedList(){
	this.head = new Node();
}
public void addNode(Node node){
	if(head!=null){
		head.next = node;
	}else{
		Node temp = head;
		while(temp.next!=null){
			temp = temp.next;
		}
		temp.next = node;
	}
}
}
