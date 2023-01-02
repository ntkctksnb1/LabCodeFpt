
import java.util.Random;
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

    /**
     * @param args the command line arguments
     */
    public void displayList(int[] list) {
        System.out.print("[");
        for (int i = 0; i < list.length - 1; i++) {
            System.out.print(list[i] + ", ");
        }
        System.out.println(list[list.length - 1] + "]");
    }
    private int[] gennerateArray(int iSize){
    int[] iList = new int[iSize];
        Random rInt = new Random();

        for (int i = 0; i < iSize; i++) {
            iList[i] = rInt.nextInt(100);
        }
        return iList;
    }
    
    private int getArraySize() {
        System.out.println("Enter number of array: ");
        int iSize = 0;
        Scanner scan = new Scanner(System.in);
        do {
            try {
                iSize = Integer.parseInt(scan.next());
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
       
    }

}
