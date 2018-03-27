package StringExamples;

public class StringEx2 {
    public static void main(String[] args) {


        String a1 = "qwe";
        String a2 = new String("qwe");
        a2.intern();
        System.out.println(a1 == a2);

        String a11 = "qwe";
        String a22 = new String("qwe");
        a22 = a22.intern();
        System.out.println(a11 == a22);

        String s1 = "Hello";
        String s2 = new String("Hello");
        String s3 = new String("Hello");
        System.out.println(s1==s2);
        System.out.println(s2==s3);
        System.out.println(s1==s3);
        s3=s3.intern();
        System.out.println(s1==s3);


    }
}

//        false
//        true
//        false
//        false
//        false
//        true

