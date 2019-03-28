package com.linkedList;

public class testList {
    public static void main(String[] args){
        System.out.println("----- test for SingleLinkedList ------");
        SingleLinkedList list = new SingleLinkedList();
        list.addHead("A");
        list.addHead("B");
        list.addHead("C");
        list.addHead("D");
        System.out.println("SingleLinkedList: ");
        list.display();
        System.out.println("After delete the head:");
        list.deleteHead();
        list.display();
        System.out.println("After delete \"B\":");
        list.delete("B");
        list.display();
        System.out.println("Find value \"A\":" + list.find("A"));
        System.out.println("---------------------------------------");

        System.out.println("----- test for StackSingleLinkedList ------");
        StackSingleLinkedList stack = new StackSingleLinkedList();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("Stack: ");
        stack.display();
        System.out.println("After one pop:");
        stack.pop();
        stack.display();
        System.out.println("--------------------------------------------");

        System.out.println("----- test for DoubleLinkedList ------");
        DoubleLinkedList dl = new DoubleLinkedList();
        dl.addHead("B");
        dl.addHead("C");
        dl.addHead("D");
        dl.addTail("A");
        System.out.println("DoubleLinkedList: ");
        dl.display();
        System.out.println("After delete the head:");
        dl.deleteHead();
        dl.display();
        System.out.println("---------------------------------------");

        System.out.println("----- test for QueueDoubleLinkedList ------");
        QueueDoubleLinkedList queue = new QueueDoubleLinkedList();
        queue.insert("A");
        queue.insert("B");
        queue.insert("C");
        queue.insert("D");
        System.out.println("Queue: ");
        queue.display();
        System.out.println("After one delete:");
        queue.delete();
        queue.display();
        System.out.println("--------------------------------------------");
    }
}
