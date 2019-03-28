package com.linkedList;

/**
 * using the Double Linked List to build a Queue
 * Author : Zequn Song
 * Email : zsong73@gwu.edu
 */
public class QueueDoubleLinkedList {
    private DoubleLinkedList list;

    public QueueDoubleLinkedList(){
        list = new DoubleLinkedList();
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
