import java.util.ArrayList;
import java.util.List;


public class GraphMain {
	public static void main(String[] args) {
		Graph g = new Graph(8);
		g.addEdge(0, 1);
		g.addEdge(0, 3);
		g.addEdge(0, 6);
		g.addEdge(1, 5);
		g.addEdge(1, 4);
		g.addEdge(3, 5);
		g.addEdge(4, 6);
		g.addEdge(5, 2);
		g.addEdge(2, 7);
		
		boolean[][] adj = g.getAdj();
		/*for(int i = 0 ; i < adj.length ; i++) {
			for(int  j = 0 ; j < adj.length ; j++ ){
				System.out.print(adj[i][j]+"  ");
			}
			System.out.println();
		}*/
		
		BFS search =  new BFS(adj);
		List<Integer> l = new ArrayList<Integer>();
		l.addAll(search.BfsSearch());
		
		System.out.println(l);
		
		
	}

}
