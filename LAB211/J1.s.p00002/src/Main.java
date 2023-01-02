
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
        // TODO code application logic here
        int iSize = new Main().getArraySize();
        new SelectionSort().processSelectionSort(iSize);
    }
    
}
