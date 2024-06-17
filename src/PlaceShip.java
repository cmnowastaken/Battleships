import java.util.Random;

public class PlaceShip {
    static void shipPlace(int replaceableX, int replaceableY, int shipSize, int toggle, int columns, int rows, String shipLetter, String[][] shipBoard) {
        Random rand = new Random();
        toggle = rand.nextInt(2);
        boolean occupied = false;

        for (int i = 0; i < shipSize; i++) {
            for (int j = 0; j < rows; j++) {
                if (shipBoard[i][j].equals("A")
                        || shipBoard[i][j].equals("B")
                        || shipBoard[i][j].equals("C")
                        || shipBoard[i][j].equals("D")
                        || shipBoard[i][j].equals("E")) {
                    occupied = true;
                }
            }
        }
        if (!occupied) {
            if (toggle == 0) {
                replaceableX = rand.nextInt(rows);
                replaceableY = rand.nextInt((columns - (shipSize + 1)) + 1);
                for (int i = 0; i < shipSize; i++) {
                    replaceableY++;
                    shipBoard[replaceableX][replaceableY] = shipLetter;
                }
            } else if (toggle == 1) {
                replaceableX = rand.nextInt((rows - (shipSize + 1)) + 1);
                replaceableY = rand.nextInt(columns);
                for (int i = 0; i < shipSize; i++) {
                    replaceableX++;
                    shipBoard[replaceableX][replaceableY] = shipLetter;
                }
            }
        }
    }
    public static void main(String[] args) {
        int columns = 10;
        int rows = 10;
        int replaceableX = 0;
        int replaceableY = 0;
        int toggle = 0;
        int shipsHit = 0;


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

        shipPlace(replaceableX, replaceableY, 5, toggle, columns, rows, "A", shipBoard);
        shipPlace(replaceableX, replaceableY, 4, toggle, columns, rows, "B", shipBoard);
        shipPlace(replaceableX, replaceableY, 3, toggle, columns, rows, "C", shipBoard);
        shipPlace(replaceableX, replaceableY, 3, toggle, columns, rows, "D", shipBoard);
        shipPlace(replaceableX, replaceableY, 2, toggle, columns, rows, "E", shipBoard);

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(shipBoard[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
