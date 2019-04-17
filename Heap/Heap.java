package com.heap;

import java.util.Arrays;

/**
 *  Max Heap
 *  Include the Advanced HeapSort Method
 *  save half space and a little time cost
 *  add all data to heapArray then do trickleDown( ) for n/2-1 Nodes to get form a Heap.
 *  using the same array, output the sort array.
 * @author : Zequn Song
 * Email : zsong73@gwu.edu
 */

public class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int mx) {
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public boolean isEmpty() {
        return (currentSize == 0)? true : false;
    }

    public boolean isFull() {
        return (currentSize == maxSize)? true : false;
    }

    /**
     * insertion
     * @param key
     * @return
     */
    public boolean insert(int key) {
        if(isFull()) {
            return false;
        }
        Node newNode = new Node(key);
        //put new data at the end of the heap
        heapArray[currentSize] = newNode;
        //do trickUp to keep the heap correct
        trickleUp(currentSize++);
        return true;
    }

    /**
     * adjust upward
     * @param index index of the new node
     */
    public void trickleUp(int index) {
        int parent = (index - 1) / 2; //index of new node's parent
        Node bottom = heapArray[index]; //save the new node to bottom
        //if keyValue of new node is bigger than its parent
        //swap the position of new node and its parent
        while(index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
            //move down the parent node
            heapArray[index] = heapArray[parent];
            //move up the index
            index = parent;
            parent = (parent - 1) / 2;
        }
        //now, index is the first index that bottom.getKey() smaller than its parent
        heapArray[index] = bottom;
    }

    /**
     * deletion the maximum node (root)
     * @return
     */
    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        //do trickDown to keep the heap correct
        trickleDown(0);
        return root;
    }

    /**
     * adjust downward
     * @param index the index of node we delete
     */
    public void trickleDown(int index) {
        //save the node which need to go down find a right place
        Node top = heapArray[index];
        int largeChildIndex;
        //while node has at least one child
        //because index of parent is parentIndex = (childIndex - 1)/2
        //at least one child means left child
        //leftChildIndex < currentSize
        //2*parentIndex + 1 < currentSize
        //parentIndex < currentSize / 2
        while(index < currentSize/2) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = leftChildIndex + 1;
            //find larger child
            if(rightChildIndex < currentSize &&  //rightChild exists?
                    heapArray[leftChildIndex].getKey() < heapArray[rightChildIndex].getKey()) {
                largeChildIndex = rightChildIndex;
            }
            else {
                largeChildIndex = leftChildIndex;
            }
            //if data of node bigger than largeChildNode, then Heap is correct
            if(top.getKey() >= heapArray[largeChildIndex].getKey()) {
                break;
            }
            //move the largeNode up
            heapArray[index] = heapArray[largeChildIndex];
            //let index go down
            index = largeChildIndex;
        }
        //now index is the first index that top.getKey() bigger than its children
        heapArray[index] = top;
    }

    /**
     * change the keyValue of Heap according to an index
     * @param index
     * @param newValue
     * @return
     */
    public boolean change(int index, int newValue) {
        if(index < 0 || index >= currentSize) {
            return false;
        }
        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);
        if(oldValue < newValue) {
            trickleUp(index);
        }
        else {
            trickleDown(index);
        }
        return true;
    }

    public void displayHeap() {
        System.out.println("heapArray(array format): ");
        for(int i = 0; i < currentSize; i++) {
            if(heapArray[i] != null) {
                System.out.print(heapArray[i].getKey() + " ");
            }
            else {
                System.out.print("--");
            }
        }
    }

    public Node getTop(){
        return isEmpty()? null : heapArray[0];
    }

    //-------------------used for heapSort ----------------------------
    /**
     * data insertion
     */
    public void insertAt(int index, Node newNode){
        heapArray[index] = newNode;
    }

    //used for heapSort
    public void incrementSize(){currentSize++;}

    public void displayArray(int dataSize){
        for (int i = 0; i < dataSize; i++) {
            System.out.print(heapArray[i].getKey() + " ");
        }
        System.out.println();
    }

    public void heapSort(){
        //used for output, currentSize changes when remove( ), so we need to save it as dataSize
        int dataSize = currentSize;

        // System.out.print("Array in Heap before sort: " );
        // displayArray(dataSize);

        /*
         * add all data to heapArray then do trickleDown( ) for n/2-1 Nodes to get form a Heap.
         * make random array into heap
         */
        for(int i = currentSize/2 - 1; i >= 0; i--){
            trickleDown(i);
        }
       // System.out.print("Array in heap after adjust: " );
       // displayArray(dataSize);

        //using the same array, output the sort array.
        for(int i = currentSize - 1; i >= 0; i--){
            Node biggestNode = remove();
            insertAt(i,biggestNode);
        }
       // System.out.print("Array in Heap after sort: " );
       // displayArray(dataSize);
    }
    //-------------------------------------------------------------------------
}

