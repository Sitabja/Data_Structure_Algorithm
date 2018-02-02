package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertTree {
	
	public BinaryTreeNode insertTree(BinaryTreeNode root,int data)
	{ 
		BinaryTreeNode newNode = new BinaryTreeNode();
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		newNode.setData(data);
		newNode.setLeft(null);
		newNode.setRight(null);
		
		if(root == null)
			return newNode;
		 queue.add(root);
			while(!queue.isEmpty())
			{
				BinaryTreeNode temp = queue.remove();
				
				if(temp.getLeft() != null)
				{
					queue.add(temp.getLeft());
				}
				else 
				{ 
					temp.setLeft(newNode);
					return root;
				}
				
				if(temp.getRight() != null)
				{
					queue.add(temp.getRight());
				}
				else 
				{ 
					temp.setRight(newNode);
					return root;
				}
					
					
			}
			return root;
	}
	

}
