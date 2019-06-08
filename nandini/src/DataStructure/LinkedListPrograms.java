package DataStructure;

public class LinkedListPrograms {

	Node head ;

	class Node{
		int data;
		Node next ;
		Node(int data){
			this.data = data;
		}
	}


	void push(int data){
		Node newData = new Node(data);
		newData.next = head ;
		head = newData;

	}

	void append(int data){
		if(head == null){
			head = new Node(data);
			return;
		}

		Node new_node = new Node(data);
		Node last_node = head;
		while(last_node.next !=null){
			last_node = last_node.next ;
		}


		new_node.next = null ;
		last_node.next = new_node;

	}

	void insertData(Node prevData , int nedData){
		if(prevData== null){
			System.out.println("Invalid prev node");
			return;
		}

		Node new_node = new Node(nedData);
		new_node.next = prevData.next;
		prevData.next = new_node;
	}

	void deleteNode(int data){

		if(head == null){
			return;
		}
		Node node = head ;
		Node prev = null;
		if(head.data == data ){
			head = node.next;
			return;
		}
	
		while(node.data != data && node.next != null){
			prev = node ;
			node = node.next;

		}
		if(node.data == data){
			prev.next = node.next;
			node = null ;
		}
	}

	void printListData(){
		Node current = head ;
		int count = 0;
		while(current != null){
			System.out.println(current.data );
			current = current.next;
			count++;
		}

		System.out.println("count\t"+count);
	}

	public static void main(String[] args) {
		LinkedListPrograms list = new LinkedListPrograms();
		list.push(3);
		list.push(0);
		list.push(2);
		list.insertData(list.head.next.next , 15);
		list.push(7);
		list.push(1);
		list.append(4);
		list.append(10);
		list.push(13);
		list.printListData();
		list.deleteNode(15);
		System.out.println("afte deletion\n\n");
		list.printListData();
	}
}




