package lab3;

import java.io.Serializable;

//Класс Квадрат наследуется от класса Ромб
//номых полей и методов не вводит
public class Square extends Rhombus implements Serializable {
    public Square(double x1, double y1, double x2, double y2, double x4, double y4) {
        super(x1, y1, x2, y2, x4, y4);
    }

    public Square(double length) {
        super(length, 90);
    }

    @Override
    public String toString() {
        return "Square" + GetStringCoord();
    }
}
