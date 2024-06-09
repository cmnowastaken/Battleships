import java.util.Scanner;

public class PlaceShip {
    public static void main(String[] args) {
        int columns = 10;
        int rows = 10;
        int replaceableX;
        int replaceableY;
        int toggle;
        int shipSize;
        int shipsHit = 0;
        int coordinateY;
        int coordinateX;

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

        shipBoard[5][4] = "X";
        shipBoard[6][4] = "X";
        shipBoard[7][4] = "X";
        shipBoard[8][4] = "X";
        shipBoard[9][4] = "X";

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }

        Scanner scanner = new Scanner(System.in);

        while (shipsHit < 5) {
            System.out.println("Choose a coordinate to shoot at (eg. B7)");
            String coordinate = scanner.nextLine();
            coordinateY = coordinate.charAt(0) - 'A';
            coordinateX = coordinate.charAt(1) - '0' - 1;

            if (shipBoard[coordinateY][coordinateX].equals("X")) {
                board[coordinateY][coordinateX] = "X";
                shipsHit++;
                System.out.println("Hit!");
            } else {
                board[coordinateY][coordinateX] = "O";
                System.out.println("Miss!");
            }
            ;
        }



        /*
        Random rand = new Random();
        toggle = rand.nextInt(2);

        replaceableX = rand.nextInt(columns);
        replaceableY = rand.nextInt(rows);

        replaceableX = rand.nextInt(columns);
        */

    }
}