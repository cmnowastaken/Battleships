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


    static void printBoard(int rows, int columns, String[][] shipBoard, String[][] board) {

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

        System.out.print(" ");
        for (int i = 1; i < columns; i++) {
            System.out.print("  " + i);
        }
        System.out.print("  " + "10");
        System.out.println();

        for (int i = 0; i < columns; i++) {
            System.out.print("ABCDEFGHIJ".charAt(i) + "  ");
            for (int j = 0; j < rows; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }
    }

    static void PlayerControls(int shipsHit,
                               int turns,
                               String[][] shipBoard,
                               String[][] board,
                               int columns,
                               int rows,
                               boolean checkForA,
                               boolean checkForB) {
        Scanner scanner = new Scanner(System.in);

        while (shipsHit < 3) {
            turns++;
            System.out.println("Choose a coordinate to shoot at (eg. B7)");
            String coordinate = scanner.nextLine();
            int coordinateY = coordinate.charAt(0) - 'A';
            int coordinateX = coordinate.charAt(1) - '0' - 1;

            if (coordinate.length() != 2) {
                System.out.println("Invalid coordinate");
                continue;
            }

            if (shipBoard[coordinateY][coordinateX].equals("A")
                    || shipBoard[coordinateY][coordinateX].equals("B")
                    || shipBoard[coordinateY][coordinateX].equals("C")
                    || shipBoard[coordinateY][coordinateX].equals("D")
                    || shipBoard[coordinateY][coordinateX].equals("E")){
                board[coordinateY][coordinateX] = "X";
                shipBoard[coordinateY][coordinateX] = "L";
                shipsHit++;
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

            for (int i = 0; i < columns; i++) {
                for (int j = 0; j < rows; j++) {
                    System.out.print(board[i][j] + "  ");
                }
                System.out.println();
            }

            boolean aSunk = true;
            if (checkForA) {
                for (int i = 0; i < columns; i++) {
                    for (int j = 0; j < rows; j++) {
                        if (shipBoard[i][j].equals("A") && !Objects.equals(board[i][j], "X")) {
                            aSunk = false;
                            break;
                        }
                    }
                }
            }

            if (aSunk && checkForA) {
                System.out.println("Sunk!");
                checkForA = false;
            }

            boolean bSunk = true;
            if (checkForB) {
                for (int i = 0; i < columns; i++) {
                    for (int j = 0; j < rows; j++) {
                        if (shipBoard[i][j].equals("B") && !Objects.equals(board[i][j], "X")) {
                            bSunk = false;
                            break;
                        }
                    }
                }
            }


            if (bSunk && checkForB) {
                System.out.println("Sunk!");
                checkForB = false;
            }

            if (shipsHit == 3) {
                System.out.println("Game over! You won in " + turns + " turns.");
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
        Scanner scanner = new Scanner(System.in);

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

        printBoard(columns, rows, shipBoard, board);
        shipPlace(5, columns, rows, "A", shipBoard);
        shipPlace(4, columns, rows, "B", shipBoard);
        shipPlace(3, columns, rows, "C", shipBoard);
        shipPlace(3, columns, rows, "D", shipBoard);
        shipPlace(2, columns, rows, "E", shipBoard);

        while (shipsHit < 17) {
            PlayerControls(shipsHit, turns, shipBoard, board, columns, rows, checkForA, checkForB);
        }
    }
}