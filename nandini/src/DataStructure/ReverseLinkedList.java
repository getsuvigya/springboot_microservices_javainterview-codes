package DataStructure;

public class ReverseLinkedList {
	Node head ;
	ReverseLinkedList(){
		head = new Node();
	}
	
 class Node{
	 
	 int data;
	 Node next ;
	  Node(){
		  
	  }
	  
	  Node(int data){
		  this.data = data;
	  }
	  
 }
 
 
 void addNode(int data){
	 Node new_node = new Node(data);
	 new_node.next = head.next;
	 head.next = new_node;
 }

 
 void printList(){
	 Node temp = head;
	 while(temp != null){
		 System.out.print(temp.data+"\t");
		 temp = temp.next;
	 }
 }
 
 void reverseList(){
	 Node prev = null, current = head , next = null;
	 while(current != null){
		 next = current.next;
		 current.next = prev;
		 prev = current;
		 current = next;
	 }
	 head = prev;
	 
	 printList();
 }
 
 
 public static void main(String[] args) {
	ReverseLinkedList list = new ReverseLinkedList();
	list.addNode(3);
	list.addNode(5);
	list.addNode(1);
	list.printList();
	
	
	System.out.println();
	list.reverseList();
}
}
