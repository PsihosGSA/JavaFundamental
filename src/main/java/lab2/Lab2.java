package lab2;

/**
 * Created by Serge on 17.05.2017.
 */
public class Lab2 {
    public static void main(String[] args) {

        //1. Создать целый массив из 100 элементов и заполнить его простыми числами: 1, 2, 3, 7, 11, 13, 17, …

        int[] arrayPrimes = ArrayPrimes.GetArrayPrimes();
        System.out.println("Массив 100 простых чисел: ");
        for (int arrayPrime : arrayPrimes) {
            System.out.println(arrayPrime);
        }
        System.out.println();


        //2. Создать двумерный массив и заполнить его 1 и 0 в шахматном порядке. Вывести на экран в виде матрицы.
        System.out.println("двумерный массив имитирующий шахматную доску: ");
        int[][] chessBoard = ChessBoard.GetChessBoard();
        ChessBoard.PrintChessBoard(chessBoard);
        System.out.println();

        //3. Создать "треугольный" массив из 10 строк и заполнить его биномиальными коэффициентами. Тоже вывести на экран.
        System.out.println("треугольный массив из 10 строк заполненный биномиальными коэффициентами.");
        int[][] binomialRate = BinomialRate.GetBinomialRate(10);
        ChessBoard.PrintChessBoard(binomialRate);
        System.out.println();

    }
}
