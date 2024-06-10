
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
    }
}



/*
        Random rand = new Random();
        toggle = rand.nextInt(2);

        replaceableX = rand.nextInt(columns);
        replaceableY = rand.nextInt(rows);

        replaceableX = rand.nextInt(columns);
        */