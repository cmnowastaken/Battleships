public class PrintBoardAlternate {
    public static void main(String[] args) {
        int columns = 10;
        int rows = 10;

        String[][] board = new String[columns][rows];


        System.out.print(" ");
        for (int i = 1; i < columns; i++) {
            System.out.print("  " + i);
        }
        System.out.print("  " + "10");
        System.out.println();

        for (int i = 0; i < columns; i++) {
            System.out.print("ABCDEFGHIJ".charAt(i) + " ");
            for (int j = 0; j < rows; j++) {
                System.out.print(" • ");
            }
            System.out.println();
        }
    }
}
