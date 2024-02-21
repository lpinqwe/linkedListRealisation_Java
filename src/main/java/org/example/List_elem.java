package org.example;

import java.lang.module.FindException;
import java.net.BindException;
import java.util.Iterator;

public class List_elem<A> implements Iterable<A> {

    ListItem<A> head;
    ListItem<A> tail;

    @Override
    public Iterator<A> iterator() {
        return new Iterator<A>() {
            ListItem<A> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public A next() {
                A data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    public class ListItem<A> {
        A data;
        ListItem<A> next;


    }

    public boolean isEmpty() {
        return head == null;
    }

    //insert, delete, replace
    public ListItem<A> delete(int index) {
        ListItem<A> current = head;
        index = index - 1;
        if (index < 0) {
            ListItem<A> buf = head;
            head = head.next;
            return buf;
        }
        //System.out.println("index=" + (index));
        for (int i = 0; i != index; i++) {
            current = current.next;
        }
        //System.out.println("CURRENT=" + current.data);
        ListItem<A> buf = current.next;
        current.next = current.next.next;
        return buf;
    }

    public void add(A item, int index) {
        if (index == 0) {
            addFirst(item);
        } else {
            insert(item, index);
        }
    }
    public void add(A item) {
        addEnd(item);
    }

    private void insert(A item, int index) {
        ListItem<A> newItem = new ListItem<>();
        ListItem<A> current = head;
        newItem.data = item;
        index = index - 1;
        if (index < 0) {
            addFirst(item);
            return;
        }
        for (int i = 0; i != index; i++) {
            current = current.next;
        }
        ListItem<A> buf = current.next;
        current.next = newItem;
        newItem.next = buf;
    }

    public ListItem<A> replace(A item, int index) {
        insert(item, index);
        return delete(index + 1);

    }

    public void addFirst(A item) {
        ListItem<A> newItem = new ListItem<A>();
        newItem.data = item;
        if (isEmpty()) {
            head = newItem;
            tail = newItem;
        } else {
            ListItem<A> buf = head;
            head = newItem;
            head.next = buf;
        }
    }

    private void addEnd(A item) {
        ListItem<A> newItem = new ListItem<>();
        newItem.data = item;
        if (isEmpty()) {
            head = newItem;
            tail = newItem;
        } else {
            tail.next = newItem;
            tail = newItem;
        }
    }

    public void reverse() {
        if (!isEmpty() && head.next != null) {
            tail = head;
            ListItem<A> current = head.next;
            head.next = null;
            while (current != null) {
                ListItem<A> next = current.next;
                current.next = head;
                head = current;
                current = next;

            }
        }
    }


}
