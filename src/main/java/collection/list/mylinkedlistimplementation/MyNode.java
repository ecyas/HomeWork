package collection.list.mylinkedlistimplementation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class MyNode<E> {
    private E value;
    private MyNode<E> next;
    private MyNode<E> prev;

}
