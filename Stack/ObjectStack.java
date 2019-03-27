package com.stack;

import java.util.Arrays;
import java.util.EmptyStackException;


/**
 *  ObjectStack -- An advanced array stack
 *  can store different types of data
 *  can auto expand the size
 *  Author : Zequn Song
 *  Email : zsong73@gwu.edu
 */
public class ObjectStack {
    //Object array can store any types of data
    private Object[] elementData;
    private int top;
    //total size
    private int maxSize;

    //default construct a size 10 stack
    public ObjectStack(){
        this.elementData = new Object[10];
        this.top = -1;
        this.maxSize = 10;
    }

    //a stack with user-defined size
    public ObjectStack(int size){
        if(size < 0)
            throw new IllegalArgumentException("error: [initial] stack capacity cannot smaller than 0");
        this.elementData = new Object[size];
        this.top = -1;
        this.maxSize = size;
    }

    public Object push(Object item){
        //whether need grow
        isGrow(top+1);
        elementData[++top] = item;
        return item;
    }

    public Object pop(){
        if(top == -1)
            throw new EmptyStackException();
        Object item = peek();
        elementData[top] = null;
        this.top--;
        return item;
    }

    public Object peek(){
        if(top == -1)
            throw new EmptyStackException();
        return elementData[top];
    }

    public int size(){
        return maxSize;
    }

    public boolean isEmpty(){
        return (top == -1);
    }

    /**
     * whether need to expand the size, if need, double the size and return true
     * @param sizeNeed
     * @return
     */
    public boolean isGrow(int sizeNeed){
        int oldSize = maxSize;
        //if the sizeNeed bigger than oldSize, stack needs to grow
        if(sizeNeed >= oldSize){
            //new size after expand
            int newSize ;
            //double the size, check whether exceed the Integer.MAX_VALUE
            if((oldSize<<1) > 0 ){
                newSize = oldSize<<1;
            }else{
                newSize = Integer.MAX_VALUE;
            }
            this.maxSize = newSize;
            this.elementData = Arrays.copyOf(elementData,maxSize);
            return true;
        }else
            return false;
    }
}
