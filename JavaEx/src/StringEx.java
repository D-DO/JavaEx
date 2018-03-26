public class StringEx {
    public static void main(String[] args) {
        String a1 = new String("qwe");
        String a2 = "qwe";
        System.out.println(a1==a2);

        String aa1 = "qwe";
        String aa2 = "qwe";
        System.out.println(aa1==aa2);

        String az2 = "qwe";
        String az1 = new String("qwe");
        System.out.println(az1==az2);

        System.out.println(aa1==az2);


    }
}
//        false
//        true
//        false
//        true