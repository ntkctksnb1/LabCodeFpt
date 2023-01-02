
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kiennthe141019
 * 
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    private void displayMenu(){
        System.out.println("=============== Login Program ===============");
        System.out.println("1. Add User");
        System.out.println("2. Login");
        System.out.println("3. Exit");
    }
    
    
    public static void main(String[] args) {
        int choose;
        do {            
            new Main().displayMenu();
            Scanner scan = new Scanner(System.in);
            choose = scan.nextInt();
        }while (choose != 3);
        ArrayList<UserInformation> u = new ArrayList<UserInformation>();        
    }
    
}
