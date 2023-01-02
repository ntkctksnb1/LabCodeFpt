/*
 *This class is contains the the Quick sort algorithm
 */

/**
 *
 * @author KienntHE141019
 */
public class QuickSort {

    //this method is used to perform quicksort algorithm
    public int[] processQuickSort(int[] array, int begin, int end) {
        int i, j , temp;
        
        if(begin<end){
            i = begin +1;
            j = end;
            
            do{
                while(array[i] <= array[begin] && i < end) i++;
                while((array[j] > array [begin]) && (j > (begin+1))) j--;
                if(i<j){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }while (i<j);
            
            temp = array[begin];
            array[begin] = array[j];
            array[j] = temp;
            
            if(begin<(j-1)) processQuickSort(array, begin, j-1);
            if((j+1)<end) processQuickSort(array, j+1, end);
        }
        return array;
    }
}
