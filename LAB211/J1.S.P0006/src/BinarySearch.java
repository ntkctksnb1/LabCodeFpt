

/*
 * This class is used to perform binary search algorithm
 */
/**
 *
 * @author Kiennthe141019
 */
public class BinarySearch {

    // method return first index that it found
    public int searchIndex(int[] array, int begin, int end, int value) {
        int result = -1;
        int position = (begin + end) / 2;

        if (value == array[position]) {
            result = position;
        } else if ((end - begin) >= 0) {

            if (array[position] > value) {
                result = searchIndex(array, begin, position - 1, value);
            } else {
                result = searchIndex(array, position + 1, end, value);
            }

        }
        return result;
    }
}
