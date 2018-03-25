public class OuterClass1 {

    private int outInt = 10;

    class InnerClass{

        int getOutInt(){
            return outInt;
        }
    }

    InnerClass getInnerClass(){
        return  new InnerClass();
    }

}
