package lab4;

import java.util.Set;
import java.util.TreeSet;

public class StringUtil {

    //Метод изменяет порядок букв в строке на обратный
    public static String ReverseString(String string){
        StringBuilder sb = new StringBuilder(string);
        return sb.reverse().toString();
    }

    //Метод возвращает массив символов которые присутствуют в одном слове и отсутствуют во втором,
    //которые передаются в качестве аргументов
    public static Character[] GetUniqueChar(String string1, String string2 ){
        Set<Character> uniqueChars= new TreeSet<Character>();

        char[] chars1 = string1.toCharArray();
        char[] chars2 = string2.toCharArray();
        for (char c : chars1) {
            if (string2.indexOf(c) == -1){
                uniqueChars.add(c);
            }
        }
        for (char c : chars2) {
            if (string1.indexOf(c) == -1){
                uniqueChars.add(c);
            }
        }

        return uniqueChars.toArray(new Character[0]);
    }

    //Метод возвращает нову строку заменяя все вхождения одного слова в предложение другим словом
    public  static String ChangeWord(String string, String word, String newWord){
        return string.replace(word, newWord);
    }

    //Метод разбирает предложение на отдельные слова и выводит их на экран в столбик.
    public static void GetArrayString(String string){
        String[] arrStr = string.split("[\\s.,!?\\-]+");
        for (String s : arrStr) {
            System.out.println(s);
        }
    }
}
