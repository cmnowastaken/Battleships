/*
Elliott Bell
26/6/24
Battleships
CSC223
*/
import java.util.Random; // importing my libraries
import java.util.Scanner;
import java.util.Objects;

public class Main {

    static void Instructions() { // method for the instructions
        String multiLineStr = """ 
                 ________  ___  ___  ___  ________        ________  ___  ________   ___  __    _______   ________  ________     \s
                |\\   ____\\|\\  \\|\\  \\|\\  \\|\\   __  \\      |\\   ____\\|\\  \\|\\   ___  \\|\\  \\|\\  \\ |\\  ___ \\ |\\   __  \\|\\   ____\\    \s
                \\ \\  \\___|\\ \\  \\\\\\  \\ \\  \\ \\  \\|\\  \\     \\ \\  \\___|\\ \\  \\ \\  \\\\ \\  \\ \\  \\/  /|\\ \\   __/|\\ \\  \\|\\  \\ \\  \\___|_   \s
                 \\ \\_____  \\ \\   __  \\ \\  \\ \\   ____\\     \\ \\_____  \\ \\  \\ \\  \\\\ \\  \\ \\   ___  \\ \\  \\_|/_\\ \\   _  _\\ \\_____  \\  \s
                  \\|____|\\  \\ \\  \\ \\  \\ \\  \\ \\  \\___|      \\|____|\\  \\ \\  \\ \\  \\\\ \\  \\ \\  \\\\ \\  \\ \\  \\_|\\ \\ \\  \\\\  \\\\|____|\\  \\ \s
                    ____\\_\\  \\ \\__\\ \\__\\ \\__\\ \\__\\           ____\\_\\  \\ \\__\\ \\__\\\\ \\__\\ \\__\\\\ \\__\\ \\_______\\ \\__\\\\ _\\ ____\\_\\  \\\s
                   |\\_________\\|__|\\|__|\\|__|\\|__|          |\\_________\\|__|\\|__| \\|__|\\|__| \\|__|\\|_______|\\|__|\\|__|\\_________\\
                   \\|_________|                             \\|_________|                                             \\|_________|
                   
                There will be 5 battleships set out on the board. Their shapes are as follows.
                 
                𝖷 𝖷 𝖷 𝖷 𝖷
                𝖷 𝖷 𝖷 𝖷
                𝖷 𝖷 𝖷
                𝖷 𝖷 𝖷
                𝖷 𝖷
                            
                Your job is to destroy these ships.
                            
                To fire a missile, simply declare where you would like to shoot.
                            
                For example, if you were to type G2 and press enter, a missile would be fired as follows:
                            
                   1  2  3  4  5  6  7  8  9  10
                A  •  •  •  •  •  •  •  •  •  •
                B  •  •  •  •  •  •  •  •  •  •
                C  •  •  •  •  •  •  •  •  •  •
                D  •  •  •  •  •  •  •  •  •  •
                E  •  •  •  •  •  •  •  •  •  •
                F  •  •  •  •  •  •  •  •  •  •
                G  •  0  •  •  •  •  •  •  •  •
                H  •  •  •  •  •  •  •  •  •  •
                I  •  •  •  •  •  •  •  •  •  •
                J  •  •  •  •  •  •  •  •  •  •
                              
                If there were to be a ship there, the board would display as follows:
                              
                   1  2  3  4  5  6  7  8  9  10
                A  •  •  •  •  •  •  •  •  •  •
                B  •  •  •  •  •  •  •  •  •  •
                C  •  •  •  •  •  •  •  •  •  •
                D  •  •  •  •  •  •  •  •  •  •
                E  •  •  •  •  •  •  •  •  •  •
                F  •  •  •  •  •  •  •  •  •  •
                G  •  𝖷  •  •  •  •  •  •  •  •
                H  •  •  •  •  •  •  •  •  •  •
                I  •  •  •  •  •  •  •  •  •  •
                J  •  •  •  •  •  •  •  •  •  •
                              
                Please note that the ships can be placed vertically as well, for example:
                              
                𝖷
                𝖷
                𝖷
                              
                As opposed to:
                              
                𝖷 𝖷 𝖷
                              
                Ships will never be placed on top of each other, but they can be placed next to each other.
                              
                Does that make sense?
                              
                1) Yes, let's play!
                2) Yes, but that sounds boring and I don't want to play
                3) No, please explain again
                4) No, I don't want to play anyway
                """; // multi line string of instructions
        System.out.println(multiLineStr);
    }

