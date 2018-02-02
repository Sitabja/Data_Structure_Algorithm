
public class Graph {

	private boolean adj[][];
	private int vertexCount;
	
	public boolean[][] getAdj() {
		return adj;
	}

	public void setAdj(boolean[][] adj) {
		this.adj = adj;
	}

	public int getVertexCount() {
		return vertexCount;
	}

	public void setVertexCount(int vertexCount) {
		this.vertexCount = vertexCount;
	}

	public Graph(int vertexCount) {
		this.vertexCount = vertexCount ;
		this.adj = new boolean[vertexCount][vertexCount];
	}
	
	public void addEdge(int i , int j) {
		if( i >= 0 && i < vertexCount && j >=0 && j < vertexCount ) {
			adj[i][j] = true;
			adj[j][i] = true;
		}
	}
	
	public void removeEdge(int i,int j) {
		if( i >= 0 && i < vertexCount && j >=0 && j < vertexCount ) {
			adj[i][j] = false;
			adj[j][i] = false;
		}
	}
	
	public boolean isEdge (int i ,int j) {
		if( i >= 0 && i < vertexCount && j >=0 && j < vertexCount ) 
			return adj[i][j];
		else 
			return false;
	}
}
