package Serialization;


import java.io.*;

//В этом примере объявлено 3 класса. Класс Parent не реализует Serializable и, следовательно,
//        не может быть сериализован. В нем объявлено 2 поля, которые при создании получают значения,
//        содержащие слово "old" ("старый"). Кроме этого, объявлен метод, позволяющий модифицировать
//        эти поля. Он выставляет им значения, содержащие слово "new" ("новый’). Также переопределен " +
//        "метод toString(), чтобы дать возможность узнать значения этих полей.
//
//        Поскольку класс Parent имеет доступный конструктор по умолчанию, его наследник может реализовать
//        интерфейс Serializable. Обратите внимание, что у самого класса Child такого конструктора уже нет.
//        Также объявлено поле и модифицирован метод toString().
//
//        Наконец, класс Child2 наследуется от Child, а потому автоматически является допустимым
//        для сериализации. Аналогично, имеет новое поле, значение которого отображает toString().
//
//        Запускаемый класс Test сериализует в файл output.bin два объекта. Обратите внимание, что
//        у первого из них предварительно вызывается метод changeNames(), который модифицирует
//        значения полей, унаследованных от класса Parent.


// Родительский класс, не реализующий Serializable
class Parent {
    public String firstName;
    private String lastName;

    public Parent() {
        System.out.println("Create Parent");
        firstName = "old_first";
        lastName = "old_last";
    }

    public void changeNames() {
        firstName = "new_first";
        lastName = "new_last";
    }

    public String toString() {
        return super.toString() + ",first=" + firstName + ",last=" + lastName;
    }
}

// Класс Child, впервые реализовавший Serializable
class Child extends Parent implements Serializable {
    private int age;

    public Child(int age) {
        System.out.println("Create Child");
        this.age = age;
    }

    public String toString() {
        return super.toString() + ",age=" + age;
    }
}

// Наследник Serializable-класса
class Child2 extends Child {
    private int size;

    public Child2(int age, int size) {
        super(age);
        System.out.println("Create Child2");
        this.size = size;
    }

    public String toString() {
        return super.toString() + ",size=" + size;
    }
}
// Запускаемый класс для теста
public class ImplSerialization {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("output.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            Child c = new Child(2);
            c.changeNames();
            System.out.println(c);
            oos.writeObject(c);
            oos.writeObject(new Child2(3, 4));
            oos.close();
            System.out.println("Read objects:");
            FileInputStream fis = new FileInputStream("output.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            System.out.println(ois.readObject());
            System.out.println(ois.readObject());
            ois.close();
        } catch (Exception e) { // упрощенная обработка для краткости
            e.printStackTrace();
        }
    }
}
//         Create Parent
//         Create Child
//         Serialization.Child@483bf400,first=new_first,last=new_last,age=2
//         Create Parent
//         Create Child
//         Create Child2

//         Read objects:

//         Create Parent
//         Serialization.Child@5dfcfece,first=old_first,last=old_last,age=2
//         Create Parent
//         Serialization.Child2@23ceabc1,first=old_first,last=old_last,age=3,size=4

//    Во всех конструкторах вставлена строка, выводящая сообщение на консоль.
//        Так можно отследить, какие конструкторы вызываются во время десериализации.
//        Видно, что для объектов, порожденных от Serializable -классов, конструкторы
//        не вызываются вовсе. Идет обращение лишь к конструктору без параметров не-
//        Serializable -суперкласса.
//
//        Сравним значения полей первого объекта и его копии, полученной десериализацией.
//        Поля, унаследованные от не- Serializable -класса ( firstName, lastName ),
//        не восстановились. Они имеют значения, полученные в конструкторе Parent без
//        параметров. Поля, объявленные в Serializable -классе, свои значения сохранили.
//        Это верно и для второго объекта – собственные поля Child2 и унаследованные
//        от Child имеют точно такие же значения, что и до сериализации. Их значения
//        были записаны, а потом считаны и напрямую установлены из потока данных.

//    Для исключения поля объекта из сериализации его необходимо объявить с модификатором
//transient. Например, следующий класс:
//
//class Account implements
//        java.io.Serializable {
//    private String name;
//    private String login;
//    private transient String password;
//   /* объявление других элементов класса
//   ...
//   */
//}
//
//    У такого класса поле password в сериализации участвовать не будет и при
//    восстановлении оно получит значение по умолчанию (в данном случае null ).