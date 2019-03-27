package com.queue;

/**
 * Circular Queue
 * Author : Zequn Song
 * Email : zsong73@gwu.edu
 */
public class MyQueue {
    private Object[] queArray;
    private int maxSize;
    //head pointer
    private int front;
    //rear pointer
    private int rear;
    //number of items in queue
    private int nItems;

    public MyQueue(int size){
        maxSize = size;
        queArray = new Object[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    /**
     * insert new item into the queue
     * @param value
     */
    public void insert(int value){
        if(isFull()){
            System.out.println("queue is already full!");
        }else{
            //if rear point to the end, loop back point to the first
            if(rear == maxSize -1){
                rear = -1;
            }
            queArray[++rear] = value;
            nItems++;
        }
    }

    /**
     * delete item from queue head
     * @return
     */
    public Object remove(){
        Object removeValue;
        if(!isEmpty()){
            removeValue = queArray[front];
            queArray[front] = null;
            front++;
            if(front == maxSize){
                front = 0;
            }
            nItems--;
            return removeValue;
        }else
            return null;
    }

    /**
     * delete item from queue head
     * @return
     */
    public Object getHead(){
        return queArray[front];
    }

    public boolean isFull(){
        return (nItems == maxSize);
    }

    public boolean isEmpty(){
        return (nItems ==0);
    }

    public int getSize(){
        return nItems;
    }

}