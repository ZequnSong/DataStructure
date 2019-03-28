package com.linkedList;

/**
 *  Single LinkedList
 *  Author : Zequn Song
 *  Email : zsong73@gwu.edu
 */
public class SingleLinkedList {
    //number of nodes in list
    private int size;
    //head node
    private Node head;

    public SingleLinkedList(){
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
    public Object addHead(Object obj){
        //create a new node which contains the data we want to add
        Node newHead = new Node(obj);
        //if list is empty, new node is the head node
        if(size == 0){
            head = newHead;
        }else{
            //insert the new node in the head, new node's pointer points to the old head node
            newHead.next = head;
            //change the current head node to the new node
            head = newHead;
        }
        size++;
        return obj;
    }

    /**
     * delete the head node
     * used for build a Stack with the LinkedList
     * @return
     */
    public Object deleteHead(){
        Object obj = head.data;
        head = head.next;
        size--;
        return obj;
    }

    /**
     * find the specified element
     * @param obj
     * @return return the node if find it
     */
    public Node find(Object obj){
        //from the head node, loop over to see if node.data == obj
        Node current = head;
        int tempSize = size;
        while(tempSize > 0){
            if(obj.equals(current.data))
                return current;
            else
                current = current.next;
            size--;
        }
        return null;
    }

    /**
     * delete node with specified value
     * @param obj
     * @return true if delete successful
     */
    public boolean delete(Object obj){
        if(size == 0){
            return false;
        }
        //build two pointer, one point to current, one point to previous
        //from the head, loop over to find the node with the specified value
        Node current = head;
        Node previous = head;
        while(!obj.equals(current.data)){
            //if current node is the last node, cannot find it, delete fail
            if(current.next == null)
                return false;
            else{
                //update the pointer and continue
                previous = current;
                current = current.next;
            }
        }
        //if the node to be deleted is the head
        if(current == head){
            head = head.next;
            size--;
        }else{
            previous.next = current.next;
            current.next = null;
            size--;
        }
        return true;
    }

    public boolean isEmpty(){
        return (size == 0);
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
