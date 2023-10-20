package level1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PieceTypeCounter {
    public static void main(String[] args) {
        String inputFileName = "src/main/resources/level1/level1_5.in";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            int n = Integer.parseInt(reader.readLine());
            List<String> pieces = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                pieces.add(reader.readLine());
            }

            Map<String, Integer> pieceTypes = new TreeMap<>();
            for (String piece : pieces) {
                pieceTypes.put(piece, pieceTypes.getOrDefault(piece, 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : pieceTypes.entrySet()) {
                System.out.println(entry.getValue() + " " + entry.getKey());
            }
        } catch (IOException e) {
            System.err.println("Die Eingabedatei '" + inputFileName + "' konnte nicht gefunden werden.");
        }
    }
}
