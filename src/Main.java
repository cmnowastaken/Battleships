/*
Elliott Bell
23/7/24
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
                                
                There will be 5 ships set out on the board. Their shapes are as follows.
                                
                𝖷 𝖷 𝖷 𝖷 𝖷
                𝖷 𝖷 𝖷 𝖷
                𝖷 𝖷 𝖷
                𝖷 𝖷 𝖷
                𝖷 𝖷
                                
                Your job is to destroy these ships before the computer destroys yours.
                                
                To place your ships, you will declare whether the ship should be placed vertically or horizontally.
                                
                You will then select a coordinate. This will be either the uppermost (vertical) or left-most (horizontal) coordinate of the ship.
                                
                For example, if I placed my Carrier (XXXXX) vertically on B4, it would be placed as follows:
                                
                   1  2  3  4  5  6  7  8  9  10
                A  •  •  •  •  •  •  •  •  •  •
                B  •  •  •  X  •  •  •  •  •  •
                C  •  •  •  X  •  •  •  •  •  •
                D  •  •  •  X  •  •  •  •  •  •
                E  •  •  •  X  •  •  •  •  •  •
                F  •  •  •  X  •  •  •  •  •  •
                G  •  •  •  •  •  •  •  •  •  •
                H  •  •  •  •  •  •  •  •  •  •
                I  •  •  •  •  •  •  •  •  •  •
                J  •  •  •  •  •  •  •  •  •  •
                                
                If I placed it horizontally on B4, it would be placed like this:
                                
                   1  2  3  4  5  6  7  8  9  10
                A  •  •  •  •  •  •  •  •  •  •
                B  •  •  •  X  X  X  X  X  •  •
                C  •  •  •  •  •  •  •  •  •  •
                D  •  •  •  •  •  •  •  •  •  •
                E  •  •  •  •  •  •  •  •  •  •
                F  •  •  •  •  •  •  •  •  •  •
                G  •  •  •  •  •  •  •  •  •  •
                H  •  •  •  •  •  •  •  •  •  •
                I  •  •  •  •  •  •  •  •  •  •
                J  •  •  •  •  •  •  •  •  •  •
                                
                You cannot place your ships on top of each other.
                                
                The prompt will tell you the valid coordinates for your ship to be placed.
                                
                If you disobey these, you will start over.
                                
                *-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
                                
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
                2) No, please explain again
                3) I don't want to play
                """; // multi line string of instructions
        System.out.println(multiLineStr);
    }

    static void printBoard(
            int rows,
            int columns,
            String[][] shipBoard,
            String[][] board
    ) {

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

    static void placeYourShips(
            String[][] playerBoard,
            String[] shipNames,
            String[][] playerBoardComputer,
            int columns,
            int rows
    ) {
        char[] maxVerticalCoordinate = {'F', 'G', 'G', 'H', 'I'};
        int[] maxHorizontalCoordinate = {6, 7, 8, 8, 9};
        int[] shipSize = {5, 4, 3, 3, 2};
        char[] shipLetters = {'A', 'B', 'C', 'D', 'E'};
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < shipNames.length; i++) { // run this for loop for all 5 ships
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
                int horizontalCoordinate;
                int verticalCoordinateInteger;

                while (true) {
                    char v = toggle.equals("V") ? maxVerticalCoordinate[i] : 'J'; // make a variable based on a ternary which either sets maxVerticalCoordinate to a value assigned in an array, or to J
                    System.out.println("What should the vertical coordinate be? (A - " + v + ")");
                    verticalCoordinate = scanner.nextLine().toUpperCase();

                    if (verticalCoordinate.length() != 1 || verticalCoordinate.charAt(0) < 'A' || verticalCoordinate.charAt(0) > v) { // catch any invalid answers to the prompt
                        System.out.println("Invalid vertical coordinate, try again");
                        continue;
                    }

                    verticalCoordinateInteger = verticalCoordinate.charAt(0) - 'A'; // convert the vertical coordinate into an integer by subtracting the ascii value of "A"
                    break;
                }

                while (true) { // does the same as the
                    int v = (toggle.equals("V") ? 10 : maxHorizontalCoordinate[i]);
                    System.out.println("What should the horizontal coordinate be? (1 - " + v + ")");
                    if (scanner.hasNextInt()) {
                        horizontalCoordinate = scanner.nextInt();
                        scanner.nextLine(); // ensure that any inputs left by pressing enter are removed

                        if (horizontalCoordinate < 1 || horizontalCoordinate > v) {
                            System.out.println("Invalid horizontal coordinate, try again");
                            continue;
                        }
                        horizontalCoordinate--; // convert to 0 index
                        break;
                    } else {
                        System.out.println("Invalid coordinate, try again");
                        scanner.next(); // get rid of the invalid input
                    }
                }

                boolean invalidPlacement = false;

                if (toggle.equals("V")) { // if a ship does not fit, try again
                    if (verticalCoordinateInteger + shipSize[i] > rows) {
                        System.out.println("Ship does not fit in the vertical space, try again");
                        continue;
                    }

                    for (int j = 0; j < shipSize[i]; j++) { // if a ship is already placed, break and try again
                        if (!playerBoard[verticalCoordinateInteger + j][horizontalCoordinate].equals("•")) {
                            invalidPlacement = true;
                            break;
                        }
                    }
                    if (!invalidPlacement) { // if the placement is valid, place the ship
                        for (int j = 0; j < shipSize[i]; j++) {
                            playerBoard[verticalCoordinateInteger + j][horizontalCoordinate] = "X";
                            playerBoardComputer[verticalCoordinateInteger + j][horizontalCoordinate] = String.valueOf(shipLetters[i]);
                        }
                    }
                } else { // does the same, but for if the player wants the ship to be placed horizontally
                    if (horizontalCoordinate + shipSize[i] > columns) {
                        System.out.println("Ship does not fit in the horizontal space, try again");
                        continue;
                    }

                    for (int j = 0; j < shipSize[i]; j++) {
                        if (!playerBoard[verticalCoordinateInteger][horizontalCoordinate + j].equals("•")) {
                            invalidPlacement = true;
                            break;
                        }
                    }
                    if (!invalidPlacement) {
                        for (int j = 0; j < shipSize[i]; j++) {
                            playerBoard[verticalCoordinateInteger][horizontalCoordinate + j] = "X";
                            playerBoardComputer[verticalCoordinateInteger][horizontalCoordinate + j] = String.valueOf(shipLetters[i]);
                        }
                    }
                }

                if (invalidPlacement) {
                    System.out.println("Invalid coordinate, try again");
                    continue;
                }

                validPlacement = true;
                System.out.println("Placing " + shipNames[i] + " at (" + verticalCoordinate + (horizontalCoordinate + 1) + ")");
                printBoard(rows, columns, playerBoard, new String[0][]); // using the existing printBoard method instead of making another
            }
        }
    }

    static int checkForSunk(
            int columns,
            int rows,
            int shipsSunk,
            boolean[] checkFor,
            String[][] shipBoard,
            String[][] board
    ) {
        char[] shipLetters = {'A', 'B', 'C', 'D', 'E'};

        for (int k = 0; k < checkFor.length; k++) { // check through every element in the array checkFor to see if any are true
            if (checkFor[k]) {
                boolean sunk = true;
                for (int i = 0; i < columns; i++) {
                    for (int j = 0; j < rows; j++) {
                        if (shipBoard[i][j].equals(String.valueOf(shipLetters[k]))) { // if the shipBoard still has a character equal to the value in the place in the shipLetters array that has been declared previously as (k), and the player board does not have an 'X' in that space, do not go further through the statement.
                            sunk = false;
                            break;
                        }
                    }
                    if (!sunk)
                        break; // if the statement is declared early, break before checking fully through both arrays for efficiency.
                }
                if (sunk) { // if the ship is sunk, reference the correct ship in the array and tell the player that the ship has been sunk.
                    checkFor[k] = false;
                    shipsSunk++;
                }
            }
        }
        return shipsSunk; // update the shipsSunk array for the win condition.
    }

    static void playerControls(
            int[] shipsSunk,
            int[] turns,
            int[] shipsSunkComputer,
            boolean[] checkForComputer,
            String[][] shipBoard,
            String[][] board,
            String[][] playerBoard,
            String[][] playerBoardComputer,
            int columns,
            int rows,
            boolean[] checkFor
    ) {
        Scanner scanner = new Scanner(System.in);

        while (shipsSunk[0] < 5) {
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
            } catch (
                    Exception e) { // if either of the IllegalArgumentExceptions applies to the coordinate, run this catch
                System.out.println("Invalid coordinate");
                continue;
            }

            if (shipBoard[coordinateY][coordinateX].matches("[ABCDE]")) { // if the coordinate the player declared had a ship on it
                board[coordinateY][coordinateX] = "X"; // make the coordinate equal to X on the player's board so the player can see the hit on their board.
                shipBoard[coordinateY][coordinateX] = "L"; // make the coordinate on the ship board equal to 'L', so that the computer knows that the square has been fired at.
                if (checkForSunk(rows, columns, shipsSunkComputer[0], checkForComputer, playerBoardComputer, playerBoard) > shipsSunkComputer[0]) {// if the ship has been sunk, say so
                    char shipType = shipBoard[coordinateY][coordinateX].charAt(0);
                    getShipName(shipType);
                    System.out.println(shipType + "hit!");
                    shipsSunk[0]++; // get the value of shipsSunk from the checkForShips method
                } else {
                    System.out.println("Hit!");
                }
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

                turns[0]++;

            if (shipsSunk[0] == 5) { // use this value to see if the player has won the game.
                turns[0]--; // the way the turns have to update is flawed, so 1 turn must be subtracted in order to be accurate
                System.out.println("Game over! You won in " + turns[0] + " turns.");
                System.exit(0);
            } else if (shipsSunkComputer[0] == 5) { // see if the computer has won the game.
                System.out.println("Game over! Computer won in " + turns[0] + " turns.");
                System.exit(0);
            } else { // if nobody has won, continue the game.
                printBoard(rows, columns, board, shipBoard);
                computerTurn(columns, rows, playerBoardComputer, playerBoard, shipsSunkComputer, checkForComputer);
                System.out.println();
                System.out.println("Your turn!");
                try { // delay to make the computer seem more human and give player time to process
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                printBoard(rows, columns, board, shipBoard);
            }
        }
    }

    static void computerTurn(
            int columns,
            int rows,
            String[][] playerBoardComputer,
            String[][] playerBoard,
            int[] shipsSunkComputer,
            boolean[] checkForComputer
    ) {
        Random rand = new Random();
        int computerXCoordinate, computerYCoordinate;
        String hitOrMiss;
        char computerYCoordinateChar;

        System.out.println();
        System.out.println("Computer's turn");

        try { // delay to give player time
            Thread.sleep(750);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true) { //
            computerXCoordinate = rand.nextInt(rows);
            computerYCoordinate = rand.nextInt(columns);
            computerYCoordinateChar = (char) ('A' + computerYCoordinate);

            if (playerBoard[computerYCoordinate][computerXCoordinate].equals("0") ||
                playerBoard[computerYCoordinate][computerXCoordinate].equals("◼")) {
                // try a new coordinate if the existing one has been hit
                continue;
            }

            if (playerBoardComputer[computerYCoordinate][computerXCoordinate].matches("[ABCDE]")) { // if the computer hits a ship
                char shipType = playerBoardComputer[computerYCoordinate][computerXCoordinate].charAt(0);
                playerBoard[computerYCoordinate][computerXCoordinate] = "◼";
                shipsSunkComputer[0] = checkForSunk(columns, rows, shipsSunkComputer[0], checkForComputer, playerBoardComputer, playerBoard);
                hitOrMiss = "hit your " + getShipName(shipType); // customise the message to the type of ship that has been hit
                if (checkForSunk(rows, columns, shipsSunkComputer[0], checkForComputer, playerBoardComputer, playerBoard) < shipsSunkComputer[0]) {
                    hitOrMiss += " and sunk it!"; // if the ship has been sunk, say so
                    shipsSunkComputer[0]++;
                } else {
                    hitOrMiss += ".";
                }
            } else {
                playerBoard[computerYCoordinate][computerXCoordinate] = "0"; // if the computer missed, do this
                playerBoardComputer[computerYCoordinate][computerXCoordinate] = "0";
                hitOrMiss = "missed.";
            }

            System.out.println("Computer fired at (" + computerYCoordinateChar + (computerXCoordinate + 1) + "), and " + hitOrMiss); // print this regardless of whether a ship was hit
            printBoard(rows, columns, playerBoard, new String[0][]);
            break;
        }
    }

    static String getShipName(char shipLetter) { // method to store all the ship names and their respective characters
        return switch (shipLetter) {
            case 'A' -> "Carrier (XXXXX)";
            case 'B' -> "Tanker (XXXX)";
            case 'C' -> "Frigate 1 (XXX)";
            case 'D' -> "Frigate 2 (XXX)";
            case 'E' -> "Patrol Boat (XX)";
            default -> "error";
        };
    }

    static void shipPlace(
            int shipSize,
            int columns,
            int rows,
            String shipLetter,
            String[][] shipBoard
    ) {
        Random rand = new Random();
        int toggle = rand.nextInt(2);

        int replaceableX;
        int replaceableY;
        if (toggle == 0) { // if the toggle is equal to 0, the ship will be placed horizontally.
            replaceableX = rand.nextInt(rows);
            replaceableY = rand.nextInt(columns - shipSize + 1); // Y-axis will be equal to a random integer between 0 and 9, however the ship size will be taken into account to make sure that it does not spawn outside the map.
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
            replaceableX = rand.nextInt(rows - shipSize + 1); // X-axis will be equal to a random integer between 0 and 9, however the ship size will be taken into account to make sure that it does not spawn outside the map.
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
        int[] shipsSunkComputer = {0};
        boolean[] checkFor = {true, true, true, true, true};
        boolean[] checkForComputer = {true, true, true, true, true};
        String[] shipNames = {"Carrier (XXXXX)", "Tanker (XXXX)", "Frigate 1 (XXX)", "Frigate 2 (XXX)", "Patrol Boat (XX)"};

        String[][] board = new String[columns][rows];
        String[][] shipBoard = new String[columns][rows];
        String[][] playerBoard = new String[columns][rows];
        String[][] playerBoardComputer = new String[columns][rows];
        Instructions();

        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                System.out.println("Error, please enter a number between 1 and 3");
                continue;
            }

            try {
                if (input.length() != 1) {
                    throw new IllegalArgumentException("Invalid input, enter a number between 1 and 3");
                }
            } catch (Exception e) {
                System.out.println("Error, please enter a number between 1 and 3");
                continue;
            }

            char decision = input.charAt(0);

            try {
                switch (decision) {
                    case '1':
                        break;
                    case '2':
                        Instructions();
                        continue;
                    case '3':
                        System.exit(0);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid input, enter a number between 1 and 3");
                }
            } catch (Exception e) {
                System.out.println("Error, please enter a number between 1 and 3");
                continue;
            }

            for (int i = 0; i < 4; i++) { // initialise all the boards
                for (int j = 0; j < columns; j++) {
                    for (int k = 0; k < rows; k++) {
                        board[j][k] = "•";
                        shipBoard[j][k] = "•";
                        playerBoard[j][k] = "•";
                        playerBoardComputer[j][k] = "•";
                    }
                }
            }

            printBoard(rows, columns, shipBoard, board); // place all the ships.
            placeYourShips(playerBoard, shipNames, playerBoardComputer, columns, rows);
            String gameStartDialogue = """
                    
                    All ships have been placed.
                    
                    Your turn!
                    """;
            System.out.println(gameStartDialogue);
            printBoard(rows, columns, shipBoard, board); // place all the ships.
            shipPlace(5, columns, rows, "A", shipBoard);
            shipPlace(4, columns, rows, "B", shipBoard);
            shipPlace(3, columns, rows, "C", shipBoard);
            shipPlace(3, columns, rows, "D", shipBoard);
            shipPlace(2, columns, rows, "E", shipBoard);

            while (shipsSunk[0] < 5 && shipsSunkComputer[0] < 5) { // keep playing the game until the win condition is met
                playerControls(shipsSunk, turns, shipsSunkComputer, checkForComputer, shipBoard, board, playerBoard, playerBoardComputer, columns, rows, checkFor);


            }
        }
    }
}