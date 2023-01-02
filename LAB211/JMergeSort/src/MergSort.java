/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class MergSort {
    
    // This method is used to merg two sorted list
    private void mergList(int[] array, int begin, int end, int index) {

        int[] temp = new int[end - begin];
        int i = begin, j = index, k = 0;
        
        // This while loop is used to merg 2 lsit until one of them end
        while (i < index && j < end) {
            if (array[i] < array[j]) {
                temp[k] = array[i];
                i++;
            } else {
                temp[k] = array[j];
                j++;
            }
            k++;
        }
        
        // If the first list end first then append the remaining element of the second list to the list
        if (i == index) {
            for (; j < end; j++) {
                temp[k] = array[j];
                k++;
            }
        // if the second list end first then append the remaining element of the first lsit to the list
        } else {
            for (; i < index; i++) {
                temp[k] = array[i];
                k++;
            }
        }

        // This for loop is used to replace the original list by new merg list
        for (i = 0; i < k; i++) {
            array[begin + i] = temp[i];
        }
    }

    // This method is used to sort a list
    public int[] sortList(int[] array, int begin, int end) {
        
        // If the list is divided and contains only one or two element, do the compare and sort
        if ((begin + 1) == end || (begin + 2) == end) {
            if (array[begin] > array[end - 1]) {
                int t = array[begin];
                array[begin] = array[end - 1];
                array[end - 1] = t;
            }
        // else, continue to divide, sort and them merg again 
        } else {
            int mid = (begin + end) / 2;
            sortList(array, begin, mid);
            sortList(array, mid, end);
            mergList(array, begin, end, mid);
        }
        
        return array;
    }
}
