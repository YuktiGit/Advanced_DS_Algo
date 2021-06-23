import java.util.*; 
import java.lang.*; 
import java.io.*; 

class BellmanFord { 
	class Edge { 
		int src, dest, weight; 
		Edge() 
		{ 
			src = dest = weight = 0; 
		} 
	} 

	int V, E; 
	Edge edge[]; 

	BellmanFord(int v, int e) { 
		V = v; 
		E = e; 
		edge = new Edge[e]; 
		for (int i = 0; i < e; ++i) 
			edge[i] = new Edge(); 
	} 

	void BellmanFord(BellmanFord bmf, int src) { 
		int V = bmf.V, E = bmf.E; 
		int dist[] = new int[V]; 

		for (int i = 0; i < V; ++i) 
			dist[i] = Integer.MAX_VALUE; 
		dist[src] = 0; 

		for (int i = 1; i < V; ++i) { 
			for (int j = 0; j < E; ++j) { 
				int u = bmf.edge[j].src; 
				int v = bmf.edge[j].dest; 
				int weight = bmf.edge[j].weight; 
				if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) 
					dist[v] = dist[u] + weight; 
			} 
		} 

		for (int j = 0; j < E; ++j) { 
			int u = bmf.edge[j].src; 
			int v = bmf.edge[j].dest; 
			int weight = bmf.edge[j].weight; 
			if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) { 
				System.out.println("Graph contains negative weight cycle"); 
				return; 
			} 
		} 
		printArr(dist, V); 
	} 

	void printArr(int dist[], int V) { 
		System.out.println("Vertex Distance from Source"); 
		for (int i = 0; i < V; ++i) 
			System.out.println(i + "\t\t" + dist[i]); 
	} 

	public static void main(String[] args) { 
		int V = 5;
		int E = 8; 

		BellmanFord bmf = new BellmanFord(V, E); 

		bmf.edge[0].src = 0; 
		bmf.edge[0].dest = 1; 
		bmf.edge[0].weight = -1; 

		bmf.edge[1].src = 0; 
		bmf.edge[1].dest = 2; 
		bmf.edge[1].weight = -2; 

		bmf.edge[2].src = 1; 
		bmf.edge[2].dest = 3; 
		bmf.edge[2].weight = -3; 

		bmf.edge[3].src = 1; 
		bmf.edge[3].dest = 3; 
		bmf.edge[3].weight = 2; 

		bmf.edge[4].src = 1; 
		bmf.edge[4].dest = 4; 
		bmf.edge[4].weight = -4; 

		bmf.edge[5].src = 3; 
		bmf.edge[5].dest = 2; 
		bmf.edge[5].weight = 5; 

		bmf.edge[6].src = 3; 
		bmf.edge[6].dest = 1; 
		bmf.edge[6].weight = 1; 

		bmf.edge[7].src = 4; 
		bmf.edge[7].dest = 3; 
		bmf.edge[7].weight = 2; 

		bmf.BellmanFord(bmf, 0); 
	} 
} 
