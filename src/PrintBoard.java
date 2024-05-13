public class PrintBoard {
    public static void main(String[] args) {
        int columns = 12;
        int rows = 12;

        String[][] board = new String[columns][rows];

        for (int i = 0; i < columns; i++) {
            System.out.print("•");
                for (int j = 0; j < rows; j++) {
                    System.out.println(" ");
                }
            }
        }
    }

