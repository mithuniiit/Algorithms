package greedy;
import java.util.LinkedList;
import java.util.Queue;

class BFS_adjMatrix{
    int adj[][];
    int V;
    boolean visited[];
    Queue<Integer> q;

    public BFS_adjMatrix(int V){
        this.V = V;
        adj = new int[V][V];
        visited = new boolean[V];
        for(int i=0;i<V;i++) {
        	for(int j=0;j<V;j++) {
        		adj[i][j]=0;
        	}
        }
        q = new LinkedList<Integer>();
    }

    public void addEdge(int src, int dest){
        adj[src][dest] = adj[dest][src] = 1;
    }

    public void doBfs(int src){
        q.add(src);
        while(!q.isEmpty()){
            int vertex = q.poll();
            if(!visited[vertex]) {
	            System.out.println(vertex);
	            visited[vertex] = true;
	            //Add adjacent nodes which are not visited to queue
	            for(int i=0;i<V;i++){
	                if(i!=vertex && adj[vertex][i] == 1 && visited[i] == false){
	                    q.add(i);
	                }
	            }
            }
        }
    }
    public static void main(String[] args){
        BFS_adjMatrix g = new BFS_adjMatrix(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 5);
        g.addEdge(4, 5);

        g.doBfs(0);
    }
}
