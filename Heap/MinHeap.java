package com.heap;

/**
 *  Heap  - Min Heap
 * @author : Zequn Song
 * Email : zsong73@gwu.edu
 */

public class MinHeap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public MinHeap(int mx) {
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
        //if keyValue of new node is smaller than its parent
        //swap the position of new node and its parent
        while(index > 0 && heapArray[parent].getKey() > bottom.getKey()) {
            //move down the parent node
            heapArray[index] = heapArray[parent];
            //move up the index
            index = parent;
            parent = (parent - 1) / 2;
        }
        //now, index is the first index that bottom.getKey() bigger than its parent
        heapArray[index] = bottom;
    }

    /**
     * deletion the minimum node (root)
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
        int smallChildIndex;
        //while node has at least one child
        //because index of parent is parentIndex = (childIndex - 1)/2
        //at least one child means left child
        //leftChildIndex < currentSize
        //2*parentIndex + 1 < currentSize
        //parentIndex < currentSize / 2
        while(index < currentSize/2) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = leftChildIndex + 1;
            //find smaller child
            if(rightChildIndex < currentSize &&  //rightChild exists?
                    heapArray[leftChildIndex].getKey() > heapArray[rightChildIndex].getKey()) {
                smallChildIndex = rightChildIndex;
            }
            else {
                smallChildIndex = leftChildIndex;
            }
            //if data of node smaller than smallChildNode, then Heap is correct
            if(top.getKey() <= heapArray[smallChildIndex].getKey()) {
                break;
            }
            //move the smallNode up
            heapArray[index] = heapArray[smallChildIndex];
            //let index go down
            index = smallChildIndex;
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
            trickleDown(index);
        }
        else {
            trickleUp(index);
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
}

