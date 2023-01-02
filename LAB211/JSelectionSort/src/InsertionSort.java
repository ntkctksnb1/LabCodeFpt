
import java.util.Random;

/*
 * This class contains method represent selection sort algorithm
 */

/**
 *
 * @author Kiennthe141019
 */
public class InsertionSort {

    private int[] iArray;

    public int[] getiArray() {
        return iArray;
    }
    
    // This method is used to generate an array with size is the input
    public void generateArray(int iSize) {
        iArray = new int[iSize];
        Random rInt = new Random();
        for (int i = 0; i < iSize; i++) {
            iArray[i] = rInt.nextInt(100);
        }

    }

    public int[] processSeletionSort() {
        for (int i = 1; i < iArray.length; i++) {
            int j = i - 1;
            int temp = iArray[i];
            while (j >= 0 && temp < iArray[j]) {
                iArray[j + 1] = iArray[j];
                j--;
            }
            iArray[j + 1] = temp;
        }
        return iArray;
    }
}
