package BinarySearchTree;

import Tree.BinaryTreeNode;

public class Find {
	
	public boolean find(BinaryTreeNode root , int data) {
		
		if(root == null)
			return false;
		while(root != null) {
			
			if(root.getData() == data)
				return true;
			else if(root.getData() > data ) 
				root = root.getLeft();
			else 
				root = root.getRight();
			
		}
		return false;
		
		
	}
	
	public boolean findRecursive(BinaryTreeNode root, int data) {
		
		if(root == null)
			return false;
		if(root.getData() == data)
			return true; 
		
		return root.getData() > data ? findRecursive(root.getLeft(), data) : findRecursive(root.getRight(), data );
	}
	
	public BinaryTreeNode findMaximum ( BinaryTreeNode root ) {	
		if(root == null)
			return null;
		while(root.getRight() != null ) {
			root = root.getRight();
		}
		return root;
		
	}
	
	public BinaryTreeNode findMaximumRecursive ( BinaryTreeNode root ) {
		
		if( root == null)
			return null;
		else if (root.getRight() == null)
			return root;
		
		else 
			return findMaximumRecursive(root.getRight());
	}
	
	public BinaryTreeNode findMinimum ( BinaryTreeNode root ) {	
		if(root == null)
			return null;
		while(root.getLeft() != null ) {
			root = root.getLeft();
		}
		return root;
		
	}
	
	public BinaryTreeNode findMinimumRecursive ( BinaryTreeNode root ) {
		
		if( root == null)
			return null;
		else if (root.getLeft() == null)
			return root;
		
		else 
			return findMinimumRecursive(root.getLeft());
	}
	
	
	public BinaryTreeNode findLowestCommonAncestor ( BinaryTreeNode root , BinaryTreeNode node1 , BinaryTreeNode node2 ) {
		
		if ( root == null )
			return null;
		while(true) {
		if( root.getData() > node1.getData() && root.getData() < node2.getData() ||
			root.getData() < node1.getData() && root.getData() > node2.getData())
			return root ;
		else if( node1.getData() < root.getData())
			root = root .getLeft();
		else
			root = root.getRight();
		}
		
	}
	
	}

