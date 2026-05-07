import java.util.Scanner;
import java.io.*;

public class FileAnalyzer {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter the filename to analyze: ");
        String filename = console.nextLine().trim();

        try {
            if (filename.isEmpty()) {
                throw new EmptyFilenameException("Filename cannot be empty.");
            }

            File file = new File(filename);
            if (!file.exists()) {
                throw new FileNotFoundException("The file '" + filename + "' does not exist.");
            }

            int lines = 0;
            int words = 0;
            int characters = 0;

            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    lines++;
                    characters += line.length();
                    
                    if (!line.trim().isEmpty()) {
                        String[] parts = line.trim().split("\\s+");
                        words += parts.length;
                    }
                }
            }

            writeResults(lines, words, characters);
            System.out.println("Analysis complete. Results written to analysis_output.txt");

        } catch (EmptyFilenameException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (FileNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        } finally {
            console.close();
        }
    }

    private static void writeResults(int lines, int words, int characters) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("analysis_output.txt"))) {
            writer.println("File Analysis Summary");
            writer.println();
            writer.println("Lines: " + lines);
            writer.println("Words: " + words);
            writer.println("Characters: " + characters);
            writer.println();
            writer.println("Great job, Java Jedi!");
            writer.println("You just tamed a file with logic and exception-handling mastery.");
            writer.println("Remember: every bug squashed is a step closer to greatness.");
            writer.println();
            writer.println("Keep building. Keep thriving. You've got this!");
        } catch (IOException e) {
            System.err.println("Could not write to output file: " + e.getMessage());
        }
    }
}