public class OuterClass2 {

    private int outInt = 10;

    class InnerClass{
        int innerInt;

        public InnerClass() {
        }

        public InnerClass(int i) {
            innerInt = i;
        }

        int getOutInt(){
            return outInt;
        }

        public int getInnerInt() {
            return innerInt;
        }
    }

    InnerClass getInnerClass(){
        return  new InnerClass();    }

    InnerClass getInnerClass(int i){
        return  new InnerClass(i);
    }

}
