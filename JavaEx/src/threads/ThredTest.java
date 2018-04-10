package threads;

import static java.lang.Thread.sleep;

public class ThredTest {
    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(1);
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    t1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(2);
            }
        });

        t1.start();
        t2.start();
    }
}
