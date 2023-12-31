import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileOperations {
    public void writeFile(String content) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/output1.txt"));
            writer.write(content);
            writer.close();
            System.out.println("File written successfully.");
        } catch (IOException e) {
            System.err.println("An error occurred while writing the file: " + e.getMessage());
        }
    }

    public String readFile(String path) {
        StringBuilder content = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
        return content.toString();
    }
}
