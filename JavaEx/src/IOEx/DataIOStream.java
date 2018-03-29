package IOEx;

import java.io.*;

public class DataIOStream {
    public static void main(String[] args) {
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            DataOutputStream outData = new DataOutputStream(out);
            outData.writeByte(128);
            // этот метод принимает аргумент int, но записывает
            // лишь младший байт
            outData.writeInt(128);
            outData.writeLong(128);
            outData.writeDouble(128);
            outData.close();
            byte[] bytes = out.toByteArray();
            InputStream in = new ByteArrayInputStream(bytes);
            DataInputStream inData = new DataInputStream(in);
            System.out.println("Чтение в правильной последовательности: ");
            System.out.println("readByte: " + inData.readByte());
            System.out.println("readInt: " + inData.readInt());
            System.out.println("readLong: " + inData.readLong());
            System.out.println("readDouble: " + inData.readDouble());
            inData.close();
            System.out.println("Чтение в измененной последовательности:");
            in = new ByteArrayInputStream(bytes);
            inData = new DataInputStream(in);
            System.out.println("readInt: " + inData.readInt());
            System.out.println("readDouble: " + inData.readDouble());
            System.out.println("readLong: " + inData.readLong());
            inData.close();
        } catch (Exception e) {
            System.out.println("Impossible IOException occurs: " +
                    e.toString());
            e.printStackTrace();
        }
    }
}
//        Чтение в правильной последовательности:
//        readByte: -128
//        readInt: 128
//        readLong: 128
//        readDouble: 128.0
//        Чтение в измененной последовательности:
//        readInt: -2147483648
//        readDouble: -0.0
//        readLong: -9205252085229027328
