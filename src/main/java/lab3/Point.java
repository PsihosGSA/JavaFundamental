package lab3;

import java.io.Serializable;

public class Point implements Serializable {

    //Приватное поле описывающее координату точки состоит
    //из двухэлементного массива описывающего координаты
    private double[] vertex = new double[2];

    public Point(double x, double y) {
        setVertex(new double[]{x, y});
    }

    public double[] getVertex() {
        return vertex;
    }

    public void setVertex(double[] vertex) {
        this.vertex = vertex;
    }

    //возвращает строку содержащую тип и ее состояние фигуры
    //на которой вызвали метод
    @Override
    public String toString() {
        return String.format("Point{ vertex = [%.3f, %.3f]}", vertex[0], vertex[1]);
    }




    public void ChangeSize(double percent){}

    public void Turn(double degree){}

    //изменяет координаты всех вершин по осям абцис и ординат
    //на заданное в качестве аргументов количество единиц
    public void MovingAbscissa(double x){
        double[] temp = getVertex();
        temp[0] += x;
        setVertex(temp);
    }

    public void MovingOrdinate(double y){
        double[] temp = getVertex();
        temp[1] += y;
        setVertex(temp);
    }

    //Метод изменяет координаты переданные в качестве второго аргумента
    //таким образом что отрезок поворачиваеться в отношении координат
    //вершины переданной в качестве первого аргумента на угол переданный в
    //качестве третьего аргумента
    public double[] TurnSegment(double[] vertex1, double[] vertex2, double degree){
        double rx = vertex2[0] - vertex1[0];
        double ry = vertex2[1] - vertex1[1];
        double c = Math.cos(Math.PI * degree / 180.0);
        double s = Math.sin(Math.PI * degree / 180.0);
        return new double[]{(vertex1[0] + rx * c - ry * s),
                (vertex1[1] + rx * s + ry * c)};
    }
}
