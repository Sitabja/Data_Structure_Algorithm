package Tree;

public class TreeMain {
	
	public static void main(String[] args) {
		 BinaryTreeNode root = null;
		 InsertTree insert = new InsertTree();
		 
		 for(int i = 0 ; i < 7 ; i++ )
			 root = insert.insertTree(root, i);
		 
		 Traversal traverse =  new Traversal();
		 traverse.postOrderNonRecursive(root);
		 TreeUtility tu = new TreeUtility();
		 
		//traverse.levelOrder(root);
		/* traverse.inOrderRecursive(root);
		System.out.println(tu.sizeRecursive(root));
		System.out.println(tu.sizeNonRecursive(root));
		System.out.println(tu.findMaxNonRecursive(root));
		System.out.println(tu.searchElementInTreeNonRecursive(root,8));
		System.out.println( tu.findHeightRecursive(root));
		System.out.println( tu.findHeightNonRecursive(root));
		System.out.println( tu.findDeepestNode(root));
*/	
	/*	BinaryTreeNode root1 = tu.deleteANode(root, 2)  ;
		
		traverse.levelOrder(root1);*/
		 System.out.println(tu.findLevelWithMaxSum(root));
	}

}
