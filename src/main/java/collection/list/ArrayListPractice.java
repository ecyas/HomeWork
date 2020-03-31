package collection.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListPractice {
    public static void main(String[] args) {
//  0.Содание списков: (Используя конструктор)
//        а). Создать пустой список
        List<String> list = new ArrayList();
//        б). Создать список размером 20
        List<String> list1 = new ArrayList(10);
//
//  1.Получить элемент по индексу:
//        а). Получить первый элемент
        //list.get(0);// выдаст NPE, поэтому лучше сперва закомментировать :)
//        б). Получить последний элемент
        //list.get(list.size() - 1);// выдаст NPE, поэтому лучше сперва закомментировать :)

//  2.Задачи на вставку элемента:
//        а) Добавить подряд 5 элементов.
        list.add("Один");
        list.add("Два");
        list.add("Три");
        list.add("Четыре");
        list.add("Пять");
//        б) Добавить шестой элемент в третию позицию. Добавить седьмой элемент в первую позицию.
        list.add(2, "Шесть");
        list.add(0, "Семь");
//        в) Записать в новый список все элементы предыдущего списка.
        list1.addAll(list);


//  3.Задачи на удаление элементов: (Используя методы)
//        а) Удалить элемент по значению
        list.remove("Четыре");
//        б) Удалить элемент по индексу
        list.remove(4);

//  4.Проверить наличие элемента
        list.contains("Шесть");

//  5.Вывод списка:
//        а) Вывести список на экран в формате: List: {"First";"Second";"Third"}
        System.out.print("List: {");
        for (String str : list) {
            System.out.print("\"" + str + "\";");
        }
        System.out.println("}");

//  6.Отфильтровать список вернуть записи по некоторому условию:
//        а) Условие на индекс: Индекс делится на 3
        System.out.println("modifiedList(list) = " + modifiedList(list));

//        б) Условие на значение: Вернуть количество элементов, которые равны "***"
        System.out.println("equalsElements(list) = " + equalsElements(list));

//  7.Пропустить несколько первых элементов
//        а) Пропустить первые 3 элемента в списке.
        skipFirstThreeElements(list);

//  6 + 7: Пропускаем элементы, которые удовлетворяют некоторому условию
//        а) Пропустить первые 2 элемента, которые равные "****"
        list1.add(1, "Два");
        System.out.println("list1 = " + list1);
        skipFirstTwoElementsEqualsSomeCondition(list1);

//  8. Вернуть первый подходящий элемент:
//        а) Возращаем Первый элемент Делящийся на 3.
        List<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            numbers.add(i);
        }
        divideFirstOnThree(numbers);

//  9. Возвращаем все элементы удовлетворяющие условию:
//        а) Возвращаем все элементы делящиеся на 3
        List<Integer> numbers1 = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            numbers1.add(i);
        }
        divideOnThree(numbers1);
    }

    public static void divideOnThree(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number % 3 == 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }

    public static void divideFirstOnThree(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number % 3 == 0) {
                System.out.print(number + " ");
                break;
            }
        }
        System.out.println();
    }

    private static void skipFirstTwoElementsEqualsSomeCondition(List<String> list) {
        int count = 0;
        for (String s : list) {
            if (count < 2) {
                if (s.length() == 4) {
                    count++;
                    continue;
                }
            }
            System.out.print(s + " ");
        }
        System.out.println();
    }

    private static void skipFirstThreeElements(List<String> list) {
        for (int i = 3; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }


    public static List<String> modifiedList(List<String> list) {
        List<String> anotherList = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            if (i % 3 == 0) {
                anotherList.add(list.get(i));
            }
        }
        return anotherList;
    }

    public static int equalsElements(List<String> list) {
        int count = 0;
        for (String s : list) {
            if (s.length() == 4) {
                count++;
            }
        }
        return count;
    }

}
