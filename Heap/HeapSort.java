package com.heap;
import java.util.Arrays;
/**
 * Compare the Time Complexity of two different HeapSort
 */
public class HeapSort {
    static int dataSize = 1000000;
    /**
     * ascending order
     * using Max Heap
     * No optimize
     * @param array
     */
    public static void heapSort(int[] array){
        MinHeap sortHeap = new MinHeap(array.length);
        //Heap sortHeap = new Heap(array.length);
        for(int i = 0; i < array.length; i++){
            sortHeap.insert(array[i]);
        }
        for(int i = 0; i < array.length; i++){
           /// array[i] = sortHeap.remove().getKey();
            array[i] = sortHeap.remove().getKey();
        }
    }

    /**
     * ascending order
     * using Max Heap
     * Do optimize, insert all data into heapArray first
     * main sort method is build in Heap,java
     * @param array
     */
    public static void dataToHeap(Heap heap, int[] array){
        for(int i = 0; i < array.length; i++) {
            Node newNode = new Node(array[i]) ;
            heap.insertAt(i,newNode);
            heap.incrementSize();
        }
    }

    public static void main(String[] args) {
        int[] array = new int[dataSize];
        randomInsert(array);
        //System.out.println("Original Array: " + Arrays.toString(array));

        //-----------Advanced Heap Sort --------------------
        long start = System.nanoTime();
        Heap ahs = new Heap(dataSize);
        dataToHeap(ahs,array);
        ahs.heapSort();
        long end = System.nanoTime();
        System.out.println("Advanced Heap Sort Time:" + (end - start));
        System.out.println();

        //-----------Normal Heap Sort --------------------
        start = System.nanoTime();
        heapSort(array);
        end = System.nanoTime();
        //System.out.print("Array in Heap after sort:");
        //System.out.println(Arrays.toString(array));
        System.out.println("Heap Sort Time:" + (end - start));
        System.out.println();

    }

    public static void randomInsert(int[] array){
        int i = 0;
        while(i < array.length){
            array[i++] = (int)(1 + Math.random()*dataSize);
        }
    }
}
