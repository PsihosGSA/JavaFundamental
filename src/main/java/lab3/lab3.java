package lab3;

import java.io.IOException;

/**
 * Created by Serge on 17.05.2017.
 */
public class lab3 {
    public static void main(String[] args) throws IOException {
        //1. Объявить систему классов: Точка Прямоугольник, Квадрат, Ромб, Трапеция, Треугольник, Четырехугольник.
        //2. Определить методы, которые перемещают фигуры по плоскости, изменяют ее размеры и выводят в стандартный выходной поток.

        //Создание экземпляров фигур по одному на каждый конструктор
        Point point = new Point(1, 1);
        Point triangle = new Triangle(1, 1, 2, 2, 3, 1);
        Point quadrilateral = new Quadrilateral(1, 1, 2, 2, -1, 4, 5, -1);
        Point trapez = new Trapezium(0, 0, 2, 2, 4, 2, 6, 0);
        Point rhomb = new Rhombus(1, 1, 2, 2, 2, 0);
        Point rhomb2 = new Rhombus(2, 60);
        Point rectang = new Rectangle(1, 1, 1, 2, 2, 1);
        Point square = new Square(1, 1, 1, 3, 3, 1);
        Point square1 = new Square(4);

        //создание и инициация массива создаными объектами
        Point[] figures = new Point[]{point, triangle, quadrilateral, trapez, rhomb, rhomb2, rectang, square, square1};

        //перебор массива в цикле и выведение результатов работы методов
        for (Point figure : figures) {
            //вывод строки созданной методом ToString
            System.out.println(figure);
            System.in.read();

            //перемещение фигуры на 1 единицу по осям абцис и ординат
            //вывод состояния фигуры после перемещения
            figure.MovingAbscissa(1);
            figure.MovingOrdinate(1);
            System.out.println("после перемещения на x=1 y=1");
            System.out.println(figure);
            System.in.read();

            //поворот фигуры на угол 45 градусов и вывод состояния фигуры после операции
            figure.Turn(45);
            System.out.println("после поворота");
            System.out.println(figure);
            System.in.read();

            //увеличение фигуры в 1,5 раза и вывод состояния фигуры после операции
            figure.ChangeSize(150);
            System.out.println("после изменения размера");
            System.out.println(figure);
            System.in.read();

        }

        System.out.println("завершение демонстрации");
    }
}
