package collection;

import java.util.*;

public class YouInTheArmyNow {
    public static void main(String[] args) {
        List<Person> soldiers = new ArrayList<>();
        soldiers.add(new Person("Vasya", "Man", 16));
        soldiers.add(new Person("Alex", "Man", 36));
        soldiers.add(new Person("Tom", "Man", 26));
        soldiers.add(new Person("Bob", "Man", 19));
        soldiers.add(new Person("John", "Man", 18));
        soldiers.add(new Person("Kate", "Woman", 16));
        soldiers.add(new Person("Susan", "Woman", 46));
        soldiers.add(new Person("Megan", "Woman", 30));
        soldiers.add(new Person("Nik", "Man", 19));
        soldiers.add(new Person("Natan", "Man", 25));

        soldiers.forEach(System.out::println);
        System.out.println("-----------------------------");
        universalSoldiers(soldiers);

        Collections.sort(soldiers, Comparator.comparing(Person::getName).thenComparing(Person::getAge));

        soldiers.forEach(System.out::println);

    }

    public static List<Person> universalSoldiers(List<Person> list) {
        ListIterator<Person> personListIterator = list.listIterator();
        while (personListIterator.hasNext()) {
            Person p = personListIterator.next();
            if (!(p.getSex().equals("Man")) || p.getAge()<18 || p.getAge()>27) {
                personListIterator.remove();
            }
        }
        return list;
    }
}
