
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DELL
 */
public class Main {

    // Display graph
    private void displayGraph(int[][] a, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(a[i][j] + "  ");
            }
            System.out.println("");
        }
        System.out.println("");
    }

    // Force user to enter graph size > 0
    private int getGraphSize() {
        System.out.print("Enter Size of graph: ");
        int size;
        do {
            try {
                size = new Scanner(System.in).nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a number > 0!");
                size = 0;
            }
        } while (size <= 0);

        return size;
    }

    // Force user to enter a vertex >= 0
    private int getVertex(int size) {
        int vertex;
        do {
            try {
                vertex = new Scanner(System.in).nextInt();
            } catch (Exception e) {
                System.out.println("Please enter a number >= 0!");
                vertex = 0;
            }
        } while (vertex < 0);

        return vertex;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int size = main.getGraphSize();
        int start;
        int end;

        int[][] graph = new GraphHandler().generateGraph(size);
        main.displayGraph(graph, size);

        System.out.println("Enter the start point: ");
        // While loop to make sure the number entered >=0 and < size
        do {
            start = main.getVertex(size);
            if (start >= size) {
                System.out.print("Start vertex is not in graph! Enter again: ");
            }
        } while (start >= size);

        System.out.println("Enter the end point: ");
        // While loop to make sure the number entered >=0 and < size
        do {
            end = main.getVertex(size);
            if (end >= size) {
                System.out.print("End vertex is not in graph! Enter again: ");
            }
        } while (end >= size);

        // Check isEdge and print out result.
        if (new GraphHandler().isEdge(graph, start, end)) {
            System.out.println("This is an edge!");
        } else {
            System.out.println("This is not an edge!");
        }

    }
}
