package collection.list.mylinkedlistimplementation;

import java.util.Collection;

public class MyLinkedList <E> {

    private int size;

    private MyNode<E> head;
    private MyNode<E> tail;



    public int size() {
        return size;
    }

    
    public boolean isEmpty() {
        return head == null;
    }

    
    public boolean contains(E element) {

        return indexOf(element) != -1 ? true : false;
    }

    
    public E[] toArray() {
        E[] result = (E[]) new Object[size];
        int i = 0;
        for (MyNode<E> x = head; x != null; x = x.getNext()) {
            result[i++] = x.getValue();
        }
        return result;
    }

    // добавление в конец
    public boolean add(E element) {
        MyNode<E> node = new MyNode<>(element, null, null);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            MyNode curNode = head;
            while (curNode.getNext() != null) {
                curNode = curNode.getNext();
            }
            curNode.setNext(node);
            tail = node;
            node.setPrev(curNode);
        }
        size++;
        return true;
    }

    
    public boolean remove(E element) {
        MyNode<E> removingNode = null;
        if (head != null) {
            MyNode<E> curNode = head;
            //removingNode = head;
            if (element.equals(curNode.getValue())) {
                head = curNode.getNext();
                size--;
                return true;
            }
            while (!curNode.getNext().getValue().equals(element)) {
                curNode = curNode.getNext();
            }
            removingNode = curNode.getNext();
            if (removingNode.getNext() != null) {
                curNode.setNext(removingNode.getNext());
                removingNode.getNext().setPrev(curNode);
                removingNode.setPrev(null);
                removingNode.setNext(null);
                size--;
                return true;
            } else {
                curNode.setNext(null);
                removingNode.setPrev(null);
                tail = curNode;
                size--;
                return true;
            }
        }

        return false;
    }

    
    public void clear() {
            for (MyNode<E> x = head; x != null;) {
                MyNode<E> next = x.getNext();
                x.setValue(null);
                x.setNext(null);
                x.setPrev(null);
                x = next;
            }
            head = tail = null;
            size = 0;
    }

    
    public E get(int index) {
        if (index < (size << 1)) {
            MyNode<E> curNode = head;
            for (int i = 0; i < index; i++) {
                curNode = curNode.getNext();
            }
            return curNode.getValue();
        } else {
            MyNode<E> curNode = tail;
            for (int i = size - 1; i > index; i--) {
                curNode = curNode.getPrev();
            }
            return curNode.getValue();
        }
    }

    
    public E set(int index, E element) {
        E oldValue = null;
        if (index < (size << 1)) {
            MyNode<E> curNode = head;
            for (int i = 0; i < index; i++) {
                curNode = curNode.getNext();
            }
            oldValue = curNode.getValue();
            curNode.setValue(element);
        } else {
            MyNode<E> curNode = tail;
            for (int i = size - 1; i > index ; i--) {
                curNode = curNode.getPrev();
            }
            oldValue = curNode.getValue();
            curNode.setValue(element);
        }
        return oldValue;
    }

    
    public void add(int index, E element) {
        MyNode<E> h = head;
        MyNode<E> t = tail;
        MyNode<E> node = new MyNode<>(element, null, null);
        if (index == 0) {
            if (head == null) {
                head = node;
                tail = node;
            } else {
                head = node;
                h.setPrev(node);
                node.setNext(h);
            }
            size++;
        } else if (index == size) {
            tail = node;
            t.setNext(node);
            node.setPrev(t);
            size++;
        } else if (index > 0 || index < size) {
            if (index < (size << 1)) {
                //MyNode<E> curNode = head;
                for (int i = 0; i < index - 1; i++) {
                    h = h.getNext();
                }
                node.setPrev(h);
                node.setNext(h.getNext());
                h.setNext(node);
                h.getNext().setPrev(node);
            } else {
                //MyNode<E> curNode = tail;
                for (int i = size - 1; i > index; i--) {
                    t = t.getPrev();
                }
                node.setNext(t);
                node.setPrev(t.getPrev());
                t.setPrev(node);
                t.getPrev().setNext(node);
            }
            size++;
        }
    }

    
    public E remove(int index) {
        MyNode<E> removingNode = null;
        if (head != null) {
            MyNode<E> curNode = head;
            //проверяем если удаляемый узел первый
            if (index == 0) {
                head = curNode.getNext();
                size --;
                return head != null ? head.getValue() : null;
            }
            for (int i = 0; i < index - 1; i++) {
                    curNode = curNode.getNext();
                }
                removingNode = curNode.getNext();

            //проверяем если удаляемый узел последний
            if (removingNode.getNext() != null) {
                curNode.setNext(removingNode.getNext());
                removingNode.getNext().setPrev(curNode);
                tail = curNode;
            } else {
                curNode.setNext(null);
                removingNode.setPrev(null);
                tail = curNode;
            }
            removingNode.setNext(null);//  имелось в виду removingNode.setPrev(null);
        }
        size--;
        return removingNode.getValue();
    }

    
    public int indexOf(E element) {
        int index = 0;
        if (element == null) {
            for (MyNode<E> x = head; x != null; x = x.getNext()) {
                if (x.getValue() == null)
                    return index;
                index++;
            }
        } else {
            for (MyNode<E> x = head; x != null; x = x.getNext()) {
                if (element.equals(x.getValue()))
                    return index;
                index++;
            }
        }
        return -1;
    }

    
    public int lastIndexOf(E element) {
        int index = size;
        if (element == null) {
            for (MyNode<E> x = tail; x != null; x = x.getPrev()) {
                index--;
                if (x.getValue() == null) {
                    return index;
                }
            }
        } else {
            for (MyNode<E> x = tail; x != null; x = x.getPrev()) {
                index--;
                if (x.getValue().equals(element)) {
                    return index;
                }
            }
        }
        return -1;
    }

    
    public boolean containsAll(MyLinkedList<E> c) {
        for (int i = 0; i < c.size(); i++) {
            if (!contains(c.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (head != null) {
            MyNode<E> curNode = head;
            while (curNode.getNext() != null) {
                sb.append(curNode.getValue()).append(" ");
                curNode = curNode.getNext();
            }
            sb.append(curNode.getValue());
        }
        return sb.toString();
    }

}
