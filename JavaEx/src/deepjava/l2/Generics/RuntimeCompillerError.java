package deepjava.l2.Generics;

import java.util.ArrayList;
import java.util.List;

public class RuntimeCompillerError {

//    List students == List<Object> students

    public static Object getFirstValue(List listOfObject){
        return listOfObject.get(0);
    }

    public static String getFirstStringValue(List<String> listOfString){
        return listOfString.get(0);
    }

    public static void main(String[] args) {
        List<Integer> listOfNumbers = new ArrayList<Integer>();
        listOfNumbers.add(45);
        String name1 = (String) getFirstValue(listOfNumbers);       // Runtime error
       // String name2 =  getFirstStringValue(listOfNumbers); // Compiller error !

    }
}
