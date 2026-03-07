import java.util.Scanner;

public class Main {

    // scanner is shared so we dont make a new one every time
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("==============================");
        System.out.println("  Welcome to Schema Squad MMO ");
        System.out.println("==============================");

        // keep showing the menu until the user quits
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            // call the right API based on what the user typed
            switch (choice) {

                // Charith
                case "1":
                case "2":
                case "3":
                    printNotImplemented(choice);
                    break;
                case "4":  CreateEvent.Client_CreateEvent(scanner);                     break;
                case "5":
                case "6":
                case "7":
                case "8":
                    printNotImplemented(choice);
                    break;

                // TODO: add other teammates APIs here as they finish them
                // case "9": Enes stuff
                // case "10": Vincent stuff
                // etc

                case "0":
                    System.out.println("Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }

    // just prints the menu options
    private static void printMenu() {
        System.out.println("\n--- API Menu ---");
        System.out.println("1.  Get Player Leaderboard");
        System.out.println("2.  Get Top Players By Level");
        System.out.println("3.  Search Players");
        System.out.println("4.  Create Event");
        System.out.println("5.  Get Active Events");
        System.out.println("6.  Get Player Event Cooldown");
        System.out.println("7.  Use Ability");
        System.out.println("8.  Get Ability Cooldowns");
        System.out.println("0.  Quit");
        System.out.print("Enter choice: ");
    }

    private static void printNotImplemented(String choice) {
        System.out.println("Option " + choice + " is not implemented yet.");
    }
}