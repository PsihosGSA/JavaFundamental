package lab3;

import java.io.Serializable;

//Класс Трапеция наследуется от Четырехугольника
//новый полей и методов не вводит
public class Trapezium extends Quadrilateral  implements Serializable {
    public Trapezium(double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {
        super(x1, y1, x2, y2, x3, y3, x4, y4);
    }

    @Override
    public String toString() {

        return "Trapezium" + GetStringCoord();
    }
}
