import java.util.Scanner;

public class Class {
    static void placeYourShips(String[][] playerBoard,
                               String[] shipNames,
                               int columns,
                               int rows,
                               String toggle) {
        char[] maxVerticalCoordinate = {'F', 'G', 'G', 'H', 'I'};
        int[] maxHorizontalCoordinate = {6, 7, 7, 8, 9};
        int verticalCoordinateInteger;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < shipNames.length; i++) {
            System.out.println("Choose where to place your " + shipNames[i]);
            System.out.println("Should it be placed vertically (V) or horizontally (H)?");
            toggle = scanner.nextLine().toUpperCase();

            try {
                if (!toggle.equals("V") && !toggle.equals("H")) {
                    throw new IllegalArgumentException("Invalid argument");
                }
            } catch (Exception e) {
                System.out.println("Invalid, try again");
                i--;
                continue;
            }

            String verticalCoordinate;
            int horizontalCoordinate;
            if (toggle.equals("V")) {
                System.out.println("What should the vertical coordinate be? (A - J)");
                verticalCoordinate = scanner.nextLine().toUpperCase();
                System.out.println("What should the horizontal coordinate be? (1 - " + maxHorizontalCoordinate[i] + ")");
                horizontalCoordinate = scanner.nextInt();
            } else {
                System.out.println("What should the vertical coordinate be? (A - " + maxVerticalCoordinate[i] + ")");
                verticalCoordinate = scanner.nextLine().toUpperCase();
                System.out.println("What should the horizontal coordinate be? (1 - 10)");
                horizontalCoordinate = scanner.nextInt();
            }

            verticalCoordinateInteger = verticalCoordinate.charAt(0) - 'A';
            horizontalCoordinate--;

            if (toggle.equals("V")) {
                try {
                    if (verticalCoordinateInteger < 0 || verticalCoordinateInteger >= 10 || horizontalCoordinate < 0 || horizontalCoordinate > maxHorizontalCoordinate[i]) { // see if either of the coordinates is less than 0, or greater than 9,
                        throw new IllegalArgumentException("Coordinate out of bounds");
                    }
                } catch (
                        Exception e) { // if either of the IllegalArgumentExceptions applies to the coordinate, run this catch
                    System.out.println("Invalid coordinate, try again");
                    i--;
                    continue;
                }
            } else {
                try {
                    if (verticalCoordinateInteger < 0 || verticalCoordinateInteger > maxVerticalCoordinate[i] || horizontalCoordinate < 0 || horizontalCoordinate >= 10) { // see if either of the coordinates is less than 0, or greater than 9,
                        throw new IllegalArgumentException("Coordinate out of bounds");
                    }
                } catch (
                        Exception e) { // if either of the IllegalArgumentExceptions applies to the coordinate, run this catch
                    System.out.println("Invalid coordinate, try again");
                    i--;
                    continue;
                }
            }

            System.out.println("Placing " + shipNames[i]);
        }
    }

    public static void main(String[] args) {
        int columns = 10;
        int rows = 10;
        String[] shipNames = {"Carrier (XXXXX)", "Tanker (XXXX)", "Frigate 1 (XXX)", "Frigate 2 (XXX)", "Patrol Boat (XX)"};
        String toggle = "";

        String[][] playerBoard = new String[columns][rows];

        // Initialize the player board
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                playerBoard[i][j] = "•";
            }
        }

        placeYourShips(playerBoard, shipNames, columns, rows, toggle);
    }
}
