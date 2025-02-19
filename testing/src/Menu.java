import java.util.Scanner;

class Menu {
    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. View Destinations");
            System.out.println("2. add Destinations");
            System.out.println("3. delete Destinations");
            System.out.println("4. Exit");
            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Destination.viewDestinations();
                    break;
                case 2:
                    AddDestination.addDestination();
                    break;
                case 3:
                    // DeleteDestination.deleteDestination();
                    break;
                case 4:
                    System.out.println("Exiting the application. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}