package com.linkedList;
/**
 * test for SingleLinkedList.java
 */
public class testSingleLinkedList {
    public static void main(String[] args){
        SingleLinkedList list = new SingleLinkedList();
        list.addHead("A");
        list.addHead("B");
        list.addHead("C");
        list.addHead("D");
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
