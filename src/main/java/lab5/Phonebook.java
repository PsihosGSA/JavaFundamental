package lab5;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//На базе подходящего контейнерного класса разработать класс «Телефонный справочник», который бы содержал
// произвольное количество абонентов. Для каждого абонента известна фамилия и один номер телефона. Фамилии
// разных абонентов могут быть одинаковыми, номера телефонов - нет. Справочник должен иметь методы поиска
// номеров телефонов по фамилии и поиска фамилии по номеру телефона. Базовый контейнерный класс выбрать самостоятельно.

//     1. Добавить в класс «Телефонный справочник» методы сохранения справочника в файле и загрузки справочника из файла.
//     2. Добавить возможность пополнения справочника новыми абонентами с клавиатуры.


//Класс Phonebook реализует базу данный «Телефонный справочник»
//БД постоена на основе контейнера HashMap<String, String>
//в качестве ключа используется номер телефона в виде строку, а в качестве значения - фамилия
//класс включает в себя метод main который запускает работу с БД
//также включены методы
//addPB - добавляет запись по заданным номеру телефона и фамилии
//delPB - удаляет запись по номеру телефона
//savePB - сохраняет БД в текстовом файле phone.txt
//loadPB - загружает БД из текстового файла phone.txt
//PrintPhonebook - выводит на екран все записи БД
//FindSurname - производит поиск фамилии по номеру телефона
//FindNumberPhone - производит поиск списка номеров по фамилии

public class Phonebook {
    private static HashMap<String, String> pb = new HashMap<String, String>();

    //addPB - добавляет запись по заданным номеру телефона и фамилии
    private static void addPB(String phone, String name) {
        pb.put(phone, name);
    }

    //delPB - удаляет запись по номеру телефона
    private static void delPB(String phone) {
        pb.remove(phone);
    }

    //savePB - сохраняет БД в текстовом файле phone.txt
    private static void savePB() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("phone.txt")));
        for(Map.Entry<String,String> k: pb.entrySet()){
            writer.write(k.getKey() + " " + k.getValue()+System.lineSeparator());
        }
        writer.close();
    }

    //loadPB - загружает БД из текстового файла phone.txt
    //производит проверку на наличие файла
    public static void loadPB() throws IOException {
        File file = new File("phone.txt");
        if (file.exists()){
            BufferedReader reader = new BufferedReader(new FileReader(new File("phone.txt")));
            String act;
            while ((act=reader.readLine())!=null) {
                String[] dat = act.split(" ");
                pb.put(dat[0], dat[1]);
            }
            reader.close();
        }
    }

    //PrintPhonebook - выводит на екран все записи БД
    public static void PrintPhonebook(){
        System.out.println("Телефонный справочник: ");
        for(Map.Entry<String,String> k: pb.entrySet()){
            System.out.println(k.getValue()+": "+ k.getKey());
        }
    }

    //FindSurname - производит поиск фамилии по номеру телефона заданому в качестве аргумента
    //возвращает строку
    public static String FindSurname(String number){
        String result = pb.get(number);
        if (result == null) return "абонент с таким номером не найдей";
        return result;
    }

    //FindNumberPhone - производит поиск списка номеров по фамилии заданой в качестве аргумента
    //возвращает массив строк
    public static String[] FindNumberPhone(String surname){
        List <String> result = new ArrayList<String>();
        for (Map.Entry entry : pb.entrySet()) {
            if (surname.equalsIgnoreCase((String)entry.getValue())){
                result.add((String)entry.getKey());
            }
        }
        if (result.size() == 0) result.add("абонент с такой фамилией не найден");
        return result.toArray(new String[0]);
    }

    public static void main(String[] args) throws IOException {
        //переменная описывает вызываемое действие
        String act;

        //загрузка БД
        loadPB();
        //вывод записей на екран
        PrintPhonebook();

        //вывод на екран описания возможных действий с указанием команд
        System.out.println("выбор действия: (add)добавить данные, (del)удалить данные, (num) найти номера по фамилии, (sur)найти фамилию, " +
                            "(save)сохранить, (exit)выход");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        act = bf.readLine();
        while(!act.equals("exit")){
            //добавление записи
            if(act.equals("add")){
                System.out.println("Введите фамилию:");
                String name = bf.readLine();
                System.out.println("Введите телефон:");
                String phone = bf.readLine();
                addPB(phone, name);
            }else{
                //удаление записи
                if(act.equals("del")){
                    System.out.println("Введите телефон:");
                    String phone = bf.readLine();
                    delPB(phone);
                }else{
                    //поиск номеров по фамилии
                    if (act.equals("num")){
                        System.out.println("Введите фамилию:");
                        String surname = bf.readLine();
                        String[] numbers = FindNumberPhone(surname);
                        for (String number : numbers) {
                            System.out.println(number);
                        }
                    } else {
                        //поиск фамилии по номеру
                        if (act.equals("sur")) {
                            System.out.println("Введите номер:");
                            String number = bf.readLine();
                            System.out.println(FindSurname(number));
                        } else {
                            //сохранение БД в файл
                            if(act.equals("save")){
                                savePB();
                            }
                        }
                    }
                }
            }
            //запрос на следующее действие
            System.out.println("выбор действия: (add)добавить данные, (del)удалить данные, (num) найти номера по фамилии, (sur)найти фамилию, (save)сохранить, (exit)выход");
            act=bf.readLine();
        }
    }
}
