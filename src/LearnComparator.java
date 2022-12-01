import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

        Collections.sort(persons,new PersonSort());
        System.out.println(persons);
    }
}

class PersonSort implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return Integer.compare(o1.name.length(), o2.name.length());
    }
}