public class PrintBoard {
    public static void main(String[] args) {
        int columns = 10;
        int rows = 10;

        String[][] board = new String[columns][rows];

        for (int i = 0; i < columns + 1; i++) {
            System.out.print(" ABCDEFGHIJ ".charAt(i) + "  ");
        }
        System.out.println();

        for (int i = 0; i < columns; i++) {
            System.out.print(i + " ");
                for (int j = 0; j < rows; j++) {
                    System.out.print(" • ");
                }
                System.out.println();
            }
        }
    }










