
import java.util.Random;
import java.util.Scanner;

/*
 * Main contain User Inteface and display result
 */
/**
 *
 * @author Kiennthe141019
 */
public class Main {

    public void displayArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1] + "]");
    }

    //This method is used to force user enter only positive integer
    private int getArraySize() {
        System.out.print("Enter size of array: ");
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

    // This method is used to generate an array with size is the input
    public int[] generateArray(int iSize) {
        int[] array = new int[iSize];

        for (int i = 0; i < iSize; i++) {
            array[i] = new Random().nextInt(100);
        }
        return array;
    }

    public static void main(String[] args) {
        Main main = new Main();
        
        // Generate an array
        int size = main.getArraySize();
        int[] array = main.generateArray(size);
        
        // Sort that array
        new MergSort().sortArray(array, 0, array.length);
        main.displayArray(array);
        
        // Input searched value
        System.out.print("Enter the value that you want to search: ");
        int value = new Scanner(System.in).nextInt();
        
        // Perform algorithm and return index
        int result = new BinarySearch().searchIndex(array, 0, size - 1, value);

        // Check index and print out result
        if (result == -1) {
            System.out.println(+value + " is not in the array!");
        } else {
            System.out.println("Found " + value + " at index: " + result);
        }
    }
}
