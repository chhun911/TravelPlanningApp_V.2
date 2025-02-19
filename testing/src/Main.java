import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Start user login
        UserLogin.startLogin(scanner);

        // Show the menu after login
        Menu.displayMenu(scanner);

        scanner.close();
    }
}