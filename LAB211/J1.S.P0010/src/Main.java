
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

    private void displayResult(int[] mapValue, int value) {
        int count = 0;
        for (int i = 0; i < mapValue.length; i++) {
            if (mapValue[i] == 1) {
                count++;
            }
        }

        if (count == 0) {
            System.out.println(value + " is not in array!");
        } else {
            System.out.print("Found " + value + " at index: ");
            for (int i = 0; i < mapValue.length; i++) {
                if (mapValue[i] == 1) {
                    System.out.print(i + " ");
                }
            }
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Main main = new Main();
        LinearSearch lSearch = new LinearSearch();

        int iSize;
        int iValue;
        int[] resultMap;
        Scanner scan = new Scanner(System.in);

        iSize = main.getArraySize();

        System.out.print("Enter search number: ");
        iValue = scan.nextInt();

        lSearch.generateArray(iSize);
        main.displayList(lSearch.getArray());

        resultMap = lSearch.searchIndex(iValue);

        main.displayResult(resultMap, iValue);
        System.out.println("");
    }

}
