package BinarySearchTree;

import Tree.BinaryTreeNode;
import Tree.InsertTree;
import Tree.Traversal;

public class BinarySearchTreeMain {
	public static void main(String[] args) {
		 BinaryTreeNode root = null;
		 Insertion insert = new Insertion();
		 
		 for(int i = 0 ; i < 10 ; i++ )
			 root = insert.insert(root, i);
		BinaryTreeNode node1 = new BinaryTreeNode();
		node1.setData(7);
		
		BinaryTreeNode node2 = new BinaryTreeNode();
		node2.setData(9);
		Find f = new Find();
		BinaryTreeNode node = f.findLowestCommonAncestor(root, node1, node2);
		System.out.println(node.getData());
		
	/*	
		Traversal tr = new Traversal();
		 tr.inOrderRecursive(root);
		 
		System.out.println(new Find().findMinimum(root));*/
	}

}
