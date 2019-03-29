package com.linkedList;
/**
 *  Double LinkedList
 *  each Node have one more pointer --- prev pointer
 *  can do forward traversal and reverse traversal
 *  Author : Zequn Song
 *  Email : zsong73@gwu.edu
 */
public class DoubleLinkedList {
    private Node head;
    private Node tail;
    //number of nodes
    private int size;

    private class Node{
        private Object data;
        private Node next;
        //have a prev pointer
        private Node prev;

        public Node(Object data){
            this.data = data;
        }
    }

    public DoubleLinkedList(){
        size = 0;
        head = null;
        tail = null;
    }

    /**
     * add value in the head
     * @param value
     */
    public void addHead(Object value){
        Node newNode = new Node(value);
        if(size == 0){
            head = newNode;
            tail = newNode;
            size++;
        }else{
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    public void addTail(Object value){
        Node newNode = new Node(value);
        if(size == 0){
            head = newNode;
            tail = newNode;
            size++;
        }else{
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    /**
     * insert the value after the key
     * @param key
     * @param value
     */
    public boolean insertAfter(Object key, Object value){
        Node current = head;
        if(current == null)
            return false;
        while(!current.data.equals(key)){
            current = current.next;
        }
        if(current == null)
            return  false;
        Node newNode = new Node(value);
        if(current == tail){
            tail.next = newNode;
            newNode.next = null;
            newNode.prev = tail;
            tail = newNode;
        }else{
            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;
        }
        return true;
    }


    /**
     * delete the value
     * @param value
     */
    public Node delete(Object value){
        Node current = head;
        if(current == null)
            return null;
        while(!current.data.equals(value)){
            current = current.next;
        }
        if(current == null)
            return  null;
        if(current == tail){
            tail = tail.prev;
            tail.next = null;
            current.prev = null;
        }else if(current == head){
            head = head.next;
            head.prev = null;
            current.next = null;
        }else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.prev = current.next = null;
        }
        return current;
    }

    /**
     * delete the value in current head
     * @return
     */
    public Node deleteHead(){
        Node temp = head;
        if(size != 0){
            head = head.next;
            head.prev = null;
            size--;
        }
        return temp;
    }


    /**
     * delete the value in current tail
     * @return
     */
    public Node deleteTail(){
        Node temp = tail;
        if(size != 0){
            tail = tail.prev;
            tail.next = null;
            size--;
        }
        return temp;
    }


    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public void displayForward(){
        System.out.print("List(first->last): ");
        Node current = head;
        while (current!=null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void displayBackward(){
        System.out.print("List(last->first): ");
        Node current = tail;
        while (current!=null){
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

}

