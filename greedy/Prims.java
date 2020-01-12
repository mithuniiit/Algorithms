package greedy;
class Prims{

    static int V = 5;

    public static int minKey(int[] key, boolean[] visited){
        int min = Integer.MAX_VALUE, min_index = -1;
        for(int v=0;v<V;v++){
            if(visited[v] == false && key[v]<min){
                min = key[v];
                min_index = v;
            }
        }
        return min_index;
    }

    public static void printMST(int[] parent, int[][] graph){
        for(int i=0;i<V;i++){
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]); 
        }
    }

    public static void primsMST(int[][] graph){
        int parent[] = new int[V];
        int key[] = new int[V];
        boolean visited[] = new boolean[V];

        //initialize all the arrays
        for(int i=0;i<V;i++){
            parent[i] = key[i] = -1;
            visited[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for(int count=0; count<V-1; count++){
            int u = minKey(key,visited);
            visited[u]=true;
            for(int v=0;v<V;v++){
                if(graph[u][v]!=0 && visited[v]==false && graph[u][v]<key[v]){
                    parent[v]=u;
                    key[v]=graph[u][v];
                }
            }
        }

        printMST(parent,graph);
    }
    public static void main(String[] args){
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, 
                                      { 2, 0, 3, 8, 5 }, 
                                      { 0, 3, 0, 0, 7 }, 
                                      { 6, 8, 0, 0, 9 }, 
                                      { 0, 5, 7, 9, 0 }
                                     }; 

        primsMST(graph);
        
    }
}
