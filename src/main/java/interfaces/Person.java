package interfaces;

public class Person implements Comparable<Person>, Cloneable{
    private String name;
    private String surName;
    private int age;

    public Person(String name, String surName, int age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }

    public int compareTo(Person person) {
        return getSurName().compareTo(person.getSurName()) == 0 ? getName().compareTo(person.getName()) == 0 ? getAge() - person.getAge();
    }
}
