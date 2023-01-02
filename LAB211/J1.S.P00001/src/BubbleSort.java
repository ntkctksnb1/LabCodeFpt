
import java.util.Random;

/*
 * This class is used to process bubble sort algorithm
 */
/**
 *
 * @author Kiennthe141019
 */
public class BubbleSort {

    public int[] proccessBubbleSort(int[] iList) {

        for (int i = 0; i < iList.length - 1; i++) {
            for (int j = 0; j < iList.length - i - 1; j++) {
                if (iList[j] >= iList[j + 1]) {
                    int temp = iList[j];
                    iList[j] = iList[j + 1];
                    iList[j + 1] = temp;
                }
            }
        }

        return iList;
    }
}
