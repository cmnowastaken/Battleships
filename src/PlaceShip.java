import java.util.Random;

public class PlaceShip {
    static void shipPlace(int shipSize, int columns, int rows, String shipLetter, String[][] shipBoard) {
        Random rand = new Random();
        int toggle = rand.nextInt(2);

        int replaceableX;
        int replaceableY;
        if (toggle == 0) {
                replaceableX = rand.nextInt(rows);
                replaceableY = rand.nextInt((columns - (shipSize + 1)) + 1);
                for (int i = 0; i < shipSize; i++) {
                    if (!shipBoard[replaceableX][replaceableY + i + 1].equals("•")) {
                        shipPlace(shipSize, columns, rows, shipLetter, shipBoard);
                        return;
                    }
                }
                for (int i = 0; i < shipSize; i++) {
                    replaceableY++;
                    shipBoard[replaceableX][replaceableY] = shipLetter;
                }
            } else {
                replaceableX = rand.nextInt((rows - (shipSize + 1)) + 1);
                replaceableY = rand.nextInt(columns);
                for (int i = 0; i < shipSize; i++) {
                    if (!shipBoard[replaceableX + i + 1][replaceableY].equals("•")) {
                        shipPlace(shipSize, columns, rows, shipLetter, shipBoard);
                        return;
                    }
                }
                for (int i = 0; i < shipSize; i++) {
                    replaceableX++;
                    shipBoard[replaceableX][replaceableY] = shipLetter;
                }
            }
        }

    public static void main(String[] args) {
        int columns = 10;
        int rows = 10;

        String[][] shipBoard = new String[columns][rows];

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                shipBoard[i][j] = "•";
            }
        }

        shipPlace(5, columns, rows, "A", shipBoard);
        shipPlace(4, columns, rows, "B", shipBoard);
        shipPlace(3, columns, rows, "C", shipBoard);
        shipPlace(3, columns, rows, "D", shipBoard);
        shipPlace(2, columns, rows, "E", shipBoard);

        for (int i = 0; i < columns; i++    ) {
            for (int j = 0; j < rows; j++) {
                System.out.print(shipBoard[i][j] + "  ");
            }
            System.out.println();
        }
    }
}
