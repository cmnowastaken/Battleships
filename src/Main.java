import java.util.Random;
import java.util.Scanner;
import java.util.Objects;

public class Main {

    static void Instructions() {
        String multiLineStr = """
                                   ___  ___ ______________   __________ _________  ____
                                  / _ )/ _ /_  __/_  __/ /  / __/ __/ // /  _/ _ \\/ __/
                                 / _  / __ |/ /   / / / /__/ _/_\\ \\/ _  // // ___/\\ \\ \s
                                /____/_/ |_/_/   /_/ /____/___/___/_//_/___/_/  /___/ \s
                                                                      \s
                                
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
                              """;
        System.out.println(multiLineStr);
    }

    static void printBoard(int rows,
                           int columns,
                           String[][] shipBoard,
                           String[][] board) {

        System.out.print(" ");
        for (int i = 1; i < columns; i++) {
            System.out.print("  " + i);
        }
        System.out.print("  " + "10");
        System.out.println();

        for (int i = 0; i < columns; i++) {
            System.out.print("ABCDEFGHIJ".charAt(i) + "  ");
            for (int j = 0; j < rows; j++) {
                System.out.print(shipBoard[i][j] + "  ");
            }
            System.out.println();
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

        for (int k = 0; k < checkFor.length; k++) {
            if (checkFor[k]) {
                boolean sunk = true;
                for (int i = 0; i < columns; i++) {
                    for (int j = 0; j < rows; j++) {
                        if (shipBoard[i][j].equals(String.valueOf(shipLetters[k])) && !Objects.equals(board[i][j], "X")) {
                            sunk = false;
                            break;
                        }
                    }
                    if (!sunk) break;
                }
                if (sunk) {
                    System.out.println(shipNames[k] + " Sunk!");
                    checkFor[k] = false;
                    shipsSunk++;
                }
            }
        }
        return shipsSunk;
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
            String coordinate = scanner.nextLine().toUpperCase();
            int coordinateY = coordinate.charAt(0) - 'A';
            int coordinateX = Integer.parseInt(coordinate.substring(1)) - 1;

            if (coordinate.length() < 2 || coordinate.length() > 3 || coordinateY < 0 || coordinateY >= 10 || coordinateX < 0 || coordinateX >= 10) {
                System.out.println("Invalid coordinate");
                continue;
            }

            if (shipBoard[coordinateY][coordinateX].matches("[ABCDE]")) {
                board[coordinateY][coordinateX] = "X";
                shipBoard[coordinateY][coordinateX] = "L";
                System.out.println("Hit!");
            } else if (board[coordinateY][coordinateX].equals("•")) {
                board[coordinateY][coordinateX] = "O";
                shipBoard[coordinateY][coordinateX] = "L";
                System.out.println("Miss!");
            } else if (shipBoard[coordinateY][coordinateX].equals("L")) {
                System.out.println("Coordinate already attempted, please try another.");
                continue;
            } else {
                System.out.println("Coordinate invalid, please enter a letter between A-J and a number between 1-10.");
                continue;
            }

            printBoard(rows, columns, board, shipBoard);

            shipsSunk[0] = checkForSunk(rows, columns, shipsSunk[0], checkFor, shipBoard, board);

            if (shipsSunk[0] == 5) {
                System.out.println("Game over! You won in " + turns[0] + " turns.");
                System.exit(0);
            }
        }
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
        if (toggle == 0) {
            replaceableX = rand.nextInt(rows);
            replaceableY = rand.nextInt(columns - shipSize + 1);
            for (int i = 0; i < shipSize; i++) {
                if (!shipBoard[replaceableX][replaceableY + i].equals("•")) {
                    shipPlace(shipSize, columns, rows, shipLetter, shipBoard);
                    return;
                }
            }
            for (int i = 0; i < shipSize; i++) {
                shipBoard[replaceableX][replaceableY + i] = shipLetter;
            }
        } else {
            replaceableX = rand.nextInt(rows - shipSize + 1);
            replaceableY = rand.nextInt(columns);
            for (int i = 0; i < shipSize; i++) {
                if (!shipBoard[replaceableX + i][replaceableY].equals("•")) {
                    shipPlace(shipSize, columns, rows, shipLetter, shipBoard);
                    return;
                }
            }
            for (int i = 0; i < shipSize; i++) {
                shipBoard[replaceableX + i][replaceableY] = shipLetter;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int columns = 10;
        int rows = 10;
        int[] turns = {0};
        int[] shipsSunk = {0};
        boolean[] checkFor = {true, true, true, true, true};
        int decision = 0;

        String[][] board = new String[columns][rows];
        String[][] shipBoard = new String[columns][rows];
        Instructions();

        while (decision != 1) {
            decision = scanner.nextInt();

            if (decision == 1) {
                System.out.println('\u000c');
            } else if (decision == 2) {
                System.exit(0);
            } else if (decision == 3) {
                System.out.println('\u000c');
                Instructions();
            } else if (decision == 4) {
                System.exit(0);
            } else {
                System.out.println("Invalid input, please enter an integer between 1 and 4.");
            }
        }

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

        printBoard(rows, columns, shipBoard, board);
        shipPlace(5, columns, rows, "A", shipBoard);
        shipPlace(4, columns, rows, "B", shipBoard);
        shipPlace(3, columns, rows, "C", shipBoard);
        shipPlace(3, columns, rows, "D", shipBoard);
        shipPlace(2, columns, rows, "E", shipBoard);

        while (shipsSunk[0] < 5) {
            playerControls(shipsSunk, turns, shipBoard, board, columns, rows, checkFor);
        }
    }
}

