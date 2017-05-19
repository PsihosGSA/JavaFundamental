package lab3;

import java.io.Serializable;

    //Класс Треугольник наследуется от класса Точка
    //добавляет два поля определяющие вместе с рродительским полем координаты вершин треугольника
public class Triangle extends Point implements Serializable {
    private double[] vertexB = new double[2];
    private double[] vertexC = new double[2];

    //Конструктор принимает в качестве аргументов координаты трех вершин
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        super(x1, y1);
        setVertexB(new double[]{x2, y2});
        setVertexC(new double[]{x3, y3});
    }

    public double[] getVertexB() {
        return vertexB;
    }

    public void setVertexB(double[] vertexB) {
        this.vertexB = vertexB;
    }

    public double[] getVertexC() {
        return vertexC;
    }

    public void setVertexC(double[] vertexC) {
        this.vertexC = vertexC;
    }

    @Override
    public String toString() {
        double[] tmpVertex = getVertex();
        return String.format(
                "Triangle{ vertex A = [%.3f, %.3f], vertex B = [%.3f, %.3f], vertex C = [%.3f, %.3f]}",
                tmpVertex[0], tmpVertex[1], vertexB[0], vertexB[1], vertexC[0], vertexC[1]);
    }

    //метод изменяет координаты фигуры при которых фигура изменит свой размер
    //в процентном соотношении заданом в качестве аргумента
    //координаты точки А не меняются
    public void ChangeSize(double percent){
        double[] tempA = getVertex();
        vertexB[0] = (vertexB[0] - tempA[0]) * percent / 100 + tempA[0];
        vertexB[1] = (vertexB[1] - tempA[1]) * percent / 100 + tempA[1];
        vertexC[0] = (vertexC[0] - tempA[0]) * percent / 100 + tempA[0];
        vertexC[1] = (vertexC[1] - tempA[1]) * percent / 100 + tempA[1];
    }

    //метод Turn() изменяет координаты всех вершин при котором
    //фигура вращается по отношению к вершине А на указанный в качестве аргумента угол
    //для вычисления изменения координат используеться базовый метод после чего
    //метод TurnSegment() которому в качестве аргументов передаються свойства
    //описывающие координаты вершин и угол
    public void Turn(double degree){
        setVertexB(TurnSegment(getVertex(), getVertexB(), degree));
        setVertexC(TurnSegment(getVertex(), getVertexC(), degree));
    }

    //изменяет координаты всех вершин по осям абцис и ординат
    //на заданное в качестве аргументов количество единиц
    public void MovingAbscissa(double x){
        super.MovingAbscissa(x);
        double[] temp = getVertexB();
        temp[0] += x;
        setVertexB(temp);
        temp = getVertexC();
        temp[0] += x;
        setVertexC(temp);
    }

    public void MovingOrdinate(double y){
        super.MovingOrdinate(y);
        double[] temp = getVertexB();
        temp[1] += y;
        setVertexB(temp);
        temp = getVertexC();
        temp[1] += y;
        setVertexC(temp);    }

}
