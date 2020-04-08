package collection.list.myarraylistimplementation;

import java.lang.reflect.Array;
import java.util.*;

public class MyArrayList<E> {

    private E[] array;

    private static final int DEFAULT_CAPACITY = 10;

    private int size;

    private Class<E> eclass;

    public MyArrayList() {
        array = (E[])new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            array = (E[])new Object[DEFAULT_CAPACITY];
        }
        array = (E[])new Object[initialCapacity];
    }

    public MyArrayList(Class<E> eclass) {
        this.eclass = eclass;
        array = (E[])Array.newInstance(eclass, size);
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private boolean isFull() {
        return array.length == size();
    }


    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }


    public E[] toArray(){
        return getInstance((Class<E>) Object.class);
    }

    private E[] getInstance(Class<E> eclass) {
        this.eclass = eclass;
        E[] newArray = (E[])Array.newInstance(eclass, size);
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
        return array;
    }

//    public Object[] toArray(E[] t) {
//        return (E[]) Arrays.copyOf(array, array.length, t.getClass());
//    }


    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            a = (T[])Array.newInstance(a.getClass().getComponentType(), size);
        }
        System.arraycopy(array, 0, a, 0, size);
        if (size < a.length) {
            array[size] = null;
        }
        return a;
    }


//    public Object[] toArray() {
//        return toArray(new Object[0]);
//    }


    public boolean add(E element) {
        if (isFull()) {
            grow();
        }
        array[size++] = element;
        return true;
    }


    public boolean remove(E element) {
        if (contains(element)) {
            for (int i = indexOf(element); i < size - 1; i++) {
                array[i] = array[i + 1];
            }
        }
        array[size - 1] = null;
        size--;
        return false;
    }


    public boolean addAll(MyArrayList<? extends E> c) {
        Object[] a = c.toArray();
        int resultSize = size;
        if ((array.length - size()) < c.size()) {
           array = Arrays.copyOf(array, size + c.size);
        }

//        while ((array.length - size()) < c.size()) {
//            grow();
//        }

//        }
//        for (int i = size(), j = 0; i < a.length; i++) {
//            array[i] = (E)a[j];
//            resultSize++;
//        }

        System.arraycopy(a, 0, array, size, a.length);
        size += c.size();

        return size == resultSize + c.size;
    }

    public void clear() {
        if (!isEmpty()) {
            for (int i = 0; i < size; i++) {
                array[i] = null;
            }
            size = 0;
        }

    }


    public E get(int index) {
        outOfRange(index);
        return array[index];
    }


    public E set(int index, E element) {
        outOfRange(index);
        E oldElement = array[index];
        array[index] = element;
        return oldElement;
    }


    public void add(int index, E element) {
        outOfRange(index);
        if (isFull()) {
            grow();
        }
        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        //System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;

    }




    public E remove(int index) {
        E oldValue = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        //System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;

        return oldValue;
    }


    public boolean containsAll(MyArrayList<? extends E> c) {
        int countOfEqual = 0;

        for (int i = 0; i < c.size; i++) {
            if (!contains(c.get(i))) {
                return false;
            }
        }

        return true;
    }

    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (array[i].equals(element)) {
                    return i;
                }
            }
        }
        return -1;
    }

    // Проверяем идет ли обращение за пределы массива
    private void outOfRange(int index) {
        if (index >= size() || index < 0) {
            throw new RuntimeException("Out of range");
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "ArrayList is empty";
        }
        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; i < size(); i++) {
            b.append(String.valueOf(array[i]));
            if (i == size() - 1) {
                return b.append(']').toString();
            }
            b.append(", ");
        }

        return b.toString();
    }

    private Object[] grow() {
        return array = Arrays.copyOf(array, array.length * 3 / 2 + 1);
    }
}
