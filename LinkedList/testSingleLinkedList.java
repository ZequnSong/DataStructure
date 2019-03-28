package com.linkedList;
/**
 * test for SingleLinkedList.java
 */
public class testSingleLinkedList {
    public static void main(String[] args){
        SingleLinkedList list = new SingleLinkedList();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.display();

        System.out.println("After delete the head:");
        list.deleteHead();
        list.display();

        System.out.println("After delete \"B\":");
        list.delete("B");
        list.display();

        System.out.println("Find value \"A\":" + list.find("A"));

    }
}
v
