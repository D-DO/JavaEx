import java.util.ArrayList;
import java.util.List;

class PrintBox {

    private Object val;

    PrintBox(Object arg) {
        val = arg;
    }

    public void print() {
        System.out.println("{" + val + "}");
    }

    public Object getVal(){
        return val;
    }


}

public class GenericTest {
    public static void main(String[] args) {
        PrintBox val1 = new PrintBox(10);

        Integer val2 = (Integer) val1.getVal();
        String[] str = new String[10];
        for (int i = 0; i < str.length; i++) {
            str[1]="ohsihtio";

        }

        ArrayList<String> list = new ArrayList<String>(10);
        ArrayList<String> list1 = new ArrayList<String>(list);

        List ddd = new ArrayList(10);

        ArrayList<String> list2 = new ArrayList<String>(ddd);
    }



}
