package operations;

/**
 * Created: 20.10.23
 */

public class TestFileOperations {
    public static void main(String[] args) {
        FileOperations fileOps = new FileOperations();
        String filePath = "src/main/resources/output1.txt";

        // Example usage:
        String contentToWrite = "Hello, this is a test content to write to a file.";
        fileOps.writeFile(contentToWrite);

        String contentRead = fileOps.readFile(filePath);
        System.out.println("Content read from the file:");
        System.out.println(contentRead);
    }
}