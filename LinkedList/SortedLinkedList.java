package com.linkedList;

/**
 *  Sorted LinkedList
 *  increasing order
 *  Author : Zequn Song
 *  Email : zsong73@gwu.edu
 */
public class SortedLinkedList {
    private Node head;

    public SortedLinkedList(){
        head = null;
    }

    class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;
        }
    }

    /**
     * insert a new value
     * increase order
     * @param data
     */
    public void insert(int data){
        Node node = new Node(data);
        Node pre = null;
        Node current = head;
        while(current!=null && current.data<data){
            pre = current;
            current = current.next;
        }
        if(pre == null){
            head = node;
            head.next = current;
        }else{
            pre.next = node;
            node.next = current;
        }
    }

    public void delete(int data){
        Node pre = null;
        Node current = head;
        while(current != null && current.data < data){
            pre = current;
            current = current.next;
        }
        if(current.data == data){
            if(pre == null)
                deleteHead();
            else{
                pre.next = current.next;
            }
        }else{
            System.out.print("error: [delete] cannot find "+ data + "in the list");
        }
    }

    public void deleteHead(){
        head = head.next;
    }

    public void display(){
        Node current = head;
        while(current!=null){
            System.out.print(current.data+" ");
            current = current.next;
        }
        System.out.println();
    }


}
