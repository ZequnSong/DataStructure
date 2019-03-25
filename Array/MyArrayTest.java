package com.array;

public class MyArrayTest {
    public static void main(String[] args){
        MyArray array = new MyArray(4);

        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.display();

        System.out.println("index whose element is 4: " + array.find(4));

        int i = array.get(3);
        System.out.println("element whose index is 3: " + i);

        array.delete(2);
        array.display();

        array.modify(3,99);
        array.display();
    }
}
