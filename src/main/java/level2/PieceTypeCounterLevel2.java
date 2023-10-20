package level2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class PieceTypeCounterLevel2 {
    public static void main(String[] args) {
        String inputFileName = "src/main/resources/level2/level2_1.in";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            int n = Integer.parseInt(reader.readLine());
            List<String> pieces = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                pieces.add(reader.readLine());
            }

            Map<String, Integer> pieceTypes = new TreeMap<>();

            for (String piece : pieces) {
                String normalizedPiece = normalizePiece(piece);
                pieceTypes.put(normalizedPiece, pieceTypes.getOrDefault(normalizedPiece, 0) + 1);
            }

            for (Map.Entry<String, Integer> entry : pieceTypes.entrySet()) {
                System.out.println(entry.getValue() + " " + entry.getKey());
            }
        } catch (IOException e) {
            System.err.println("Die Eingabedatei '" + inputFileName + "' konnte nicht gefunden werden.");
        }
    }

    private static String normalizePiece(String piece) {
        String[] sides = piece.split(",");
        List<String> orientations = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            StringBuilder orientation = new StringBuilder();
            for (int j = 0; j < 4; j++) {
                orientation.append(sides[(i + j) % 4]);
                if (j < 3) {
                    orientation.append(",");
                }
            }
            orientations.add(orientation.toString());
        }

        Collections.sort(orientations);
        return orientations.get(0);
    }
}

