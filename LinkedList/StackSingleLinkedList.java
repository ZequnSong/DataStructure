package com.linkedList;

/**
 * using the Single Linked List to build a Stack
 * Author : Zequn Song
 * Email : zsong73@gwu.edu
 */
public class StackSingleLinkedList {
    private SingleLinkedList list;

    public StackSingleLinkedList(){
        list = new SingleLinkedList();
    }

    public void push(Object obj){
        list.addHead(obj);
    }

    public Object pop(){
        Object obj = list.deleteHead();
        return obj;
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public void display(){
        list.display();
    }
}
