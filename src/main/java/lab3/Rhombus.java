package lab3;

import java.io.Serializable;

//класс Ромб наследуется от класса Четырехугольник
//Методы и поля заимствуются из материнского класса
public class  Rhombus extends Quadrilateral implements Serializable {

    //конструктор в качестве аргументов принимает координаты
    //трех вершин которые составляют две прилегающих стороны
    //координаты четвертой вершины вычисляются
    public Rhombus(double x1, double y1, double x2, double y2, double x4, double y4) {
        super(x1, y1, x2, y2,(x2 + x4 - x1), (y2 + y4 - y1), x4, y4);
    }

    //конструктор принимающий в качестве аргументов длину стороны фигуры и
    //прилегающего угла создает фигуру вершина А которой находиться в начале координат а вершина D
    //расположена на оси абцисс вызывает конструктор с 4 переменными и передает длину стороны в качестве первого
    //аргумента остальные аргументы равны нулю после чего вычисляет координаты тертьей вершины при помощи метода TurnSegment
    public Rhombus(double length, double degree){
        super(0, 0, 0, 0, 0, 0, length, 0);
        setVertexB(TurnSegment(getVertex(), getVertexD(), degree));
        setVertexC(TurnSegment(getVertexB(), getVertex(), 180 - degree));
    }

    @Override
    public String toString() {
        return "Rhombus" + GetStringCoord();
    }
}
