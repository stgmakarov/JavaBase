import java.util.HashSet;
import java.util.Set;

/**
 * @author Stanislav Makarov
 */
public class SetsOnMyObj {
    public static void main(String[] args) {
        Set<Person> testSet = new HashSet<>();

        testSet.add(new Person(1,"Bob"));
        testSet.add(new Person(1,"Bob"));

        System.out.println(testSet);
    }

}

class Person {
    int id;
    String name;

    public Person (int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " - "+name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person person)) return false;

        return id == person.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

/*    @Override
    public int compareTo(Object o) {
        return Integer.compare(name.length(), ((Person) o).name.length());
    }*/
}
