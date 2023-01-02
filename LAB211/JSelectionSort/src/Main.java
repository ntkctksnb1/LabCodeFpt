
import java.util.Scanner;

/*
 * This class contains funtions: display list, get array size and generate random array
 */
/**
 *
 * @author Kiennthe141019
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    // This method is used to display the array, input is an array
    public void displayList(int[] list) {
        System.out.print("[");
        for (int i = 0; i < list.length - 1; i++) {
            System.out.print(list[i] + ", ");
        }
        System.out.println(list[list.length - 1] + "]");
    }

    //This method is used to force user enter only positive integer
    private int getArraySize() {
        System.out.println("Enter number of array: ");
        int iSize = 0;
        Scanner scan = new Scanner(System.in);

        do {
            // This try catch is used to make sure user enter only number, not any other character.
            try {
                iSize = Integer.parseInt(scan.next());
                // Make sure user enter positive number
                if (iSize <= 0) {
                    System.out.println("Please enter positive integer!");
                }
            } catch (Exception e) {
                System.out.println("Invalid type " + e.getMessage());
            }

        } while (!(iSize > 0));
        return iSize;
    }

    public static void main(String[] args) {
        Main main = new Main();
        InsertionSort sort = new InsertionSort();
        int iSize;
        iSize = main.getArraySize();
        sort.generateArray(iSize);
        
        System.out.println("Unsorted list: ");
        main.displayList(sort.getiArray());
        
        sort.processSeletionSort();
        
        System.out.println("Sorted list:");
        main.displayList(sort.getiArray());
    }
}
