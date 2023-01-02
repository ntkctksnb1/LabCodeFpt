
import java.util.Arrays;
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
public class LinearSearch {

    int[] array;

    public int[] getArray() {
        return array;
    }

    // This method is used to generate an array with size is the input
    public void generateArray(int iSize) {
        array = new int[iSize];
        Random rInt = new Random();
        
        for (int i = 0; i < iSize; i++) {
            array[i] = rInt.nextInt(100);
        }
        
    }

    public int[] searchIndex(int value) {
        int[] mapValue = new int[array.length];
        Arrays.fill(mapValue, 0);

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                mapValue[i] = 1;
            }
        }

        return mapValue;
    }
}
