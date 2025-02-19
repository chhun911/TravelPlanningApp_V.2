import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddDestination {
    public static void main(String[] args) {
        Menu.displayMenu();
    }

    public static void addDestination() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter city: ");
        String city = scanner.nextLine();
        System.out.print("Enter country: ");
        String country = scanner.nextLine();

        try {
            FileWriter fw = new FileWriter("\src Destination.csv", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(city + "," + country);
            bw.newLine();
            bw.close();
            System.out.println("Destination added successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}