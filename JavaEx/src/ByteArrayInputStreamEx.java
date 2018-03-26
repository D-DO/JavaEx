import java.io.ByteArrayInputStream;

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
    }
}

//        first element read is: 1
//        second element read is: 255
//        third element read is: 0