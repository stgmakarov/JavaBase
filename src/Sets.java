import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Stanislav Makarov
 */
public class Sets {
    private int id;

    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();
        Set<String> linkedHashSet = new LinkedHashSet<>();
        Set<String> treeSet = new TreeSet<>();

        testSet(hashSet);
        testSet(linkedHashSet);
        testSet(treeSet);

        hashSet.add("Mike");
        hashSet.add("Bob");
        hashSet.add("Michale");
        hashSet.add("Tom");
        hashSet.add("Tim");

        Set<String> hashSet2 = new HashSet<>();
        hashSet2.add("Mike");
        hashSet2.add("Timur");

        //объедиинение
        Set<String> hashSetUnion = new HashSet<>(hashSet);
        hashSetUnion.addAll(hashSet2);
        System.out.println(hashSetUnion);

        //разность
        Set<String> hashSetSubstration = new HashSet<>(hashSet);
        hashSetSubstration.removeAll(hashSet2);
        System.out.println(hashSetSubstration);

        //пересечение
        Set<String> hashSetIntersection = new HashSet<>(hashSet);
        hashSetIntersection.retainAll(hashSet2);
        System.out.println(hashSetIntersection);

    }

    public static void testSet(Set<String> set){
        set.add("Mike");
        set.add("Bob");
        set.add("Michale");
        set.add("Tom");
        set.add("Tim");

        set.forEach(v->{
            System.out.println(v);
        });

        System.out.println("------------------------");
    }
}
