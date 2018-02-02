import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class DFS {
	
	boolean[] visited ;
	boolean[][] adj;
	public DFS(boolean adj[][])
	{
		visited = new boolean [ adj.length];
		this.adj = adj;
		
	}
	public List<Integer> DfsSearch()
	{
		List<Integer> display = new ArrayList<Integer>();
		 for(int i = 0 ; i < visited.length ; i++)
		 {
			 visited[i] = false;
		 }
		 
		 Stack<Integer> s = new Stack<Integer>();
		 
		 s.push(0);
		 visited[0] = true;
		 display.add(0);
		 
		 while(!s.isEmpty()){
				
				int v = getAdjUnvisitedVertex(s.peek());
				
				if( v == -1)
					s.pop();
				else {
					s.push(v);
					visited[v] = true;
					display.add(v);
				}
				 	 
			 }
		 return display;
	}

	private int getAdjUnvisitedVertex(int i) {
	
		for(int j = 0 ; j < adj.length ; j++)
			if(adj[i][j] == true && visited[j] == false)
				return j; 
		return -1;
	}

}
