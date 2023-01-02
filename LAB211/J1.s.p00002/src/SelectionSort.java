
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
public class SelectionSort {

    public void displayList(int[] list) {
        System.out.print("[");
        for (int i = 0; i < list.length - 1; i++) {
            System.out.print(list[i] + ", ");
        }
        System.out.println(list[list.length - 1] + "]");
    }

    public void processSelectionSort(int iSize) {
        int[] iList = new int[iSize];
        Random rInt = new Random();

        for (int i = 0; i < iSize; i++) {
            iList[i] = rInt.nextInt(100);
        }

        System.out.println("Original list:");
        displayList(iList);

        for (int i = 0; i < iSize - 1; i++) {
            int min = iList[i];
            for (int j = i; j < iSize; j++) {
                if (min >= iList[j]) {

                    iList[i] = iList[j];
                    iList[j] = min;
                    min = iList[i];
                }
            }
        }
        System.out.println("Sorted list:");
        displayList(iList);

    }
}
