
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class GraphHandler {

    // Generate a random graph
    public int[][] generateGraph(int size) {
        int[][] graph = new int[size][size];
        
        // Create a random matrix on the right size ob diagonal.
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                graph[i][j] = new Random().nextInt(2);
            }
        }
        
        // Copy value to create a symetric adjaency matrix across the main diagonal
        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                graph[j][i] = graph[i][j];
            }
        }
        
        return graph;
    }

    // Check whether  2 vertices form a edge or not and return
    public boolean isEdge(int[][] graph, int i, int j) {
        return (graph[i][j] == 1) && (graph[i][j] == 1);
    }
}
