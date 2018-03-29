package Serialization;

import java.io.*;

public class SimpleSerialization {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        Чтобы начать сериализацию объекта, нужен выходной поток OutputStream, в который и будет
//        записываться сгенерированная последовательность байт. Этот поток передается в конструктор
//        ObjectOutputStream. Затем вызовом метода writeObject() объект сериализуется и записывается
//        в выходной поток. Например:

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Object objSave = new Integer(1);
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(objSave);

        // Чтобы увидеть, во что превратился объект objSave, можно просмотреть содержимое массива:

        byte[] bArray = bos.toByteArray();

        // А чтобы восстановить объект, его нужно десериализовать из этого массива:

        ByteArrayInputStream bis = new ByteArrayInputStream(bArray);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Object objRead = ois.readObject();

        //Теперь можно убедиться, что восстановленный объект идентичен исходному:

        System.out.println("readed object is: " + objRead.toString());
        System.out.println("Object equality is: " + (objSave.equals(objRead)));
        System.out.println("Reference equality is: " + (objSave == objRead));

//        Как мы видим, восстановленный объект не совпадает с исходным (что очевидно – ведь восстановление
//                могло происходить и на другой машине), но равен сериализованному по значению.
    }
}
//        readed object is: 1
//        Object equality is: true
//        Reference equality is: false