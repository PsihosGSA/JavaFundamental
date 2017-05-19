package lab2;

/**
 * Created by Serge on 17.05.2017.
 */
public class ChessBoard {
    //метод создает двумерный массив в котором чередуются 1 и 0
    //в шахматном порядке
    public static int[][] GetChessBoard(){
        int[][] chessBoard = new int[8][8];
        boolean isDark;
        for (int i = 0; i < 8; i++) {
            isDark = (i % 2 == 0) ? true : false;

            for (int j = 0; j < 8; j++) {
                chessBoard[i][j] = (isDark) ? 1 : 0;
                isDark = !isDark;
            }
        }
        return chessBoard;
    }

    //метод выводит на екран многомерный массив
    public static void PrintChessBoard(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
