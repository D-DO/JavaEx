package deepjava.l2.Generics;

import java.util.ArrayList;
import java.util.List;

public class GenMethod {

    public static <T> T getFirst(List<T> list){
        return list.get(0);
    }

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(7);
        Integer integer = getFirst(integerList);
        System.out.println(integer);

        List<String> stringList = new ArrayList<>();
        stringList.add("String");
        String string = getFirst(stringList);
        System.out.println(string);

    }
}
