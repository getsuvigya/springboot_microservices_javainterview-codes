package revision;

public class BinarySearchTree {
	Node root;
	Node temp;
public Node addNodeRecursive(Node current, int value){
	if(current==null){
		current = new Node(value);
	}
	if(value<current.data){
		current.left = addNodeRecursive(current.left, value);
	}
	if(value>current.data){
		current.right = addNodeRecursive(current.right, value);
	}
	return current;
}
public void preOrder(Node root){
	if(root!=null){
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	
}
public void inOrder(Node root){
	if(root!=null){
		inOrder(root.left);
		System.out.println(root.data);
		inOrder(root.right);
	}
	
}
public Node findMinValue(Node n1){
	Node min = n1;
	Node temp = min;
	while(temp.left!=null){
		
		temp = temp.left;
		if(min.data>temp.data){
			min = temp;
		}
	}
	return min;
}
public Node deleteNode(Node current, int value){
		if(current == null){
			return current;
		}
		if(value<current.data){
			current.left = deleteNode(current.left, value);
		}
		if(value>current.data){
			current.right=deleteNode(current.right, value);
		}
		if(value==current.data){
			if(current.left==null){
				return current.right;
			}
			else if(current.right==null){
				return current.left;
			}
			
				current.data = findMinValue(current.right).data;
				current.right = deleteNode(current.right, current.data);
		}
		return current;
}
public static void main(String[] args) {
	BinarySearchTree binarySearchTree = new BinarySearchTree();
	binarySearchTree.root = binarySearchTree.addNodeRecursive(binarySearchTree.root, 70);
//	binarySearchTree.addNodeRecursive(binarySearchTree.root, 70);
	binarySearchTree.addNodeRecursive(binarySearchTree.root, 35);
	binarySearchTree.addNodeRecursive(binarySearchTree.root, 53);
	binarySearchTree.addNodeRecursive(binarySearchTree.root, 47);
	binarySearchTree.addNodeRecursive(binarySearchTree.root, 90);
	binarySearchTree.addNodeRecursive(binarySearchTree.root, 110);
	binarySearchTree.addNodeRecursive(binarySearchTree.root, 83);
	binarySearchTree.addNodeRecursive(binarySearchTree.root, 77);
	binarySearchTree.addNodeRecursive(binarySearchTree.root, 86);
	binarySearchTree.addNodeRecursive(binarySearchTree.root, 61);
	binarySearchTree.addNodeRecursive(binarySearchTree.root, 21);
	binarySearchTree.addNodeRecursive(binarySearchTree.root, 10);
	binarySearchTree.addNodeRecursive(binarySearchTree.root, 29);
	binarySearchTree.inOrder(binarySearchTree.root);
	binarySearchTree.root  = binarySearchTree.deleteNode(binarySearchTree.root, 29);
	System.out.println("After delete");
	binarySearchTree.inOrder(binarySearchTree.root);
	binarySearchTree.root  = binarySearchTree.deleteNode(binarySearchTree.root, 70);
	System.out.println("After delete");
	binarySearchTree.inOrder(binarySearchTree.root);
}

}
class Node{
	int data;
	Node left, right;
	public Node(int value){
		this.data = value;
		left=right=null;
	}
}