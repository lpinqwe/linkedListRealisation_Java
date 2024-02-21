package org.example;

public class Main {
    public static void main(String[] args) {
        List_elem<Example> list = new List_elem<>();
        //list.add_first(new Example(888, "888", "1111111"));
        //list.add_first(new Example(999, "999", "0000000"));
        list.addEnd(new Example(0, "a", "+2112"));
        list.addEnd(new Example(1, "a", "+2112"));
        list.addEnd(new Example(2, "b", "+2112"));
        list.addEnd(new Example(3, "c", "+2112"));
        list.addEnd(new Example(4, "d", "+2112"));
        list.addEnd(new Example(5, "e", "+2112"));
        list.reverse();

        //System.out.println("DELETED " + list.delete(1).data);
        Example elem = new Example(41, "d", "+2112");
        list.replace(elem,1);



        for (Example exampleaa : list) {
            System.out.println(exampleaa);
        }

        System.out.println("Hello world!");
    }
}