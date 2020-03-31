package interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Aleksandr", "Kolosov", 35));
        persons.add(new Person("Aleksandr", "Kolosov", 33));
        persons.add(new Person("Aleksandr", "Kolosov", 25));
        persons.add(new Person("Aleksandr", "Kolosov", 23));
        persons.add(new Person("Aleksandr", "Kolosov", 15));

        Collections.sort(persons);

        persons.forEach(System.out::println);
    }
}
