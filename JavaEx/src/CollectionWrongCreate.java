import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class CollectionWrongCreate {

    public static void main(String[] args) {

        HashSet<String> s = new LinkedHashSet<>();

        Set<String> s1 = new TreeSet<>();

        Set<String> s2 = new HashSet<>();

//        HashSet<String> s3 = new TreeSet<String>();


    }
}
