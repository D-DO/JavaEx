public class RecursionEx {

    static int factorial(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return factorial(n - 1) * n;
        }
    }


    static int fibonachi(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1)
            return 1;
        else if (n == 2)
            return 1;

        return fibonachi(n - 2) + fibonachi(n - 1);
    }


    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            System.out.print(factorial(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonachi(i) + " ");
        }


    }
}
