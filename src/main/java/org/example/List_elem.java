package org.example;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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


    public void add_first(A item){
        ListItem<A> newItem=new ListItem<A>();
        newItem.data=item;
        if(isEmpty()){
            head=newItem;
            tail=newItem;
        }else{
            ListItem<A> buf = head;
            head=newItem;
            head.next=buf;
        }
    }
    public void addEnd(A item) {
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
            tail=head;
            ListItem<A> current = head.next;
            head.next=null;
            while (current!=null){
                ListItem<A> next = current.next;
                current.next= head;
                head=current;
                current=next;

            }
        }
    }


}
