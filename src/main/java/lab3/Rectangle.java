package lab3;

import java.io.Serializable;

    //Класс Прямоугольник
    //методов и полей не добавляет
public class Rectangle extends Quadrilateral implements Serializable {

    //конструктор в качестве аргументов принимает координаты
    //трех вершин которые составляют две прилегающих стороны
    //координаты четвертой вершины вычисляются
    public Rectangle(double x1, double y1, double x2, double y2, double x4, double y4) {
        super(x1, y1, x2, y2,(x2 + x4 - x1), (y2 + y4 - y1), x4, y4);
    }

    @Override
    public String toString() {
        return "Rectangle" + GetStringCoord();
    }
}
