package interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Aleksandr", "Kolosov", 35));
        persons.add(new Person("Vitaliy", "Nezhiskiy", 29));
        persons.add(new Person("Aleksey", "Kolosov", 33));
        persons.add(new Person("Ekaterina", "Kolosova", 34));
        persons.add(new Person("Eva", "Kolosova", 6));
        persons.add(new Person("Olga", "Chemodurova", 70));

        Collections.sort(persons);

        persons.forEach(System.out::println);
    }
}
