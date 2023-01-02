
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Kien
 */
public class Main {

    public static void main(String[] args) {
        StaxReader reader = new StaxReader();
        Race race = reader.getRace();
        StaxWriter writer = new StaxWriter();
        while (true) {
            System.out.println("""
                           ------------------------------------------------Horse Race------------------------------------------------------------
                           1. View Horse Race Information.
                           2. Add Horse
                           3. Save
                           4. Exit
                           Your choice: """);
            int choice = 0;
            try {
                choice = Integer.parseInt(new Scanner(System.in).nextLine());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            switch (choice) {
                case 1 -> {
                    System.out.println(race);
                }
                case 2 -> {
//                    editInfor(race);
                     addHorse(race);
                }
                case 3 -> {
                    writer.writeXML(race);
                    System.out.println("Save Success");
                }
                case 4 -> {
                    return;
                }
                default -> {
                }
            }
        }

//        StaxWriter writer = new StaxWriter();
//        writer.writeXML(reader.getRace());
    }

    static void editInfor(Race race) {
        System.out.println("""
                           ------------------------------------------------Edit Horse Race Information------------------------------------------------------------
                           1. Edit Race Information.
                           2. Remove Horse.
                           3. Edit Horse Information.
                           4. Add Horse
                           5. Exit
                           Your choice: """);
        int choice = 0;
        try {
            choice = Integer.parseInt(new Scanner(System.in).nextLine());
        } catch (NumberFormatException e) {
            choice = 0;
        }

        switch (choice) {
            case 1 -> {
                String input = "";
                System.out.print("Enter date: ");
                input = readInput();
                race.setDate(input);

                System.out.print("Enter name: ");
                input = readInput();
                race.setName(input);

                System.out.print("Enter Course Name: ");
                input = readInput();
                race.setCourseName(input);

                System.out.print("Enter Address: ");
                input = readInput();
                race.setCourseAddress(input);
            }
            case 2 -> {
                String input = "";
                System.out.print("Enter horse name: ");
                input = readInput();
                deleteHorse(race, input);

            }
            case 3 -> {
                String input = "";
                System.out.print("Enter horse name: ");
                input = readInput();
                editHorse(race, input);
            }
            case 4 -> {
                addHorse(race);
            }
            case 5 -> {

                return;
            }
            default -> {
            }
        }
    }

    static String readInput() {
        String input = "";
        try {
            input = new Scanner(System.in).nextLine();
        } catch (Exception e) {
            System.out.println("Wrong format!");
        }
        return input;
    }

    static void deleteHorse(Race race, String hName) {
        List<Horse> horses = race.getHorses();
        boolean z = false;
        for (int i = 0; i < horses.size(); i++) {
            if (horses.get(i).getName().equalsIgnoreCase(hName)) {
                horses.remove(i);
                System.out.println("Remove Success");
                z = true;
            }
        }
        if (!z) {
            System.out.println("The horse with the name '" + hName + "' doesnt exist in this race!");
        }
    }

    static void editHorse(Race race, String hName) {
        List<Horse> horses = race.getHorses();
        boolean z = false;
        for (int i = 0; i < horses.size(); i++) {
            if (horses.get(i).getName().equalsIgnoreCase(hName)) {
                String input = "";
                System.out.print("Enter New Name: ");
                input = readInput();
                if (!input.trim().isEmpty()) {
                    horses.get(i).setName(input);
                }

                System.out.print("Enter New Value: ");
                input = readInput();
                if (!input.trim().isEmpty()) {
                    horses.get(i).setValue(input);
                }

                System.out.print("Enter New Date of birth: ");
                input = readInput();
                if (!input.trim().isEmpty()) {
                    horses.get(i).setDateOfBirth(input);
                }

                System.out.print("Enter New Gender: ");
                input = readInput();
                if (!input.trim().isEmpty()) {
                    horses.get(i).setGender(input);
                }
                System.out.println("Edit Success");
                z = true;
            }
        }
        if (!z) {
            System.out.println("The horse with the name '" + hName + "' doesnt exist in this race!");
        }
    }

    static void addHorse(Race race) {
        String input = "";
        Horse h = new Horse();
        System.out.print("Enter Name: ");
        input = readInput();
        h.setName(input);

        System.out.print("Enter Value: ");
        input = readInput();
        h.setValue(input);

        System.out.print("Enter Date of birth: ");
        input = readInput();
        h.setDateOfBirth(input);

        System.out.print("Enter Gender: ");
        input = readInput();
        h.setGender(input);
        race.getHorses().add(h);
        System.out.println("Add Success");

    }
}