    static void printBoard(int rows,
                           int columns,
                           String[][] shipBoard,
                           String[][] board) {

        System.out.println(" "); // printing the board
        for (int j = 1; j < columns; j++) { // prints the numbers on the top of the board
            System.out.print("  " + j);
        }
        System.out.print("  " + "10");
        System.out.println();

        for (int k = 0; k < columns; k++) { // prints the bullet points on the board, as well as the letters down the side
            System.out.print("ABCDEFGHIJ".charAt(k) + " ");
            for (int l = 0; l < rows; l++) {
                System.out.print(shipBoard[k][l] + "  ");
            }
                System.out.println();
            }
    }



    static void placeYourShips(String[][] playerBoard,
                               String[] shipNames,
                               int columns,
                               int rows) {
        char[] maxVerticalCoordinate = {'F', 'G', 'G', 'H', 'I'};
        int[] maxHorizontalCoordinate = {6, 7, 8, 8, 9};
        int[] shipSize = {5, 4, 3, 3, 2};
        int verticalCoordinateInteger;
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < shipNames.length; i++) {
            boolean validPlacement = false;

            while (!validPlacement) {
                System.out.println("Choose where to place your " + shipNames[i]);
                System.out.println("Should it be placed vertically (V) or horizontally (H)?");
                String toggle = scanner.nextLine().toUpperCase();

                if (!toggle.equals("V") && !toggle.equals("H")) {
                    System.out.println("Invalid argument, try again");
                    continue;
                }

                String verticalCoordinate;
                int horizontalCoordinate = 0;

                if (toggle.equals("V")) {
                    System.out.println("What should the vertical coordinate be? (A - J)");
                    verticalCoordinate = scanner.nextLine().toUpperCase();
                    System.out.println("What should the horizontal coordinate be? (1 - " + maxHorizontalCoordinate[i] + ")");
                    if (scanner.hasNextInt()) {
                        horizontalCoordinate = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                    } else {
                        System.out.println("Invalid coordinate, try again");
                        scanner.next(); // Consume the invalid input
                        continue;
                    }
                } else {
                    System.out.println("What should the vertical coordinate be? (A - " + maxVerticalCoordinate[i] + ")");
                    verticalCoordinate = scanner.nextLine().toUpperCase();
                    System.out.println("What should the horizontal coordinate be? (1 - 10)");
                    if (scanner.hasNextInt()) {
                        horizontalCoordinate = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character
                    } else {
                        System.out.println("Invalid coordinate, try again");
                        scanner.next(); // Consume the invalid input
                        continue;
                    }
                }

                verticalCoordinateInteger = verticalCoordinate.charAt(0) - 'A';
                horizontalCoordinate--;

                boolean invalidPlacement = false;

                if (toggle.equals("V")) {
                    for (int j = 0; j < shipSize[i]; j++) {
                        if (verticalCoordinateInteger + j >= rows || !playerBoard[verticalCoordinateInteger + j][horizontalCoordinate].equals("•")) {
                            invalidPlacement = true;
                            break;
                        }
                    }
                    if (!invalidPlacement) {
                        for (int j = 0; j < shipSize[i]; j++) {
                            playerBoard[verticalCoordinateInteger + j][horizontalCoordinate] = "X";
                        }
                    }
                } else {
                    for (int j = 0; j < shipSize[i]; j++) {
                        if (horizontalCoordinate + j >= columns || !playerBoard[verticalCoordinateInteger][horizontalCoordinate + j].equals("•")) {
                            invalidPlacement = true;
                            break;
                        }
                    }
                    if (!invalidPlacement) {
                        for (int j = 0; j < shipSize[i]; j++) {
                            playerBoard[verticalCoordinateInteger][horizontalCoordinate + j] = "X";
                        }
                    }
                }

                if (invalidPlacement) {
                    System.out.println("Invalid coordinate, try again");
                    continue;
                }

                validPlacement = true;
                System.out.println("Placing " + shipNames[i] + " at (" + verticalCoordinate + (horizontalCoordinate + 1) + ")");
                printBoard(rows, columns, playerBoard, new String[0][]);
            }
        }
    }


    static int checkForSunk(int columns,
                            int rows,
                            int shipsSunk,
                            boolean[] checkFor,
                            String[][] shipBoard,
                            String[][] board) {
        String[] shipNames = {"Carrier (XXXXX)", "Tanker (XXXX)", "Frigate 1 (XXX)", "Frigate 2 (XXX)", "Patrol Boat (XX)"};
        char[] shipLetters = {'A', 'B', 'C', 'D', 'E'};
        int[] shipSizes = {5, 4, 3, 3, 2};

        for (int k = 0; k < checkFor.length; k++) { // check through every element in the array checkFor to see if any are true
            if (checkFor[k]) {
                boolean sunk = true;
                for (int i = 0; i < columns; i++) {
                    for (int j = 0; j < rows; j++) {
                        if (shipBoard[i][j].equals(String.valueOf(shipLetters[k])) && !Objects.equals(board[i][j], "X")) { // if the shipBoard still has a character equal to the value in the place in the shipLetters array that has been declared previously as (k), and the player board does not have an 'X' in that space, do not go further through the statement.
                            sunk = false;
                            break;
                        }
                    }
                    if (!sunk) break; // if the statement is declared early, break before checking fully through both arrays for efficiency.
                }
                if (sunk) { // if the ship is sunk, reference the correct ship in the array and tell the player that the ship has been sunk.
                    System.out.println(shipNames[k] + " Sunk!");
                    checkFor[k] = false;
                    shipsSunk++;
                }
            }
        }
        return shipsSunk; // update the shipsSunk array for the win condition.
    }

    static void playerControls(int[] shipsSunk,
                               int[] turns,
                               String[][] shipBoard,
                               String[][] board,
                               int columns,
                               int rows,
                               boolean[] checkFor) {
        Scanner scanner = new Scanner(System.in);

        while (shipsSunk[0] < 5) {
            turns[0]++;
            System.out.println("Choose a coordinate to shoot at (eg. B7)");
            String coordinate = scanner.nextLine().toUpperCase(); // make sure that the code that converts the letter into an integer does not break by only giving it capitals to work with.

            int coordinateY;
            int coordinateX;

            try {
                if (coordinate.length() < 2 || coordinate.length() > 3) { // see if the character is either less than 2 or more than 3 characters.
                    throw new IllegalArgumentException("Invalid length of coordinate");
                }

                coordinateY = coordinate.charAt(0) - 'A'; // take the letter in the coordinate that the player gives, and subtract the ascii value of 'A' from it. This makes it into an integer between 0 and 9, to reference the array.
                coordinateX = Integer.parseInt(coordinate.substring(1)) - 1; // take the part of the string from the second character to the end, and subtract 1 from to make it equal a value between 0 and 9.

                if (coordinateY < 0 || coordinateY >= 10 || coordinateX < 0 || coordinateX >= 10) { // see if either of the coordinates is less than 0, or greater than 9,
                    throw new IllegalArgumentException("Coordinate out of bounds");
                }
            } catch (Exception e) { // if either of the IllegalArgumentExceptions applies to the coordinate, run this catch
                System.out.println("Invalid coordinate");
                continue;
            }

            if (shipBoard[coordinateY][coordinateX].matches("[ABCDE]")) { // if the coordinate the player declared had a ship on it
                board[coordinateY][coordinateX] = "X"; // make the coordinate equal to X on the player's board so the player can see the hit on their board.
                shipBoard[coordinateY][coordinateX] = "L"; // make the coordinate on the ship board equal to 'L', so that the computer knows that the square has been fired at.
                System.out.println("Hit!");
            } else if (board[coordinateY][coordinateX].equals("•")) { // if the coordinate fired at did not have a ship on it
                board[coordinateY][coordinateX] = "O"; // show the player that the square did not have a ship on it by assigning a 0
                shipBoard[coordinateY][coordinateX] = "L"; // show the computer that the square has been fired by making the shipBoard square equal to L
                System.out.println("Miss!");
            } else if (shipBoard[coordinateY][coordinateX].equals("L")) { // If the coordinate has already been fired at, make the player try again.
                System.out.println("Coordinate already attempted, please try another.");
                continue;
            } else { // if the coordinate did not get caught by the other coordinate checker, send an error.
                System.out.println("Coordinate invalid, please enter a letter between A-J and a number between 1-10.");
                continue;
            }

            printBoard(rows, columns, board, shipBoard);


            shipsSunk[0] = checkForSunk(rows, columns, shipsSunk[0], checkFor, shipBoard, board); // get the value of shipsSunk from the checkForShips method

            if (shipsSunk[0] == 5) { // use this value to see if the player has won the game.
                System.out.println("Game over! You won in " + turns[0] + " turns.");
                System.exit(0);
            }
        }
    }

    static void computerTurn(int columns,
                             int rows,
                             String[][] playerBoard) {
        Random rand  = new Random();
        int computerXCoordinate = rand.nextInt(rows);
        int computerYCoordinate = rand.nextInt(columns);

        if (!playerBoard[computerXCoordinate][computerYCoordinate].equals("0") &&
            (!playerBoard[computerXCoordinate][computerYCoordinate].equals("◼"))) {
            if (playerBoard[computerXCoordinate][computerYCoordinate].equals("X")) {
                playerBoard[computerXCoordinate][computerYCoordinate] = "◼";
            } else {
                playerBoard[computerXCoordinate][computerYCoordinate] = "0";
            }
            printBoard(rows, columns, playerBoard, new String[0][]);        }
    }

    static void shipPlace(int shipSize,
                          int columns,
                          int rows,
                          String shipLetter,
                          String[][] shipBoard) {
        Random rand = new Random();
        int toggle = rand.nextInt(2);

        int replaceableX;
        int replaceableY;
        if (toggle == 0) { // if the toggle is equal to 0, the ship will be placed horizontally.
            replaceableX = rand.nextInt(rows);
            replaceableY = rand.nextInt(columns - shipSize + 1); // Y axis will be equal to a random integer between 0 and 9, however the ship size will be taken into account to make sure that it does not spawn outside of the map.
            for (int i = 0; i < shipSize; i++) {
                if (!shipBoard[replaceableX][replaceableY + i].equals("•")) { // if a ship is placed in any of the locations declared by the for loop, find a new location
                    shipPlace(shipSize, columns, rows, shipLetter, shipBoard);
                    return;
                }
            }
            for (int i = 0; i < shipSize; i++) {
                shipBoard[replaceableX][replaceableY + i] = shipLetter; // place the ship, going downwards if there is no ship where it wants to be placed.
            }
        } else { // if the toggle is 1, the ship will be placed vertically.
            replaceableX = rand.nextInt(rows - shipSize + 1); // X axis will be equal to a random integer between 0 and 9, however the ship size will be taken into account to make sure that it does not spawn outside of the map.
            replaceableY = rand.nextInt(columns);
            for (int i = 0; i < shipSize; i++) {
                if (!shipBoard[replaceableX + i][replaceableY].equals("•")) { // if a ship is placed in any of the locations declared by the for loop, find a new location
                    shipPlace(shipSize, columns, rows, shipLetter, shipBoard);
                    return;
                }
            }
            for (int i = 0; i < shipSize; i++) {
                shipBoard[replaceableX + i][replaceableY] = shipLetter; // place the ship, going to the right.
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // declare variables to be used in various methods
        int columns = 10;
        int rows = 10;
        int[] turns = {0};
        int[] shipsSunk = {0};
        boolean[] checkFor = {true, true, true, true, true};
        String[] shipNames = {"Carrier (XXXXX)", "Tanker (XXXX)", "Frigate 1 (XXX)", "Frigate 2 (XXX)", "Patrol Boat (XX)"};
        int decision = 0;

        String[][] board = new String[columns][rows];
        String[][] shipBoard = new String[columns][rows];
        String[][] playerBoard = new String[columns][rows];
        Instructions();

        while (decision != 1) {
            decision = scanner.nextInt(); // while the decision is not to continue to the game, keep trying for a new decision

            if (decision == 1) {
                System.out.println('\u000c'); // if the player wants to continue, clear screen
            } else if (decision == 2) {
                System.exit(0); // if the player wants to leave, quit game
            } else if (decision == 3) {
                System.out.println('\u000c'); // if the player wants to get instructions again, clear screen and give them again
                Instructions();
            } else if (decision == 4) {
                System.exit(0); // if the player wants to leave, quit game
            } else {
                System.out.println("Invalid input, please enter an integer between 1 and 4.");
            }
        }

        for (int i = 0; i < columns; i++) { // assign the values to the boards for the methods to use later
            for (int j = 0; j < rows; j++) {
                board[i][j] = "•";
            }
        }

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                shipBoard[i][j] = "•";
            }
        }

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                playerBoard[i][j] = "•";
            }
        }

        printBoard(rows, columns, shipBoard, board); // place all the ships.
        placeYourShips(playerBoard, shipNames, columns, rows);
        printBoard(rows, columns, shipBoard, board); // place all the ships.
        shipPlace(5, columns, rows, "A", shipBoard);
        shipPlace(4, columns, rows, "B", shipBoard);
        shipPlace(3, columns, rows, "C", shipBoard);
        shipPlace(3, columns, rows, "D", shipBoard);
        shipPlace(2, columns, rows, "E", shipBoard);

        while (shipsSunk[0] < 5) { // keep playing the game until the win condition is met
            playerControls(shipsSunk, turns, shipBoard, board, columns, rows, checkFor);
            computerTurn(columns, rows, playerBoard);
        }
    }
}