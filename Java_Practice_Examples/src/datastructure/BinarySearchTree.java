package datastructure;

import java.util.Scanner;

public class BinarySearchTree {
	Node treeRoot;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		 Node root=null;
		while (true) {
			System.out.println("Enter 1 if you want to Add and 2 to exit");
			
			int k=scanner.nextInt();
			if(k==1){
				System.out.println("Enter the element that you want to add");
				Node node = new Node(scanner.nextInt());
				root = binarySearchTree.addNode(root,node);
			}else{
				break;
			}
			
		}
		binarySearchTree.inOrderTraversal(root);
		System.out.println("Press 3 to delete a node");
		if(scanner.nextInt()==3){
			while(true){
				System.out.println("Enter the node you want to delete.");
				Node node1 = new Node(scanner.nextInt());
				binarySearchTree.treeRoot = binarySearchTree.delete(root, node1);
				System.out.println(root.data);
				
				break;
			}
			binarySearchTree.inOrderTraversal(binarySearchTree.treeRoot);
		}
	}
public Node addNode(Node root, Node node){
	if(root==null){
		root = node;
	}
	else{
		if(root.data>node.data){
			root.left = addNode(root.left,node);
		}else if(root.data<node.data){
			root.right = addNode(root.right, node);
			
		}
	}
	return root;
}

public void inOrderTraversal(Node node){
	if(node==null){
		return;
	}
	inOrderTraversal(node.left);
	System.out.print(node.data+"->");
	inOrderTraversal(node.right);
}

public Node delete(Node root, Node node){
	if(root==null){
		return root;
	}
	else{
		if(node.data<root.data){
			root.left=delete(root.left,node);
		}
		if(node.data>root.data){
			root.right=delete(root.right, node);
		}else{
			if(root.left==null){
				return root.right;
			}
			if(root.right==null){
				return root.left;
			}
				Node minNode = minNode(root.right);
				root.data = minNode.data;
				root.right=delete(root.right,minNode);
				inOrderTraversal(root);
		}
		return root;
	}
}
public Node minNode(Node root){
	Node minValueNode = new Node(root.data);
	while(root.left!=null){
		minValueNode.data = root.left.data;
		root=root.left;
		
	}
	return minValueNode;
}
}
class Node{
	
	Node left, right;
	Integer data;
	Node(){	
	}
	Node(Integer data){
		this.data = data;
	}
}