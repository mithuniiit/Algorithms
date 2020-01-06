package greedy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

class Colouring_Greedy{
	private int V;
	private LinkedList<Integer> adj[];
	
	Colouring_Greedy(int v){
		V=v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++){
			adj[i] = new LinkedList();
		}
	}
	
	void addEdge(int v, int w){
		adj[v].add(w);
		adj[w].add(v);
	}
	
	void greedyColouring(){
		//Approach is to have result array and available array.
		int[] result = new int[V];
		
		Arrays.fill(result,-1);
		result[0]=0;
		
		boolean available[] = new boolean[V];
		Arrays.fill(available,true);
		
		for(int u=1;u<V;u++){
			Iterator<Integer> it = adj[u].iterator();
			while(it.hasNext()){
				int i = it.next();
				if(result[i] != -1){
					available[result[i]]= false;
				}
			}
			
			int c;
			for(c=0;c<V;c++){
				if(available[c]){
					break;
				}
			}
			
			result[u]= c;
			Arrays.fill(available,true);
		
		}
		
		  for (int u = 0; u < V; u++) 
            System.out.println("Vertex " + u + " --->  Color "
                                + result[u]); 
	}


	 public static void main(String args[]) 
    { 
		 Colouring_Greedy g1 = new Colouring_Greedy(5); 
        g1.addEdge(0, 1); 
        g1.addEdge(0, 2); 
        g1.addEdge(1, 2); 
        g1.addEdge(1, 3); 
        g1.addEdge(2, 3); 
        g1.addEdge(3, 4); 
        System.out.println("Coloring of graph 1"); 
        g1.greedyColouring(); 
  
        System.out.println(); 
        Colouring_Greedy g2 = new Colouring_Greedy(5); 
        g2.addEdge(0, 1); 
        g2.addEdge(0, 2); 
        g2.addEdge(1, 2); 
        g2.addEdge(1, 4); 
        g2.addEdge(2, 4); 
        g2.addEdge(4, 3); 
        System.out.println("Coloring of graph 2 "); 
        g2.greedyColouring(); 
    } 
}
