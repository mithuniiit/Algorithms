package greedy;

import java.util.LinkedList;

class GraphRepresentation {
    int[][] adjMatrix;
    int V;
    LinkedList<Integer> adjList[];

    public GraphRepresentation(int V){
        this.V = V;
        adjMatrix = new int[V][V];
        adjList = new LinkedList[V];
        for(int i=0;i<V;i++){
            adjList[i]= new LinkedList<>();
        }
    }

    public void addEdge(int src,int dest){
        adjMatrix[src][dest] = adjMatrix[dest][src] = 1;
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    public void printAdjMatrix(){
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void printAdjList(){
        System.out.println("Printing Adj List");
        for(int i=0;i<V;i++){
        	System.out.print(i+" ");
            for(Integer p : adjList[i]){
                System.out.print(p+" ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args){
        GraphRepresentation g = new GraphRepresentation(6);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(2,4);
        g.addEdge(3,5);
        g.addEdge(4,5);

        g.printAdjMatrix();
        g.printAdjList();
    }
}
