import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayInputStreamEx {
    public static void main(String[] args) {
        byte[] bytes = {1, -1, 0};
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        int readedInt = in.read(); // readedInt=1
        System.out.println("first element read is: " + readedInt);
        readedInt = in.read();
// readedInt=255. Однако
// (byte)readedInt даст значение -1

//        System.out.println("second element read is: " + (byte)readedInt);
        System.out.println("second element read is: " + readedInt);
        readedInt = in.read(); // readedInt=0
        System.out.println("third element read is: " + readedInt);



        ByteArrayOutputStream out =
                new ByteArrayOutputStream();
        out.write(10);
        out.write(11);
        byte[] bytes1 = out.toByteArray();
        in = new ByteArrayInputStream(bytes1);
        readedInt = in.read();
        System.out.println("ByteArrayOutputStream 1 is: " + readedInt);
        readedInt = in.read();
        System.out.println("ByteArrayOutputStream 2 is: " + readedInt);


    }
}

//        first element read is: 1
//        second element read is: 255
//        third element read is: 0