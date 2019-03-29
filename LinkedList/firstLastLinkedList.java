package com.linkedList;

/**
 *  Double LinkedList
 *  have one more pointer --- tail pointer
 *  Author : Zequn Song
 *  Email : zsong73@gwu.edu
 */
public class firstLastLinkedList {
    //number of nodes in list
    private int size;
    //head node
    private Node head;
    //tail node
    private Node tail;

    public firstLastLinkedList(){
        size = 0;
        head = null;
    }

    //class of node
    private class Node{
        //data in node
        private Object data;
        //pointer in node. point to next node
        private Node next;

        public Node(Object data){
            this.data = data;
        }
    }

    /**
     * add new node in the head of the list
     * @param obj
     * @return
     */
    public void addHead(Object obj){
        //create a new node which contains the data we want to add
        Node node = new Node(obj);
        //if list is empty, new node is the head node and the tail node
        if(size == 0){
            head = node;
            tail = node;
        }else{
            //insert the new node in the head, new node's pointer points to the old head node
            node.next = head;
            //change the current head node to the new node
            head = node;
        }
        size++;
    }

    /**
     * add new node in the tail of the list
     * @param obj
     * @return
     */
    public void addTail(Object obj){
        //create a new node which contains the data we want to add
        Node node = new Node(obj);
        //if list is empty, new node is the head node and the tail node
        if(size == 0){
            head = node;
            tail = node;
            size++;
        }else{
            //insert the new node in the tail, old tail node's pointer points to the new node
            tail.next = node;
            //change the current tail node to the new node
            tail = node;
            size++;
        }
    }

    /**
     * delete the head node
     * @return true if delete success
     */
    public boolean deleteHead(){
        if(size == 0)
            return false;
        if(head.next == null){
            head = null;
            tail = null;
        }else{
            head = head.next;
        }
        size--;
        return true;
    }

    public boolean isEmpty(){
        return (size == 0);
    }

    public int getSize(){
        return size;
    }

    /**
     * display the list
     */
    public void display(){
        if(size > 0){
            Node node = head;
            int tempSize = size;
            //if the list only have one node
            if(tempSize == 1) {
                System.out.println("[" + node.data + "]");
                return;
            }
            //if the list have more than one node
            while(tempSize>0){
                if(node.equals(head)){
                    System.out.print("[" + node.data + "->");
                }else if(node.next == null){
                    System.out.print(node.data + "]");
                }else{
                    System.out.print(node.data + "->");
                }
                node = node.next;
                tempSize--;
            }
            System.out.println();
        }else{
            System.out.println("[]");
        }
    }
}
