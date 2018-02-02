package BinarySearchTree;

import Tree.BinaryTreeNode;

public class Insertion {
	
	public BinaryTreeNode insert(BinaryTreeNode root , int data) {
		
		BinaryTreeNode node = new BinaryTreeNode();
		node.setData(data);
		node.setLeft(null);
		node.setRight(null);
		
		BinaryTreeNode temp = root; 
	
		if(root == null) {
			return node;
		}
		
		else 
			while(true) {
			if (temp.getData() >= data)
				{
					if(temp.getLeft() == null) {
						temp.setLeft(node);
						return root;
					}
					else
						temp = temp.getLeft();
						
				}
				
			else if(temp.getData() < data)
			{
				if(temp.getRight() == null) {
					temp.setRight(node);
					return root;
				}
				else
					temp = temp.getRight();
			}
				

			}
			
	}

}
