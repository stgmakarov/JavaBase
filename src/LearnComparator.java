import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Stanislav Makarov
 */
public class LearnComparator {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(100,"Stas"));
        persons.add(new Person(1,"Alexandra"));
        persons.add(new Person(50,"Nil"));

        Collections.sort(persons);
        System.out.println(persons);
    }
}

