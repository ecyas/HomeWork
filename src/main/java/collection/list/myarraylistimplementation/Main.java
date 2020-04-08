package collection.list.myarraylistimplementation;

import collection.Person;

public class Main {
    public static void main(String[] args) {

        MyArrayList<Person> myList1 = new MyArrayList<>();
        myList1.add(new Person("Aleksandr", "Male", 35));
        myList1.add(new Person("Eva", "Female", 6));


        MyArrayList<Person> myList2 = new MyArrayList<>(Person.class);
        myList2.add(new Person("Bob", "Male", 45));
        myList2.add(new Person("Tom", "Male", 24));
        myList2.add(new Person("Alex", "Male", 35));
        myList2.add(new Person("Kate", "Female", 34));
        myList2.add(new Person("Jack", "Male", 34));
        myList2.add(new Person("Megan", "Female", 35));

        MyArrayList<Person> myList3 = new MyArrayList<>();

        System.out.println("myList3.size() = " + myList3.size());

        myList3.addAll(myList1);
        System.out.println("myList3.size() = " + myList3.size());

        System.out.println(myList1.containsAll(myList3));


    }
}
