package com.heap;

/**
 * Priority Queue
 * build by Max Heap
 * @author : Zequn Song
 * Email : zsong73@gwu.edu
 */
public class HeapPriQueue {
    private Heap theHeap;

    public HeapPriQueue(int size){
        theHeap = new Heap(size);
    }

    public void insert(int key){
        theHeap.insert(key);
    }

    public Node remove(){
        return theHeap.remove();
    }

    public Node getMax(){
        return theHeap.getTop();
    }

    public static void main(String[] args){
        HeapPriQueue pq = new HeapPriQueue(10);
        pq.insert(6);
        pq.insert(0);
        pq.insert(64);
        pq.insert(99);
        pq.insert(3);
        pq.insert(54);

        System.out.println("highest value: "+ pq.remove().getKey());
        System.out.println("highest value: "+pq.getMax().getKey());

    }
}
