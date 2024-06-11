import java.util.Objects;
import java.util.Scanner;

public class PlayerControls {
    public static void main(String[] args) {
        int columns = 10;
        int rows = 10;
        int shipsHit = 0;
        int coordinateY;
        int coordinateX;
        int turns = 0;
        boolean aSunk;
        boolean bSunk;
        boolean checkForA = true;
        boolean checkForB = true;

        String[][] board = new String[columns][rows];
        String[][] shipBoard = new String[columns][rows];

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                board[i][j] = "•";
            }
        }

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                shipBoard[i][j] = "•";
            }
        }

        shipBoard[5][4] = "A";
        shipBoard[6][4] = "A";
        shipBoard[7][4] = "A";
        shipBoard[8][4] = "A";
        shipBoard[9][4] = "A";
        shipBoard[3][6] = "B";
        shipBoard[3][7] = "B";
        shipBoard[3][8] = "B";

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);

        while (shipsHit < 8) {
            turns++;
            System.out.println("Choose a coordinate to shoot at (eg. B7)");
            String coordinate = scanner.nextLine();
            coordinateY = coordinate.charAt(0) - 'A';
            coordinateX = coordinate.charAt(1) - '0' - 1;

            if (coordinate.length() != 2) {
                System.out.println("Invalid coordinate");
                continue;
            }

            if (shipBoard[coordinateY][coordinateX].equals("A") || shipBoard[coordinateY][coordinateX].equals("B")) {
                board[coordinateY][coordinateX] = "X";
                shipsHit++;
                System.out.println("Hit!");
            } else if (board[coordinateY][coordinateX].equals("•")) {
                board[coordinateY][coordinateX] = "O";
                System.out.println("Miss!");
            } else {
                System.out.println("Coordinate invalid, please enter a letter between A-J and a number between 1-10.");
                continue;
            }

            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; j++) {
                    System.out.print(board[i][j] + "  ");
                }
                System.out.println();
            }

            aSunk = true;
            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; j++) {
                    if (shipBoard[i][j].equals("A") && !Objects.equals(board[i][j], "X") && checkForA) {
                        aSunk = false;
                        break;
                    }
                }
            }

            if (aSunk) {
                System.out.println("Sunk!");
                checkForA = false;
            }

            bSunk = true;
            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; j++) {
                    if (shipBoard[i][j].equals("B") && !Objects.equals(board[i][j], "X") && checkForB) {
                        bSunk = false;
                        break;
                    }
                }
            }

            if (bSunk) {
                System.out.println("Sunk!");
                checkForB = false;
            }

            if (shipsHit == 8) {
                System.out.println("Game over! You won in " + turns + " turns." );
            }
        }
    }
}

