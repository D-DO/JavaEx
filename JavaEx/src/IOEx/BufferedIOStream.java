package IOEx;

import java.io.*;

public class BufferedIOStream {
    public static void main(String[] args) {

        try {
            String fileName = "file3.txt";
            InputStream inStream = null;
            OutputStream outStream = null;

            //Записать в файл некоторое количество байт
            long timeStart = System.currentTimeMillis();
            outStream = new FileOutputStream(fileName);
           // outStream = new BufferedOutputStream(outStream);
            for (int i = 1024000; --i >= 0; ) {
                outStream.write(i);
            }
            long time = System.currentTimeMillis() - timeStart;
            System.out.println("Direct Writing time: " + time + " millisec");
            outStream.close();

            //Записать в файл некоторое количество байт
            timeStart = System.currentTimeMillis();
            outStream = new FileOutputStream(fileName);
            outStream = new BufferedOutputStream(outStream);
            for (int i = 1024000; --i >= 0; ) {
                outStream.write(i);
            }
            time = System.currentTimeMillis() - timeStart;
            System.out.println("Buffered Writing time: " + time + " millisec");
            outStream.close();

            // Определить время считывания без буферизации
            timeStart = System.currentTimeMillis();
            inStream = new FileInputStream(fileName);
            while (inStream.read() != -1) {
            }
            time = System.currentTimeMillis() - timeStart;
            inStream.close();
            System.out.println("Direct read time: " + (time) + " millisec");

            // Теперь применим буферизацию
            timeStart = System.currentTimeMillis();
            inStream = new FileInputStream(fileName);
            inStream = new BufferedInputStream(inStream);
            while (inStream.read() != -1) {
            }
            time = System.currentTimeMillis() - timeStart;
            inStream.close();
            System.out.println("Buffered read time: " + (time) + " millisec");
        } catch (IOException e) {
            System.out.println("IOException: " + e.toString());
            e.printStackTrace();
        }
    }
}

//      Direct Writing time: 2153 millisec
//      Buffered Writing time: 15 millisec
//      Direct read time: 1779 millisec
//      Buffered read time: 31 millisec
