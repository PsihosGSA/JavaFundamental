package lab2;

/**
 * Created by Serge on 17.05.2017.
 */
public class BinomialRate {
    //метод возвращает факториал числа заданого аргументом
    public static int Fakt(int n){
        int r = 1;
        for (; n > 0 ; --n)
            r *= n;
        return r;
    }

    //метод возвращает биноминальный коефициент
    //на основе заданого аргументами номеров строки (n) и столбца (k)
    public static int BCI(int n,int k)
    {
        return Fakt(n) / (Fakt(k) * Fakt(n - k));
    }

    //метод возвращает многомерный массив с биноминальными коэфициентами
    public static int[][] GetBinomialRate(int n){
        int[][] binomialRate = new int[n][];
        for (int i = 0; i < n; i++) {
            binomialRate[i] = new int[i+1];
            for (int j = 0; j <= i; j++) {
                binomialRate[i][j] = BCI(i,j);
            }
        }
        return binomialRate;
    }

}
