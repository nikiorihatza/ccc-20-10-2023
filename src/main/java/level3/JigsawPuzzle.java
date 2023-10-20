package level3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class JigsawPuzzle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[][] puzzle = new String[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                puzzle[i][j] = sc.next();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (puzzle[i][j].equals("E")) {
                    puzzle[i][j] = "K";
                }
                if (i == 0 && puzzle[i][j].charAt(0) == 'H') {
                    puzzle[i][j] = "E" + puzzle[i][j].substring(1);
                }
                if (i == n - 1 && puzzle[i][j].charAt(2) == 'H') {
                    puzzle[i][j] = puzzle[i][j].substring(0, 2) + "E" + puzzle[i][j].charAt(3);
                }
                if (j == 0 && puzzle[i][j].charAt(3) == 'K') {
                    puzzle[i][j] = puzzle[i][j].substring(0, 3) + "H";
                }
                if (j == n - 1 && puzzle[i][j].charAt(1) == 'K') {
                    puzzle[i][j] = puzzle[i][j].charAt(0) + "H" + puzzle[i][j].substring(2);
                }
            }
        }

        try {
            File file = new File("src\\main\\resources\\level3\\output.txt");
            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    writer.write(puzzle[i][j] + " ");
                }
                writer.write("\n");
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (Exception e) {
            System.out.println("Error occurred.");
        }

        System.out.println("Die korrigierte Puzzle-Ausgabe wurde in die Datei \"output.txt\" geschrieben.");
    }
}