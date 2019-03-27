package com.queue;

/**
 * Priority Queue
 * with insertion sort
 * build by Integer array
 * Author : Zequn Song
 * Email : zsong73@gwu.edu
 */
public class PriorityQueue {
    private int maxSize;
    private int[] priQueArray;
    private int nItems;

    public PriorityQueue(int maxSize){
        this.maxSize = maxSize;
        priQueArray = new int[maxSize];
        nItems = 0;
    }

    /**
     * insert new item into the queue
     * @param value
     */
    public void insert(int value){
        if(nItems == 0){
            priQueArray[nItems++] = value;
        }else{
            //insertion-sort, the largest value is on the top of queue
            int j = nItems -1;
            while(j >=0 && value < priQueArray[j]){
                priQueArray[j+1] = priQueArray[j];
                j--;
            }
            priQueArray[j+1] = value;
            nItems++;
        }
    }

    /**
     * delete the biggest value
     * -1 means deleted because int[]array cannot be null
     * @return
     */
    public int remove(){
        int k = nItems -1;
        int value = priQueArray[k];
        priQueArray[k] = -1;
        nItems--;
        return value;
    }

    /**
     * find the highest priority value
     * @return
     */
    public int highestPri(){
        return priQueArray[nItems-1];
    }

    public boolean isEmpty(){
        return (nItems == 0);
    }

    public boolean isFull(){
        return (nItems == maxSize);
    }
}
