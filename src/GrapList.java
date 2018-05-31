/**
 * Created by parcpaes on 19/09/2017.
 */
import java.util.*;

public class GrapList {
    static class Graph{
        private int v;
        LinkedList<Integer> adjListArray[];
        public Graph(int v){
            this.v = v;
            //define the size of array as number of vertices
            adjListArray = new LinkedList[v];
            for(int i=0; i<v ; i++){
                adjListArray[i]= new LinkedList<>();
            }
        }
    }

    public static void addEdges(Graph graph, int src, int dest){
        graph.adjListArray[src].addFirst(dest);
        graph.adjListArray[dest].addFirst(src);
    }

    public static void printGraph(Graph graph){
        for(int v = 0 ; v<graph.v; v++){
            System.out.println("Adjacency list of vertex " +v);
            for(Integer data: graph.adjListArray[v]){
                System.out.printf(" %d-> ", data);
            }
            System.out.println("\n");
        }
    }

    public static void main(String arg[]){
        int v = 10;
        Graph graph = new Graph(8);
        addEdges(graph, 0,1);
        addEdges(graph, 0,2);
        addEdges(graph, 1,3);
        addEdges(graph, 1,4);
        addEdges(graph, 2,5);
        addEdges(graph, 2,6);
        addEdges(graph, 3,7);
        addEdges(graph, 4,7);
        addEdges(graph, 5,7);
        addEdges(graph, 6,7);
        printGraph(graph);
    }
}
