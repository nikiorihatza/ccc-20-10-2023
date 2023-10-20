package level1;

import operations.FileOperations;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class Computer {

    public static void main(String[] args) {
        compute();
    }

    public static void compute() {
        FileOperations fileOperations = new FileOperations();

        var content = fileOperations.readFile(Path.of(".", "src", "main", "java", "resources", "level1_example.in").toAbsolutePath().toString());
        var list = content.split("\n");
        Arrays.stream(list).toList().forEach(System.out::println);
        var outNumbers = new ArrayList<Integer>();
        var outValue = new ArrayList<>();
        var alignments = PieceUtils.allignments();
        alignments.forEach((value) -> {
            var counter = 0;
            for (String string : list) {
                if (string.equals(value))
                    counter++;
                System.out.println(value + " " + counter);
            };
            outNumbers.add(counter);
            outValue.add(value);
        });

        StringBuffer outputBuffer = new StringBuffer();
        for (int i = 0; i < outValue.size(); i++) {
            var key = outNumbers.get(i);
            var value = outValue.get(i);
            System.out.println(key + "  " + value);
            if (key != 0)
                outputBuffer.append(key + "  " + value);
            outputBuffer.append("\n");
        }
        fileOperations.writeFile(outputBuffer.toString(), "level1\\test1.txt");
    }
}
