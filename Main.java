import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercise {

    public static void main(String[] args) {
        String inputFilename = "groceries.txt";
        String[] names = new String[50];
        double[] prices = new double[50];

        loadGroceryData(inputFilename, names, prices);

        int count = 0;
        for (int i = 0; i < names.length; i++) {
            if (names[i] != null) {
                count++;
            }
        }

        if (count > 0) {
            double average = calculateAveragePrice(prices, count);
            writeReport(names, prices, count, average);
            System.out.println("Success: grocery_report.txt has been generated.");
        } else {
            System.out.println("No data was loaded. Please check groceries.txt.");
        }
    }

    public static void loadGroceryData(String filename, String[] names, double[] prices) {
        File file = new File(filename);
        try (Scanner fileScanner = new Scanner(file)) {
            int index = 0;
            while (fileScanner.hasNextLine() && index < 50) {
                String line = fileScanner.nextLine();
                if (!line.trim().isEmpty()) {
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        names[index] = parts[0].trim();
                        prices[index] = Double.parseDouble(parts[1].trim());
                        index++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: Could not find " + filename);
        } catch (NumberFormatException e) {
            System.out.println("Error: Could not parse a price value in the file.");
        }
    }

    public static double calculateAveragePrice(double[] prices, int count) {
        if (count == 0) {
            return 0.0;
        }
        
        double sum = 0.0;
        for (int i = 0; i < count; i++) {
            sum += prices[i];
        }
        return sum / count;
    }

    public static void writeReport(String[] names, double[] prices, int count, double average) {
        try (PrintWriter writer = new PrintWriter("grocery_report.txt")) {
            writer.println("Grocery Items Report");
            writer.println("--------------------");
            writer.println();

            for (int i = 0; i < count; i++) {
                writer.printf("%s: $%.2f\n", names[i], prices[i]);
            }

            writer.println();
            writer.printf("Average Price: $%.2f\n", average);

        } catch (FileNotFoundException e) {
            System.out.println("Error: Could not create output file.");
        }
    }
}