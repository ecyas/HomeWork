package collection.list.mylinkedlistimplementation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LinkedListPractice {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

        myLinkedList.add("Иван");
        myLinkedList.add("Александр");
        myLinkedList.add("Дмитрий");
        myLinkedList.add("Александр");
        myLinkedList.add("Виталий");

        System.out.println(myLinkedList.toString());

        System.out.println("myLinkedList.get(5) = " + myLinkedList.get(0));

        myLinkedList.add(5, "Ева");


        System.out.println(myLinkedList.toString());
        System.out.println(myLinkedList.size());


    }
}
