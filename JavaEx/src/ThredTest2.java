public class ThredTest2 implements Runnable{
    @Override
    public void run() {
        System.out.println(1);
    }

    public static void main(String[] args) {
        new Thread(new ThredTest2()).start();
      //  Thread t = new Thread(); t.run();
    }
}
