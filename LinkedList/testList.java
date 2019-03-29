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

        System.out.println("----- test for firstLastLinkedList ------");
        firstLastLinkedList dl = new firstLastLinkedList();
        dl.addHead("B");
        dl.addHead("C");
        dl.addHead("D");
        dl.addTail("A");
        System.out.println("firstLastLinkedList: ");
        dl.display();
        System.out.println("After delete the head:");
        dl.deleteHead();
        dl.display();
        System.out.println("---------------------------------------");

        System.out.println("----- test for QueueFirstLastLinkedList ------");
        QueueFirstLastLinkedList queue = new QueueFirstLastLinkedList();
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

        System.out.println("-------- test for SortedLinkedList----------");
        SortedLinkedList sl = new SortedLinkedList();
        sl.insert(4);
        sl.insert(8);
        sl.insert(2);
        sl.insert(22);
        System.out.println("SortedLinkedList: ");
        sl.display();
        sl.delete(8);
        System.out.println("after delete \"8\":  ");
        sl.display();
        System.out.println("--------------------------------------------");

        System.out.println("-------- test for DoubleLinkedList----------");
        DoubleLinkedList dlist = new DoubleLinkedList();
        dlist.addTail(3);
        dlist.addTail(9);
        dlist.addTail(13);
        dlist.addHead(0);
        dlist.insertAfter(0,99);
        System.out.println("DoubleLinkedList: ");
        dlist.displayForward();
        dlist.displayBackward();
        System.out.println("After delete head, tail and 13: ");
        dlist.delete(13);
        dlist.deleteHead();
        dlist.deleteTail();
        dlist.displayForward();
        dlist.displayBackward();
        System.out.println("--------------------------------------------");

    }
}
