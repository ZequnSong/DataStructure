package com.linkedList;

/**
 * using the Double Linked List to build a Queue
 * Author : Zequn Song
 * Email : zsong73@gwu.edu
 */
public class QueueFirstLastLinkedList {
    private firstLastLinkedList list;

    public QueueFirstLastLinkedList(){
        list = new firstLastLinkedList();
    }

    public void insert(Object data){
        list.addTail(data);
    }

    public void delete(){
        list.deleteHead();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int getSize(){
        return list.getSize();
    }

    public void display(){
        list.display();
    }
}
