package lab2;

/**
 * Created by Serge on 17.05.2017.
 */

public class ArrayPrimes {
    //метод возвращает массив простых чисел размером 100
    //в цикле перебираются цифры и проверяется являются ли они простыми
    //
    public static int[] GetArrayPrimes(){
        int n = 0;
        int[] arrayPrimes = new int [100];
        for (int i = 0; i < 100; i++) {
            while (arrayPrimes[i] == 0){
                ++n;
                if (IsNumberPrimes(n)){
                    arrayPrimes[i] = n;
                }
            }
        }
        return arrayPrimes;
    }

    //Метод проверяет является заданое в качестве аргумента число простым
    private static boolean IsNumberPrimes (int n) {
        if(n==1) // 1 - не простое число
            return true; // по условию должно быть
        // перебираем возможные делители от 2 до sqrt(n)
        for(int d=2; d*d<=n; d++){
            // если разделилось нацело, то составное
            if(n%d==0)
                return false;
        }
        // если нет нетривиальных делителей, то простое
        return true;
    }

}
