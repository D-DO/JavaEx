public class OuterMain2 {
    public static void main(String[] args) {
        OuterClass2 outerClass2 = new OuterClass2();
        OuterClass2.InnerClass ic1 = outerClass2.getInnerClass(1);
        OuterClass2.InnerClass ic2 = outerClass2.getInnerClass(2);

        System.out.println(ic1.getInnerInt());
        System.out.println(ic2.getInnerInt());
        System.out.println(ic1.getOutInt());
        System.out.println(ic2.getOutInt());
    }
}

//        1
//        2
//        10
//        10