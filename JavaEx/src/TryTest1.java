import java.util.*;

public class TryTest1 {
    public static void main(String[] args) {
//

        HashMap<String, Integer> map1 = new LinkedHashMap<>();
        Map<String, Integer> map = new HashMap<>();
        NavigableMap<String, Integer> fgfg = new TreeMap<>();

//        Collection<String, Integer> fgfg1 = new HashMap<>();// Wrong!!!


        try {
            return;
        } finally {
            System.out.println("Finnaly");
        }
    }
}
