public class IncTest {
    public static void main(String[] args) {
        int a = 20;
        a = --a - 1;
        System.out.println(a);

        a = 20;
        a = a-- - 1;
        System.out.println(a);

    }
}
