package graph;

/**
 * Created by parcpaes on 17/04/2018.
 */
import java.util.*;
public class graphdfs {
    public boolean visited[] = new boolean[1000];
    LinkedList<Integer>adj[] = new LinkedList[10];


    public static void main(String arg[]){
        EdgeWeightedGraph graph = new EdgeWeightedGraph(10);
        graph.addEdge(new Edge(1,2,10.06));

    }
}
