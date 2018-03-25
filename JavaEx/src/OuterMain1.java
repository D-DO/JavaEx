public class OuterMain1 {
    public static void main(String[] args) {
        OuterClass1 outerClass1 = new OuterClass1();
        OuterClass1.InnerClass innerClass = outerClass1.getInnerClass();
        System.out.println("getOutInt = " + innerClass.getOutInt());
    }
}

//getOutInt = 10