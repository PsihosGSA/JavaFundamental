package lab4;

import java.util.Arrays;

        //1. В строке находится одно слово. Изменить порядок букв в слове на обратный.
        //2. Даны два слова, каждое в отдельной строке. Найти все буквы, которые присутствуют в одном слове и отсутствуют во втором.
        //3. В строке содержится предложение - множество слов, разделенное одним или более пробелами. Заменить все вхождения одного слова в предложение другим словом.
        //4. Разобрать предложение на отдельные слова и вывести их на экран в столбик.
public class app {
    public static void main(String[] args) {
        String s1 = "qqq aaa ddd fff ggg ddd";
        String s2 = "ddd";
        String s3 = "ssss";
        String s4 = "abcd";
        String s5 = "abfg";

        System.out.println("Изменить порядок букв в слове на обратный. abcd");
        System.out.println(StringUtil.ReverseString(s4));
        System.out.println();
        System.out.println("Найти все буквы, которые присутствуют в одном слове и отсутствуют во втором dcba abfg");
        System.out.println(Arrays.toString(StringUtil.GetUniqueChar(s4, s5)));
        System.out.println();
        System.out.println("Заменить все вхождения одного слова в предложение другим словом. Предложение qqq aaa ddd fff ggg ddd, старое слово: ddd, новое qqqq");
        System.out.println(StringUtil.ChangeWord(s1, s2, s3));
        System.out.println();
        System.out.println("Разобрать предложение на отдельные слова и вывести их на экран в столбик qqq aaa qqqq fff ggg qqqq");
        StringUtil.GetArrayString(s1);
    }
}
