package com.stack;
/**
 * Stack Structure
 *  Author : Zequn Song
 *  Email : zsong73@gwu.edu
 */
public class MyStack {
    private int[] array;
    private int maxSize;
    private int top;

    public MyStack(int size){
        this.maxSize = size;
        array = new int[size];
        top = -1;
    }

    /**
     * add value on the top of stack
     * @param value
     */
    public void push(int value){
        if(top < maxSize - 1){
            array[++top] = value;
        }
    }

    /**
     * pop value of top of the stack
     * @return
     */
    public int pop(){
        return array[top--];
    }

    /**
     * get the element on the top
     * @return
     */
    public int peek(){
        return array[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == maxSize-1);
    }

}
