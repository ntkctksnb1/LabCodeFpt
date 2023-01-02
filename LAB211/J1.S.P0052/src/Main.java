
import controller.ManageEastAsiaCountries;
import entities.EastAsiaCountries;
import java.util.ArrayList;
import java.util.Scanner;

/*
 *  Main class contain the user inteface and execute the other class
 */
/**
 *
 * @author Kiennthe141019
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    // This method is use to display menu
    private void displayMenu() {
        System.out.println("MENU");
        System.out.println("===============================================================================");
        System.out.println("1. Enter the information for 11 countries in Southeast Asia.\n"
                + "2. Display already information.\n"
                + "3. Search the country according to the entered country's name.\n"
                + "4. Display the information increasing with the country name.\n"
                + "5. Exit.");
        System.out.println("===============================================================================");
        System.out.print("Enter Your Choice: ");
    }

    // This method is use to list the country
    private void displayCountry(ArrayList<EastAsiaCountries> country) {
        System.out.printf("%15s %30s %20s %20s\n", "Country Code", "Country Name", "Country Area(km2)", "Country Terrain");
        for (int i = 0; i < country.size(); i++) {
            System.out.format("%15s %30s %20s %20s\n",
                    country.get(i).getCountryCode(),
                    country.get(i).getCountryName(),
                    country.get(i).getTotalArea(),
                    country.get(i).getCountryTerrain()
            );
        }

    }

    // This method is used to prompt user to enter infor of a new countries 
    private void inputCountry(ManageEastAsiaCountries manager) {
        Scanner scan = new Scanner(System.in);
        String countryCode;
        String countryName;
        float totalArea;
        String countryTerrain;

        System.out.println("Enter code of country: ");
        // While loop to force user enter code which is not existed in the list
        do {
            countryCode = scan.nextLine();
            if (!manager.isExisted(countryCode)) {
                System.out.println("Country code existed, Enter Again!");
            }
        } while (!manager.isExisted(countryCode));

        System.out.println("Enter name of country: ");
        countryName = scan.nextLine();

        System.out.println("Enter total area of country: ");
        // While loop to force user enter a float number greater than 0
        do {
            try {
                totalArea = scan.nextFloat();
            } catch (Exception e) {
                totalArea = 0;
            }

            scan.nextLine(); // Throw away the \n character.

            if (!manager.checkValidArea(totalArea)) {
                System.out.println("Invalid area! Area must be number and greater than 0! Please enter again!");
            }

        } while (!manager.checkValidArea(totalArea));

        System.out.println("Enter terrain of country: ");
        countryTerrain = scan.nextLine();

        // Add new country to the list
        manager.addCountry(countryCode, countryName, totalArea, countryTerrain);
    }

    // Method to force user enter a number
    private int checkChoice() {
        Scanner scan = new Scanner(System.in);
        int input = 0;

        try {
            String sInput;
            sInput = scan.next();
            input = Integer.parseInt(sInput);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a number!");
        }

        return input;
    }

    public static void main(String[] args) {

        Main main = new Main();
        Scanner scan = new Scanner(System.in);
        ManageEastAsiaCountries manageCountry = new ManageEastAsiaCountries();

        int choice;
        do {
            main.displayMenu();
            choice = main.checkChoice();

            switch (choice) {
                case 1:
                    main.inputCountry(manageCountry);
                    break;

                case 2:
                    if (manageCountry.getCountries().isEmpty()) {
                        System.out.println("There is no country in the list!");
                    } else {
                        main.displayCountry(manageCountry.getPrevCountry());
                    }
                    break;

                case 3:
                    if (manageCountry.getCountries().isEmpty()) {
                        System.out.println("There is no country in the list!");
                    } else {
                        System.out.println("Enter country name that you want to search: ");
                        String name = scan.next();

                        if (manageCountry.findCountry(name).isEmpty()) {
                            System.out.println("This country is not in list!");
                        } else {
                            main.displayCountry(manageCountry.findCountry(name));
                        }
                    }
                    break;

                case 4:

                    if (manageCountry.getCountries().isEmpty()) {
                        System.out.println("There is no country in the list!");
                    } else {
                        System.out.println("Toi day");
                        manageCountry.sortByName();
                        System.out.println("Toi day 2");
                        main.displayCountry(manageCountry.getCountries());
                    }
                    break;

                case 5:
                    break;

                default:
                    System.out.println("Not an option, please try again!");

            }

        } while (choice != 5);

    }

}
