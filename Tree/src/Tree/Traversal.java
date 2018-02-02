package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversal {
	
	public void preOrderRecursive(BinaryTreeNode root)
	{
		if( root == null )
			return;
		else{
			System.out.println(root.getData());
			preOrderRecursive(root.getLeft());
			preOrderRecursive(root.getRight());
		}
			
	}
	
	public void preOrderNonRecursive(BinaryTreeNode root)
	{
		if(root == null)
			return;
		Stack<BinaryTreeNode> node = new Stack<BinaryTreeNode>();
		while(true)
		{   
			while(root != null)
			{
				System.out.println(root.getData());
				node.push(root.getLeft());
				root = root.getLeft();
			}
			
			if(node.isEmpty())
			{
				break;
			}
			root = node.pop();
			root =root.getRight();
		}
	}
	
	public void postOrderRecursive(BinaryTreeNode root)
	{
		if(root != null)
		{
			root.getLeft();
			root.getRight();
			System.out.println(root.getData());
		}
			
	}
  
	public void postOrderNonRecursive(BinaryTreeNode root)
	{
		Stack<BinaryTreeNode> node = new Stack<BinaryTreeNode>();
		
		while(true)
		{	if(root != null)
			{
				node.push(root);
				root = root.getLeft();
			}
			
			else{
				if(node.isEmpty())
					return;
				else
				if(node.peek().getRight() == null)
				{
					root = node.pop();
					System.out.println(root.getData());
					if(root == node.peek().getRight())
					{
						System.out.println(node.pop().getData());
					}
				} 
				
				if(!node.isEmpty())
					root = node.peek().getRight();
				else
					root = null;
			}
		
		}
		
	}
	public void levelOrder(BinaryTreeNode root)
	{
		if(root == null)
			return;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(root);
	
		while(!queue.isEmpty())
		{ 	
		    root = queue.remove();
			System.out.println(root.getData());
			
			if(root.getLeft() != null)
			queue.add(root.getLeft());
			if(root.getRight() != null)
			queue.add(root.getRight());
		
		}
	}
	public void inOrderRecursive(BinaryTreeNode root)
	{  
		if(root == null)
			return;
		else{
			inOrderRecursive(root.getLeft());
			System.out.println(root.getData());
			inOrderRecursive(root.getRight());
		}
		
	}

	public void inOrderNonRecursive(BinaryTreeNode root)
	{  
		if(root == null)
			return ;
		
		Stack<BinaryTreeNode> node = new Stack<BinaryTreeNode>();
		
		while(true)
		{
			while(root != null)
				{ 
					node.push(root);
					root = root.getLeft();
				
				}
				if(node.isEmpty())
					break;	
				System.out.println(node.pop().getData());
				root = root.getRight();
		}
		
	}

}
