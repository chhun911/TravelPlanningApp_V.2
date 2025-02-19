import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Search {
    private String city;
    private String country;

    public Search(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}

public class Destination {
    public static void main(String[] args) {
        Menu.displayMenu();
    }

    public static void viewDestinations() {
        List<Search> searches = new ArrayList<>();

        try {
            FileReader fr = new FileReader("\src Destination.csv");
            BufferedReader br = new BufferedReader(fr);
            String data;

            while ((data = br.readLine()) != null) {
                String[] pieces = data.split(",");
                if (pieces.length == 2) {
                    Search search = new Search(pieces[0].trim(), pieces[1].trim());
                    searches.add(search);
                }
            }

            br.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        // Print header
        System.out.printf("%-15s %s\n", "City", "Country");
        System.out.println("----------------------------");

        // Print formatted city-country pairs
        for (Search search : searches) {
            System.out.printf("%-15s %s\n", search.getCity(), search.getCountry());
        }
    }
}
