package com.reversePolishNotation;
/**
 *  Stack Structure
 *  build by char[] used for reversePolishNotation
 *  Author : Zequn Song
 *  Email : zsong73@gwu.edu
 */
public class MyCharStack {
    private char[] array;
    private int maxSize;
    private int top;

    public MyCharStack(int size){
        this.maxSize = size;
        array = new char[size];
        top = -1;
    }

    /**
     * add value on the top of stack
     * @param value
     */
    public void push(char value){
        if(top < maxSize - 1){
            array[++top] = value;
        }
        else{
            System.out.println("error: [push] The stack is already full");
        }
    }

    /**
     * Normally shouldn't have this method
     * only used for display the process result for analysis
     */
    public void displayStack(){
        System.out.print("Stack(bottom-->top):");
        for(int i = 0 ; i < top+1; i++){
            System.out.print(array[i]);
            System.out.print(' ');
        }
        System.out.println();
    }

    /**
     * pop value of top of the stack
     * @return
     */
    public char pop(){
        return array[top--];
    }

    /**
     * get the element on the top
     * @return
     */
    public char peek(){
        return array[top];
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    public boolean isFull(){
        return (top == maxSize-1);
    }

}
