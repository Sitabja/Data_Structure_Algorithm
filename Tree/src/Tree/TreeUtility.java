package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeUtility {
	public int sizeRecursive(BinaryTreeNode root)
	{
		if(root == null)
			return 0;
		else return (sizeRecursive(root.getLeft()) + 1 + sizeRecursive(root.getRight()));
	}
	
	public int sizeNonRecursive(BinaryTreeNode root)
	{
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		BinaryTreeNode temp;
		int count = 0;
		if(root == null)
			return 0;
		else
		{ 	
			queue.add(root);
			
			while(!queue.isEmpty())
			{	
				count++ ;
				 temp = queue.remove();
				 if(temp.getLeft() != null)
					 queue.add(temp.getLeft());
				 if(temp.getRight()!= null)
					 queue.add(temp.getRight());	 
			}
			
			return count;
			
		}
	}
	
	public int findMaxRecursive(BinaryTreeNode root)
	{
		int max = Integer.MIN_VALUE;
		int root_val,left,right;
		if(root != null)
		{
			root_val = root.getData();
			left = findMaxRecursive(root.getLeft());
			right = findMaxRecursive(root.getRight());
			
			if(right > left )
				max = right;
			else
				max = left;
			if(root_val > max)
				max = root_val;
		}
		
		return max;
	}
	public int findMaxNonRecursive(BinaryTreeNode root)
	{
		BinaryTreeNode temp;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		int max = Integer.MIN_VALUE;
		if(root != null)
		{
			queue.add(root);
			
			while(!queue.isEmpty())
			{   
				temp = queue.remove();
				if(max < temp.getData())
					max = temp.getData();
				
				if(temp.getLeft() != null)
					queue.add(temp.getLeft());
				if(temp.getRight() != null)
					queue.add(temp.getRight());
				
			}
			
		}
		return max;
	}
	
	public boolean searchElementInTreeRecursive(BinaryTreeNode root,int data)
	{
		if(root == null)
			return false;
		else{
			if(root.getData() == data)
				return true;
			
			if(searchElementInTreeRecursive(root.getLeft(), data))
				return true;
			
			else return(searchElementInTreeRecursive(root.getRight(), data));
		}
		
	
	}
	
	public boolean searchElementInTreeNonRecursive (BinaryTreeNode root, int data ) {
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		
		if( root == null )
			return false;
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			
			BinaryTreeNode temp = queue.remove();
			
			if(temp.getData() == data)
				return true;
			
			if(root.getLeft() != null)
				queue.add(temp.getLeft());
			if(root.getRight() != null)
				queue.add(temp.getRight());	
			
		}
		
		return false;
	}
	
	public void printingInReverseOrder(BinaryTreeNode root)
	{
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		
		if(root == null)
			{ 
				System.out.println("tree is empty");
				return;
			}
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			BinaryTreeNode temp = queue.remove();
			stack.add(temp);
			
			if(temp.getRight() != null)
				queue.add(temp.getRight());
			if(temp.getLeft() != null)
				queue.add(temp.getLeft());
		}
		
		while(!stack.isEmpty())
			System.out.print(stack.pop().getData()+" ");
		
		
	}

	public void deleteTree(BinaryTreeNode root)
	{
		if( root == null )
			return;
		deleteTree(root.getLeft());
		deleteTree(root.getRight());
		root = null ;	
		
	}
	
	public int findHeightRecursive(BinaryTreeNode root)
	{
		if( root == null )
			return 0;
		int left = findHeightRecursive(root.getLeft());
		int right = findHeightRecursive(root.getRight());
		
		if( left > right)
			return left+1;
		else
			return right+1;
	}
	
	public int findHeightNonRecursive(BinaryTreeNode root)
	{
		int level = 1;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		
		if(root == null)
			return 0;
		
		queue.add(root);
		queue.add(null);
		
		while(!queue.isEmpty()){
			
			BinaryTreeNode temp = queue.remove();
			 if ( temp==null ) {
				 
				 if(!queue.isEmpty())
					 queue.add(null);
				 level++;
			 }
			 else {
				 
				 if(temp.getLeft() != null)
					 queue.add(temp.getLeft());
				 if(temp.getRight() != null)
					 queue.add(temp.getRight());
			 }
			 
				 
		}
		return level;
	}
	
	public int findDeepestNode(BinaryTreeNode root) {
		 
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		BinaryTreeNode temp = null;
		if(root == null)
			return -1;
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			 temp = queue.remove();
			if( temp.getLeft() != null )
				queue.add(temp.getLeft());
			if( temp.getRight() != null)
				queue.add(temp.getRight());
			
		}
		
		return temp.getData();
	}
	
	public BinaryTreeNode deleteANode(BinaryTreeNode root,int data)
	{
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		
		BinaryTreeNode temp = null;
		BinaryTreeNode temp1 = null;
		BinaryTreeNode temporary = null;
		boolean left = false,right = false;
		
		if(root == null)
			return null;
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			 temp = queue.remove();
			if( temp.getLeft() != null )
			{   
				temporary = temp;
				queue.add(temp.getLeft());
				
				 if(temp.getLeft().getData() == data)
				 {
					 temp1 = temp;
					 left = true;
				 }
				
			}
			if( temp.getRight() != null) {
				temporary = temp;
				queue.add(temp.getRight());
				 if(temp.getRight().getData() == data)
				 {
					 temp1 = temp;
					 right = true;
				 }
			}
			
		}
		if(left)
			temp1.getLeft().setData(temp.getData());
		if(right)
			temp1.getRight().setData(temp.getData());
		
		if( temporary.getLeft().equals(temp)){
			temporary.setLeft(null);
		}
		else if (temporary.getRight().equals(temp)){
			temporary.setRight(null);
		}
		
		return root;
	}
	
	public int noOfLeaves(BinaryTreeNode root)
	{
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		BinaryTreeNode temp = null;
		int count = 0;
		if(root == null)
			return -1;
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			 temp = queue.remove();
			 if(temp.getLeft() == null && temp.getRight() == null)
				 count++;
			if( temp.getLeft() != null )
				queue.add(temp.getLeft());
			if( temp.getRight() != null)
				queue.add(temp.getRight());
			
		}
		
		return count;
	}
	
	public int noOfFullNodes(BinaryTreeNode root)
	{
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		BinaryTreeNode temp = null;
		int count = 0;
		if(root == null)
			return -1;
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			 temp = queue.remove();
			 if(temp.getLeft() != null && temp.getRight() != null)
				 count++;
			if( temp.getLeft() != null )
				queue.add(temp.getLeft());
			if( temp.getRight() != null)
				queue.add(temp.getRight());
			
		}
		
		return count;
	}
	
	public int noOfHalfNodes(BinaryTreeNode root)
	{
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		BinaryTreeNode temp = null;
		int count = 0;
		if(root == null)
			return -1;
		queue.add(root);
		
		while(!queue.isEmpty())
		{
			 temp = queue.remove();
			 if((temp.getLeft() != null && temp.getRight() == null) || (temp.getLeft() == null && temp.getRight() != null))
				 count++;
			if( temp.getLeft() != null )
				queue.add(temp.getLeft());
			if( temp.getRight() != null)
				queue.add(temp.getRight());
			
		}
		return count;
	}
	
	/*public void zigZag(BinaryTreeNode root)
	{
		
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		int count = 0;
		
		if(root == null)
			return;
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty())
		{
			
			
			if(count % 2 == 0 )
			{
				BinaryTreeNode temp = queue.remove();
				if(temp == null)
				{
					if(!queue.isEmpty()){
						count++;
						queue.add(null);
					}
					continue;
				}
				if(temp.getLeft() != null){
					stack.push(temp.getLeft());
				}
				
				if(temp.getRight() != null){
					stack.push(temp.getRight());
				}
			}
			
			else
			{
				System.out.println(temp.getData());
				
				if(temp.getLeft() != null)
					queue.add(temp.getLeft());
				if(temp.getRight() != null)
					queue.add(temp.getRight());
			}
			
			
		}
	}*/
	public boolean checkForIdentical(BinaryTreeNode root1,BinaryTreeNode root2)
	{
		if(root1 == null && root2 == null)
			return true;
		if( root1 == null || root2 == null)
			return false;
		return (root1.getData() == root2.getData() && (checkForIdentical(root1.getLeft(), root2.getLeft()) && 
				root1.getRight() == root2.getRight()));
	}
	
	public BinaryTreeNode mirror(BinaryTreeNode root)
	{
		if(root == null)
			return null;
		else
		{
			mirror(root.getLeft());
			mirror(root.getRight());
			
			BinaryTreeNode temp;
			temp = root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(temp);
		}
		return root;
	}
	
	public boolean areMirrors(BinaryTreeNode root1,BinaryTreeNode root2)
	{
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		else
			return(root1.getData() == root2.getData() && areMirrors(root1.getLeft(), root2.getRight()) && areMirrors(root1.getRight(), root2.getRight()));
		
	}
	
	public int findLevelWithMaxSum(BinaryTreeNode root)
	{
		
		if(root == null)
			return -1;
		Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		int sum = 0;
		int maxSum =  Integer.MIN_VALUE;
		int maxLevel = -1;
		int level = 0;
		queue.add(root);
		queue.add(null);
		
		while(!queue.isEmpty())
		{
			BinaryTreeNode temp = queue.remove();
			
			if(temp == null)
			{
				if(sum > maxSum)
					{ maxSum = sum;
					  maxLevel = level;
					}
				sum = 0;
				if(!queue.isEmpty())
					{ 
					 	queue.add(null);
					 
					}
				
				level++;
			}
			
			else
			{
				sum += temp.getData();
				
				if(temp.getLeft() != null )
					queue.add(temp.getLeft());
				if(temp.getRight() != null)
					queue.add(temp.getRight());
				
			}
			
		}
		return maxLevel;
		
	}
}

 