import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetEx {
    public static void main(String[] args) {
        SortedSet<String> countrySet = new TreeSet<>();
        countrySet.add("вРоссия");
        countrySet.add("бФранция");
        countrySet.add("яГондурас");
        countrySet.add("аКот-Д'Ивуар"); // любимая страна всех котов

        String d = new String("sdf");
        System.out.println(countrySet.toString());
    }

}
