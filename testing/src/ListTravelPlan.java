import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ListTravelPlan {
    private static class TravelPlan {
        String season;
        int year;
        String country;

        TravelPlan(String season, int year, String country) {
            this.season = season;
            this.year = year;
            this.country = country;
        }
    }

    void listing(Scanner scanner) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Destination.csv", true))) {
            System.out.print("Enter the Number of Travel Plans (Enter 0 to Exit): ");
            int n = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            if (n > 0) {
                ArrayList<TravelPlan> plans = new ArrayList<>();
                
                for (int i = 0; i < n; i++) {
                    System.out.print("Enter Season for Your Plan " + (i + 1) + ": ");
                    String season = scanner.nextLine();
                   
                    System.out.print("Enter Year for Your Plan " + (i + 1) + ": ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                   
                    System.out.print("Enter Country for Your Plan " + (i + 1) + ": ");
                    String country = scanner.nextLine();
                    
                    plans.add(new TravelPlan(season, year, country));
                }
                
                // Display all plans together
                System.out.println("\nYour Travel Plans:");
                for (int i = 0; i < plans.size(); i++) {
                    TravelPlan plan = plans.get(i);
                    System.out.println(" Plan " + (i + 1) + ":");
                    System.out.println("Season: " + plan.season);
                    System.out.println("Year: " + plan.year);
                    System.out.println("Country: " + plan.country);
                    System.out.println();
                    
                    // Write to CSV
                    writer.println(plan.season + "," + plan.year + "," + plan.country);
                }
                writer.flush();
                System.out.println("All data has been saved to Destination.csv");
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListTravelPlan listTravelPlan = new ListTravelPlan();
        listTravelPlan.listing(scanner);
        scanner.close();
    }
}