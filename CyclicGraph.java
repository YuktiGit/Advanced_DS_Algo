import java.util.*;

class CyclicGraph {
	
	private final int V;
	private final List<List<Integer>> adj;

	public CyclicGraph(int V) {
		this.V = V;
		adj = new ArrayList<>(V);
		
		for (int i = 0; i < V; i++)
			adj.add(new LinkedList<>());
	}
	
	private boolean isCyclic(int i, boolean[] visited, boolean[] dfstack) {
		if (dfstack[i])
			return true;

		if (visited[i])
			return false;
			
		visited[i] = true;

		dfstack[i] = true;
		List<Integer> children = adj.get(i);
		
		for (Integer c: children)
			if (isCyclic(c, visited, dfstack))
				return true;
				
		dfstack[i] = false;

		return false;
	}


	private boolean isCyclic(){
		boolean[] visited = new boolean[V];
		boolean[] dfstack = new boolean[V];
		
		for (int i = 0; i < V; i++)
			if (isCyclic(i, visited, dfstack))
				return true;

		return false;
	}

   private void addEdge(int source, int dest) {
		adj.get(source).add(dest);
	}

	public static void main(String[] args) {
		CyclicGraph cgraph = new CyclicGraph(4);
		cgraph.addEdge(0, 1);
		cgraph.addEdge(0, 2);
		cgraph.addEdge(1, 2);
		cgraph.addEdge(2, 0);
		cgraph.addEdge(2, 3);
		cgraph.addEdge(3, 3);
		
		if(cgraph.isCyclic())
			System.out.println("Graph contains cycle");
		else
			System.out.println("Graph doesn't contain cycle");
	}
}
