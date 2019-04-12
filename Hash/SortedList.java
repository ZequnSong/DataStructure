package com.hash;

/**
 *  used for chain addressing hash table
 *  Sorted LinkedList
 *  increasing order
 *   
 *  Author : Zequn Song
 *  Email : zsong73@gwu.edu
 */
public class SortedList {
    private Node head;

    public SortedList(){
        head = null;
    }

    class Node{
        private ChainHash.DataItem data;
        private Node next;

        public Node(int data){
            ChainHash.DataItem dataItem = new ChainHash.DataItem(data);
            this.data = dataItem;
        }


        public ChainHash.DataItem getKey(){
            return this.data;
        }

        public void displayLink(){
            System.out.println(data + " ");
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
        while(current!=null && current.data.getKey()<data){
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

    public boolean isEmpty(){
        return (head == null);
    }

    public void delete(int data){
        Node pre = null;
        Node current = head;
        if(isEmpty()){
            System.out.print("linked list is empty");
            return;
        }
        while(current != null && current.data.getKey() < data){
            pre = current;
            current = current.next;
        }
        if(current.data.getKey() == data){
            if(pre == null)
                deleteHead();
            else{
                pre.next = current.next;
            }
        }else{
            System.out.print("error: [delete] cannot find "+ data + "in the list");
        }
    }

    public Node find(int key){
        Node current = head;
        while(current != null && current.getKey().getKey() < key){
            current = current.next;
        }
        if(current.getKey().getKey() == key){
            return current;
        }
        return null;
    }

    public void deleteHead(){
        head = head.next;
    }

    public void display(){
        System.out.println("Link(First->Last)");
        Node current = head;
        while(current!=null){
            System.out.print(current.data.getKey()+" ");
            current = current.next;
        }
        System.out.println();
    }


}
