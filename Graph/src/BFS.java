import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BFS {
	boolean[] visited ;
	boolean[][] adj;
	public BFS(boolean adj[][])
	{
		visited = new boolean [ adj.length];
		this.adj = adj;
		
	}
	
	public List<Integer> BfsSearch() {
		
		List<Integer> display = new ArrayList<Integer>();
		for(int i = 0 ; i < visited.length ; i++)
			visited[i] = false;
		Queue<Integer> q = new LinkedList<Integer>();
		visited[0] = true;
		q.add(0);
		while(!q.isEmpty())
		{
			int element = q.remove();
			
			for(int i = 0 ; i < adj.length ;i++) {
				if(adj[element][i] == true && !visited[i])
				{
					visited[i] = true;
					q.add(i);
				}
				
			}
			
			display.add(element);
		}
		
		return display;
 		
	}
	
	

}
