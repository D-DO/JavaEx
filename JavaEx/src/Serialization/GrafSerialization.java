//Например, сериализуемый объект A ссылается на объекты B и C, каждый из которых,
//        в свою очередь, ссылается на один и тот же объект D. После десериализации
//        не должно возникать ситуации, когда B ссылается на D1, а C – на D2, где
//        D1 и D2 – равные, но все же различные объекты.
//
//        Для организации такого процесса стандартный механизм сериализации строит
//        граф, включающий в себя все участвующие объекты и ссылки между ними. Если
//        очередная ссылка указывает на некоторый объект, сначала проверяется – нет
//        ли такого объекта в графе. Если есть – объект второй раз не сериализуется.
//        Если нет – новый объект добавляется в граф.
//
//        При построении графа может встретиться объект, порожденный от класса,
//        не реализующего интерфейс Serializable. В этом случае сериализация
//        прерывается, генерируется исключение java.io.NotSerializableException.


package Serialization;
import java.io.*;
class Point implements Serializable {
    double x;
    double y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return "("+x+","+y+") reference="+super.toString();
    }
}
class Line implements Serializable {
    Point point1;
    Point point2;
    int index;
    public Line() {
        System.out.println("Constructing empty line");
    }
    Line(Point p1, Point p2, int index) {
        System.out.println("Constructing line: " + index);
        this.point1 = p1;
        this.point2 = p2;
        this.index = index;
    }
    public int getIndex() { return index; }
    public void setIndex(int newIndex) { index = newIndex; }
    public void printInfo() {
        System.out.println("Line: " + index);
        System.out.println(" Object reference: " + super.toString());
        System.out.println(" from point "+point1);
        System.out.println(" to point "+point2);
    }
}

public class GrafSerialization {
    public static void main(String[] args) {
        Point p1 = new Point(1.0,1.0);
        Point p2 = new Point(2.0,2.0);
        Point p3 = new Point(3.0,3.0);
        Line line1 = new Line(p1,p2,1);
        Line line2 = new Line(p2,p3,2);
        System.out.println("line 1 = " + line1);
        System.out.println("line 2 = " + line2);
        String fileName = "file3.txt";
        try{
            // записываем объекты в файл
            FileOutputStream os = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(line1);
            oos.writeObject(line2);
            // меняем состояние line1 и записываем его еще раз
            line1.setIndex(3);
            //oos.reset();
            oos.writeObject(line1);
            // закрываем потоки
            // достаточно закрыть только поток-надстройку
            oos.close();
            // считываем объекты
            System.out.println("Read objects:");
            FileInputStream is = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(is);
            for (int i=0; i<3; i++) { // Считываем 3 объекта
                Line line = (Line)ois.readObject();
                line.printInfo();
            } ois.close();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}

//        В этой программе работа идет с классом Line (линия), который
//        имеет 2 поля типа Point (линия описывается двумя точками). Запускаемый
//        класс Main создает два объекта класса Line, причем, одна из
//        точек у них общая. Кроме этого, линия имеет номер (поле index ).
//        Созданные линии (номера 1 и 2) записываются в поток, после чего
//        одна из них получает новый номер (3) и вновь сериализуется.

    //    Выполнение этой программы приведет к выводу на экран примерно следующего:
//        Constructing line: 1
//        Constructing line: 2
//        line 1 = Serialization.Line@b684286
//        line 2 = Serialization.Line@880ec60
//        Read objects:
//        Line: 1
//        Object reference: Serialization.Line@6276ae34
//        from point (1.0,1.0) reference=Serialization.Point@7946e1f4
//        to point (2.0,2.0) reference=Serialization.Point@4520ebad
//        Line: 2
//        Object reference: Serialization.Line@5419f379
//        from point (2.0,2.0) reference=Serialization.Point@4520ebad
//        to point (3.0,3.0) reference=Serialization.Point@7dc7cbad
//        Line: 1
//        Object reference: Serialization.Line@6276ae34
//        from point (1.0,1.0) reference=Serialization.Point@7946e1f4
//        to point (2.0,2.0) reference=Serialization.Point@4520ebad
//
