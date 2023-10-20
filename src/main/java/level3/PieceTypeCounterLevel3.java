package level3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


//String outputFile = "D:\\OutsourcedIdeaProject\\ccc-20-10-2023\\src\\main\\java\\resources\\level3\\test3.out";
//String inputFile = "D:\\OutsourcedIdeaProject\\ccc-20-10-2023\\src\\main\\java\\resources\\level3_example.in";
public class PieceTypeCounterLevel3 {
    public static void main(String[] args) {

        String outputFile = "D:\\OutsourcedIdeaProject\\ccc-20-10-2023\\src\\main\\java\\resources\\level3\\test3.out";
        String inputFile = "D:\\OutsourcedIdeaProject\\ccc-20-10-2023\\src\\main\\java\\resources\\level3_example.in";

        try {
            List<String> puzzleLines = readPuzzleFromFile(inputFile);
            List<String> correctedPuzzle = correctPuzzle(puzzleLines);
            writePuzzleToFile(outputFile, correctedPuzzle);
            System.out.println("Puzzle correction complete.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readPuzzleFromFile(String inputFile) throws IOException {
        List<String> puzzleLines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                puzzleLines.add(line);
            }
        }
        return puzzleLines;
    }

    public static List<String> correctPuzzle(List<String> puzzleLines) {
        List<String> correctedPuzzle = new ArrayList<>();
        for (String line : puzzleLines) {
            String[] pieces = line.split(" ");
            correctedPuzzle.add(correctLine(pieces));
        }
        return correctedPuzzle;
    }

    public static String correctLine(String[] pieces) {
        for (int i = 0; i < pieces.length - 1; i++) {
            if (hasMistake(pieces[i], pieces[i + 1])) {
                pieces[i + 1] = fixMistake(pieces[i + 1]);
            }
        }
        return String.join(" ", pieces);
    }

    public static void writePuzzleToFile(String outputFile, List<String> correctedPuzzle) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (String line : correctedPuzzle) {
                writer.write(line);
                writer.newLine();
            }
        }
    }

    public static boolean hasMistake(String piece1, String piece2) {
        return piece1.charAt(2) == piece2.charAt(0) || piece1.charAt(3) == piece2.charAt(1);
    }

    public static String fixMistake(String piece) {
        String[] pieceParts = piece.split(" ");
        char[] pieceChars = pieceParts[0].toCharArray();
        if (pieceChars[1] == pieceChars[0]) {
            pieceChars[1] = 'E';
        } else if (pieceChars[1] == pieceChars[3]) {
            pieceChars[1] = 'H';
        } else if (pieceChars[1] == pieceChars[5]) {
            pieceChars[1] = 'K';
        }

        if (pieceChars[3] == pieceChars[0]) {
            pieceChars[3] = 'E';
        } else if (pieceChars[3] == pieceChars[1]) {
            pieceChars[3] = 'H';
        } else if (pieceChars[3] == pieceChars[5]) {
            pieceChars[3] = 'K';
        }

        if (pieceChars[5] == pieceChars[0]) {
            pieceChars[5] = 'E';
        } else if (pieceChars[5] == pieceChars[1]) {
            pieceChars[5] = 'K';
        } else if (pieceChars[5] == pieceChars[3]) {
            pieceChars[5] = 'H';
        }

        return String.valueOf(pieceChars[0]) + "," + String.valueOf(pieceChars[2]) + "," + String.valueOf(pieceChars[4] + "," + pieceChars[6]);
    }

}
