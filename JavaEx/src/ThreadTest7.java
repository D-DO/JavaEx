public class ThreadTest7 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
//                for (int i = 0; i < 5; i++) {

                    try {
                        Thread.sleep(0);
                        System.out.print(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


//                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
//                for (int i = 0; i < 5; i++) {

                    try {
                        Thread.sleep(0);
                        System.out.print(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


//                }
            }
        }).start();
    }
}
